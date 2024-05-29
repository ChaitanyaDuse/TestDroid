package com.debunrebuild.testdroid;

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before;
import org.junit.Test
import kotlin.Exception

public class UseCaseUserListTest {

    lateinit var testDispatcher: TestDispatcher
    @Before
    fun setup() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testFetchOfUserCaseList() {
        val useCaseUserList = UseCaseUserList(DemoRepository(FakeLocalDataSource(), DemoRemoteDataSource(FakeAPI()), testDispatcher, testDispatcher ))
        runTest {
            val users = useCaseUserList.getAllUsersFromThisOrg("org1")
            Assert.assertTrue(users.isEmpty())
        }
    }

    @Test(expected = Exception::class)
    fun `if org id is empty throw exception`() {
        val useCaseUserList = UseCaseUserList(DemoRepository(FakeLocalDataSource(), DemoRemoteDataSource(FakeAPI()), testDispatcher, testDispatcher ))
        runTest {
            val users = useCaseUserList.getAllUsersFromThisOrg("")
        }
    }


}
