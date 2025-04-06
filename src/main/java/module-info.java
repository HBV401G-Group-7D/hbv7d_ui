module hbv7d.hdv7d_ui {
    requires javafx.controls;
    requires javafx.fxml;
//    requires hbv7d;
    requires Group.DayTour7.main;


    opens hbv7d.hdv7d_ui to javafx.fxml;
    exports hbv7d.hdv7d_ui;
    exports hbv7d.hdv7d_ui.controller;
    opens hbv7d.hdv7d_ui.controller to javafx.fxml;
}