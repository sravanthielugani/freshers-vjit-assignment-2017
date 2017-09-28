package com.restaurant.management.system.scene.impl;

import com.restaurant.management.system.controller.MainController;
import com.restaurant.management.system.scene.ViewScene;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DineInSceneImpl implements ViewScene {

    private MainController controller;

    public DineInSceneImpl(MainController controller) {
        this.controller = controller;
    }

    public Scene getScene() {
        Label label = new Label();
        label.setText("Dine-In");
        label.setFont(Font.font(40));
        label.setBackground(new Background(new BackgroundFill(Color.OLIVE, null, null)));
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

        final CheckBox customerWalksInCheckBox = new CheckBox();
        customerWalksInCheckBox.setSelected(false);
        customerWalksInCheckBox.setLayoutX(40);
        customerWalksInCheckBox.setLayoutY(200);

        Text customerWalksInText = new Text();
        customerWalksInText.setText("Customer walks in");
        customerWalksInText.setFont(Font.font(30));
        customerWalksInText.setX(100);
        customerWalksInText.setY(220);

        final CheckBox hostAllotsOneTableCheckBox = new CheckBox();
        hostAllotsOneTableCheckBox.setSelected(false);
        hostAllotsOneTableCheckBox.setLayoutX(40);
        hostAllotsOneTableCheckBox.setLayoutY(300);

        Text hostAllotsOneTableText = new Text();
        hostAllotsOneTableText.setText("Host allots a table for him/her.");
        hostAllotsOneTableText.setFont(Font.font(30));
        hostAllotsOneTableText.setX(100);
        hostAllotsOneTableText.setY(320);

        final CheckBox busBoyServesWaterCheckBox = new CheckBox();
        busBoyServesWaterCheckBox.setSelected(false);
        busBoyServesWaterCheckBox.setLayoutX(40);
        busBoyServesWaterCheckBox.setLayoutY(400);

        Text busBoyServesWaterText = new Text();
        busBoyServesWaterText.setText("Bus boy serves water");
        busBoyServesWaterText.setFont(Font.font(30));
        busBoyServesWaterText.setX(100);
        busBoyServesWaterText.setY(420);

        final CheckBox managerShowsMenuCheckBox = new CheckBox();
        managerShowsMenuCheckBox.setSelected(false);
        managerShowsMenuCheckBox.setLayoutX(40);
        managerShowsMenuCheckBox.setLayoutY(500);

        Text managerShowsMenuText = new Text();
        managerShowsMenuText.setText("Manager shows the menu to the customer");
        managerShowsMenuText.setFont(Font.font(30));
        managerShowsMenuText.setX(100);
        managerShowsMenuText.setY(520);

        Button startDineInButton = new Button();
        startDineInButton.setText("Click on this to start Dine-In");
        startDineInButton.setFont(Font.font(20));
        startDineInButton.setLayoutX(250);
        startDineInButton.setLayoutY(100);
        startDineInButton.setBackground(new Background(new BackgroundFill(Color.OLIVE, null, null)));
        startDineInButton.setMinSize(100, 30);
        startDineInButton.setStyle("-fx-text-fill: white;");

        EventHandler<MouseEvent> startDineInEvent = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                customerWalksInCheckBox.fire();
                hostAllotsOneTableCheckBox.fire();
                busBoyServesWaterCheckBox.fire();
                managerShowsMenuCheckBox.fire();
            }
        };

        Button nextButton = new Button();
        nextButton.setText("Next");
        nextButton.setFont(Font.font(27));
        nextButton.setLayoutX(670);
        nextButton.setLayoutY(700);
        nextButton.setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, null, null)));
        nextButton.setMinSize(30, 40);
        nextButton.setStyle("-fx-text-fill: red;");

        EventHandler<MouseEvent> goToNextSceneEventHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                Stage currentStage = controller.getCurrentStage();
                currentStage.setScene(new OrderFoodSceneImpl(controller).getScene());
                controller.setStage(currentStage);
            }
        };

        nextButton.addEventHandler(MouseEvent.MOUSE_CLICKED, goToNextSceneEventHandler);

        startDineInButton.addEventHandler(MouseEvent.MOUSE_CLICKED, startDineInEvent);

        Group root = new Group(label, backButton, nextButton, homeButton, customerWalksInCheckBox, customerWalksInText, hostAllotsOneTableCheckBox,
                hostAllotsOneTableText, busBoyServesWaterCheckBox, busBoyServesWaterText, managerShowsMenuCheckBox,
                managerShowsMenuText, startDineInButton);
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, Color.DARKRED);

        return scene;
    }
}
