package hbv7d.hdv7d_ui.view;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    HEIMA("fxml/heima-view.fxml"),
    LISTI("fxml/listi-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
