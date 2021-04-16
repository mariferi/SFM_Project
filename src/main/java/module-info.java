module sfm.pontus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;


    opens sfm.pontus to javafx.fxml, javafx.controls, javafx.graphics, javafx.base;
    exports sfm.pontus;
}
