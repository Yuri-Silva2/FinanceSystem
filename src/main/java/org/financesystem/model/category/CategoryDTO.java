package org.financesystem.model.category;

import org.financesystem.model.Icon;
import org.financesystem.model.Color;

public class CategoryDTO {

    private final CategoryType categoryType;
    private String description;
    private Color color;
    private Icon icon;

    public CategoryDTO(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
