package com.uniyaz.ui.page;

import com.vaadin.ui.VerticalLayout;


public abstract class BasePage extends VerticalLayout {

    public BasePage() {
        setSizeFull();
    }

    public abstract void buildMainLayout();
}