package gracodev.android.baubaptest.data.modules

import gracodev.android.baubaptest.data.repositories.MainActivityRepository
import gracodev.android.baubaptest.data.repositories.MainActivityRepositoryImpl
import gracodev.android.baubaptest.ui.viewmodels.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {


    factory<MainActivityRepository> {
        MainActivityRepositoryImpl()
    }

    viewModel {
        MainActivityViewModel(repository = get())
    }
}