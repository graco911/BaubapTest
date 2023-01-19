package gracodev.android.baubaptest

import gracodev.android.baubaptest.data.models.LoginData
import gracodev.android.baubaptest.data.repositories.MainActivityRepositoryImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class MainActivityTests {

    @Test
    fun validateCredentials_AddValidCredentials_SuccessValidation() {
        val email = "carlos@gmail.com"
        val pass = "Carlos123"
        val expectedResult = true
        val validationResult = MainActivityRepositoryImpl().validateCredentials(
            LoginData(email,pass)
        )
        assertEquals(expectedResult, validationResult)
    }
}