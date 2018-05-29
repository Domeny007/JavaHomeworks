package ru.kpfu.itis.javaFXcalculator;

import ru.kpfu.itis.beans.controllers.AppController;
import ru.kpfu.itis.utils.SpringFXMLLoaderUtil;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Calculator extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Калькулятор");
		AppController ac = (AppController) SpringFXMLLoaderUtil.load("/fxml/calculator.fxml");
		Scene scene = new Scene((Parent) ac.getView());
        stage.setScene(scene);
        stage.show();
	}
}
