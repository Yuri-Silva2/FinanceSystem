package org.fsystem.financesystem.model.transaction;

import org.fsystem.financesystem.model.category.CategoryDTO;

public class CardExpenseDTO implements Transaction {

    private double value;
    private String date;
    private String observations;
    private CategoryDTO category;
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
    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public CategoryDTO getCategory() {
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
