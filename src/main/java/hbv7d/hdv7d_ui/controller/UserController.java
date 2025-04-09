package hbv7d.hdv7d_ui.controller;

import hbv7d.hdv7d_ui.view.View;
import hbv7d.hdv7d_ui.view.ViewSwitcher;
import javafx.event.ActionEvent;

public class UserController {

    public void onBack(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.MAIN, false, 800, 400);
    }

    public void onViewBooking(ActionEvent actionEvent) {
    }
}
