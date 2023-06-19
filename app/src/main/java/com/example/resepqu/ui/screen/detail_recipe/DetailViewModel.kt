package com.example.resepqu.ui.screen.detail_recipe

import androidx.lifecycle.ViewModel
import com.example.resepqu.data.RecipeRepository
import com.example.resepqu.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailViewModel(private val repository: RecipeRepository, private val recipeTitle: String) :
    ViewModel() {
    private val _recipe = MutableStateFlow(
        repository.getRecipeByTitle(recipeTitle)
    )
    val recipe: StateFlow<Recipe> get() = _recipe
}