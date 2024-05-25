package org.financesystem.model.account;

import org.financesystem.model.Color;
import org.financesystem.model.Institution;

import java.util.UUID;

public record AccountDTO(UUID uuid, Institution institution, AccountType accountType, boolean quickAddNotification,
                         boolean includeHomeScreen, String description, double value, Color color) {
}
