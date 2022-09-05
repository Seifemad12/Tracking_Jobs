package com.example.trackingjobs.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.trackingjobs.data.JobDatabase
import com.example.trackingjobs.data.UserDao
import com.example.trackingjobs.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<UserModel>>
    private var userDaoObj: UserDao
    init {
        val userDao = JobDatabase.getDatabse(application).userDao()
        userDaoObj = userDao
        readAllData = userDao.readAllData()
    }

    fun addUser(user: UserModel){
        viewModelScope.launch(Dispatchers.IO) {
            userDaoObj.addUser(user)
        }

    }
    fun updateUser(user: UserModel){
        viewModelScope.launch(Dispatchers.IO) {
            userDaoObj.updateUser(user)
        }

    }
    fun deleteUser(user: UserModel){
        viewModelScope.launch(Dispatchers.IO) {
            userDaoObj.deleteUser(user)
        }

    }
}