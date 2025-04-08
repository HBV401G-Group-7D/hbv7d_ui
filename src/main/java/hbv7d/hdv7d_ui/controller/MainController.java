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

    public TableView tab = new TableView<>();

    public VBox vBox;

//    public TableColumn date;
//    public TableColumn price;
//    public TableColumn group_size;
//    public TableColumn seatsTaken;
//    public TableColumn location;
//    public TableColumn pickUp;
//    public TableColumn type;
//    public TableColumn difficulty;
//    public TableColumn text;

    public MainController(){

        Company company1 = new Company(1, "company1");
        Tour tour = new Tour(
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
        addRow(tour);
    }

    private void addRow(){

    }

    public void makeTable(Tour tour){

        TableColumn nameColumn = new TableColumn(tour.getName());
        nameColumn.setCellFactory(new PropertyValueFactory<>("name"));

        TableColumn dateColumn = new TableColumn(tour.getDate().toString());
        nameColumn.setCellFactory(new PropertyValueFactory<>("date"));

        TableColumn priceColumn = new TableColumn(String.valueOf(tour.getPrice()));
        nameColumn.setCellFactory(new PropertyValueFactory<>("price"));

        TableColumn groupSizeColumn = new TableColumn(String.valueOf(tour.getGroupSize()));
        nameColumn.setCellFactory(new PropertyValueFactory<>("groupSize"));

        TableColumn seatsTakenColumn = new TableColumn(String.valueOf(tour.getSteatsTaken()));
        nameColumn.setCellFactory(new PropertyValueFactory<>("seatsTaken"));

        TableColumn locationColumn = new TableColumn(tour.getLocation());
        nameColumn.setCellFactory(new PropertyValueFactory<>("location"));

        TableColumn pickUpColumn = new TableColumn(String.valueOf(tour.isPickupService()));
        nameColumn.setCellFactory(new PropertyValueFactory<>("pickupService"));

        TableColumn typeColumn = new TableColumn(tour.getType());
        nameColumn.setCellFactory(new PropertyValueFactory<>("name"));

        TableColumn difficultyColumn = new TableColumn(tour.getDifficultyRating());
        nameColumn.setCellFactory(new PropertyValueFactory<>("difficultyRating"));

//        TableColumn nameColumn = new TableColumn(tour.getName());
//        nameColumn.setCellFactory(new PropertyValueFactory<>("name"));
        this.tab.getColumns().addAll(nameColumn,dateColumn,priceColumn,groupSizeColumn,seatsTakenColumn,locationColumn,pickUpColumn,typeColumn,difficultyColumn);

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
