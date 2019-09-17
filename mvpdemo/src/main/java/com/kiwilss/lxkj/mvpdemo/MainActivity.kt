package com.kiwilss.lxkj.mvpdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lxkj.mvpdemo.ui.banner.BannerActivity
import com.kiwilss.lxkj.xktx.core.postDelay
import com.kiwilss.lxkj.xktx.core.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postDelay(1000) {
            startActivity<BannerActivity>()
        }


    }
}
