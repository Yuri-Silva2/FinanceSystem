package org.financesystem.model.creditcard;

import org.financesystem.model.Institution;

import java.time.LocalDate;

public class CreditcardDTO {

    private final CreditcardFlag creditCardFlag;
    private final Institution institution;
    private LocalDate closingDay;
    private String description;
    private LocalDate dueDate;
    private double value;

    public CreditcardDTO(CreditcardFlag creditCardFlag, Institution institution) {
        this.creditCardFlag = creditCardFlag;
        this.institution = institution;
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

    public void setClosingDay(LocalDate closingDay) {
        this.closingDay = closingDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
