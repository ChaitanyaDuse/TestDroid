package com.debunrebuild.testdroid

import retrofit2.http.GET
import retrofit2.http.Query

interface DemoAPI {
    @GET
    suspend fun getSomeValue(@Query("param1") param1 : String): String
}