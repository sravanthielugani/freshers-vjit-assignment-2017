package com.restaurant.management.system.scene.impl;

import com.restaurant.management.system.controller.MainController;
import com.restaurant.management.system.model.Category;
import com.restaurant.management.system.model.Item;
import com.restaurant.management.system.scene.ViewScene;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
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

import java.util.ArrayList;
import java.util.List;

public class OrderFoodSceneImpl implements ViewScene {

    private MainController controller;

    public List<Category> categories = new ArrayList<>();

    public List<Item> selectedItems = new ArrayList<>();

    public OrderFoodSceneImpl(MainController controller) {
        this.controller = controller;
        Category starterCategory = new Category();
        starterCategory.setCategoryName("Starters");
        List<Item> starterItems = new ArrayList<>();
        starterItems.add(new Item("Chicken Lollipop", 150));
        starterItems.add(new Item("Paneer Mashroom Kabab", 120));
        starterItems.add(new Item("Prawn Kabab", 250));
        starterCategory.setItems(starterItems);
        Category mainCourseCategory = new Category();
        mainCourseCategory.setCategoryName("Main Course Curry");
        List<Item> mainCourseItems = new ArrayList<>();
        mainCourseItems.add(new Item("Chicken Keema Masala", 130));
        mainCourseItems.add(new Item("Paneer Tikka Masala", 110));
        mainCourseItems.add(new Item("Prawn Curry", 170));
        mainCourseCategory.setItems(mainCourseItems);
        Category dessertCategory = new Category();
        dessertCategory.setCategoryName("Desserts");
        List<Item> dessertItems = new ArrayList<>();
        dessertItems.add(new Item("Vanilla", 50));
        dessertItems.add(new Item("Strawberry", 60));
        dessertItems.add(new Item("Chocolate", 55));
        dessertCategory.setItems(dessertItems);
        categories.add(starterCategory);
        categories.add(mainCourseCategory);
        categories.add(dessertCategory);
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

        Text customerWalksInText = new Text();
        customerWalksInText.setText("Select Items");
        customerWalksInText.setFont(Font.font(30));
        customerWalksInText.setFill(Color.GAINSBORO);
        customerWalksInText.setX(10);
        customerWalksInText.setY(100);

        List<Node> nodes = new ArrayList<>();
        int yPosition = 130;
        for (Category category : categories) {
            Label categoryLabel = new Label();
            categoryLabel.setText(category.getCategoryName());
            categoryLabel.setFont(Font.font(20));
            categoryLabel.setBackground(new Background(new BackgroundFill(Color.OLIVE, null, null)));
            categoryLabel.setMinSize(700, 30);
            categoryLabel.setTextAlignment(TextAlignment.CENTER);
            categoryLabel.setAlignment(Pos.CENTER);
            categoryLabel.setLayoutX(50);
            categoryLabel.setLayoutY(yPosition);
            yPosition += 50;

            nodes.add(categoryLabel);
            for (Item item : category.getItems()) {
                CheckBox checkBox = new CheckBox();
                checkBox.setId(item.getItemName());
                checkBox.setLayoutX(150);
                checkBox.setLayoutY(yPosition);
                yPosition += 15;

                EventHandler<MouseEvent> itemEvent = new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (checkBox.isSelected()) {
                            selectedItems.add(item);
                        } else {
                            selectedItems.remove(item);
                        }
                    }
                };
                checkBox.addEventHandler(MouseEvent.MOUSE_CLICKED, itemEvent);

                Text itemText = new Text();
                itemText.setText(item.getItemName());
                itemText.setFont(Font.font(20));
                itemText.setLayoutX(250);
                itemText.setLayoutY(yPosition);

                Text itemCost = new Text();
                itemCost.setText(item.getItemCost() + "");
                itemCost.setFont(Font.font(20));
                itemCost.setLayoutX(550);
                itemCost.setLayoutY(yPosition);
                yPosition += 20;

                nodes.add(checkBox);
                nodes.add(itemText);
                nodes.add(itemCost);
            }
        }

        Button placeOrderButton = new Button();
        placeOrderButton.setText("Place Order");
        placeOrderButton.setFont(Font.font(27));
        placeOrderButton.setLayoutX(600);
        placeOrderButton.setLayoutY(700);
        placeOrderButton.setBackground(new Background(new BackgroundFill(Color.PERU, null, null)));
        placeOrderButton.setMinSize(30, 40);
        placeOrderButton.setStyle("-fx-text-fill: white;");

        EventHandler<MouseEvent> placeOrderEventHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                System.out.println(selectedItems.size());
//                Stage currentStage = controller.getCurrentStage();
//                currentStage.setScene(new HomeSceneImpl(controller).getScene());
//                controller.setStage(currentStage);
            }
        };

        placeOrderButton.addEventHandler(MouseEvent.MOUSE_CLICKED, placeOrderEventHandler);

        Group root = new Group(label, homeButton, placeOrderButton, customerWalksInText);
        root.getChildren().addAll(nodes);
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, Color.DARKRED);

        return scene;
    }
}
