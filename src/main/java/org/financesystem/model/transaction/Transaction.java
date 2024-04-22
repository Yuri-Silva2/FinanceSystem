package org.financesystem.model.transaction;

import org.financesystem.model.category.CategoryDTO;

import java.time.LocalDate;

public interface Transaction {
    void setObservations(String observations);
    String getObservations();

    void setCategory(CategoryDTO category);
    CategoryDTO getCategory();

    void ignoreTransaction(boolean ignoreValue);
    boolean isIgnoreTransaction();

    void fixedTransaction(boolean fixedValue);
    boolean isFixedTransaction();

    void setValue(double value);
    double getValue();

    void setDate(LocalDate date);
    LocalDate getDate();
}
