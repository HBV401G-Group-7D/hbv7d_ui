package hbv7d.hdv7d_ui.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class TourController {
    public Label name;
    public Label fxlocation;
    public Label price;
    public Label date;
    public Label duration;
    public Label groupSize;
    public Label difficultyRating;
    public Label type;
    public Label pickupService;
    public Label host;
    public Label description;



    public void initialize(){
      setAllLabels();
    }

    private void setAllLabels(){
        name.setText(MainController.selectedTour.getName());
        fxlocation.setText(String.valueOf(MainController.selectedTour.getLocation()));
        price.setText(String.valueOf(MainController.selectedTour.getPrice()));
        date.setText(String.valueOf(MainController.selectedTour.getDate()));
        duration.setText(String.valueOf(MainController.selectedTour.getDuration()));
        groupSize.setText(String.valueOf(MainController.selectedTour.getGroupSize()));
        type.setText(MainController.selectedTour.getType());
        pickupService.setText(String.valueOf(MainController.selectedTour.isPickupService()));
        try {
            host.setText(MainController.selectedTour.getHost().getName());
        } catch (NullPointerException e) {
            System.out.println("No Company found");
            host.setText("Host not found");
        }
        description.setText(MainController.selectedTour.getDescription());
    }

        public void onBack(ActionEvent actionEvent) {
    }
}
