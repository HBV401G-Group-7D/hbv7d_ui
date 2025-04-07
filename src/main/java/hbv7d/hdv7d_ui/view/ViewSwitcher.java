package hbv7d.hdv7d_ui.view;

import hbv7d.hdv7d_ui.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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

    private static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
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
