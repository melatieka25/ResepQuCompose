package com.example.resepqu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.resepqu.data.RecipeRepository
import com.example.resepqu.ui.screen.detail_recipe.DetailViewModel
import com.example.resepqu.ui.screen.list_recipe.ListRecipeViewModel

class ViewModelFactory(private val repository: RecipeRepository, private val recipeTitle: String = "") :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListRecipeViewModel::class.java)) {
            return ListRecipeViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository, recipeTitle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}