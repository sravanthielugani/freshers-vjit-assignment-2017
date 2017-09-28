package com.restaurant.management.system.scene.impl;

import com.restaurant.management.system.controller.MainController;
import com.restaurant.management.system.scene.ViewScene;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HomeDeliverySceneImpl implements ViewScene {

    private MainController controller;

    public HomeDeliverySceneImpl(MainController controller) {
        this.controller = controller;
    }

    public Scene getScene() {
        Label label = new Label();
        label.setText("Home Delivery");
        label.setFont(Font.font(40));
        label.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
        label.setMinSize(800, 50);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);
        label.setLayoutX(0);
        label.setLayoutY(0);

        Button backButton = new Button();
        backButton.setText("<-");
        backButton.setFont(Font.font(27));
        backButton.setLayoutX(0);
        backButton.setLayoutY(0);
        backButton.setBackground(new Background(new BackgroundFill(Color.PURPLE, null, null)));
        backButton.setMinSize(30, 40);
        backButton.setStyle("-fx-text-fill: white;");

        EventHandler<MouseEvent> goBackEventHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                Stage currentStage = controller.getCurrentStage();
                currentStage.setScene(new HomeSceneImpl(controller).getScene());
                controller.setStage(currentStage);
            }
        };

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, goBackEventHandler);

        Button homeButton = new Button();
        homeButton.setText("Home");
        homeButton.setFont(Font.font(27));
        homeButton.setLayoutX(690);
        homeButton.setLayoutY(0);
        homeButton.setBackground(new Background(new BackgroundFill(Color.PERU, null, null)));
        homeButton.setMinSize(30, 40);
        homeButton.setStyle("-fx-text-fill: white;");

        EventHandler<MouseEvent> showHomeEventHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                Stage currentStage = controller.getCurrentStage();
                currentStage.setScene(new HomeSceneImpl(controller).getScene());
                controller.setStage(currentStage);
            }
        };

        homeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, showHomeEventHandler);

        Group root = new Group(label, backButton, homeButton);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, Color.DARKRED);
        return scene;
    }
}
