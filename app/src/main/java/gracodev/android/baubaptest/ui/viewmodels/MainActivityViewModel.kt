package gracodev.android.baubaptest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gracodev.android.baubaptest.data.models.LoginData
import gracodev.android.baubaptest.data.repositories.MainActivityRepository
import gracodev.android.baubaptest.data.usescases.UseCaseResult
import gracodev.android.baubaptest.utils.SingleLiveEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel(
    private val repository: MainActivityRepository
) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    private val showError = SingleLiveEvent<Unit>()
    private val isLogged = MutableLiveData<Boolean>()
    private var email = MutableLiveData("")
    private var password = MutableLiveData("")

    fun login() {
        launch {

            val result = withContext(Dispatchers.IO) {
                repository.validateLogin(LoginData(email.value!!, password.value!!))
            }
            when (result) {
                is UseCaseResult.Success -> isLogged.postValue(result.data)
                is UseCaseResult.Error -> showError.postValue(Unit)
            }
        }
    }

    fun onGetEmail(): MutableLiveData<String> = email
    fun onGetPassword(): MutableLiveData<String> = password
    fun onGetShowError(): LiveData<Unit> = showError
    fun onGetIsLogged(): LiveData<Boolean> = isLogged
}