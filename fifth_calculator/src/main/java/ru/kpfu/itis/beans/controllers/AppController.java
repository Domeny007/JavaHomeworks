package ru.kpfu.itis.beans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.kpfu.itis.beans.base.controllers.Controller;
import ru.kpfu.itis.beans.components.MathComponent;
import ru.kpfu.itis.beans.model.MathOperation;
import ru.kpfu.itis.utils.AlertUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Window;

import java.util.List;

@Component
public class AppController implements Controller {
	
	@FXML
	private TextField calcInput;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private ToggleGroup toggleGroup;
	
	@Autowired
	public MathComponent math;
	
	@FXML
	private Label history;
	
	public String chosenFunction = "+";

	private Node view;

	@Override
	public Node getView() {
		return view;
	}

	@Override
	public void setView(Node view) {
		this.view = view;
	}
	
	@FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
		Window owner = submitButton.getScene().getWindow();
		String input = calcInput.getText();
		MathOperation mo = new MathOperation();
		mo.setNumber(input);
		mo.setFunction(chosenFunction);
		try {
			math.proceed(mo);
		} catch (Exception e) {
			AlertUtil.showAlert(AlertType.ERROR, owner, "Ошибка", "Введено неправильное значение");
			e.printStackTrace();
		}
		if (math.getHistory() != null && math.getHistory().size() != 0) {
			List<Double> histArr = math.getHistory();
			history.setText("Ответ " + histArr.get(histArr.size()-1));
		}
		else {
			history.setText("");
		}
	}
	
	public void initialize() {
		toggleGroup.selectedToggleProperty().addListener((ov, oldToggle, newToggle) -> {
			 if (toggleGroup.getSelectedToggle() != null) {
                 RadioButton button = (RadioButton) toggleGroup.getSelectedToggle();
                 chosenFunction = button.getText();
             }
		});
	}

}
