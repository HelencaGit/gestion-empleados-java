import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static GestionEmpleados ges = new GestionEmpleados();
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu(){
        Scanner scan = new Scanner(System.in);
        int eleccion = 0;

        while (eleccion != 6){
            System.out.println("//////////////////////////");
            System.out.println("MENU:");
            System.out.println("1.Leer el fichero que tenemos");
            System.out.println("2.Introducir un nuevo empleado");
            System.out.println("3.Eliminar un empleado por ID");
            System.out.println("4.Eliminar un empleado por nombre");
            System.out.println("5.Sacar por pantalla el fichero organizado por ID");
            System.out.println("6.Salir y actualizar");
            System.out.println("//////////////////////////");
            System.out.println("Elige una opción");
            try {
                eleccion = scan.nextInt();
                switch (eleccion) {
                    case 1:
                        ges.mostrarEmpleados();
                        break;
                
                    case 2:
                        ges.introducirEmpleado();
                        break;
                    case 3:
                        scan.nextLine();
                        ges.eliminarDeColeccionPorId();
                        break;
                
                    case 4:
                        scan.nextLine();
                        ges.eliminarDeColeccionPorNombre();
                        break;
                    case 5:
                        ges.mostrarOrganizadoPorId();
                        break;
                
                    case 6:
                        ges.leerFicheroActualizarMap();
                        System.out.println("Hasta pronto!!");
                        break;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número del 1 al 6.");
                scan.nextLine(); // limpia lo que escribió mal, para que no se repita en bucle
            }

            
        }
    }
}
