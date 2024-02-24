package com.example.shaikhcommunication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shaikhcommunication.data.DataSource
import com.example.shaikhcommunication.model.Mobiles
import com.example.shaikhcommunication.ui.theme.ShaikhCommunicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShaikhCommunicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShaikhApp()
                }
            }
        }
    }
}

@Composable
fun ShaikhApp() {
    ShaikhAppList(mobiles = DataSource().loadMobiles())
}

@Composable
fun ShaikhAppList(mobiles : List<Mobiles> ,modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(mobiles) {
            mobiles -> ShaikhAppCard(
            mobiles,
                modifier = Modifier
                .padding(8.dp)
            )

        }
    }
}

@Composable
fun ShaikhAppCard(mobiles: Mobiles, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
        containerColor =  MaterialTheme.colorScheme.primaryContainer,
    )
    ){
    Column {
        Image(
            painter = painterResource(mobiles.modelImage),
            contentDescription = stringResource(R.string.mobile1),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(
            text = stringResource(mobiles.modelName),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
    }
}

@Preview()
@Composable
fun ShaikhAppPreview() {
    ShaikhCommunicationTheme {
        ShaikhApp()
    }
}