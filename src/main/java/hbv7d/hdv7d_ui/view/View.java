package hbv7d.hdv7d_ui.view;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {

    BOOKING("fxml/booking-view.fxml"),
    COMPANY("fxml/company-view.fxml"),
    MAIN("fxml/main-view.fxml"),
    CREATE_TOUR("fxml/create_tour-view.fxml"),
    USER("fxml/user-view.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
