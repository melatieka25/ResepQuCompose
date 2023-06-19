package com.example.resepqu.ui.screen.detail_recipe

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.resepqu.R
import com.example.resepqu.data.RecipeRepository
import com.example.resepqu.model.Step
import com.example.resepqu.ui.components.StepListItem
import com.example.resepqu.ui.theme.ResepQuTheme

@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
) {
    val recipe by viewModel.recipe.collectAsState()
    DetailContent(
        title = recipe.title,
        photoUrl = recipe.photo,
        author = recipe.authorName,
        createdDate = recipe.createdDate,
        listStep = recipe.listStep
    )
}

@Composable
fun DetailContent(
    title: String,
    photoUrl: String,
    author: String,
    createdDate: String,
    listStep: List<Step>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            )

            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                    )
                    Text(
                        text = "$author - $createdDate",
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier.padding(bottom = 16.dp),
                    )

                    Text(
                        text = stringResource(R.string.cara_membuat),
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.Bold
                        ),
                    )
                }
                items(listStep, key = { it.text }) { step ->
                    StepListItem(
                        text = step.text,
                        photoUrl = step.photo,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Divider()
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    val recipe = RecipeRepository(LocalContext.current).listRecipe[0]
    ResepQuTheme {
        DetailContent(
            recipe.title,
            recipe.photo,
            recipe.authorName,
            recipe.createdDate,
            recipe.listStep,
        )
    }
}