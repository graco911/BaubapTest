package gracodev.android.baubaptest.data.usescases

sealed class UseCaseResult<out T : Any> {
    class Success<out T : Any>(val data: T) : UseCaseResult<T>()
    class Error(val exception: Unit) : UseCaseResult<Nothing>()
}