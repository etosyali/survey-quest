package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.AnketKisi;
import com.uniyaz.core.domain.Kisi;
import com.uniyaz.core.service.AnketKisiService;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class AnketKisiPage extends VerticalLayout {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    private Kisi kisi;
    private Anket anket;


    public AnketKisiPage(AnketKisi anketKisi){
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
    }

    private void buildContainer() {
    }

    private void fillTable() {

        AnketKisiService anketKisiService = new AnketKisiService();
        List<AnketKisi> anketKisiList = anketKisiService.findAllByKisiId(kisi.getId());
        for (AnketKisi anketKisi : anketKisiList) {
            Item item = container.addItem(anketKisi);
            item.getItemProperty("id").setValue(kisi.getId());
        }
    }
}
