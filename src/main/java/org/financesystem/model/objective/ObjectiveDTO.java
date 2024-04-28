package org.financesystem.model.objective;

import org.financesystem.model.Color;
import org.financesystem.model.Icon;

import java.time.LocalDate;
import java.util.UUID;

public class ObjectiveDTO {

    private final UUID userUUID;
    private ObjectiveSituation objectiveSituation;
    private double initialValue;
    private String description;
    private final String name;
    private LocalDate date;
    private double value;
    private Color color;
    private Icon icon;

    public ObjectiveDTO(UUID userUUID, String name) {
        this.userUUID = userUUID;
        this.name = name;
    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public ObjectiveSituation getObjectiveSituation() {
        return objectiveSituation;
    }

    public void setObjectiveSituation(ObjectiveSituation objectiveSituation) {
        this.objectiveSituation = objectiveSituation;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
