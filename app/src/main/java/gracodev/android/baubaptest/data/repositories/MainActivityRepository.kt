package gracodev.android.baubaptest.data.repositories

import androidx.annotation.VisibleForTesting
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

    @VisibleForTesting
    internal fun validateCredentials(loginData: LoginData): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return emailRegex.toRegex().matches(loginData.email)
                && loginData.password.isNotEmpty()
    }
}