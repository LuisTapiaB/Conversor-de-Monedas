package Principal;

import Modelos.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Monedas.llenado();
        String monedaBase;
        String monedaObjetivo;
        ConversionRateRaw cambioraw;
        Scanner teclado = new Scanner(System.in);
        int base = 0;

        // primera pantalla

        while (base< Monedas.Size()){
            Menu.encabezado();
            System.out.println("ingrese Moneda Base:");
            Menu.menu1();

            // Pedido de datos de entrada
            try {
                base = teclado.nextInt() - 1;
                if(base == Monedas.Size())break;
                monedaBase = Monedas.getListaClaves().get(base);
                ArrayList <Monedas.ParMonedas> pares = new ArrayList<>();

                for (String i : Monedas.getListaClaves()) {
                    if(i.equals(monedaBase)) continue;
                    pares.add(new Monedas.ParMonedas(monedaBase, i));
                    pares.add(new Monedas.ParMonedas(i, monedaBase));
                }
                int opcion;
                while (true){
                    Menu.menu2(base);
                    opcion = teclado.nextInt()-1;
                    monedaBase = pares.get(opcion).base();
                    monedaObjetivo = pares.get(opcion).target();

                    if(opcion == Menu.getContadorMenu2()) break;

                    double monto;

                    if(opcion < Menu.getContadorMenu2()){
                        System.out.println("Ingrese el monto a convertir: ("+monedaBase+" >> "+monedaObjetivo+")");

                            monto = teclado.nextDouble();
                        //Consumo de Api
                        cambioraw = ConsultaApi.pairConversion(monedaBase,monedaObjetivo,monto);
                        ConversionRate cambio = new ConversionRate(cambioraw);
                        System.out.println(cambio);
                    }

                }
            } catch (InputMismatchException|IndexOutOfBoundsException e){
                System.out.println("entrada no valida: "+ e);
                teclado.nextLine(); // Limpiar el buffer para evitar el bucle infinito
            }
        }
    }
}

