package com.debunrebuild.testdroid.di;

import com.debunrebuild.testdroid.DemoViewModel
import com.debunrebuild.testdroid.MainActivity;

import dagger.Component;
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Component(modules = [IOModule::class, DemoModule::class, AppModule::class])
interface ApplicationComponent {

    fun demoUserComponent() : DemoUserComponent.Factory


    fun inject(activity:MainActivity)

   // fun inject(viewModel : DemoViewModel)


}
