package hbv7d.hdv7d_ui.controller;


import hbv7d.hdv7d_ui.view.View;
import hbv7d.hdv7d_ui.view.ViewSwitcher;
import hbv7d.model.Company;
import hbv7d.model.Tour;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Date;

import static hbv7d.hdv7d_ui.Global.api;

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

    public TableView tourTable;

    public TableView<Tour> tab = new TableView<>();

    public VBox vboxMain;
//    public Pane painMain;

//    public TableColumn date;
//    public TableColumn price;
//    public TableColumn group_size;
//    public TableColumn seatsTaken;
//    public TableColumn location;
//    public TableColumn pickUp;
//    public TableColumn type;
//    public TableColumn difficulty;
//    public TableColumn text;

    public void initialize(){

        Company company1 = new Company(1, "company1");
        Tour tour_test = new Tour(
                1,
                "Tour 1",
                "this is description",
                "this is a location",
                20,
                new Date(),
                20,
                32,
                "this is a difficultyRating",
                "this is a type",
                false,
                company1
        );

        System.out.println("seatsTaken = " + tour_test.getSeatsTaken());
        makeTable();


//        addRow(tour_test);



    }

    private void addRow(Tour tour){
        tab.getItems().add(tour);
    }

    public void makeTable() {
        TableColumn<Tour, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Tour, Date> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Tour, Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Tour, Integer> groupSizeColumn = new TableColumn<>("Group size");
        groupSizeColumn.setCellValueFactory(new PropertyValueFactory<>("groupSize"));

        TableColumn<Tour, Integer> seatsTakenColumn = new TableColumn<>("Seats taken");
        seatsTakenColumn.setCellValueFactory(new PropertyValueFactory<>("seatsTaken"));

        TableColumn<Tour, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Tour, Boolean> pickUpColumn = new TableColumn<>("Pick up?");
        pickUpColumn.setCellValueFactory(new PropertyValueFactory<>("pickupService"));

        TableColumn<Tour, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        tab.getColumns().addAll(nameColumn, dateColumn, priceColumn, groupSizeColumn,
                seatsTakenColumn, locationColumn, pickUpColumn, typeColumn);

        vboxMain.getChildren().add(tab);
    }


    public void onConfirmBooking(ActionEvent actionEvent) {
    }

    public void onUserPage(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.USER, false, 600, 400);
    }

    public void onCompanyPage(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.COMPANY, false, 600, 400);
    }
}
