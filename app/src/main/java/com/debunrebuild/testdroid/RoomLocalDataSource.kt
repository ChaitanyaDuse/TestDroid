package com.debunrebuild.testdroid

class RoomLocalDataSource : ILocalDataSource {

    val mapOfUser = HashMap<String, User>()
    override fun saveDummyData(user: User) {
        mapOfUser.put(user.id, user)
    }

    override fun getDummyData(userId: String): User? {
        return mapOfUser.get(userId)
    }

    override fun removeDummyData(id: String) {
        mapOfUser.remove(id)
    }

    override fun updateDummyData(user: User) {
        mapOfUser.remove(user.id)
        mapOfUser.put(user.id, user)
    }

    override suspend fun insertAll(users: List<User>) {
       users.forEach { user ->
           mapOfUser.put(user.id, user)
       }
    }

    override suspend fun getAllUsersForThisOrg(orgId: String): List<User> {
        return mapOfUser.values.filter { user -> user.orgId == orgId }
    }
}

fun getDummyListOfUsers() : List<User> {
    val userList = arrayListOf<User>()
    userList.add(User("123", "John", "Org1"))
    userList.add(User("124", "Joe", "Org1"))
    userList.add(User("125", "Joseph", "Org1"))
    userList.add(User("126", "Johnny", "Org1"))
    userList.add(User("127", "Jarvis", "Org2"))
    userList.add(User("128", "Jack", "Org2"))
    userList.add(User("129", "Jackie", "Org2"))
    userList.add(User("130", "Jacquline", "Org3"))
    userList.add(User("131", "Johnson", "Org3"))
    return userList
}