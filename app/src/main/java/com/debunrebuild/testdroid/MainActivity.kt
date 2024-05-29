package com.debunrebuild.testdroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.debunrebuild.testdroid.di.DemoUserComponent
import com.debunrebuild.testdroid.di.ViewModelFactory
import javax.inject.Inject

class  MainActivity : AppCompatActivity() {

    @Inject
     lateinit var viewModelFactory: ViewModelFactory<DemoViewModel>

     private val demoViewModel: DemoViewModel by lazy {
         ViewModelProvider.create(this, viewModelFactory).get(DemoViewModel::class)
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        DemoApp.getAppComponent().inject(this)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        demoViewModel.setup("org1")
    }
}