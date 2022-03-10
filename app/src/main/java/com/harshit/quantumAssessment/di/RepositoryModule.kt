package com.harshit.quantumAssessment.di

import com.harshit.quantumAssessment.network.Services
import com.harshit.quantumAssessment.pojo.firebase.FirebaseSource
import com.harshit.quantumAssessment.ui.auth.UserRepository
import com.harshit.quantumAssessment.ui.home.HomeRepository
import com.harshit.quantumAssessment.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideConstants(): Constants {
        return Constants
    }

    @Singleton
    @Provides
    fun provideFirebase(): FirebaseSource{
        return FirebaseSource()
    }

    @Singleton
    @Provides
    fun provideHomeRepository(webServices: Services, constants: Constants, firebaseSource: FirebaseSource): HomeRepository {
        return HomeRepository(webServices, constants, firebaseSource)
    }

    @Singleton
    @Provides
    fun provideUserRepository(firebaseSource: FirebaseSource): UserRepository{
        return UserRepository(firebaseSource)
    }
}