package Entidades;

public class Cancion extends Contenido implements Publicitable {
    private GeneroMusical generoMusical;
    private CalidadAudio calidadAudio;

    public Cancion(String titulo, int duracion, Artista artista, GeneroMusical generoMusical, CalidadAudio calidadAudio) {
        super(titulo, duracion, artista);
        this.generoMusical = generoMusical;
        this.calidadAudio = calidadAudio;
    }

    @Override
    public int getDuracionConPublicidad() {
        if (this.calidadAudio == CalidadAudio.BAJA) {
            return this.duracion + 30;
        } else if (this.calidadAudio == CalidadAudio.MEDIA) {
            return this.duracion + 20;
        }
        return this.duracion;
    }

    @Override
    public String toString() {
        return super.toString() + " - Duracion con publicidad: " + this.getDuracionConPublicidad() + "s";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Cancion) {
            Cancion otra = (Cancion) obj;
            return super.equals(otra) && this.generoMusical == otra.generoMusical;
        }
        return false;
    }
}