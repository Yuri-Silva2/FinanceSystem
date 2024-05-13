package org.financesystem.model.creditcard;

import org.financesystem.model.Institution;

import java.time.LocalDate;
import java.util.UUID;

public class CreditcardDTO {

    private final UUID id;
    private final CreditcardFlag creditCardFlag;
    private final Institution institution;
    private final LocalDate closingDay;
    private final LocalDate dueDate;
    private String description;
    private double value;

    public CreditcardDTO(UUID id, CreditcardFlag creditCardFlag, Institution institution, LocalDate closingDay, LocalDate dueDate) {
        this.id = id;
        this.creditCardFlag = creditCardFlag;
        this.institution = institution;
        this.closingDay = closingDay;
        this.dueDate = dueDate;
    }

    public UUID getID() {
        return id;
    }

    public CreditcardFlag getCreditCardFlag() {
        return creditCardFlag;
    }

    public Institution getInstitution() {
        return institution;
    }

    public LocalDate getClosingDay() {
        return closingDay;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
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
}
