package com.uniyaz.ui;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Kisi;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.ui.component.ContentComponent;
import com.uniyaz.ui.component.SyMenuBar;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class SyUI extends UI {

    private VerticalLayout mainLayout;
    private ContentComponent contentComponent;
    private Anket anket;
    private Soru soru;
    private Kisi kisi;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        buildMainLayout();
        setContent(mainLayout);
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        contentComponent = new ContentComponent();


        SyMenuBar syMenuBar = new SyMenuBar();

        mainLayout.addComponent(syMenuBar);
        mainLayout.addComponent(contentComponent);

        mainLayout.setExpandRatio(syMenuBar, 0.4f);
        mainLayout.setExpandRatio(contentComponent, 8.6f);
    }

    public ContentComponent getContentComponent() {
        return contentComponent;
    }

    public void setContentComponent(ContentComponent contentComponent) {
        this.contentComponent = contentComponent;
    }

    public Anket getAnket() {
        return anket;
    }

    public void setAnket(Anket anket) {
        this.anket = anket;
    }

    public Soru getSoru(){return soru;}

    public void setSoru(Soru soru){this.soru = soru;}

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

}