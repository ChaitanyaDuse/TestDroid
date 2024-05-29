package com.debunrebuild.testdroid

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun getSomeData(num: Int, coroutineDispatcher: CoroutineDispatcher): Int {
    return withContext(coroutineDispatcher) {
        delay(10000)
        num * 10
    }
}

suspend fun getSomeDataWithoutDispatcher(num: Int): Int {
    return withContext(Dispatchers.Default) {
        delay(10000)
        num * 10
    }
}