package com.debunrebuild.testdroid

interface IDemoRepository {

    suspend fun getUser(userid : String): User?
    suspend fun saveUser(user: User)

    suspend fun updateUSer(user: User)

    suspend fun removeUser(userid: String)

    suspend fun getAllUsersForThisOrg(orgId : String) : List<User>
}