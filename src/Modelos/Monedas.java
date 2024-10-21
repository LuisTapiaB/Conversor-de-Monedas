package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monedas {
    private static Map<String, String> monedasMap = new HashMap<>();
    private static List<String> listaClaves;
    private static List<String> listaValores;
    private static int size;

    public static void llenado(){
        monedasMap.put("ARS", "Pesos Argentinos");
        monedasMap.put("MXN", "Pesos Mexicanos");
        monedasMap.put("COP", "Pesos Colombianos");
        monedasMap.put("USD", "Dolares");

        listaClaves = new ArrayList<>(monedasMap.keySet());
        listaValores = new ArrayList<>(monedasMap.values());
    }
    // getters -------------------------------------------------------
    public static int Size() {
        return size = monedasMap.size();
    }

    public static List<String> getListaClaves() {
        return listaClaves;
    }

    public static List<String> getListaValores() {
        return listaValores;
    }

    public static Map<String, String> getMonedasMap() {
        return monedasMap;
    }
    // Records----------------------------------------------------------

    public static record ParMonedas(String base, String target){
    }
}
