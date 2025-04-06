module hbv7d.hdv7d_ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens hbv7d.hdv7d_ui to javafx.fxml;
    exports hbv7d.hdv7d_ui;
}