package com.uniyaz.ui.page;


import com.uniyaz.core.domain.Secenek;
import com.uniyaz.core.service.SecenekService;
import com.uniyaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class SecenekPage extends VerticalLayout {
    @PropertyId("id")
    private TextField id;

    @PropertyId("secenek")
    private TextField secenek;

    private FormLayout mainLayout;

    private BeanItem<Secenek> secenekBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;


    public SecenekPage(Secenek secenek){
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        secenekBeanItem = new BeanItem<Secenek>(secenek);
        binder = new FieldGroup(secenekBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(false);
        mainLayout.addComponent(id);


        secenek = new TextField();
        secenek.setCaption("Secenekler");
        mainLayout.addComponent(secenek);

        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Secenek secenek = secenekBeanItem.getBean();
                    SecenekService secenekService = new SecenekService();
                    secenekService.saveSecenek(secenek);
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
