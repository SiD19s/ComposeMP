package org.example.composemp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import composemp.composeapp.generated.resources.Res
import composemp.composeapp.generated.resources.addiction
import composemp.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            modifier =Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(Res.drawable.addiction),"")
            Text(
                text = stringResource(Res.string.app_name),
            )
        }
    }
}

