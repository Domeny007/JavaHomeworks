package ru.kpfu.itis.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import ru.kpfu.itis.server.model.Operation;


public class GwtCalculator implements EntryPoint, ClickHandler {

    private GwtCalculatorServiceAsync calculatorService = GWT.create(GwtCalculatorService.class);
    final TextBox textBox = new TextBox();
    final Label resultLabel = new Label();
    final Button plusButton = new Button("+");
    final Button minusButton = new Button("-");
    final Button multiplyButton = new Button("*");
    final Button divideButton = new Button("/");
    final Button equalsButton = new Button("=");
    private Character mathAction;
    AsyncCallback<Double> callback;

    @Override
    public void onModuleLoad() {
        initFields();
        RootPanel.get().add(textBox);
        RootPanel.get().add(plusButton);
        RootPanel.get().add(minusButton);
        RootPanel.get().add(multiplyButton);
        RootPanel.get().add(divideButton);
        RootPanel.get().add(equalsButton);
        RootPanel.get().add(resultLabel);

        callback = new AsyncCallback<Double>() {
            @Override
            public void onFailure(Throwable caught) {
                resultLabel.setText("SERVER ERROR");
            }

            @Override
            public void onSuccess(Double result) {
                resultLabel.setText(String.valueOf(result));
            }
        };
    }

    private void initFields() {
        textBox.setHeight("40px");
        resultLabel.getElement().getStyle().setFontSize(30, Style.Unit.PX);
        plusButton.setWidth("60px");
        plusButton.setHeight("40px");
        plusButton.addClickHandler(this);
        minusButton.setWidth("60px");
        minusButton.setHeight("40px");
        minusButton.addClickHandler(this);
        multiplyButton.setWidth("60px");
        multiplyButton.setHeight("40px");
        multiplyButton.addClickHandler(this);
        divideButton.setWidth("60px");
        divideButton.setHeight("40px");
        divideButton.addClickHandler(this);
        equalsButton.setWidth("60px");
        equalsButton.setHeight("40px");
        equalsButton.addClickHandler(this);
    }

    @Override
    public void onClick(ClickEvent event) {
        try {
            Double.parseDouble(textBox.getText());
        } catch (Exception e) {
            resultLabel.setText("Введено некорректное значение");
            return;
        }

        Widget sender = (Widget) event.getSource();
        Button button;

        if (sender == plusButton) {
            button = plusButton;
        } else if (sender == minusButton) {
            button = minusButton;
        } else if (sender == multiplyButton) {
            button = multiplyButton;
        } else if (sender == divideButton) {
            button = divideButton;
        } else {
            button = equalsButton;
        }

        if (mathAction != null) {
            if (mathAction == '/' && Double.parseDouble(textBox.getText()) == 0.0) {
                resultLabel.setText("Деление на ноль - бесконечность");
                return;
            } else {
                calculatorService.compute(Double.parseDouble(textBox.getText()), mathAction, callback);
            }
        } else {
            mathAction = button.getText().charAt(0);
            calculatorService.setResult(Double.parseDouble(textBox.getText()) ,mathAction, callback);
        }

        mathAction = button.getText().charAt(0);
        calculatorService.saveOperation(new Operation(Double.parseDouble(textBox.getText()), mathAction), new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                resultLabel.setText("Ошибка");
            }

            @Override
            public void onSuccess(Void result) {

            }
        });
        textBox.setText("");

        if(mathAction == '='){
            mathAction = null;
        }
    }
}
