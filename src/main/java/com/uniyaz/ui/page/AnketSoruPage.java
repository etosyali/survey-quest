package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.AnketSoru;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.AnketService;
import com.uniyaz.core.service.AnketSoruService;
import com.uniyaz.ui.component.SyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class AnketSoruPage extends VerticalLayout {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    private Soru soru;
    private Anket anket;

    public AnketSoruPage(AnketSoru anketSoru){
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

        AnketSoruService anketSoruService = new AnketSoruService();
        List<AnketSoru> anketSoruList = anketSoruService.findAllHql();
        for (AnketSoru anketSoru : anketSoruList) {
            Item item = container.addItem(anketSoru);
            item.getItemProperty("id").setValue(soru.getId());
            item.getItemProperty("soruyaz").setValue(soru.getSoruyaz());
            item.getItemProperty("cevap").setValue(soru.getCevap());

        }
    }
}
