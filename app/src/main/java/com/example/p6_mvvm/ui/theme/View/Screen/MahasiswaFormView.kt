import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum7.model.JenisKelamin.JenisKelamin
import com.example.praktikum7.viewmodel.MahasiswaViewModel
import java.lang.reflect.Modifier

sealed class Halaman(val name: String) {
    object FORMULIR : Halaman("formulir")
    object TAMPILDATA : Halaman("tampildata")
}

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
            FormulirView(
                ListJK = JenisKelamin.map { id ->
                    konteks.getString(id)
                },
                onSubmitClicked = {
                    viewModel.setDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
    }
}