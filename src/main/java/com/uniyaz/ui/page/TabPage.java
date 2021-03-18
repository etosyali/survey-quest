package com.uniyaz.ui.page;




import com.uniyaz.core.domain.Kisi;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;



public class TabPage extends TabSheet {
    private VerticalLayout kisiLayout;
 //   private VerticalLayout secenekEkleLayout;
    private VerticalLayout anketListeLayout;
    private VerticalLayout kisiAnketSonucLayout;



    public TabPage() {

        setSizeFull();

        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        final FormLayout formLayout = new FormLayout();
        formLayout.setWidth(100.0f, Unit.PERCENTAGE);

        buidEkle();
        buildListele();
        buildkisiAnketSonuc();
       // buildSecenekEkle();


    }

  /*  private void buildSecenekEkle() {
        secenekEkleLayout=new VerticalLayout();
        secenekEkleLayout.setMargin(true);
        addTab(secenekEkleLayout, "SeçenekEkle " );


    }*/

    private void buildkisiAnketSonuc() {
        kisiAnketSonucLayout=new VerticalLayout();
        kisiAnketSonucLayout.setMargin(true);
        addTab(kisiAnketSonucLayout, "Kişi Anket Sonucu " );



    }

    private void buildListele() {

        anketListeLayout=new VerticalLayout();
        anketListeLayout.setMargin(true);
        addTab(anketListeLayout, "Anket Listele " );
        AnketCozListePage anketCozListePage=new AnketCozListePage();
        anketListeLayout.addComponent(anketCozListePage);

    }

    private void buidEkle() {
        kisiLayout=new VerticalLayout();
        kisiLayout.setMargin(true);
        addTab(kisiLayout, "Kişi Ekle " );
        KisiPage kisiPage=new KisiPage();
        kisiLayout.addComponent(kisiPage);
    }

}