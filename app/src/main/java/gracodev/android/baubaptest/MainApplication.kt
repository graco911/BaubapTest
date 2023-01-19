package gracodev.android.baubaptest

import android.app.Application
import gracodev.android.baubaptest.data.modules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(appModules)
        }
    }
}