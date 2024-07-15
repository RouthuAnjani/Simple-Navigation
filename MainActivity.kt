package com.example.mynav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynav.ui.theme.MyNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val navController = rememberNavController()
//                    NavHost(
//                        navController = navController,
//                        startDestination = "firstscreen", builder = {
//                            composable("firstscreen") {
//                                FirstScreen(navController)
//                            }
//                            composable("secondscreen") {
//                                SecondScreen(navController)
//                            }
//                        }
//                    )

//Column {
    AssistChipExample()
//    FilterChipExample()
//    InputChipExample(text = "Anjani", onDismiss = { Unit })
//    SuggestionChipExample()
//    ElevatedAssistChipExample()
//}

                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    val msg = navController.currentBackStackEntry?.savedStateHandle?.get<String>("msg")
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("secondscreen") }) {
            Text("Go to next screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        msg?.let {
            Text(it)
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text, onValueChange = { text = it },
            placeholder = {
                Text("Enter text", color = Color.Gray)
            })
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            navController.previousBackStackEntry?.savedStateHandle?.set("msg", text)
            navController.popBackStack()
        }) {
            Text(text = "Submit")
        }
    }
}