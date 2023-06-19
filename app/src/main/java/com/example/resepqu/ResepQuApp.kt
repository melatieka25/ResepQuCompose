package com.example.resepqu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.resepqu.data.RecipeRepository
import com.example.resepqu.ui.components.BottomBar
import com.example.resepqu.ui.components.TopBar
import com.example.resepqu.ui.navigation.Screen
import com.example.resepqu.ui.screen.detail_recipe.DetailScreen
import com.example.resepqu.ui.screen.list_recipe.ListRecipeScreen
import com.example.resepqu.ui.screen.profile.ProfileScreen
import com.example.resepqu.ui.theme.ResepQuTheme

@Composable
fun ResepQuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute == Screen.DetailRecipe.route) {

                TopBar(
                    onBackClick = {navController.navigateUp()}
                )
            }
        },
        bottomBar = {
            if (currentRoute != Screen.DetailRecipe.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                ListRecipeScreen(
                    navigateToDetail = { recipeTitle ->
                        navController.navigate(Screen.DetailRecipe.createRoute(recipeTitle))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailRecipe.route,
                arguments = listOf(navArgument("recipeTitle") { type = NavType.StringType }),
            ) {
                val title = it.arguments?.getString("recipeTitle") ?: ""
                DetailScreen(
                    viewModel = viewModel(factory = ViewModelFactory(RecipeRepository(
                    LocalContext.current), title))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResepQuAppPreview() {
    ResepQuTheme {
        ResepQuApp()
    }
}
