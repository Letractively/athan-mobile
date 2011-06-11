/*
 * Copyright � 2008, 2010, Oracle and/or its affiliates. All rights reserved
 */
package athan.src.options;

import athan.src.Client.AthanException;
import athan.src.Client.Main;
import athan.src.Client.Menu;
import athan.src.Factory.Preferences;
import athan.src.Factory.ResourceReader;
import athan.src.Factory.ServiceFactory;
import athan.src.Outils.StringOutilClient;
import athan.web.LocationFetcher;
import com.sun.lwuit.Button;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.TextField;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.impl.midp.VirtualKeyboard;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.table.TableLayout;
import java.rmi.RemoteException;
import javax.microedition.location.Coordinates;
import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationProvider;

/**
 * Set of the button types available in the UI
 * 
 * @author Saad BENBOUZID
 */
public class MenuChoisirVille extends Menu {

    private static final int HAUTEUR_LABEL = 15;

    private TextField mTextFieldNomVille;
    private TextField mTextFieldNomRegion;
    private TextField mTextFieldNomPays;
    private TextField mTextFieldLat;
    private TextField mTextFieldLng;

    private Button mGpsSearch;
    private Button mApiSearch;
    private Button mManualSearch;

    private Button mOK;
    private Button mAnnuler;

    public String getName() {
        return "Position";
    }

    public String getIconBaseName() {
        return MENU_CHOISIR_VILLE;
    }

    protected String getHelp() {
        return "Aide";
    }

    protected void execute(final Form f) {

        final ResourceReader RESSOURCE = ServiceFactory.getFactory()
                            .getResourceReader();

        if (Main.isTactile()) {
            f.setTactileTouch(true);
            f.setSmoothScrolling(true);
        } else {
            f.setTactileTouch(false);
            f.setSmoothScrolling(false);
            f.setFocusScrolling(true);
        }

        TableLayout tblLayoutInfosLocalisation = new TableLayout(5, 4);
        Container ctnInfosLocalisation = new Container();
        ctnInfosLocalisation.setLayout(tblLayoutInfosLocalisation);
        //tblLayoutInfosLocalisation.createConstraint().setWidthPercentage(100);

        Label lLabelNomVille = new Label(RESSOURCE.get("CityName"));
        lLabelNomVille.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
        lLabelNomVille.setAlignment(Component.LEFT);

        Label lLabelNomRegion = new Label(RESSOURCE.get("RegionName"));
        lLabelNomRegion.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
        lLabelNomRegion.setAlignment(Component.LEFT);

        Label lLabelNomPays = new Label(RESSOURCE.get("CountryName"));
        lLabelNomPays.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
        lLabelNomPays.setAlignment(Component.LEFT);

        Label lLabelLat = new Label(RESSOURCE.get("LatLng"));
        lLabelLat.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
        lLabelLat.setAlignment(Component.LEFT);

        mTextFieldNomVille = new TextField();
        mTextFieldNomVille.setUIID(UIID_LABEL_LOCALISATION_INFO);
        mTextFieldNomVille.setAlignment(TextField.LEFT);
        mTextFieldNomVille.setRows(1);
        mTextFieldNomVille.setPreferredH(HAUTEUR_LABEL);

        mTextFieldNomRegion = new TextField();
        mTextFieldNomRegion.setUIID(UIID_LABEL_LOCALISATION_INFO);
        mTextFieldNomRegion.setAlignment(TextField.LEFT);
        mTextFieldNomRegion.setRows(1);
        mTextFieldNomRegion.setPreferredH(HAUTEUR_LABEL);

        mTextFieldNomPays = new TextField();
        mTextFieldNomPays.setUIID(UIID_LABEL_LOCALISATION_INFO);
        mTextFieldNomPays.setAlignment(TextField.LEFT);
        mTextFieldNomPays.setRows(1);
        mTextFieldNomPays.setPreferredH(HAUTEUR_LABEL);

        mTextFieldLat = new TextField();
        mTextFieldLat.setUIID(UIID_LABEL_LOCALISATION_INFO);
        mTextFieldLat.setAlignment(TextField.LEFT);
        mTextFieldLat.setRows(1);
        mTextFieldLat.setPreferredH(HAUTEUR_LABEL);

        mTextFieldLng = new TextField();
        mTextFieldLng.setUIID(UIID_LABEL_LOCALISATION_INFO);
        mTextFieldLng.setAlignment(TextField.LEFT);
        mTextFieldLng.setRows(1);
        mTextFieldLng.setPreferredH(HAUTEUR_LABEL);

        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 100, 4),
                                    new Label());
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 30, 1),
                                    lLabelLat);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 34, 1),
                                    mTextFieldLat);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 2, 1),
                                    new Label());
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 34, 1),
                                    mTextFieldLng);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 30, 1),
                                    lLabelNomVille);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 70, 3),
                                    mTextFieldNomVille);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 30, 1),
                                    lLabelNomRegion);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 70, 3),
                                    mTextFieldNomRegion);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 30, 1),
                                    lLabelNomPays);
        ctnInfosLocalisation.addComponent(getCtnLayoutLocalisation(tblLayoutInfosLocalisation, 70, 3),
                                    mTextFieldNomPays);

        mGpsSearch = new Button(RESSOURCE.get("GPSSearch"));
        mGpsSearch.setAlignment(Component.CENTER);
        mApiSearch = new Button(RESSOURCE.get("CitySearch"));
        mApiSearch.setAlignment(Component.CENTER);
        mManualSearch = new Button(RESSOURCE.get("ManualSearch"));
        mManualSearch.setAlignment(Component.CENTER);
        mOK = new Button(RESSOURCE.get("Command.OK"));
        mOK.setAlignment(Component.CENTER);
        mAnnuler = new Button(RESSOURCE.get("Command.Cancel"));
        mAnnuler.setAlignment(Component.CENTER);

        Container ctnOkAnnuler = new Container(new BorderLayout());
        ctnOkAnnuler.addComponent(BorderLayout.WEST, mAnnuler);
        ctnOkAnnuler.addComponent(BorderLayout.EAST, mOK);

        Container ctnSaisies = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ctnSaisies.addComponent(ctnOkAnnuler);
        ctnSaisies.addComponent(mGpsSearch);
        ctnSaisies.addComponent(mApiSearch);
        ctnSaisies.addComponent(mManualSearch);
        
        f.setLayout(new BorderLayout());
        f.addComponent(BorderLayout.CENTER, ctnInfosLocalisation);
        f.addComponent(BorderLayout.SOUTH, ctnSaisies);

        // Gestion du comportement (ergonomie)
        if (!Main.isTactile()) {
           mTextFieldNomVille.setFocusable(true);
           mTextFieldNomRegion.setFocusable(true);
           mTextFieldNomPays.setFocusable(true);
           mTextFieldLat.setFocusable(true);
           mTextFieldLng.setFocusable(true);

           mOK.setFocusable(true);
           mAnnuler.setFocusable(true);
           mGpsSearch.setFocusable(true);
           mApiSearch.setFocusable(true);
           mManualSearch.setFocusable(true);
        }

        mOK.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                if (sauvegarderParametresEcran()) {
                    changerModeEdition(false, f);
                    initialiserInfosLocalisation();
                }
            }
        });

        mAnnuler.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                changerModeEdition(false, f);
                initialiserInfosLocalisation();
            }
        });

        mGpsSearch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                boolean success = true;
                
                Criteria cr = new Criteria();
                cr.setHorizontalAccuracy(500);
                LocationProvider lp;

                final String[] latLng = new String[2];

                try {
                    lp = LocationProvider.getInstance(cr);
                    Location l = lp.getLocation(TIMEOUT_GPS); // timeout de 15 secondes
                    Coordinates c = l.getQualifiedCoordinates();

                    if (c != null ) {
                      double lat = c.getLatitude();
                      double lon = c.getLongitude();

                      latLng[0] = Double.toString(lat);
                      latLng[1] = Double.toString(lon);
                    }
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                    success = false;
                }

                Command okCommand = new Command(RESSOURCE.get("Command.OK")) {
                    public void actionPerformed(ActionEvent evt) {
                        // OK Gps
                        okGpsPerformed(latLng, f);
                    }
                };

                Command annulerCommand = new Command(RESSOURCE.get("Command.Cancel")) {
                    public void actionPerformed(ActionEvent evt) {
                        // Fail Gps
                    }
                };

                String contenuDialogue;
                int dialogType;
                if (success) {
                    dialogType = Dialog.TYPE_INFO;
                    contenuDialogue = RESSOURCE.get("fetchGPSContent");
                    contenuDialogue += "\n";
                    contenuDialogue += RESSOURCE.get("Latitude") + " " + latLng[0];
                    contenuDialogue += "\n";
                    contenuDialogue += RESSOURCE.get("Longitude") + " " + latLng[1];

                    Dialog.show(RESSOURCE.get("fetchGPSTitle"), contenuDialogue, annulerCommand,
                    new Command[] {annulerCommand, okCommand}, dialogType, null, TIMEOUT_FENETRE_GPS,
                    CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 1000));

                } else {
                    dialogType = Dialog.TYPE_ERROR;
                    contenuDialogue = RESSOURCE.get("ErrorFetchGPS");

                    Dialog.show(RESSOURCE.get("fetchGPSTitle"), contenuDialogue, annulerCommand,
                    new Command[] {annulerCommand}, dialogType, null, TIMEOUT_FENETRE_GPS,
                    CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 1000));
                }
            }
        });

        mApiSearch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                final Form parametersForm = new Form(RESSOURCE.get("GeocodingWindowTitle"));
                parametersForm.setLayout(new BorderLayout());

                TableLayout tbGrid = new TableLayout(4, 2);
                Container grid = new Container(tbGrid);
                grid.setLayout(tbGrid);

                Label lLabelNomVille = new Label(RESSOURCE.get("CityName"));
                lLabelNomVille.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
                lLabelNomVille.setAlignment(Component.LEFT);

                Label lLabelNomRegion = new Label(RESSOURCE.get("RegionName"));
                lLabelNomRegion.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
                lLabelNomRegion.setAlignment(Component.LEFT);

                Label lLabelNomPays = new Label(RESSOURCE.get("CountryName"));
                lLabelNomPays.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
                lLabelNomPays.setAlignment(Component.LEFT);

                Label lLabelLanguage = new Label(RESSOURCE.get("GeocodingIndicative"));
                lLabelLanguage.getStyle().setFont(Main.theme.getFont(FONT_LABEL_INFO_NAME));
                lLabelLanguage.setAlignment(Component.LEFT);

                final TextField lTextFieldNomVille = new TextField();
                lTextFieldNomVille.setUIID(UIID_LABEL_LOCALISATION_INFO);
                lTextFieldNomVille.setAlignment(TextField.LEFT);
                lTextFieldNomVille.setText(mTextFieldNomVille.getText());
                lTextFieldNomVille.setEditable(true);
                lTextFieldNomVille.setRows(1);

                final TextField lTextFieldNomRegion = new TextField();
                lTextFieldNomRegion.setUIID(UIID_LABEL_LOCALISATION_INFO);
                lTextFieldNomRegion.setAlignment(TextField.LEFT);
                lTextFieldNomRegion.setText(mTextFieldNomRegion.getText());
                lTextFieldNomRegion.setEditable(true);
                lTextFieldNomRegion.setRows(1);

                final TextField lTextFieldNomPays = new TextField();
                lTextFieldNomPays.setUIID(UIID_LABEL_LOCALISATION_INFO);
                lTextFieldNomPays.setAlignment(TextField.LEFT);
                lTextFieldNomPays.setText(mTextFieldNomPays.getText());
                lTextFieldNomPays.setEditable(true);
                lTextFieldNomPays.setRows(1);

                final ComboBox lCbIndicatif = new ComboBox(INDICATIF_PAYS);
                if (ServiceFactory.getFactory().getPreferences().getLangue()
                        .equals(Preferences.LANGUE_EN)) {
                    lCbIndicatif.setSelectedIndex(2, true);
                } else if (ServiceFactory.getFactory().getPreferences().getLangue()
                        .equals(Preferences.LANGUE_EN)) {
                    lCbIndicatif.setSelectedIndex(4, true);
                } else {
                    lCbIndicatif.setSelectedIndex(2, true);
                }

                VirtualKeyboard.bindVirtualKeyboard(lTextFieldNomVille,
                    VirtualKeyboard.getVirtualKeyboard(mTextFieldNomVille));
                VirtualKeyboard.bindVirtualKeyboard(lTextFieldNomRegion,
                    VirtualKeyboard.getVirtualKeyboard(mTextFieldNomRegion));
                VirtualKeyboard.bindVirtualKeyboard(lTextFieldNomPays,
                    VirtualKeyboard.getVirtualKeyboard(mTextFieldNomPays));

                TextArea consignes = new TextArea(RESSOURCE.getContenu_ConsignesGeocoding());
                consignes.setUIID(UIID_TEXTAREA_SEARCH_TOOLTIP);
                consignes.setEnabled(false);
                consignes.setEditable(false);
                consignes.setGrowByContent(true);

                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lLabelNomVille);
                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lTextFieldNomVille);
                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lLabelNomRegion);
                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lTextFieldNomRegion);
                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lLabelNomPays);
                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lTextFieldNomPays);
                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lLabelLanguage);
                grid.addComponent(getCtnLayoutGeocoding(tbGrid, 50, 1),
                                    lCbIndicatif);

                //parametersForm.setScrollable(true);
                parametersForm.addComponent(BorderLayout.NORTH, consignes);
                parametersForm.addComponent(BorderLayout.CENTER, grid);
                
                Command searchCommand = new Command(RESSOURCE.get("Command.Search")) {
                    public void actionPerformed(ActionEvent evt) {
                        boolean peutChercher = false;

                        // Recherche
                        if ((lTextFieldNomVille.getText() != null
                                && lTextFieldNomVille.getText().trim().length() > 0)
                        || (lTextFieldNomRegion.getText() != null
                                && lTextFieldNomRegion.getText().trim().length() > 0)
                        || (lTextFieldNomPays.getText() != null
                                && lTextFieldNomPays.getText().trim().length() > 0)) {
                            peutChercher = true;
                        }

                        if (!peutChercher) {
                            Command annulerCommand = new Command(RESSOURCE.get("Command.OK")) {
                                public void actionPerformed(ActionEvent evt) {
                                    // Fail Parameters
                                }
                            };
                            
                            Dialog.show(RESSOURCE.get("GeocodingWindowParametersLackTitle"),
                                    RESSOURCE.get("GeocodingWindowParametersLackContent"), annulerCommand,
                            new Command[] {annulerCommand}, Dialog.TYPE_INFO, null, TIMEOUT_FENETRE_GPS,
                            CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 1000));
                            return;
                        } else {
                            // On lance la recherche
                            
                            //LocationFetcherService_Stub service = new LocationFetcherService_Stub();
                            //service._setProperty(LocationFetcherService_Stub.SESSION_MAINTAIN_PROPERTY, new Boolean(true));

                            final LocationFetcher service = new LocationFetcher();

                            new Thread(new Runnable() {

                                public void run() {
                                    try {

                                        athan.web.Location lLocation = service.geoname(
                                                        lTextFieldNomVille.getText(),
                                                        lTextFieldNomRegion.getText(),
                                                        lTextFieldNomPays.getText(),
                                                        INDICATIF_PAYS[lCbIndicatif.getSelectedIndex()]);
                                        
                                        mTextFieldNomVille.setText(lLocation.getCityName());
                                        mTextFieldNomRegion.setText(lLocation.getRegionName());
                                        mTextFieldNomPays.setText(lLocation.getCountryName());

                                        if (lLocation.getCoordinates() != null) {
                                            mTextFieldLat.setText(
                                                  new Double(lLocation.getCoordinates()
                                                                .getLat()).toString());
                                            mTextFieldLng.setText(
                                                  new Double(lLocation.getCoordinates()
                                                                .getLng()).toString());
                                        }

                                        // On bascule en demande de validation par l'utilisateur
                                        changerModeEdition(true, f);

                                    } catch (RemoteException exc) {
                                        //exc.printStackTrace();
                                        Command annulerCommand = new Command(RESSOURCE.get("Command.OK")) {
                                            public void actionPerformed(ActionEvent evt) { }
                                        };
                                        Dialog.show(RESSOURCE.get("errorTitle"),
                                            RESSOURCE.get("GeocodingWindowRemoteException"), annulerCommand,
                                            new Command[] {annulerCommand}, Dialog.TYPE_ERROR, null, TIMEOUT_FENETRE_GPS,
                                            CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 1000));
                                        return;
                                    } catch (AthanException exc) {
                                        //exc.printStackTrace();
                                        Command annulerCommand = new Command(RESSOURCE.get("Command.OK")) {
                                            public void actionPerformed(ActionEvent evt) { }
                                        };
                                        Dialog.show(RESSOURCE.get("errorTitle"),
                                            RESSOURCE.get("GeocodingWindowCustomException") + "\n" + exc.getMessage(), annulerCommand,
                                            new Command[] {annulerCommand}, Dialog.TYPE_ERROR, null, TIMEOUT_FENETRE_GPS,
                                            CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 1000));
                                        return;
                                    } catch (Exception exc) {
                                        //exc.printStackTrace();
                                        Command annulerCommand = new Command(RESSOURCE.get("Command.OK")) {
                                            public void actionPerformed(ActionEvent evt) { }
                                        };
                                        Dialog.show(RESSOURCE.get("errorTitle"),
                                            RESSOURCE.get("GeocodingWindowUnknownException"), annulerCommand,
                                            new Command[] {annulerCommand}, Dialog.TYPE_ERROR, null, TIMEOUT_FENETRE_GPS,
                                            CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 1000));
                                        return;
                                    }

                                    System.out.println("GEOCODING OK");

                                    // Geocoding OK
                                    f.showBack();

                                    System.out.println("fin showback OK");
                                }
                            }).start();

                            System.out.println("fin thread OK");
                        }
                    }
                };

                Command cancelCommand = new Command(RESSOURCE.get("Command.Cancel")) {
                    public void actionPerformed(ActionEvent evt) {
                        // Annuler
                        f.showBack();
                    }
                };

                parametersForm.addCommand(cancelCommand);
                parametersForm.addCommand(searchCommand);
                parametersForm.setBackCommand(cancelCommand);
                parametersForm.show();
            }
        });

        mManualSearch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                changerModeEdition(true, f);
            }
        });

        changerModeEdition(false, f);
        initialiserInfosLocalisation();
        initialiserClaviers();
    }

    private void changerModeEdition(boolean editable, Form form) {
        mTextFieldLat.setEditable(editable);
        mTextFieldLng.setEditable(editable);
        mTextFieldNomPays.setEditable(editable);
        mTextFieldNomRegion.setEditable(editable);
        mTextFieldNomVille.setEditable(editable);

        mOK.setVisible(editable);
        mAnnuler.setVisible(editable);
        mApiSearch.setVisible(!editable);
        mGpsSearch.setVisible(!editable);
        mManualSearch.setVisible(!editable);

        mGpsSearch.setVisible(false);
        mManualSearch.setVisible(false);
        mApiSearch.setVisible(false);

        form.repaint();
    }

    private boolean sauvegarderParametresEcran() {
        // On v�rifie que les param�tres sont corrects
        boolean okDonnees = true;
        try {
            double latitude = Double.valueOf(mTextFieldLat.getText()).doubleValue();
            double longitude = Double.valueOf(mTextFieldLng.getText()).doubleValue();

            if (latitude < 0.0 || latitude > 90.0) {
                okDonnees = false;
            }

            if (longitude < -180.0 || longitude > 180.0) {
                okDonnees = false;
            }

        } catch (Exception exc) {
            okDonnees = false;
        }

        if (!okDonnees) {
            final ResourceReader RESSOURCE = ServiceFactory.getFactory()
                            .getResourceReader();

            // Message
            Command okCommand = new Command(RESSOURCE.get("Command.OK"));
            Dialog.show(RESSOURCE.get("errorTitle"), RESSOURCE.get("errorLocationParameters"), okCommand,
                    new Command[] {okCommand}, Dialog.TYPE_ERROR, null, TIMEOUT_FENETRE_GPS,
                    CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 1000));
            // Sortie
            return false;
        }

        try {
            ServiceFactory.getFactory().getPreferences()
                .set(Preferences.sLatitude, mTextFieldLat.getText());
            ServiceFactory.getFactory().getPreferences()
                .set(Preferences.sLongitude, mTextFieldLng.getText());
            ServiceFactory.getFactory().getPreferences()
                .set(Preferences.sCityName, mTextFieldNomVille.getText());
            ServiceFactory.getFactory().getPreferences()
                .set(Preferences.sRegionName, mTextFieldNomRegion.getText());
            ServiceFactory.getFactory().getPreferences()
                .set(Preferences.sCountryName, mTextFieldNomPays.getText());

            ServiceFactory.getFactory().getPreferences()
                    .save();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return true;
    }

    private void initialiserInfosLocalisation() {

        String lLat = StringOutilClient.EMPTY;
        String lLng = StringOutilClient.EMPTY;
        String lVille = StringOutilClient.EMPTY;
        String lRegion = StringOutilClient.EMPTY;
        String lPays = StringOutilClient.EMPTY;

        try {
            lLat = ServiceFactory.getFactory().getPreferences()
                        .get(Preferences.sLatitude);
            lLng = ServiceFactory.getFactory().getPreferences()
                        .get(Preferences.sLongitude);
            lVille = ServiceFactory.getFactory().getPreferences()
                        .get(Preferences.sCityName);
            lRegion = ServiceFactory.getFactory().getPreferences()
                        .get(Preferences.sRegionName);
            lPays = ServiceFactory.getFactory().getPreferences()
                        .get(Preferences.sCountryName);

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        mTextFieldLat.setText(lLat);
        mTextFieldLng.setText(lLng);
        mTextFieldNomVille.setText(lVille);
        mTextFieldNomRegion.setText(lRegion);
        mTextFieldNomPays.setText(lPays);
    }

    private TableLayout.Constraint getCtnLayoutLocalisation(TableLayout pTB,
                                                    int pPourcentage,
                                                    int pHorizontalSpan) {
        TableLayout.Constraint contrainte = pTB.createConstraint();
        if (pPourcentage == 100) {
            contrainte.setHeightPercentage(10);
        } else {
            contrainte.setHeightPercentage(18);
        }
        contrainte.setHorizontalSpan(pHorizontalSpan);
        contrainte.setWidthPercentage(pPourcentage);
        return contrainte;
    }

    private TableLayout.Constraint getCtnLayoutGeocoding(TableLayout pTB,
                                                    int pPourcentage,
                                                    int pHorizontalSpan) {
        TableLayout.Constraint contrainte = pTB.createConstraint();
        if (pPourcentage == 100) {
            //contrainte.setHeightPercentage(10);
        } else {
            //contrainte.setHeightPercentage(30);
        }
        contrainte.setHorizontalSpan(pHorizontalSpan);
        contrainte.setWidthPercentage(pPourcentage);
        return contrainte;
    }

    private void okGpsPerformed(String[] pLatLng, Form pForm) {

        mTextFieldLat.setText(pLatLng[0]);
        mTextFieldLng.setText(pLatLng[1]);

        changerModeEdition(true, pForm);
    }

    private void initialiserClaviers() {
        VirtualKeyboard vkbCoordonnees = new VirtualKeyboard();
        vkbCoordonnees.addInputMode(KB_COORDINATES_MODE, KB_COORDINATES);
        vkbCoordonnees.setInputModeOrder(new String[]{KB_COORDINATES_MODE});
        VirtualKeyboard.bindVirtualKeyboard(mTextFieldLat, vkbCoordonnees);
        VirtualKeyboard.bindVirtualKeyboard(mTextFieldLng, vkbCoordonnees);

        VirtualKeyboard vkbNoms = new VirtualKeyboard();
        if (ServiceFactory.getFactory()
                .getPreferences().getLangue().equals(Preferences.LANGUE_EN)) {
            vkbNoms.addInputMode(KB_NOMS_US_MODE, KB_NOMS_US);
            vkbNoms.addInputMode(KB_NOMS_us_MODE, KB_NOMS_us);
            vkbNoms.addInputMode(KB_SYMBOLS_MODE, KB_SYMBOLS);
            vkbNoms.setInputModeOrder(new String[] { KB_NOMS_US_MODE,
                        KB_NOMS_us_MODE, VirtualKeyboard.NUMBERS_MODE,
                        KB_SYMBOLS_MODE });
        } else if (ServiceFactory.getFactory()
                .getPreferences().getLangue().equals(Preferences.LANGUE_FR)) {
            vkbNoms.addInputMode(KB_NOMS_FR_MODE, KB_NOMS_FR);
            vkbNoms.addInputMode(KB_NOMS_fr_MODE, KB_NOMS_fr);
            vkbNoms.addInputMode(KB_SYMBOLS_MODE, KB_SYMBOLS);
            vkbNoms.setInputModeOrder(new String[] { KB_NOMS_FR_MODE,
                        KB_NOMS_fr_MODE, VirtualKeyboard.NUMBERS_MODE,
                        KB_SYMBOLS_MODE });
        } else {
            vkbNoms.addInputMode(KB_NOMS_US_MODE, KB_NOMS_US);
            vkbNoms.addInputMode(KB_NOMS_us_MODE, KB_NOMS_us);
            vkbNoms.addInputMode(KB_SYMBOLS_MODE, KB_SYMBOLS);
            vkbNoms.setInputModeOrder(new String[] { KB_NOMS_US_MODE,
                        KB_NOMS_us_MODE, VirtualKeyboard.NUMBERS_MODE,
                        KB_SYMBOLS_MODE });
        }
        VirtualKeyboard.bindVirtualKeyboard(mTextFieldNomVille, vkbNoms);
        VirtualKeyboard.bindVirtualKeyboard(mTextFieldNomRegion, vkbNoms);
        VirtualKeyboard.bindVirtualKeyboard(mTextFieldNomPays, vkbNoms);
    }
}
