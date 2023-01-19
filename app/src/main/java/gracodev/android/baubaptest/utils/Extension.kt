package gracodev.android.baubaptest.utils

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

fun View.snackbar(message: String) {
    val snackbar = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
            snackbar.setAction("Aceptar") {
                snackbar.dismiss()
            }
        }
    snackbar.view.background = ContextCompat.getDrawable(context, android.R.color.black)
    snackbar.show()
}