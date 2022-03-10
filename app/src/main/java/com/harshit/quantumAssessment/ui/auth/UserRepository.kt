package com.harshit.quantumAssessment.ui.auth

import com.harshit.quantumAssessment.pojo.firebase.FirebaseSource
import javax.inject.Inject

class UserRepository
@Inject constructor(
    private val firebaseSource: FirebaseSource
) {
    fun login(email: String, password: String) = firebaseSource.login(email, password)

    fun register(email: String, password: String) = firebaseSource.register(email, password)

    fun currentUser() = firebaseSource.currentUser()

    fun logout() = firebaseSource.logout()
}