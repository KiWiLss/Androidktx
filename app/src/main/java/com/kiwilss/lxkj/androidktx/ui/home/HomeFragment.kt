package com.kiwilss.lxkj.androidktx.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kiwilss.lxkj.androidktx.R
import com.kiwilss.lxkj.androidktx.ui.base_test.TestOneActivity
import com.kiwilss.lxkj.androidktx.ui.okhttp.OkhttpActivity
import com.kiwilss.lxkj.xktx.core.click
import com.kiwilss.lxkj.xktx.core.startActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_fg_home_okhttp.click {
            startActivity<OkhttpActivity>()
        }

        btn_fg_home_base.click {
            startActivity<TestOneActivity>()
        }

    }
}