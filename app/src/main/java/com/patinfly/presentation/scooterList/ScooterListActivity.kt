package com.patinfly.presentation.scooterList

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.dbDataSource.ScooterDao
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.usecase.GetScooterUsecase
import com.patinfly.presentation.scooterList.ui.theme.PatinflyTheme
import org.json.JSONArray
import java.io.InputStream
import java.nio.charset.StandardCharsets

//creare una funzioe che legge i file json come in RegisterActivity
//diversa da come la implementa lui nel paper L4

//implementa la interfaccia come in registerActivity

class ScooterListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val viewModel: ScooterViewModel = ScooterViewModel(GetScooterUsecase(
//                        ScooterRepository(ScooterDataSource(),
//                            AppDatabase.getDatabase(LocalContext.current).scooterDataSource())
                    ))
                    ScooterListScreen(context = this.applicationContext, viewModel = viewModel)
                }
            }
        }
    }



    private fun loadJson(): JSONArray?{
        return try {
            val inputStream: InputStream = assets.open("scooter.json")
            val size:Int=inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val json = String(buffer, StandardCharsets.UTF_8)
            val jsonArray = JSONArray(json)

            jsonArray
        }catch (error:Exception){
            Log.e("TAG","loadJson: error")
            null
        }
    }
}

//fun ScooterScreen


@Preview(showBackground = true)
@Composable
fun ScooterListPreview() {
    PatinflyTheme {

    }
}