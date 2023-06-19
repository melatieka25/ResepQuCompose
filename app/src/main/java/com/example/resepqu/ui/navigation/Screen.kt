package com.example.resepqu.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailRecipe : Screen("home/{recipeTitle}") {
        fun createRoute(recipeTitle: String) = "home/$recipeTitle"
    }
}