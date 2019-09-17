package com.kiwilss.lxkj.okhttpdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lxkj.okhttpdemo.ui.home.HomeActivity
import com.kiwilss.lxkj.xktx.core.postDelay
import com.kiwilss.lxkj.xktx.core.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postDelay (2000){
            startActivity<HomeActivity>()
        }
    }
}
