package gracodev.android.baubaptest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gracodev.android.baubaptest.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel() : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    private val showError = SingleLiveEvent<String>()
    private val isLogged = MutableLiveData<Boolean>()
    private var email = MutableLiveData<String>()
    private var password = MutableLiveData<String>()

    fun login() {
        launch {
            if (email.value.isNullOrEmpty()
                || password.value.isNullOrEmpty()) {
                showError.value = "Agregue los datos faltantes"
            } else {
                isLogged.postValue(validateLogin())
            }
        }
    }

    private fun validateLogin(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email.value).matches()
                && !password.value.isNullOrEmpty()
    }

    fun onGetEmail(): MutableLiveData<String> = email
    fun onGetPassword(): MutableLiveData<String> = password
    fun onGetShowError(): LiveData<String> = showError
    fun onGetIsLogged(): LiveData<Boolean> = isLogged
}