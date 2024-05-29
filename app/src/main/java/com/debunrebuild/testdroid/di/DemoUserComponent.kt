package com.debunrebuild.testdroid.di

import com.debunrebuild.testdroid.MainActivity
import dagger.Subcomponent


@Subcomponent
interface DemoUserComponent {
    //fun inject(activity: MainActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create(): DemoUserComponent
    }
}