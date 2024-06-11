package com.patinfly.presentation.scooterList
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.remoteDbDataSource.ScooterAPIDataSource
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.usecase.GetSingleScooterUsercase
import com.patinfly.presentation.scooterList.ui.theme.PatinflyTheme


class SingleScooterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uuid: String? = intent.getStringExtra("UUID")
        Log.e("TAG check single",uuid.toString())

        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    val viewModel = ScooterViewModel(GetScooterUsecase(
//                    ), InsertScooterUsecase()
//                    )
                    ScooterInfo(uuid,
                        GetSingleScooterUsercase(ScooterRepository( ScooterDataSource.getInstance(LocalContext.current), AppDatabase.getDatabase(LocalContext.current).scooterDataSource(),
                            ScooterAPIDataSource.getInstance(LocalContext.current)))
                        )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SingleScooterActivityPreview() {
    PatinflyTheme {

    }
}