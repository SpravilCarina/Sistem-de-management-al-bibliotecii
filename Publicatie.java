package publicatii;

public class Publicatie {
    private String titlu;
    private String autor;
    private int anPublicare;

    // Constructor
    public Publicatie(String titlu, String autor, int anPublicare) {
        this.titlu = titlu;
        this.autor = autor;
        this.anPublicare = anPublicare;
    }

    // Getteri și setteri
    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnPublicare() {
        return anPublicare;
    }

    public void setAnPublicare(int anPublicare) {
        this.anPublicare = anPublicare;
    }

    // Suprascrierea metodei toString
    @Override
    public String toString() {
        return "Titlu: " + titlu + ", Autor: " + autor + ", An Publicare: " + anPublicare;
    }
}
