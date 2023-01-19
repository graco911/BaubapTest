package gracodev.android.baubaptest.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import gracodev.android.baubaptest.R
import gracodev.android.baubaptest.databinding.ActivityMainBinding
import gracodev.android.baubaptest.ui.viewmodels.MainActivityViewModel
import gracodev.android.baubaptest.utils.alert
import gracodev.android.baubaptest.utils.neutralButton
import gracodev.android.baubaptest.utils.snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mainActivityViewModel = viewModel

        binding.lifecycleOwner = this

        binding.apply {
            loginButton.setOnClickListener {
                viewModel.login()
            }
        }

        initViewModel()
    }

    private fun initViewModel() {

        viewModel.apply {

            onGetIsLogged().observe(this@MainActivity) { isLogged ->
                alert {
                    setTitle("Información")
                    setMessage(if (isLogged) "Login exitoso" else "Revisa tus credenciales")
                    neutralButton("Aceptar") {
                        it.dismiss()
                    }
                }
            }

            onGetShowError().observe(this@MainActivity) { showError ->
                binding.root.snackbar(showError)
            }
        }
    }
}