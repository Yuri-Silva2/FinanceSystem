package org.fsystem.financesystem.models.account;

import org.fsystem.financesystem.models.Color;

public class Account {

    private final Institutions institutions;
    private final AccountType accountType;
    private boolean quickAddNotification;
    private boolean includeHomeScreen;
    private String description;
    private Color color;

    public Account(Institutions institutions, String description, AccountType accountType, Color color, boolean includeHomeScreen, boolean quickAddNotification) {
        this.institutions = institutions;
        this.description = description;
        this.accountType = accountType;
        this.color = color;
        this.includeHomeScreen = includeHomeScreen;
        this.quickAddNotification = quickAddNotification;
    }

    public Institutions getInstitutions() {
        return institutions;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
