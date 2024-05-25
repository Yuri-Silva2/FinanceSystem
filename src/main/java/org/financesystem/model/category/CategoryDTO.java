package org.financesystem.model.category;

import org.financesystem.model.Color;
import org.financesystem.model.Icon;

import java.util.UUID;

public class CategoryDTO {

    private final UUID id;
    private final CategoryType categoryType;
    private String description;
    private Color color;
    private Icon icon;

    public CategoryDTO(UUID id, CategoryType categoryType) {
        this.id = id;
        this.categoryType = categoryType;
    }

    public UUID getId() {
        return id;
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
