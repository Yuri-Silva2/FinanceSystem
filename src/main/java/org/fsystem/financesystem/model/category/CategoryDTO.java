package org.fsystem.financesystem.model.category;

import org.fsystem.financesystem.model.Color;
import org.fsystem.financesystem.model.Icon;

public class CategoryDTO {

    private final CategoryType categoryType;
    private Icon icon;
    private String description;
    private Color color;

    public CategoryDTO(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon categoryIcon) {
        this.icon = categoryIcon;
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
