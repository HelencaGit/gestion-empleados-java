import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GestionEmpleados {
    Scanner teclado = new Scanner(System.in);
    private Map <Integer,Empleado> todosEmpleados = new HashMap<>();

    public GestionEmpleados(){
        mostrarEmpleados();
    }

    public void leerFicheroActualizarMap(){
        Path ruta = Paths.get("Empleados.dat");

        if(Files.notExists(ruta)){
            System.out.println("El fichero no existe");
        }else{
            try {
                InputStream is = Files.newInputStream(ruta);
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(is));
                todosEmpleados = (HashMap)ois.readObject();
                ois.close();
                is.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();   
            }
        }
    }

    public Map<Integer,Empleado> mostrarEmpleados(){
        leerFicheroActualizarMap();
        for(Map.Entry<Integer,Empleado> emple:todosEmpleados.entrySet()){
            System.out.println("Empleado " + emple.getKey()+": " + emple.getValue().toString());
        }

        return todosEmpleados;
    }

    public void escribirEnColeccionConFichero(){
        Path ruta = Paths.get("Empleados.dat");
        try {
            OutputStream os = Files.newOutputStream(ruta);
            ObjectOutputStream oos= new ObjectOutputStream(new BufferedOutputStream(os));
            oos.writeObject(todosEmpleados);
            oos.close();
            os.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();   
        }
    }

    public void introducirEmpleado(){
        System.out.println("Nuevo empleado:");
        System.out.println("ID:");
        int id = teclado.nextInt();
        teclado.nextLine();
        if(todosEmpleados.containsKey(id)){//si ya existe ese id, avisamos y no seguimos
            System.out.println("Este ID ya está inscrito");
            return;
        }
        System.out.println("Nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Sueldo:");
        double sueldo;
        try {
            sueldo = Double.parseDouble(teclado.nextLine().replace(",", "."));//cambio la coma por punto, por si escribe 1500,5
        } catch (NumberFormatException e) {
            System.out.println("El sueldo no es válido");
            return;
        }
        Empleado empleadoNuevo = new Empleado(id, nombre, sueldo);
        todosEmpleados.put(id,empleadoNuevo);
        escribirEnColeccionConFichero();

    }

    public void eliminarDeColeccionPorId(){
        leerFicheroActualizarMap();
        System.out.println("¿Qué id quieres borrar?");
        int id = teclado.nextInt();
        Iterator<Map.Entry<Integer,Empleado>> iteratorEmpleados = todosEmpleados.entrySet().iterator();
        while(iteratorEmpleados.hasNext()){
            Map.Entry<Integer,Empleado> emple = iteratorEmpleados.next();
            if(emple.getKey()==(id)){
                System.out.println("Empleado con id " + emple.getKey() + " borrado");
                iteratorEmpleados.remove();
            }
        }
        escribirEnColeccionConFichero();
    }

    public void eliminarDeColeccionPorNombre(){
        leerFicheroActualizarMap();
        System.out.println("¿Qué nombre de empleado quieres borrar?");
        String nombre = teclado.nextLine();
        Iterator<Map.Entry<Integer,Empleado>> iteratorEmpleados = todosEmpleados.entrySet().iterator();
        while(iteratorEmpleados.hasNext()){
            Map.Entry<Integer,Empleado> emple = iteratorEmpleados.next();
            if(emple.getValue().getNombre().toLowerCase().equals(nombre)){
                System.out.println("Empleado con nombre " + emple.getValue().getNombre() + " borrado");
                iteratorEmpleados.remove();
            }
        }
        escribirEnColeccionConFichero();
    }

    public void mostrarOrganizadoPorId(){
        TreeMap <Integer,Empleado> mapOrganizado = new TreeMap<>(todosEmpleados);
        for(Map.Entry<Integer,Empleado> emple:mapOrganizado.entrySet()){
            System.out.println("ID: " + emple.getKey());
            System.out.println("Empleado: " + emple.getValue().toString());
        }
    }





}
