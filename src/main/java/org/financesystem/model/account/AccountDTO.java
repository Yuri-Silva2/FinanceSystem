package org.financesystem.model.account;

import org.financesystem.model.Color;
import org.financesystem.model.Institution;

import java.util.UUID;

public class AccountDTO {

    private final UUID id;
    private final Institution institution;
    private final AccountType accountType;
    private boolean quickAddNotification;
    private boolean includeHomeScreen;
    private String description;
    private double value;
    private Color color;

    public AccountDTO(UUID id, Institution institution, AccountType accountType) {
        this.id = id;
        this.institution = institution;
        this.accountType = accountType;
    }

    public UUID getID() {
        return id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public boolean isQuickAddNotification() {
        return quickAddNotification;
    }

    public void setQuickAddNotification(boolean quickAddNotification) {
        this.quickAddNotification = quickAddNotification;
    }

    public boolean isIncludeHomeScreen() {
        return includeHomeScreen;
    }

    public void setIncludeHomeScreen(boolean includeHomeScreen) {
        this.includeHomeScreen = includeHomeScreen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
