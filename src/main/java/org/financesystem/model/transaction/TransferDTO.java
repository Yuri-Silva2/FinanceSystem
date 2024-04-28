package org.financesystem.model.transaction;

import org.financesystem.model.category.CategoryDTO;

import java.time.LocalDate;
import java.util.UUID;

public class TransferDTO implements Transaction {

    private UUID userUUID;
    private String observations;
    private CategoryDTO category;
    private boolean ignoreValue;
    private boolean fixedValue;
    private double value;
    private LocalDate date;

    @Override
    public void setUserUUID(UUID userUUID) {

    }

    @Override
    public UUID getUserUUID() {
        return userUUID;
    }

    @Override
    public void setObservations(String observations) {

    }

    @Override
    public String getObservations() {
        return "";
    }

    @Override
    public void setCategory(CategoryDTO category) {

    }

    @Override
    public CategoryDTO getCategory() {
        return null;
    }

    @Override
    public void ignoreTransaction(boolean ignoreValue) {

    }

    @Override
    public boolean isIgnoreTransaction() {
        return false;
    }

    @Override
    public void fixedTransaction(boolean fixedValue) {

    }

    @Override
    public boolean isFixedTransaction() {
        return false;
    }

    @Override
    public void setValue(double value) {

    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public void setDate(LocalDate date) {

    }

    @Override
    public LocalDate getDate() {
        return null;
    }
}
