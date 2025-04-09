package hbv7d.hdv7d_ui.controller;

import hbv7d.api.Api;
import hbv7d.hdv7d_ui.view.View;
import hbv7d.hdv7d_ui.view.ViewSwitcher;
import hbv7d.model.Booking;
import hbv7d.model.Tour;
import hbv7d.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.Date;
import java.util.List;

public class UserController {

    public VBox vboxMain;
    public Label userLabel;
    public Label emailLabel;
    private TableView<Booking> userTableView = new TableView<>();;

    public void initialize(){
        makeTable();

        addAllBookngToTabel();

        emailLabel.setText(MainController.currUser.getEmail());
        userLabel.setText(MainController.currUser.getName());
    }

    private void addAllBookngToTabel() {
        List<Booking> bookings = Api.viewBookings(MainController.currUser.getUserId());
        userTableView.getItems().addAll(bookings);
    }

    public void makeTable() {
        TableColumn<Booking, String> nameColumn = new TableColumn<>("Tour Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("tourName"));

        TableColumn<Booking, Date> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        userTableView.getColumns().addAll(nameColumn, statusColumn);

        vboxMain.getChildren().add(userTableView);
    }

    public void onBack(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.MAIN, false, 800, 400);
    }

    public void onViewBooking(ActionEvent actionEvent) {
    }
}
