package com.debunrebuild.testdroid

class FakeRemoteDataSource : IDemoRemoteDataSource {
    override suspend fun getSomeDataFromRemote(param1: String): String {
        return "Some  Data"
    }
}