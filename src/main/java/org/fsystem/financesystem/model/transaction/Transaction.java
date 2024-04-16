package org.fsystem.financesystem.model.transaction;

import org.fsystem.financesystem.model.category.CategoryDTO;

public interface Transaction {
    void setValue(double value);
    double getValue();
    void setDate(String date);
    String getDate();
    void setObservations(String observations);
    String getObservations();
    void setCategory(CategoryDTO category);
    CategoryDTO getCategory();
    void fixedTransaction(boolean fixedValue);
    boolean isFixedTransaction();
    void ignoreTransaction(boolean ignoreValue);
    boolean isIgnoreTransaction();
}
