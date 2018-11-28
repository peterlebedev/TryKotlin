package cz.lebedev.mvapp.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cz.lebedev.mvapp.DataViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DataViewModel.class)
    abstract ViewModel bindDataViewModel(DataViewModel DataViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
