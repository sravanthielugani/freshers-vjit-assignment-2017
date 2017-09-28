package com.restaurant.management.system.controller;

import javafx.stage.Stage;

public class MainController {

    public Stage getCurrentStage() {
        return currentStage;
    }

    private Stage currentStage;

    public void setStage (Stage stage){
        currentStage = stage;
    }

    public void showStage(){
        currentStage.show();
    }
}
