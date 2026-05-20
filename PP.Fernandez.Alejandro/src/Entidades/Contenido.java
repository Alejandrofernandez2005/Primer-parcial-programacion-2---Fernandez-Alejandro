package Entidades;

import java.util.Random;

public abstract class Contenido implements Comparable<Contenido> {
    protected Artista artista;
    protected String titulo;
    protected int duracion;
    protected int likes;
    protected static Random generadorLikes;

    static {
        generadorLikes = new Random();
    }

    public Contenido(String titulo, int duracion, Artista artista) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.artista = artista;
        this.likes = 0;
    }

    public Contenido(String titulo, int duracion, String nombreArtista, String apellidoArtista, String paisArtista) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.artista = new Artista(nombreArtista, apellidoArtista, paisArtista);
        this.likes = 0;
    }

    public int getLikes() {
        if (this.likes == 0) {
            this.likes = generadorLikes.nextInt(1000000) + 1;
        }
        return this.likes;
    }

    private static String mostrar(Contenido c) {
        if (c == null) {
            return "";
        }
        return "Titulo: " + c.titulo + " - Duracion: " + c.duracion + " - Likes: " + c.getLikes() + " - Artista: " + c.artista.getArtista();
    }

    public static boolean sonIguales(Contenido c1, Contenido c2) {
        if (c1 == null || c2 == null) {
            return false;
        }
        return c1.titulo.equals(c2.titulo) && Artista.sonIguales(c1.artista, c2.artista);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Contenido) {
            Contenido c = (Contenido) obj;
            return sonIguales(this, c);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.titulo + " - Artista: " + this.artista.getNombre() + " " + this.artista.getApellido() + " - Likes: " + this.getLikes();
    }

    @Override
    public int compareTo(Contenido c) {
        int compApellido = this.artista.getApellido().compareTo(c.artista.getApellido());
        
        if (compApellido == 0) {
            int compNombre = this.artista.getNombre().compareTo(c.artista.getNombre());
            if (compNombre == 0) {
                return this.titulo.compareTo(c.titulo);
            }
            return compNombre;
        }
        return compApellido;
    }
}