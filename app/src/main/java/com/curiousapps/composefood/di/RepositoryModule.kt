package com.curiousapps.composefood.di

import com.curiousapps.composefood.network.RecipeService
import com.curiousapps.composefood.network.model.RecipeDtoMapper
import com.curiousapps.composefood.repository.DefaultRecipeRepository
import com.curiousapps.composefood.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository{
        return DefaultRecipeRepository(
            recipeService = recipeService,
            mapper = recipeDtoMapper
        )
    }
}