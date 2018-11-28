package cz.lebedev.mvapp

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import cz.lebedev.mvapp.databinding.ActivityMainBinding

import javax.inject.Inject
import java.util.UUID

class MainActivity : AppCompatActivity() {

    var dataViewModel: DataViewModel? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    var viewDataBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        dataViewModel = ViewModelProviders.of(this, viewModelFactory).get(DataViewModel::class.java)
        viewDataBinding!!.showProgress = true
        dataViewModel!!.getData().observe(this, Observer {
            viewDataBinding?.data = it
            viewDataBinding!!.showProgress = false
        })

        viewDataBinding!!.bvSet.setOnClickListener { v ->
            viewDataBinding!!.showProgress = true
            dataViewModel!!.setData(UUID.randomUUID().toString())
        }
    }
}
