package com.debunrebuild.testdroid

class DemoRemoteDataSource(private val api: DemoAPI) : IDemoRemoteDataSource {
    override suspend fun getSomeDataFromRemote(param1: String): String {
        return api.getSomeValue(param1)
    }
}