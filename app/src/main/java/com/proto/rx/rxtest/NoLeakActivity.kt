package com.proto.rx.rxtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers.io
import kotlinx.android.synthetic.main.activity_count.*


class NoLeakActivity : AppCompatActivity() {

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        disposable = countForeverObservable()
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                text.text = it
            }
    }

    override fun onStop() {
        disposable.dispose()
        super.onStop()
    }
}
