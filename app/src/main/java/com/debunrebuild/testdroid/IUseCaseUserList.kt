package com.debunrebuild.testdroid

interface IUseCaseUserList {
    suspend fun getAllUsersFromThisOrg(org : String) : List<User>
}