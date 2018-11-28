package com.proto.rx.rxtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToLeak.setOnClickListener {
            startActivity(Intent(this, LeakActivity::class.java))
        }

        goToNoLeak.setOnClickListener {
            startActivity(Intent(this, NoLeakActivity::class.java))
        }


    }
}
