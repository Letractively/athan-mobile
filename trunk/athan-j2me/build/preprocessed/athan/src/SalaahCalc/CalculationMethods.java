/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package athan.src.SalaahCalc;

/**
 * @author BENBOUZID
 */
public class CalculationMethods {

    public final int value;

    protected static final int Jafari_VAL = 0;
    protected static final int Karachi_VAL = 1;
    protected static final int ISNA_VAL = 2;
    protected static final int MWL_VAL = 3;
    protected static final int Makkah_VAL = 4;
    protected static final int Egypt_VAL = 5;
    protected static final int Custom_VAL = 6;

    /** L'attribut qui contient la valeur associ� � l'enum */
    public static final CalculationMethods Jafari = new CalculationMethods(Jafari_VAL);
    public static final CalculationMethods Karachi = new CalculationMethods(Karachi_VAL);
    public static final CalculationMethods ISNA = new CalculationMethods(ISNA_VAL);
    public static final CalculationMethods MWL = new CalculationMethods(MWL_VAL);
    public static final CalculationMethods Makkah = new CalculationMethods(Makkah_VAL);
    public static final CalculationMethods Egypt = new CalculationMethods(Egypt_VAL);
    public static final CalculationMethods Custom = new CalculationMethods(Custom_VAL);

    /** Le constructeur qui associe une valeur � l'enum */
    private CalculationMethods(int value) {
        this.value = value;
    }

    /** La m�thode accesseur qui renvoit la valeur de l'enum */
    public int getValue() {
        return this.value;
    }
}
