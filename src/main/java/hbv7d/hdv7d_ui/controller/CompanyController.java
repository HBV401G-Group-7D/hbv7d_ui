package hbv7d.hdv7d_ui.controller;

import hbv7d.api.Api;
import hbv7d.hdv7d_ui.view.View;
import hbv7d.hdv7d_ui.view.ViewSwitcher;
import hbv7d.model.Tour;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.Date;
import java.util.List;

public class CompanyController {


    public TableView<Tour> tourTable = new TableView<>();
    public VBox vboxMain;


    public void initialize(){

        Api api = new Api();
        makeTable();

        addAllTourToTable();

    }

    private void addAllTourToTable(){
        List<Tour> tours = Api.viewCompanyTours(1);
        tourTable.getItems().clear();
        tourTable.getItems().addAll(tours);

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






    public void onBack(ActionEvent actionEvent) {
        ViewSwitcher.switchTo_WithSize(View.MAIN, false, 800, 400);
    }







    public void onCreateTour(ActionEvent actionEvent){
        ViewSwitcher.switchTo_WithSize(View.CREATE_TOUR, false, 400, 300);
    }



    public void onDeleteTour(ActionEvent actionEvent){

    }
}
