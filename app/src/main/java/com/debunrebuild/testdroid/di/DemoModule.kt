package com.debunrebuild.testdroid.di

import com.debunrebuild.testdroid.DemoAPI
import com.debunrebuild.testdroid.DemoRemoteDataSource
import com.debunrebuild.testdroid.DemoRepository
import com.debunrebuild.testdroid.IDemoRemoteDataSource
import com.debunrebuild.testdroid.IDemoRepository
import com.debunrebuild.testdroid.ILocalDataSource
import com.debunrebuild.testdroid.IUseCaseUserList
import com.debunrebuild.testdroid.RoomLocalDataSource
import com.debunrebuild.testdroid.UseCaseUserList
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
object DemoModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(demoAPI: DemoAPI) : IDemoRemoteDataSource {
        return DemoRemoteDataSource(demoAPI)
    }

    @Provides
    @Singleton
    fun providesLocalDataSource() : ILocalDataSource {
        return RoomLocalDataSource()
    }

    @Provides
    @Singleton
    fun providesDemoRepository(localDataSource: ILocalDataSource, remoteDataSource: IDemoRemoteDataSource, @IoDispatcher ioDispatcher: CoroutineDispatcher, @DefaultDispatcher defaultDispatcher: CoroutineDispatcher) : IDemoRepository {
        return DemoRepository(localDataSource, remoteDataSource, ioDispatcher, defaultDispatcher )
    }

    @Provides
    @Singleton
    fun providesDemoUseCase(demoRepository: IDemoRepository) : IUseCaseUserList {
        return UseCaseUserList(demoRepository)
    }



}