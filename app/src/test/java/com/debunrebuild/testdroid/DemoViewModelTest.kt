package com.debunrebuild.testdroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class DemoViewModelTest {

    lateinit var testDispatcher: TestDispatcher

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()
    @Before
    fun setup() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testViewModel() {
        val demoViewModel = DemoViewModel(UseCaseUserList(DemoRepository(FakeLocalDataSource(), DemoRemoteDataSource(FakeAPI()), testDispatcher, testDispatcher )))
        runTest {
            demoViewModel.setup("org1")
            Assert.assertTrue(demoViewModel.liveData.value is ScreenState.Empty)
        }

    }

    @Test
    fun `testemptyorgidexception`() {
        val demoViewModel = DemoViewModel(UseCaseUserList(DemoRepository(FakeLocalDataSource(), DemoRemoteDataSource(FakeAPI()), testDispatcher, testDispatcher )))
        runTest {
            demoViewModel.setup("")
            Assert.assertTrue(demoViewModel.liveData.value is ScreenState.Error)
        }

    }
}

