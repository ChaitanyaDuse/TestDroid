package com.debunrebuild.testdroid

import javax.inject.Inject

class UseCaseUserList @Inject constructor (private val repository: IDemoRepository) : IUseCaseUserList {
    override suspend fun getAllUsersFromThisOrg(org: String): List<User> {
        if(org.isEmpty()) {
            throw Exception("Invalid Org Id")
        }
        return repository.getAllUsersForThisOrg(org)
    }

}