/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: ApiService
 * Author:   kiwilss
 * Date:     2019-06-24 11:27
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.basemvp.api


import com.kiwilss.lxkj.basemvp.bean.BaseBean
import com.kiwilss.lxkj.basemvp.bean.HomeBanner
import retrofit2.http.GET
import retrofit2.http.Path


/**
 *@FileName: ApiService
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-06-24
 * @desc   : {DESCRIPTION}
 */
interface ApiService{

    companion object{
        const val BASE_URL = "https://www.wanandroid.com/"
    }

//    //图虫壁纸
//    @GET("https://api.tuchong.com/2/wall-paper/app")
//    suspend fun getWallPaper(@Query("page") page: Int): TuChongWallPaperResponse

//干货集中营图片
    @GET("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/{page}")
    suspend fun getSisterIcon(@Path("page")page: Int): Any

//    @GET("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/{page}")
//     fun getSisterIcon2(@Path("page")page: Int): Deferred<SisterBean>

//    /**
//     * 自带的方法获取省
//     * @return Call<List<Province>>
//     */
//    @GET("http://guolin.tech/api/china")
//    fun getProvince(): Call<List<Province>>
//
//
    /**
     * 获取首页文章
     * @param page ") page: Int
     * @return BaseBean<List<HomeBean>>
     */
//    @GET("article/list/{page}/json")
//    suspend fun getHomeArticles(@Path("page") page: Int): BaseBean<HomeBean>

    @GET("banner/json")
    suspend fun getBanner(): BaseBean<List<HomeBanner>>


}