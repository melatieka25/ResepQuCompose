package com.example.resepqu.ui.screen.list_recipe


import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.resepqu.R
import com.example.resepqu.ViewModelFactory
import com.example.resepqu.data.RecipeRepository
import com.example.resepqu.ui.components.RecipeHeader
import com.example.resepqu.ui.components.RecipeListItem
import com.example.resepqu.ui.components.ScrollToTopButton
import com.example.resepqu.ui.components.SearchBar
import com.example.resepqu.ui.theme.ResepQuTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListRecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: ListRecipeViewModel = viewModel(
        factory = ViewModelFactory(
            RecipeRepository(
                LocalContext.current
            )
        )
    ),
    navigateToDetail: (String) -> Unit,
) {
    val groupedRecipe by viewModel.groupedRecipe.collectAsState()
    val query by viewModel.query

    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton: Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                SearchBar(
                    query = query,
                    onQueryChange = viewModel::search,
                    modifier = Modifier.background(MaterialTheme.colors.primary)
                )

                if (groupedRecipe.isNullOrEmpty()) {
                    AsyncImage(
                        model = "https://img.freepik.com/free-vector/no-data-concept-illustration_114360-536.jpg?w=740&t=st=1684077121~exp=1684077721~hmac=8b22357b8bac38612858784d51485acd5684cb5a81669631d67249675dd07e0f",
                        contentDescription = stringResource(R.string.no_recipe_img),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(200.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = stringResource(R.string.recipe_not_found),
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }

            groupedRecipe.forEach { (initial, recipes) ->
                stickyHeader {
                    RecipeHeader(initial)
                }
                items(recipes, key = { it.title }) { recipe ->
                    RecipeListItem(
                        title = recipe.title,
                        photoUrl = recipe.photo,
                        author = recipe.authorName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateItemPlacement(tween(durationMillis = 100))
                            .clickable {
                                navigateToDetail(recipe.title)
                            }
                    )
                }
            }
        }

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(
                onClick = {
                    scope.launch {
                        listState.scrollToItem(index = 0)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListRecipeScreenPreview() {
    ResepQuTheme {
        ListRecipeScreen(navigateToDetail = {})
    }
}