
package ec.edu.ups.modelo;

/**
 *
 * @author srcti
 */
public class Empleado extends Persona{
    private String contrasenia;
    private int cargo;

    public Empleado() {
      
    }

   
    public Empleado(String contrasenia, int cargo, int id, String nombre, String apellido, String cedula, String direccion, String telefono, String email, String genero, String estado) {
        super(id, nombre, apellido, cedula, direccion, telefono, email, genero, estado);
        this.contrasenia = contrasenia;
        this.cargo = cargo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "contrasenia=" + contrasenia + ", cargo=" + cargo + '}';
    }
    

   
 
    
}
