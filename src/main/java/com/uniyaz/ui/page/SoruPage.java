package com.uniyaz.ui.page;


import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.EnumSoruTipi;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.ui.component.SecenekComboBox;
import com.uniyaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


public class SoruPage extends TabSheet  {

    @PropertyId("id")
    private TextField id;

    @PropertyId("soruyaz")
    private TextField soruyaz;


    @PropertyId("sorutipi")
    private ComboBox sorutipi;

    @PropertyId("secenek")
    private TextField secenek;


    @PropertyId("cevap")
    private TextField cevap;

    @PropertyId("enumSoruTipi")
    private SecenekComboBox secenekComboBox;


    private FormLayout mainLayout;
    private BeanItem<Soru> soruBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;
    private VerticalLayout secenekEkleLayout;
    private VerticalLayout soruEkleLayout;
    private Anket anket;
    private EnumSoruTipi enumSoruTipi;


    public SoruPage(Anket anket) {
        this.anket = anket;
        Soru soru = new Soru();
        soru.setAnket(anket);

        soruBeanItem = new BeanItem<Soru>(soru);
        binder = new FieldGroup(soruBeanItem);

        setSizeFull();

        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        final FormLayout formLayout = new FormLayout();
        formLayout.setWidth(100.0f, Unit.PERCENTAGE);


        soruEkleLayout();
        secenekEkleLayout();


        binder.bindMemberFields(this);
        id.setEnabled(false);
    }

    public SoruPage(Soru soru){
        soruBeanItem = new BeanItem<Soru>(soru);
        binder = new FieldGroup(soruBeanItem);

        setSizeFull();

        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        final FormLayout formLayout = new FormLayout();
        formLayout.setWidth(100.0f, Unit.PERCENTAGE);



        soruEkleLayout();
        secenekEkleLayout();

        binder.bindMemberFields(this);
        id.setEnabled(false);
    }

    private void secenekEkleLayout() {
        secenekEkleLayout = new VerticalLayout();
        secenekEkleLayout.setMargin(true);
        addTab(secenekEkleLayout,"Seçenek Ekle");

        id = new TextField();
        id.setCaption("ID");
        id.setNullRepresentation("");
        secenekEkleLayout.addComponent(id);

        secenek = new TextField();
        secenek.setCaption("Seçenekler");
        secenek.setNullRepresentation("");
        secenekEkleLayout.addComponent(secenek);
    }

    private void soruEkleLayout() {
        soruEkleLayout=new VerticalLayout();
        soruEkleLayout.setMargin(true);
        addTab(soruEkleLayout, "Soru Ekle " );


        id = new TextField();
        id.setCaption("ID");
        id.setNullRepresentation("");
        soruEkleLayout.addComponent(id);

        soruyaz = new TextField();
        soruyaz.setCaption("Soruyaz");
        soruyaz.setNullRepresentation("");
        soruEkleLayout.addComponent(soruyaz);


        secenekComboBox = new SecenekComboBox();
        secenekComboBox.setCaption("Soru Tipi");
        soruEkleLayout.addComponent(secenekComboBox);


        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Soru soru = soruBeanItem.getBean();
                    SoruService soruService = new SoruService();
                    soruService.saveSoru(soru);
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Alanlar nesne ile uyumlu değil", Notification.Type.ERROR_MESSAGE);
                } catch (Exception e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        soruEkleLayout.addComponent(sySaveButton);
    }

    private void buildMainLayout() {

    }
}
