import java.io.Serializable;

public class Empleado implements Serializable {
    private Integer id;
    private String nombre;
    private double salario;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public Empleado(Integer id, String nombre, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }
    public Empleado() {
    }
    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", salario=" + salario + "]";
    }

}
