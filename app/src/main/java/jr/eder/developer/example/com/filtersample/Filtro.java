package jr.eder.developer.example.com.filtersample;


public class Filtro
{
    String nombre;
    int id;

    public Filtro() {
    }

    public Filtro(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Filtro{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
