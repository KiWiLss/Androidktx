
package com.kiwilss.lxkj.basemvp.http

import com.blankj.utilcode.util.NetworkUtils
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.kiwilss.lxkj.basemvp.BaseConfig
import com.kiwilss.lxkj.basemvp.api.ApiService
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *@FileName: RetrofitHelper
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-06-24
 * @desc   : {DESCRIPTION}
 */
object RetrofitHelper {



    /**
     * 玩安卓 api
     */
    val apiService by lazy {
        getService(ApiService::class.java, ApiService.BASE_URL)
    }


    private fun <S> getService(serviceClass: Class<S>, baseUrl: String): S {
        return Retrofit.Builder()
            .client(initOkhttp())
            //.addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .build().create(serviceClass)

    }


    fun initOkhttp(): OkHttpClient {
        // Cookie 持久化
        val cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(BaseConfig.context))
// 指定缓存路径,缓存大小 50Mb
        val cache = Cache(
            File(BaseConfig.context.cacheDir, "HttpCache"),
            (1024 * 1024 * 50).toLong()
        )
        var builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .cookieJar(cookieJar)
            //.sslSocketFactory(SSLHelper.getSSLCertifcation(context))
            .cache(cache)
            .addInterceptor(cacheControlInterceptor)//有网策略,缓存
            .addNetworkInterceptor(HttpLogInterceptor())//无网策略,打印请求信息
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(25, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            //.addNetworkInterceptor(new StethoInterceptor())
            .retryOnConnectionFailure(true)

        return builder.build()
    }


    /**
     * 自定义拦截器,缓存设置
     */
    private val cacheControlInterceptor = Interceptor { chain ->
        var request = chain.request()

        //LogUtils.e("--------------interceptor---------------")
        if (!NetworkUtils.isConnected()) {//网络未连接
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
        }
        val originalResponse = chain.proceed(request)
//        //获取cookie
//        val cookies = originalResponse.headers("Set-Cookie")
//        LogUtils.e(JSON.toJSONString(cookies))
//        // ["SESSION=ec42c395-69e2-4563-b20b-c01386f27561; Path=/vm.open/; HttpOnly","SESSION=ec42c395-69e2-4563-b20b-c01386f27561; Path=/msf.open/; HttpOnly"]
//        if (cookies != null && cookies.size > 0) {
//            SPKUtils.saveS("cookie", cookies[0])
//            sp().putString("","")
//        }
        if (NetworkUtils.isConnected()) {
            // 有网络时 设置缓存为默认值
            val cacheControl = request.cacheControl().toString()
            originalResponse.newBuilder()
                .header("Cache-Control", cacheControl)
                //.addHeader("Cookie", "SESSION=84663fd9-9931-4e3f-b616-1b80b2216710")
                .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                .build()
        } else {
            // 无网络时 设置超时为1周
            val maxStale = 60 * 60 * 24 * 7
            originalResponse.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .removeHeader("Pragma")
                .build()
        }
    }

}