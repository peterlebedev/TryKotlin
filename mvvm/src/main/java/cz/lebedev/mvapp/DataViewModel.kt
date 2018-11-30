package cz.lebedev.mvapp

import android.app.Application
import android.os.Handler
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

import javax.inject.Inject

class DataViewModel @Inject
constructor(app: Application) : AndroidViewModel(app) {
    var data = MutableLiveData<String>()
    var loading = ObservableField<Boolean>()

    internal var dataModel: DataModel


    init {
        dataModel = DataModel()
        loading.set(true)
        Handler().postDelayed({ reload() }, 2000)
    }

    private fun reload() {
        val dataFromModel = dataModel.data
        data.postValue(dataFromModel)
        loading.set(false)
    }

    fun getData(): LiveData<String> {
        return data
    }

    fun setData(s: String) {
        loading.set(true)
        Handler().postDelayed({
            dataModel.data = s
            reload()
        }, 2000)
    }

    fun update(){
        setData(UUID.randomUUID().toString())
    }
}
