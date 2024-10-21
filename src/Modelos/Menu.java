package Modelos;

public class Menu {
    private static int contadorMenu2 = 0;

    public static void menu1(){
        for(int i = 0; i < Monedas.Size(); i++) {
            System.out.println(i+1 +")"+ Monedas.getListaClaves().get(i)+
                    "("+ Monedas.getListaValores().get(i)+")");
        }
        menuSalir(Monedas.Size());
    }
    public static void menu1(int base){
        for(int i = 0; i < Monedas.Size(); i++) {
            if(i != base){
                System.out.println(i+1 +")"+ Monedas.getListaClaves().get(i)+
                        "("+ Monedas.getListaValores().get(i)+")");
            }
        }
        menuSalir(Monedas.Size());
    }

    public static void menu2(int base){
        encabezado();
        contadorMenu2 = 0;

        for(int i = 0; i< Monedas.Size(); i++) {
            if(base == i) continue;
            contadorMenu2++;
            System.out.println(contadorMenu2 +")"+ Monedas.getListaClaves().get(base)+
                    "("+ Monedas.getListaValores().get(base)+")"+ " >> " +
                    Monedas.getListaClaves().get(i)+"("+ Monedas.getListaValores().get(i)+")");
            contadorMenu2++;
            System.out.println(contadorMenu2 +")"+ Monedas.getListaClaves().get(i)+
                    "("+ Monedas.getListaValores().get(i)+")"+ " >> " +
                    Monedas.getListaValores().get(base)+"("+ Monedas.getListaValores().get(base)+")");
        }
        menuSalir(contadorMenu2);
    }

    public static void encabezado(){
        System.out.println("\nConversor de Modelos.Monedas");
        System.out.println("*****************************\n");
    }

    static void menuSalir(Integer finalnum){
        finalnum++;
        System.out.println(finalnum + ") Salir\n");
        System.out.println("¿Que opción va a elegir?:");
    }
    public static int getContadorMenu2() {
        return contadorMenu2;
    }
}
