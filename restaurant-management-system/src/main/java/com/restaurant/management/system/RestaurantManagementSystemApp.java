package com.restaurant.management.system;

import com.restaurant.management.system.controller.MainController;
import com.restaurant.management.system.scene.ViewScene;
import com.restaurant.management.system.scene.impl.HomeSceneImpl;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class RestaurantManagementSystemApp extends Application {

    ViewScene scene;

    MainController controller = new MainController();

    @Override
    public void init() throws Exception {
        super.init();
        scene = new HomeSceneImpl(controller);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Restaurant Management System");
        primaryStage.setScene(scene.getScene());
        primaryStage.setResizable(false);
        controller.setStage(primaryStage);
        controller.showStage();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
