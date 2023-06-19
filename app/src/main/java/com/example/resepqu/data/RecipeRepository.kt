package com.example.resepqu.data

import android.content.Context
import android.content.res.Resources
import com.example.resepqu.R
import com.example.resepqu.model.Recipe
import com.example.resepqu.model.Step


class RecipeRepository(private val context: Context) {
    private val resources: Resources = context.resources
    var listRecipe: List<Recipe>

    init {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataAuthorName = resources.getStringArray(R.array.data_author_name)
        val dataAuthorDom = resources.getStringArray(R.array.data_author_dom)
        val dataAuthorPhoto = resources.getStringArray(R.array.data_author_photo)
        val dataCreatedDate = resources.getStringArray(R.array.data_created_date)
        val listRecipe = ArrayList<Recipe>()
        for (i in dataTitle.indices) {
            val listStep = getListStep(i)
            val recipe = Recipe(dataTitle[i], dataDescription[i], dataPhoto[i], dataAuthorName[i], dataAuthorDom[i], dataAuthorPhoto[i], dataCreatedDate[i], listStep)
            listRecipe.add(recipe)
        }
        this.listRecipe = listRecipe
    }

    fun getRecipe(): List<Recipe> {
        return this.listRecipe
    }

    private fun getListStep(position: Int): ArrayList<Step> {
        val listStep = ArrayList<Step>()
        when (position) {
            0 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_0)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_0)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            1 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_1)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_1)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            2 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_2)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_2)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            3 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_3)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_3)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            4 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_4)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_4)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            5 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_5)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_5)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            6 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_6)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_6)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            7 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_7)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_7)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            8 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_8)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_8)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
            9 -> {
                val dataStepText = resources.getStringArray(R.array.data_howtotext_9)
                val dataStepImg = resources.getStringArray(R.array.data_howtoimage_9)

                for (j in dataStepText.indices) {
                    val step = Step(dataStepText[j], dataStepImg[j])
                    listStep.add(step)
                }
            }
        }
        return listStep
    }

    fun searchRecipe(query: String): List<Recipe>{
        return getRecipe().filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    fun getRecipeByTitle(title: String): Recipe {
        return listRecipe.first {
            it.title == title
        }
    }
}