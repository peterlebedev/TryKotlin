package cz.lebedev.mvapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cz.lebedev.mvapp.DataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DataViewModel::class)
    internal abstract fun bindDataViewModel(DataViewModel: DataViewModel): ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
