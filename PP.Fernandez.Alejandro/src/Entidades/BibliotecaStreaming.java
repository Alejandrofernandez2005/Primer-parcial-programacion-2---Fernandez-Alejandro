package Entidades;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;

public class BibliotecaStreaming {
    private int capacidad;
    private Collection<Contenido> contenidos;

    public BibliotecaStreaming() {
        this.contenidos = new ArrayList<Contenido>();
        this.capacidad = 3;
    }

    public BibliotecaStreaming(int capacidad) {
        this.contenidos = new ArrayList<Contenido>();
        this.capacidad = capacidad;
    }

    private boolean sonIguales(Contenido c) {
        for (Contenido elemento : this.contenidos) {
            if (elemento.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(Contenido c) {
        if (this.contenidos.size() < this.capacidad) {
            if (!this.sonIguales(c)) {
                this.contenidos.add(c);
            } else {
                System.out.println("No se pudo agregar: El contenido ya existe.");
            }
        } else {
            System.out.println("No se pudo agregar: Biblioteca llena.");
        }
    }

    private int getDuracionCanciones() {
        int total = 0;
        for (Contenido c : this.contenidos) {
            if (c instanceof Cancion) {
                Cancion cancion = (Cancion) c;
                total += cancion.getDuracionConPublicidad();
            }
        }
        return total;
    }

    private int getDuracionPodcasts() {
        int total = 0;
        for (Contenido c : this.contenidos) {
            if (c instanceof Podcast) {
                Podcast podcast = (Podcast) c;
                total += podcast.getDuracionConPublicidad();
            }
        }
        return total;
    }

    private int getDuracionTotal() {
        return this.getDuracionCanciones() + this.getDuracionPodcasts();
    }

    private int getDuracionContenido(TipoContenido tipo) {
        if (tipo == TipoContenido.CANCIONES) {
            return this.getDuracionCanciones();
        } else if (tipo == TipoContenido.PODCASTS) {
            return this.getDuracionPodcasts();
        } else {
            return this.getDuracionTotal();
        }
    }

    private void ordenar() {
        ArrayList<Contenido> lista = (ArrayList<Contenido>) this.contenidos;
        Collections.sort(lista);
    }

    @Override
    public String toString() {
        this.ordenar();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de contenidos en la biblioteca: ").append(this.contenidos.size()).append("\n");
        sb.append("Contenidos ordenados:\n");
        
        for (Contenido c : this.contenidos) {
            sb.append("  - ").append(c.toString()).append("\n");
        }
        
        sb.append("\nDuraciones totales con publicidad por tipo:\n");
        sb.append("  - Canciones: ").append(this.getDuracionContenido(TipoContenido.CANCIONES)).append("s\n");
        sb.append("  - Podcasts: ").append(this.getDuracionContenido(TipoContenido.PODCASTS)).append("s\n");
        sb.append("  - Total: ").append(this.getDuracionContenido(TipoContenido.TODOS)).append("s\n");
        
        return sb.toString();
    }
}