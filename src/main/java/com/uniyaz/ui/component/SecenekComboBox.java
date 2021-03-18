package com.uniyaz.ui.component;

import com.uniyaz.core.domain.EnumSoruTipi;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;

public class SecenekComboBox extends ComboBox
{
    private EnumSoruTipi enumSoruTipi;
    private FormLayout mainLayout;

    public SecenekComboBox()
    {
        mainLayout = new FormLayout();

        fillCombobox();
    }

    private void fillCombobox()
    {
        for (EnumSoruTipi soruTuru : EnumSoruTipi.values())
        {
            Item item = addItem(soruTuru);

    }
}
}