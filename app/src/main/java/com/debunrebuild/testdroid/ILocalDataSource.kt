package com.debunrebuild.testdroid

interface ILocalDataSource {

    fun saveDummyData(user: User)

    fun getDummyData(id : String) : User?

    fun removeDummyData(id: String)

    fun updateDummyData(user: User)

    suspend fun insertAll(users: List<User>)
    suspend fun getAllUsersForThisOrg(orgId: String) : List<User>
}

data class User(val id: String, val name: String, val orgId : String)