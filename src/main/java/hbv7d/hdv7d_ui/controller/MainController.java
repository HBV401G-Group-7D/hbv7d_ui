package hbv7d.hdv7d_ui.controller;


import hbv7d.hdv7d_ui.view.View;
import hbv7d.hdv7d_ui.view.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class MainController {


    public Button confirmBookingButton;
    public Button userPageButton;
    public Button companyPageButton;
    public Button resetFilters;

    public Button byPrice;
    public Button byGroupSize;
    public Button byLocation;
    public Button byType;
    public Button byDuration;

//    public TableColumn date;
//    public TableColumn price;
//    public TableColumn group_size;
//    public TableColumn seatsTaken;
//    public TableColumn location;
//    public TableColumn pickUp;
//    public TableColumn type;
//    public TableColumn difficulty;
//    public TableColumn text;

    public void onConfirmBooking(ActionEvent actionEvent) {
    }

    public void onUserPage(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.USER, false, 600, 400);
    }

    public void onCompanyPage(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.COMPANY, false, 600, 400);
    }
}
