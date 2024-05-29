package com.debunrebuild.testdroid

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class DemoRemoteDataSourceTest {

    lateinit var testDispatcher: TestDispatcher
    lateinit var fakeAPI: DemoAPI

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
        fakeAPI = FakeAPI()
    }


    @After
    fun tearDown() {
    }

    @Test
    fun `response from api service`() {
        val dataSource = DemoRemoteDataSource(fakeAPI)
        runTest {
            val response = dataSource.getSomeDataFromRemote("param1")
            Assert.assertEquals(response, "Success Response")
        }
    }

}