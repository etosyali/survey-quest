package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.CevapService;
import com.uniyaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class CevapPage extends BasePage{
    @PropertyId("id")
    private TextField id;

    @PropertyId("cevap")
    private TextField cevap;

    private FormLayout mainLayout;

    private BeanItem<Cevap> cevapBeanItem;
    private FieldGroup binder;
    private SySaveButton vpSaveButton;

    public CevapPage(Soru soru)
    {
        this(new Cevap());
    }

    public CevapPage(Cevap cevap) {

        cevapBeanItem = new BeanItem<Cevap>(cevap);
        binder = new FieldGroup(cevapBeanItem);

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        binder.bindMemberFields(this);
    }

    @Override
    public void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();


        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(false);
        mainLayout.addComponent(id);

        cevap = new TextField();
        cevap.setCaption("Cevap");
        mainLayout.addComponent(cevap);

        vpSaveButton = new SySaveButton();
        vpSaveButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                try
                {
                    binder.commit();

                    Cevap cevap = cevapBeanItem.getBean();
                    CevapService cevapService = new CevapService();
                    cevapService.saveCevap(cevap);
                }
                catch (FieldGroup.CommitException e)
                {
                    Notification.show("Geçersiz, lütfen geçerli değerler giriniz", Notification.Type.ERROR_MESSAGE);
                } catch (Exception e)
                {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(vpSaveButton);
    }
}

