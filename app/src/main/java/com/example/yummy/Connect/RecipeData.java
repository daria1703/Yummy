package com.example.yummy.Connect;

public class RecipeData {

    private final int recipeId;
    private final int customerId;
    private final String category;
    private final String title;
    private final String description;
    private final String ingredients;

    public RecipeData(int recipeId, int customerId, String category, String title,
                      String description, String ingredients) {
        this.recipeId = recipeId;
        this.customerId = customerId;
        this.category = category;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }
}
