package com.example.resepqu.ui.screen.list_recipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.resepqu.data.RecipeRepository
import com.example.resepqu.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListRecipeViewModel(private val repository: RecipeRepository) : ViewModel() {
    private val _groupedRecipe = MutableStateFlow(
        repository.getRecipe()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )
    val groupedRecipe: StateFlow<Map<Char, List<Recipe>>> get() = _groupedRecipe

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedRecipe.value = repository.searchRecipe(_query.value)
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    }
}