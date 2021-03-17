package com.uniyaz.ui.component;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.page.*;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;


public class SyMenuBar extends MenuBar {

    private ContentComponent contentComponent;

    public SyMenuBar() {
        setSizeFull();
        addStyleName("syMenuBar");

        SyUI syUI = (SyUI) UI.getCurrent();
        contentComponent = syUI.getContentComponent();

       // buildUrunIslemleriMenuItem();
        buildAnketIslemleriMenuItem();
        buildAnketCozMenuItem();
    }

   /* private void buildUrunIslemleriMenuItem() {
        MenuItem urunIslemleriMenuItem = addItem("Ürün İşlemleri", null);
        urunIslemleriMenuItem.addItem("Ürün Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UrunPage urunPage = new UrunPage();
                contentComponent.addComponent(urunPage);
            }
        });

        urunIslemleriMenuItem.addItem("Ürün Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UrunListePage urunListePage = new UrunListePage();
                contentComponent.addComponent(urunListePage);
            }
        });
    }*/

    private void buildAnketIslemleriMenuItem() {
        MenuItem AnketIslemleriMenuItem = addItem("Anket İşlemleri", null);
        AnketIslemleriMenuItem.addItem("Anket Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                AnketPage anketPage = new AnketPage();
                contentComponent.addComponent(anketPage);
            }
        });

        AnketIslemleriMenuItem.addItem("Anket Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                AnketListePage anketListePage = new AnketListePage();
                contentComponent.addComponent(anketListePage);
            }
        });
        AnketIslemleriMenuItem.addItem("KISI", FontAwesome.LIST, new Command() {
           @Override
            public void menuSelected(MenuItem menuItem) {
                TabPage tabPage = new TabPage();
               contentComponent.addComponent(tabPage);
            }
        });
    }

    private void buildAnketCozMenuItem() {
        MenuItem AnketCozMenuItem = addItem("Anket Çöz", null);
        AnketCozMenuItem.addItem("Anket Listele", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                AnketCozListePage anketCozListePage = new AnketCozListePage();
                contentComponent.addComponent(anketCozListePage);
            }
        });
    }
}
