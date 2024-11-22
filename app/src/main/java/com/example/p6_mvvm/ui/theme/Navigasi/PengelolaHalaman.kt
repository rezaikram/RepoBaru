import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.praktikum7.model.JenisKelamin.JenisKelamin
import com.example.praktikum7.viewmodel.MahasiswaViewModel
//Quest6_3NIM
@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        navController = navHost,
        startDestination = Halaman.FORMULIR.name) {
        composable(
            route = Halaman.FORMULIR.name
        ) {
            val konteks = LocalContext.current
            MahasiswaViewModel(
                JenisKelamin = JenisKelamin.map { id ->
                    konteks.getString(id)
                },
                onSubmitClicked = {
                    viewModel.setMahasiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
    }
}