package com.proto.rx.rxtest

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun countForeverObservable(): Observable<String> =
    Observable.interval(0, 1, TimeUnit.SECONDS)
        .map { "Number $it" }