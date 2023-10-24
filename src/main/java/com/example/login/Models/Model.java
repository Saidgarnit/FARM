package com.example.login.Models;

import com.example.login.Views.ViewFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

    private static Model model;
    private ViewFactory viewFactory;

    private Model() {
        StringProperty clientSelectedMenuItem = new SimpleStringProperty(""); // Initialize with a default value
        viewFactory = new ViewFactory(clientSelectedMenuItem);
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}