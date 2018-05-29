package ru.kpfu.itis.beans.base.controllers;

import javafx.scene.Node;

public interface Controller {
	Node getView();
    void setView (Node view);
}
