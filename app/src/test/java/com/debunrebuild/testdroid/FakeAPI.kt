package com.debunrebuild.testdroid

class FakeAPI : DemoAPI {
    override suspend fun getSomeValue(param1 : String): String {
        return "Success Response"
    }
}