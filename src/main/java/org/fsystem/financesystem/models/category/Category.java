package org.fsystem.financesystem.models.category;

import org.fsystem.financesystem.models.Color;

public class Category {

    private final CategoryType categoryType;
    private CategoryIcon categoryIcon;
    private String description;
    private Color color;

    public Category(CategoryType categoryType, Color color, CategoryIcon categoryIcon, String description) {
        this.color = color;
        this.categoryType = categoryType;
        this.categoryIcon = categoryIcon;
        this.description = description;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public CategoryIcon getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(CategoryIcon categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getcolor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
