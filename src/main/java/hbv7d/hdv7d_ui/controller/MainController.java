package hbv7d.hdv7d_ui.controller;


import hbv7d.api.Api;
import hbv7d.hdv7d_ui.view.View;
import hbv7d.hdv7d_ui.view.ViewSwitcher;
import hbv7d.main.Main;
import hbv7d.model.Booking;
import hbv7d.model.Company;
import hbv7d.model.Tour;
import hbv7d.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.Date;
import java.util.List;

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


    public TableView<Tour> tourTable = new TableView<>();

    public VBox vboxMain;

    public static User currUser = new User(1, "user name", "email user"); //TODO make a selection panel to select user

    public static Tour selectedTour;

    public void initialize(){

        Api api = new Api();
        makeTable();

        addAllTourToTable();

        tourTable.setRowFactory( tv -> {
        TableRow<Tour> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    selectedTour = row.getItem();
//                    System.out.println(rowData);

                    ViewSwitcher.switchTo_WithSize(View.TOUR, false, 800, 400);
                }
            });
            return row ;
        });

    }

    private void addAllTourToTable(){
        List<Tour> tours = Api.viewAllATours();

        tourTable.getItems().addAll(tours);
    }

    private void addRow(Tour tour){
        tourTable.getItems().add(tour);
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

        tourTable.getColumns().addAll(nameColumn, dateColumn, priceColumn, groupSizeColumn,
                seatsTakenColumn, locationColumn, pickUpColumn, typeColumn);

        vboxMain.getChildren().add(tourTable);
    }


    public void onConfirmBooking(ActionEvent actionEvent) {
        Tour tour = tourTable.getSelectionModel().getSelectedItem();
//        User user = new User(1, "user name", "email user");
//
//        System.out.println(tour.getTourId());
//        Booking booking = new Booking(user.getUserId(), tour.getTourId());
//        user.addBooking(booking);
//        System.out.println(user.getBookings());
        if (tour != null){
            System.out.println(currUser.getUserId());
           System.out.println(Api.makeBooking(currUser.getUserId(), tour.getTourId()));
           currUser = Api.getUser(currUser.getUserId());


           System.out.println(currUser.getBookings());
           System.out.println(Api.viewBookings(currUser.getUserId()));
        }
    }

    public void onUserPage(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.USER, false, 600, 400);
    }

    public void onCompanyPage(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.COMPANY, false, 700, 400);
    }

    //Það er innbyggt filters þannig ég nota það bara i guess.
    public void onResetFilters(ActionEvent actionEvent) {
        tourTable.getSortOrder().clear();
        tourTable.getItems().clear();
        addAllTourToTable();
    }

    public void onByPrice(ActionEvent actionEvent) {
        tourTable.getSortOrder().clear();
        for (TableColumn<Tour, ?> col : tourTable.getColumns()) {
            if ("Price".equals(col.getText())) {
                tourTable.getSortOrder().add(col);
                break;
            }
        }
    }

    public void onByGroupSize(ActionEvent actionEvent) {
        tourTable.getSortOrder().clear();
        for (TableColumn<Tour, ?> col : tourTable.getColumns()) {
            if ("Group size".equals(col.getText())) {
                tourTable.getSortOrder().add(col);
                break;
            }
        }
    }

    public void onByLocation(ActionEvent actionEvent) {
        tourTable.getSortOrder().clear();
        for (TableColumn<Tour, ?> col : tourTable.getColumns()) {
            if ("Location".equals(col.getText())) {
                tourTable.getSortOrder().add(col);
                break;
            }
        }
    }

    public void onByType(ActionEvent actionEvent) {
        tourTable.getSortOrder().clear();
        for (TableColumn<Tour, ?> col : tourTable.getColumns()) {
            if ("Type".equals(col.getText())) {
                tourTable.getSortOrder().add(col);
                break;
            }
        }
    }

    public void onByDuration(ActionEvent actionEvent) {
        tourTable.getSortOrder().clear();
        for (TableColumn<Tour, ?> col : tourTable.getColumns()) {
            if ("Duration".equals(col.getText())) {
                tourTable.getSortOrder().add(col);
                break;
            }
        }
    }
}
