package cz.lebedev.mvapp;

import android.app.Application;
import android.os.Handler;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

public class DataViewModel extends AndroidViewModel {
    public MutableLiveData<String> data = new MutableLiveData<String>();

    DataModel dataModel;


    @Inject
    public DataViewModel(Application app){
        super(app);
        dataModel = new DataModel();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                reload();
            }
        },2000);    }

    private void reload() {
        String dataFromModel = dataModel.getData();
        data.postValue(dataFromModel);
    }

    public LiveData<String> getData() {
        return data;
    }

    public void setData(String s) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataModel.setData(s);
                reload();
            }
        },2000);
    }
}
