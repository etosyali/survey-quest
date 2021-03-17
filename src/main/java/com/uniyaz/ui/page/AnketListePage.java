package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.AnketService;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.component.ContentComponent;
import com.uniyaz.ui.component.SyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.*;

import java.util.List;


public class AnketListePage extends VerticalLayout {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    private Soru soru;

    public AnketListePage() {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);

    }

    private void buildTable() {

        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "ADI", "", "");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("adi", String.class, null);
        container.addContainerProperty("guncelle", SyEditButton.class, null);
        container.addContainerProperty("secim", Button.class, null);

    }

    private void fillTable() {

        AnketService anketService = new AnketService();
        List<Anket> anketList = anketService.findAllHql();
        for (Anket anket : anketList) {
            Item item = container.addItem(anket);
            item.getItemProperty("id").setValue(anket.getId());
            item.getItemProperty("adi").setValue(anket.getAdi());


            SyEditButton guncelle = buildGuncelleButton(anket);
            item.getItemProperty("guncelle").setValue(guncelle);

            Button secim = buildSecimButton(anket);
            item.getItemProperty("secim").setValue(secim);

        }
    }



    private Button buildSecimButton(final Anket anket) {

        Button secim = new Button("SORU EKLE");
        secim.setIcon(FontAwesome.CHECK);
        secim.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SoruPage soruPage = new SoruPage(anket);
                Window window = new Window();
                window.setCaption("SORU YAZ");
                window.setClosable(true);
                window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(50, Unit.PERCENTAGE);
                window.setHeight(50, Unit.PERCENTAGE);
                window.setResizable(true);
                window.center();
                window.setContent(soruPage);



                SyUI syUI = (SyUI) SyUI.getCurrent();
                syUI.addWindow(window);



            }
        });
        return secim;
    }

    private SyEditButton buildGuncelleButton(final Anket anket) {
        SyEditButton guncelle = new SyEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                SyUI syUI = (SyUI) SyUI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                AnketPage anketPage = new AnketPage(anket);
                contentComponent.addComponent(anketPage);
            }
        });
        return guncelle;
    }

     private Button buildSiparisButton(Anket anket) {
      Button siparisButton = new Button();
    siparisButton.setIcon(FontAwesome.SHOPPING_BASKET);
        siparisButton.addClickListener(new Button.ClickListener() {
           @Override
           public void buttonClick(Button.ClickEvent clickEvent) {
              // SiparisListePage siparisListePage = new SiparisListePage(anket);
               Window window = new Window();
               window.setCaption("Siparişler");
               window.setClosable(true);
               window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(30, Unit.PERCENTAGE);
               window.setHeight(30, Unit.PERCENTAGE);
               window.setResizable(true);
                window.center();
                //window.setContent(siparisListePage);

                SyUI syUI = (SyUI) SyUI.getCurrent();
                syUI.addWindow(window);
            }
        });
        return siparisButton;
    }
}