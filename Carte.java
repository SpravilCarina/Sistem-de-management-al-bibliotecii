package publicatii;

public class Carte extends Publicatie {
    private int numarPagini;

    // Constructor
    public Carte(String titlu, String autor, int anPublicare, int numarPagini) {
        super(titlu, autor, anPublicare); // Apel către constructorul clasei de bază
        this.numarPagini = numarPagini;
    }

    // Getter și setter
    public int getNumarPagini() {
        return numarPagini;
    }

    public void setNumarPagini(int numarPagini) {
        this.numarPagini = numarPagini;
    }

    // Metodă pentru numărul de cuvinte
    public int calculeazaNumarCuvinte(int cuvintePePagina) {
        return numarPagini * cuvintePePagina;
    }

    // Suprascrierea metodei toString
    @Override
    public String toString() {
        return super.toString() + ", Număr Pagini: " + numarPagini;
    }
}
