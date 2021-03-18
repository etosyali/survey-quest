package com.uniyaz.ui.component;


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

        buildAnketIslemleriMenuItem();
        buildAnketCozMenuItem();
    }

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
    }

    private void buildAnketCozMenuItem() {
        MenuItem AnketCozMenuItem = addItem("Anket Çöz", null);
        AnketCozMenuItem.addItem("KISI", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                TabPage tabPage = new TabPage();
                contentComponent.addComponent(tabPage);
            }
        });
    }
}
