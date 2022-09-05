package com.example.trackingjobs.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.trackingjobs.model.UserModel

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(userModel: UserModel)

    @Query("select * from todoData Order By id Asc")
    fun readAllData():LiveData<List<UserModel>>

    @Update
    suspend fun updateUser(userModel: UserModel)

    @Delete
    suspend fun deleteUser(userModel: UserModel)
}