module org.fsystem.financesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens org.fsystem.financesystem to javafx.fxml;
    exports org.fsystem.financesystem;
}