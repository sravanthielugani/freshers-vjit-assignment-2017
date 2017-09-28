package com.restaurant.management.system.scene.impl;

import com.restaurant.management.system.controller.MainController;
import com.restaurant.management.system.scene.ViewScene;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;

public class HomeSceneImpl implements ViewScene {

    private MainController controller;

    public HomeSceneImpl(MainController controller) {
        this.controller = controller;
    }

    public Scene getScene() {
        //Creating a Text object
        Text text = new Text();

        //Setting the text to be added.
        text.setText("Restaurant Management System");
        text.setFont(Font.font(40));

        //setting the position of the text
        text.setX(120);
        text.setY(400);

        InputStream stream = getClass().getClassLoader().getResourceAsStream("images/restaurant.png");

        Image image = new Image(stream);

        ImageView imageView = new ImageView(image);
        //Setting the position of the image
        imageView.setX(300);
        imageView.setY(150);

        //setting the fit height and width of the image view
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        Button dineInButton = new Button();
        dineInButton.setText("Dine-In");
        dineInButton.setFont(Font.font(20));
        dineInButton.setLayoutX(200);
        dineInButton.setLayoutY(450);
        dineInButton.setBackground(new Background(new BackgroundFill(Color.OLIVE, null, null)));
        dineInButton.setMinSize(150, 30);
        dineInButton.setStyle("-fx-text-fill: white;");

        EventHandler<MouseEvent> showDineInEventHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                Stage currentStage = controller.getCurrentStage();
                currentStage.setScene(new DineInSceneImpl(controller).getScene());
                controller.setStage(currentStage);
            }
        };
        //Registering the event filter
        dineInButton.addEventFilter(MouseEvent.MOUSE_CLICKED, showDineInEventHandler);


        Button homeDeliveryButton = new Button();
        homeDeliveryButton.setText("Home Delivery");
        homeDeliveryButton.setFont(Font.font(20));
        homeDeliveryButton.setLayoutX(400);
        homeDeliveryButton.setLayoutY(450);
        homeDeliveryButton.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
        homeDeliveryButton.setMinSize(150, 30);
        homeDeliveryButton.setStyle("-fx-text-fill: white;");

        EventHandler<MouseEvent> showHomeDeliveryEventHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                Stage currentStage = controller.getCurrentStage();
                currentStage.setScene(new HomeDeliverySceneImpl(controller).getScene());
                controller.setStage(currentStage);
            }
        };

        //Registering the event filter
        homeDeliveryButton.addEventFilter(MouseEvent.MOUSE_CLICKED, showHomeDeliveryEventHandler);

        Group root = new Group(text, imageView, dineInButton, homeDeliveryButton);
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, Color.DARKRED);
        return scene;
    }
}
