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
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.*;
import java.util.List;

public class AnketCozListePage extends VerticalLayout {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    private Soru soru;
    private Anket anket;
    private SoruListelePage soruListelePage;

    public AnketCozListePage() {

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
        table.setColumnHeaders("ID", "ADI", "");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("adi", String.class, null);
      //  container.addContainerProperty("secenek",String.class,null);
      //  container.addContainerProperty("cevap",String.class,null);
        container.addContainerProperty("kaydet", Button.class, null);

    }

    private void fillTable() {

        AnketService anketService = new AnketService();
        List<Anket> anketList = anketService.findAllHql();
        for (Anket anket : anketList) {
            Item item = container.addItem(anket);
            item.getItemProperty("id").setValue(anket.getId());
            item.getItemProperty("adi").setValue(anket.getAdi());

           // item.getItemProperty("soruyaz").setValue(soru.getSoruyaz());
           // item.getItemProperty("cevap").setValue(soru.getCevap());
           // item.getItemProperty("secenek").setValue(soru.getSecenek());



            Button secim = buildSecimButton(new SoruListelePage());
            item.getItemProperty("kaydet").setValue(secim);

            //  Button siparisButton = buildSiparisButton(anket);
            //  item.getItemProperty("siparis").setValue(siparisButton);
        }
    }

    private Button buildSecimButton(SoruListelePage soruListelePage) {

        Button secim = new Button("ANKETİ ÇÖZ");
        secim.setIcon(FontAwesome.CHECK);
        secim.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SoruListelePage SoruListelePage = new SoruListelePage(soruListelePage);
                Window window = new Window();
                window.setCaption("ANKET");
                window.setClosable(true);
                window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(50, Unit.PERCENTAGE);
                window.setHeight(50, Unit.PERCENTAGE);
                window.setResizable(true);
                window.center();
                window.setContent(soruListelePage);

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
}
