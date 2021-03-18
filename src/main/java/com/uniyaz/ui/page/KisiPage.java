package com.uniyaz.ui.page;



import com.uniyaz.core.domain.Kisi;
import com.uniyaz.core.service.KisiService;
import com.uniyaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class KisiPage extends VerticalLayout {


    @PropertyId("id")
    private TextField id;

    @PropertyId("adi")
    private TextField adi;

    @PropertyId("email")
    private TextField email;

    private FormLayout mainLayout;

    private BeanItem<Kisi> kisiBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;

    public KisiPage() {
        this(new Kisi());
    }

    public KisiPage(Kisi kisi) {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        kisiBeanItem = new BeanItem<Kisi>(kisi);
        binder = new FieldGroup(kisiBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {

        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setCaption("ID");
        id.setNullRepresentation("");
        mainLayout.addComponent(id);

        adi = new TextField();
        adi.setCaption("Adı");
        mainLayout.addComponent(adi);

        email = new TextField();
        email.setCaption("Email");
        mainLayout.addComponent(email);


        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Kisi kisi = kisiBeanItem.getBean();
                    KisiService kisiService = new KisiService();
                    kisiService.saveKisi(kisi);
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Alanlar nesne ile uyumlu değil", Notification.Type.ERROR_MESSAGE);
                } catch (Exception e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(sySaveButton);
    }
}