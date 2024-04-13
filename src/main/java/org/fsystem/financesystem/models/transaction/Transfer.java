package org.fsystem.financesystem.models.transaction;

import org.fsystem.financesystem.models.category.Category;

public class Transfer implements Transaction {

    private double value;
    private String date;
    private String observations;
    private Category category;
    private boolean fixedValue;
    private boolean ignoreValue;

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String getObservations() {
        return observations;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void fixedTransaction(boolean fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public boolean isFixedTransaction() {
        return fixedValue;
    }

    @Override
    public void ignoreTransaction(boolean ignoreValue) {
        this.ignoreValue = ignoreValue;
    }

    @Override
    public boolean isIgnoreTransaction() {
        return ignoreValue;
    }
}
