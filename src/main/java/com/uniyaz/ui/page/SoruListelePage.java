package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.component.SyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.*;

import java.util.List;

public class SoruListelePage extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    public Soru soru;
    public Cevap cevap;

    private long _anketId;

    SoruListelePage(long anketId){
        this._anketId = anketId;

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    public SoruListelePage(SoruListelePage soruListelePage,long anketId) {
        this._anketId = anketId;
    }


    private void buildTable() {

        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "SORU","SECENEK","CEVAP");
    }



    private void buildContainer() {
        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("soruyaz", String.class, null);
        container.addContainerProperty("sorutipi",String.class,null);
        container.addContainerProperty("guncelle",SyEditButton.class,null);

    }

    private void fillTable() {
        SoruService soruService = new SoruService();
        List<Soru> soruList = soruService.findByAnketId(_anketId);
        for (Soru soru : soruList) {
            Item item = container.addItem(soru);
            item.getItemProperty("id").setValue(soru.getId());
            item.getItemProperty("soruyaz").setValue(soru.getSoruyaz());
            item.getItemProperty("sorutipi").setValue(soru.getSorutipi());

            SyEditButton guncelle = buildGuncelleButton(soru,cevap);
            item.getItemProperty("guncelle").setValue(guncelle);

        }
    }


    private void buildMainLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private SyEditButton buildGuncelleButton(final Soru soru,Cevap cevap) {
        SyEditButton guncelle = new SyEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                CevapPage cevapPage = new CevapPage(soru);
                Window window = new Window();
                window.setCaption("CEVAP");
                window.setClosable(true);
                window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(50, Unit.PERCENTAGE);
                window.setHeight(50, Unit.PERCENTAGE);
                window.setResizable(true);
                window.center();
                window.setContent(cevapPage);

                SyUI syUI = (SyUI) SyUI.getCurrent();
                syUI.addWindow(window);



            }
        });
        return guncelle;
    }






}
