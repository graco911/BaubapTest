package gracodev.android.baubaptest.data.repositories

import gracodev.android.baubaptest.data.models.LoginData
import gracodev.android.baubaptest.data.usescases.UseCaseResult

interface MainActivityRepository {
    suspend fun validateLogin(loginData: LoginData): UseCaseResult<Boolean>
}

class MainActivityRepositoryImpl() : MainActivityRepository {
    override suspend fun validateLogin(loginData: LoginData): UseCaseResult<Boolean> {
        return if (loginData.email.isEmpty()
            || loginData.password.isEmpty()
        ) {
            UseCaseResult.Error(Unit)
        } else {
            UseCaseResult.Success(validateCredentials(loginData))
        }
    }

    private fun validateCredentials(loginData: LoginData): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(loginData.email).matches()
                && loginData.password.isNotEmpty()
    }
}