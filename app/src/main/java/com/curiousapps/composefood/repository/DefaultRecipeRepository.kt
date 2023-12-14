package com.curiousapps.composefood.repository

import com.curiousapps.composefood.domain.model.Recipe
import com.curiousapps.composefood.network.RecipeService
import com.curiousapps.composefood.network.model.RecipeDtoMapper

class DefaultRecipeRepository(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String):
            List<Recipe> {
        val result = recipeService.search(token, page, query).recipes
        return mapper.toDomainList(result)
    }

    override suspend fun get(token: String, id: Int):
            Recipe {
        val result = recipeService.get(token, id)
        return mapper.mapToDomainModel(result)
    }
}