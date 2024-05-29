package com.debunrebuild.testdroid

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class DemoRepositoryTest {
    lateinit var testDispatcher: TestDispatcher


    @Before
    fun setup() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)

    }

    @Test
    fun `save user to sb check if present`() {
       val  fakeLocalDataSource = FakeLocalDataSource()
       val  fakeRemoteDataSource = FakeRemoteDataSource()
       val  repository = DemoRepository(fakeLocalDataSource,fakeRemoteDataSource, testDispatcher, testDispatcher)
        val user = User("123", "John Doe", "org1")
        runTest {
            repository.saveUser(user)
            val fromDb = repository.getUser("123")
            Assert.assertNotNull(fromDb)
        }
    }

    @Test
    fun updateUser() {
        val  fakeLocalDataSource = FakeLocalDataSource()
        val  fakeRemoteDataSource = FakeRemoteDataSource()
        val  repository = DemoRepository(fakeLocalDataSource, fakeRemoteDataSource, testDispatcher, testDispatcher)
        val user = User("123", "John Doe", "org1")
        runTest {
            repository.saveUser(user)
            repository.updateUSer(User("123", "Martha Stuart", "org1"))
            val userFromDb = repository.getUser("123")
            Assert.assertEquals(userFromDb?.name, "Martha Stuart")
        }
    }

    @Test
    fun removeUser() {
        val  fakeLocalDataSource = FakeLocalDataSource()
        val  fakeRemoteDataSource = FakeRemoteDataSource()
        val  repository = DemoRepository(fakeLocalDataSource,fakeRemoteDataSource, testDispatcher, testDispatcher)
        val user = User("123", "John Doe", "org1")
        runTest {
            repository.saveUser(user)
            repository.removeUser("123")
            val userFromDb = repository.getUser("123")
            Assert.assertNull(userFromDb)
        }
    }

    @Test
    fun `return non empty userlist for org`() {
        val  fakeLocalDataSource = FakeLocalDataSource()
        val  fakeRemoteDataSource = FakeRemoteDataSource()
        val  repository = DemoRepository(fakeLocalDataSource, fakeRemoteDataSource, testDispatcher, testDispatcher)
        runTest {
            fakeLocalDataSource.insertAll(getDummyListOfUsers())
            val listOfUsers = repository.getAllUsersForThisOrg("Org1")
            Assert.assertFalse(listOfUsers.isEmpty())
        }
    }


}