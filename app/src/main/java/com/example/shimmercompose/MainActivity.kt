package com.example.shimmercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shimmercompose.ui.ListItem
import com.example.shimmercompose.ui.ShimmerListItem
import com.example.shimmercompose.ui.theme.ShimmerComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShimmerComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var isLoading by rememberSaveable {
                        mutableStateOf(true)
                    }
                    LaunchedEffect(key1 = Unit) {
                        delay(5000)
                        isLoading = false
                    }
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(20) {
                            ShimmerListItem(
                                isLoading = isLoading,
                                contentAfterLoading = {
                                    ListItem(
                                        text = "This is some long sample text that hopefully spans over multiple lines so we can see the shimmer effect in action.",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}