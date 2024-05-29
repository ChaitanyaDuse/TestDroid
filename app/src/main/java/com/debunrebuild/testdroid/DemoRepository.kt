package com.debunrebuild.testdroid

import com.debunrebuild.testdroid.di.DefaultDispatcher
import com.debunrebuild.testdroid.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

class DemoRepository(private val localdataSource: ILocalDataSource, private val remoteDataSource: IDemoRemoteDataSource, @IoDispatcher private val ioDispatcher: CoroutineDispatcher, @DefaultDispatcher defaultDispatcher: CoroutineDispatcher) : IDemoRepository {
    override suspend fun getUser(userid: String): User? {
        return localdataSource.getDummyData(userid)
    }

    override suspend fun saveUser(user: User) {
        return localdataSource.saveDummyData(user)
    }

    override suspend fun updateUSer(user: User) {
        return localdataSource.updateDummyData(user)
    }

    override suspend fun removeUser(userid: String) {
        localdataSource.removeDummyData(userid)
    }

    override suspend fun getAllUsersForThisOrg(orgId: String) : List<User> {
        return localdataSource.getAllUsersForThisOrg(orgId)
    }
}