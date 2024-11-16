package publicatii;

public class revista extends Publicatie {
    private int numarExemplare;

    // Constructor
    public revista(String titlu, String autor, int anPublicare, int numarExemplare) {
        super(titlu, autor, anPublicare); // Apel către constructorul clasei de bază
        this.numarExemplare = numarExemplare;
    }

    // Getter și setter
    public int getNumarExemplare() {
        return numarExemplare;
    }

    public void setNumarExemplare(int numarExemplare) {
        this.numarExemplare = numarExemplare;
    }

    // Suprascrierea metodei toString
    @Override
    public String toString() {
        return super.toString() + ", Număr Exemplare: " + numarExemplare;
    }
}
