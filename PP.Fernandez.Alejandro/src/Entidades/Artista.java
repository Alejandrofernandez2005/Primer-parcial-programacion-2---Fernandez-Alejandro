package Entidades;

public class Artista {
    private String nombre;
    private String apellido;
    private String pais;

    public Artista(String nombre, String apellido, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }

    public static boolean sonIguales(Artista a1, Artista a2) {
        if (a1 == null || a2 == null) {
            return false;
        }
        return a1.nombre.equals(a2.nombre) && 
               a1.apellido.equals(a2.apellido) && 
               a1.pais.equals(a2.pais);
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getArtista() {
        return this.nombre + " - " + this.apellido + " - " + this.pais;
    }
}