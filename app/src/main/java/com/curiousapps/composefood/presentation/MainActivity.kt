package com.curiousapps.composefood.presentation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.curiousapps.composefood.R
import com.curiousapps.composefood.network.RecipeService
import com.curiousapps.composefood.presentation.ui.recipe_list.RecipeListFragment
import com.curiousapps.composefood.presentation.ui.theme.ComposeFoodTheme
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Field Injection
    @Inject
    lateinit var randomHiltString: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)


        //serviceTest()
        somebodyLogHiltString()
//        setContent {
//            ComposeFoodTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }

    }

    private fun somebodyLogHiltString() {
        Log.i(TAG, "onCreate: $randomHiltString")
//         supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.main_container, RecipeListFragment())
//                .commit()
        }

    private fun serviceTest(){
        val service = Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)

        CoroutineScope(IO).launch {
            val recipe = service.get(
                token = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
                id = 116
            )
//            val tv = findViewById<TextView>(R.id.tv)
//            tv.text = recipe.title
//            Log.i("MainActivity", "onCreate: ${recipe.title}")
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@OptIn(ExperimentalMaterialApi::class)
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeFoodTheme(
//        darkTheme: Boolean,
//        displayProgressBar: Boolean,
//        scaffoldState: ScaffoldState,
//    ) {
//        Greeting("Android")
//    }
//}