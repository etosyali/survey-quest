package com.uniyaz.ui.component;

import com.uniyaz.ui.page.SoruPage;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;


public class ContentComponent extends VerticalLayout {

    public ContentComponent() {
        setSizeFull();
        buildLayout();
    }

    private void buildLayout() {

    }

    @Override
    public void addComponent(Component c) {
        removeAllComponents();
        super.addComponent(c);
    }

    public void addComponent(SoruPage soruPage) {


    }
}
