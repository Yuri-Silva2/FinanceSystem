package org.fsystem.financesystem.models.transaction;

import org.fsystem.financesystem.models.category.Category;

public interface Transaction {
    void setValue(double value);
    double getValue();
    void setDate(String date);
    String getDate();
    void setObservations(String observations);
    String getObservations();
    void setCategory(Category category);
    Category getCategory();
    void fixedTransaction(boolean fixedValue);
    boolean isFixedTransaction();
    void ignoreTransaction(boolean ignoreValue);
    boolean isIgnoreTransaction();
}
