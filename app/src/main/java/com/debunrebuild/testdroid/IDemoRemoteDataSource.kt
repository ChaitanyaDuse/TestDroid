package com.debunrebuild.testdroid

interface IDemoRemoteDataSource {
    suspend fun getSomeDataFromRemote(param1 : String): String
}
