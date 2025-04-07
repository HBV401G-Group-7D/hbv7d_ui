package hbv7d.hdv7d_ui.view;

import hbv7d.hdv7d_ui.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * this class is used to switch between views <br>
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 *
 */
public class ViewSwitcher {

    private static final Map<View, Parent> cache = new HashMap<>();

    private static Scene scene; // the scene the view is on

    private static Stage stage; // the stage the scene is on

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setStage(Stage stage) {
        ViewSwitcher.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    /**
     * set the height of the scene
     * @param height the height of the scene
     */
    public static void setSceneHeight(double height){
        scene.getWindow().setHeight(height);
    }

    /**
     * sets the width of the scene
     * @param width the width of the scene
     */
    public static void setSceneWidth(double width){
        scene.getWindow().setWidth(width);
    }

    /**
     * sets both the width of the scene
     * @param width the width of the scene
     * @param height the height of the scene
     */
    public static void setSceneSize(double width, double height){
        ViewSwitcher.setSceneWidth(width);
        ViewSwitcher.setSceneHeight(height);
    }

    /**
     * same as the switch to function but also sets the size of the scene
     * @param view the view you want to choose from the enum in the view file
     * @param isCache when you return to the view is it the same or does it get reset
     * @param width the width of the scene
     * @param height the height of the scene
     */
    public static void switchTo_WithSize(View view, boolean isCache, double width, double height){
        ViewSwitcher.setSceneSize(width, height);
        ViewSwitcher.switchTo(view, isCache);
    }


    /**
     * this method is used to switch between Scenes
     * @param view the view you want to choose from the enum in the view file
     * @param isCache when you return to the view is it the same or does it get reset
     */
    public static void switchTo(View view, boolean isCache) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;

            if (cache.containsKey(view) && isCache) {
                System.out.println("Loading from cache");

                root = cache.get(view);
            } else {
                System.out.println("Loading from FXML");

                root = FXMLLoader.load(
                        Objects.requireNonNull(MainApplication.class.getResource(view.getFileName()))
                );

                cache.put(view, root);
            }

            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
