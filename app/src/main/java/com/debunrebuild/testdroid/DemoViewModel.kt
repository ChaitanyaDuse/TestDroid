package com.debunrebuild.testdroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class DemoViewModel @Inject constructor (private val useCaseUserList: UseCaseUserList) : ViewModel() {
    val liveData = MutableLiveData<ScreenState>()

    fun setup(orgId : String) {
        //Log.d("VM", "Setup complete")
        viewModelScope.launch {
            try {
                val users =  useCaseUserList.getAllUsersFromThisOrg(orgId)
                if(users.isEmpty()) {
                    liveData.postValue(ScreenState.Empty)
                }
            } catch (ex : Exception) {
                liveData.postValue(ScreenState.Error(1))
            }


        }
    }
}

sealed class ScreenState {
    object Empty : ScreenState()
    class ShowList(val userList: List<User>) : ScreenState()
    class Error(errorCode : Int) : ScreenState()

}