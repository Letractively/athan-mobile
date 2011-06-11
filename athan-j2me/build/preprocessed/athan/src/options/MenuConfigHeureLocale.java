/*
 * Copyright © 2008, 2010, Oracle and/or its affiliates. All rights reserved
 */
package athan.src.options;

import athan.src.Client.Menu;
import com.sun.lwuit.Button;
import com.sun.lwuit.ButtonGroup;
import com.sun.lwuit.CheckBox;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.RadioButton;
import com.sun.lwuit.plaf.Border;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import java.io.IOException;

/**
 * Menu de configuration de l'heure locale
 * 
 * @author Saad BENBOUZID
 */
public class MenuConfigHeureLocale extends Menu {

    public String getName() {
        return "Heure locale";
    }

    public String getIconBaseName() {
        return MENU_CONFIG_HEURE_LOCALE;
    }

    protected String getHelp() {
        return "Aide";
    }

    protected void execute(final Form f) {
        // TODO
    }
}
