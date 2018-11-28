package com.proto.rx.rxtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io
import kotlinx.android.synthetic.main.activity_count.*


class LeakActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        countForeverObservable()
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                text.text = it
            }
    }
}
