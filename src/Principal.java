import Modelos.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
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
            base = teclado.nextInt() - 1; // Pedido de datos de entrada

            if(base == Monedas.Size())break;
            if(base <= 0 || base > Monedas.Size()) {
                System.out.println("invalido");
                base = 0;
                continue;
            }

            monedaBase = Monedas.getListaClaves().get(base);
            //Limpieza de buffer
            teclado.nextLine();
            ArrayList <Monedas.ParMonedas> pares = new ArrayList<>();

            for (String i : Monedas.getListaClaves()) {
                if(i.equals(monedaBase)) continue;
                pares.add(new Monedas.ParMonedas(monedaBase, i));
                pares.add(new Monedas.ParMonedas(i, monedaBase));
            }

            if(base < Monedas.Size()) {
                while (true){
                    Menu.menu2(base);
                    int opcion = teclado.nextInt()-1;
                    teclado.nextLine();
                    if(opcion == Menu.getContadorMenu2())break;
                    monedaBase = pares.get(opcion).base();
                    monedaObjetivo = pares.get(opcion).target();

                    if(opcion < Menu.getContadorMenu2()){
                        System.out.println("Ingrese el monto a convertir: ("+monedaBase+" >> "+monedaObjetivo+")");
                        Double monto = teclado.nextDouble();

                        //Consumo de Api
                        cambioraw = ConsultaApi.pairConversion(monedaBase,monedaObjetivo,monto);
                        ConversionRate cambio = new ConversionRate(cambioraw);
                        System.out.println(cambio);
                    }

                }
            }
        }
    }
}
