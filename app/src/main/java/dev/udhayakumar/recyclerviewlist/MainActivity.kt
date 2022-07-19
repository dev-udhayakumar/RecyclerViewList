package dev.udhayakumar.recyclerviewlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.udhayakumar.recyclerviewlist.ui.theme.RecyclerViewListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var  sampledatas = mutableListOf<smapledata>()
                    sampledatas.add(smapledata("CSE", stringResource(id = R.string.dis_cse)))
                    sampledatas.add(smapledata("ECE", stringResource(id = R.string.dis_ece)))
                    sampledatas.add(smapledata("EEE", stringResource(id = R.string.dis_eee)))
                    sampledatas.add(smapledata("CIV", stringResource(id = R.string.dis_civ)))
                    sampledatas.add(smapledata("CHE", stringResource(id = R.string.dis_che)))
                    sampledatas.add(smapledata("BIO", stringResource(id = R.string.dis_bio)))
                    sampledatas.add(smapledata("IT", stringResource(id = R.string.dis_it)))
                    Column() {
                        Row {
                            topbar()
                            //Text(text = stringResource(id = R.string.app_name), fontSize = 30.sp, modifier = Modifier.padding(16.dp))
                        }
                        Row() {
                            LazyColumn{
                                items(sampledatas){
                                        index -> card(title = index.title, dis = index.dis)
                                }
                            }
                        }
                    }


                }
            }
        }
    }

}

@Composable
fun card(title : String , dis : String ){
    Card(modifier = Modifier
        .padding(16.dp)
        .wrapContentHeight()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = title , fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = dis , fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun topbar(){
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) }
    )
}

data class smapledata(val title :String , val  dis: String){

}

