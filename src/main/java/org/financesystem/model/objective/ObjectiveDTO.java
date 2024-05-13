package org.financesystem.model.objective;

import org.financesystem.model.Color;
import org.financesystem.model.Icon;

import java.time.LocalDate;
import java.util.UUID;

public class ObjectiveDTO {

    private final UUID id;
    private final ObjectiveSituation situation;
    private double initialValue;
    private String description;
    private final String name;
    private LocalDate date;
    private double value;
    private Color color;
    private Icon icon;

    public ObjectiveDTO(UUID id, ObjectiveSituation situation, String name) {
        this.id = id;
        this.situation = situation;
        this.name = name;
    }

    public UUID getID() {
        return id;
    }

    public ObjectiveSituation getSituation() {
        return situation;
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
