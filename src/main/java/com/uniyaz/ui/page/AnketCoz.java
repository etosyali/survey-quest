/*package com.uniyaz.ui.page;


import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.AnketSoru;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.AnketSoruService;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.component.SySaveButton;
import com.uniyaz.ui.component.UrunKart;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;


public class AnketCoz extends VerticalLayout {

    private SySaveButton saveButton;
    private VerticalLayout mainLayout;
    private List<UrunKart> urunKartList;

    public AnketCoz() {

        buildMainLayout();
        addComponent(mainLayout);
        setMargin(true);
        setSpacing(true);


        buildSaveButton();
        addComponent(saveButton);
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setSpacing(true);
    }


    private void buildSaveButton() {

        saveButton = new SySaveButton();
        saveButton.setWidth(100, Unit.PERCENTAGE);
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                SyUI syUI = (SyUI) SyUI.getCurrent();
                Anket anket = syUI.getAnket();
                if (anket == null) {
                    Notification.show("Müşteri Seçmelisiniz", Notification.Type.ERROR_MESSAGE);
                    return;
                }

                List<AnketSoru> anketSoruList = new ArrayList<>();
                for (UrunKart urunKart : urunKartList) {
                    Boolean secimValue = urunKart.getSecimValue();
                    if (Boolean.TRUE.equals(secimValue)) {
                        Urun urun = urunKart.getUrun();

                        AnketSoru anketSoru = new AnketSoru();
                        anketSoru.setSoru(soru);
                        anketSoru.setAnket(anket);
                        anketSoruList.add(anketSoru);
                    }
                }

                AnketSoruService anketSoruService = new AnketSoruService();
                anketSoruService.saveAnketSoru(anketSoruList);
            }
        });
    }
}*/