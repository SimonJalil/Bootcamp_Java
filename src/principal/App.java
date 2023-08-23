package principal; 

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una fecha (dd/mm/yyyy): ");
        String fecha = scanner.nextLine();
        
        if (validarFecha(fecha)) {
            System.out.println("La fecha es correcta.");
        } else {
            System.out.println("La fecha es incorrecta.");
        }
    }

    public static boolean validarFecha(String fecha) {
        String[] partes = fecha.split("/");
        if (partes.length != 3) {
            return false;
        }
        
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);
        
        if (anio < 1900 || anio > 2099) {
            return false;
        }
        
        if (mes < 1 || mes > 12) {
            return false;
        }
        

        /* Año bisiesto: */
        /*En el calendario gregoriano, un año bisiesto ocurre cada 4 años, excepto en los años que son múltiplos de 100 pero no son múltiplos de 400. Esto significa que si un año es divisible por 4 y no es divisible por 100, o si es divisible por 400, entonces es un año bisiesto.*/ 
        if (mes == 2) {
            if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
                if (dia < 1 || dia > 29) {
                    return false;
                }
            } else {
                if (dia < 1 || dia > 28) {
                    return false;
                }
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia < 1 || dia > 30) {
                return false;
            }
        } else {
            if (dia < 1 || dia > 31) {
                return false;
            }
        }
        
        return true;
    }
}
