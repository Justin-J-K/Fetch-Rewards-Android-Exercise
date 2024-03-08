package justinkim.fetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import justinkim.fetch.model.FetchItem
import justinkim.fetch.ui.theme.FetchRewardsExerciseTheme
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FetchRewardsExerciseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FetchItemsLazyColumn(fetchItemStateFlow = mainActivityViewModel.items)
                }
            }
        }
    }
}

@Composable
fun FetchItemsLazyColumn(fetchItemStateFlow: StateFlow<List<FetchItem>>, modifier: Modifier = Modifier) {
    val itemList by fetchItemStateFlow.collectAsState(initial = emptyList())
    val groupedItemList = itemList.groupBy { it.listId }

    LazyColumn (
        modifier = modifier.fillMaxSize()
    ) {
        groupedItemList.forEach { (listId, items) ->
            item {
                ListItemIdHeader(listId = listId)
            }
            items(items) {
                ListFetchItem(fetchItem = it)
            }
        }
        
    }
}

@Composable
fun ListItemIdHeader(listId: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .padding(vertical = 8.dp)
        .background(color = MaterialTheme.colorScheme.secondaryContainer)
        .padding(8.dp)
    ) {
        Row(modifier.fillMaxWidth()) {
            Text(text = "List ID $listId", style = MaterialTheme.typography.displayLarge)
        }
    }
}

@Composable
fun ListFetchItem(fetchItem: FetchItem, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .background(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium
        )
        .padding(8.dp)
    ) {
        Row(modifier.fillMaxWidth()) {
            Column {
                Text(text = fetchItem.name, style = MaterialTheme.typography.titleLarge)
                Text(text = "List ID: ${fetchItem.listId}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "ID: ${fetchItem.id}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}