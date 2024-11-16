package publicatii;

import java.io.*;
import java.util.*;

public class GestionarePublicatii {
    // Citire din fișier CSV
    public static List<Publicatie> citesteDinCSV(String fisier) throws IOException {
        List<Publicatie> publicatii = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fisier));
        String linie;

        while ((linie = reader.readLine()) != null) {
            String[] valori = linie.split(",");
            String tip = valori[0];
            String titlu = valori[1];
            String autor = valori[2];
            int anPublicare = Integer.parseInt(valori[3]);

            if (tip.equalsIgnoreCase("Carte")) {
                int numarPagini = Integer.parseInt(valori[4]);
                publicatii.add(new Carte(titlu, autor, anPublicare, numarPagini));
            } else if (tip.equalsIgnoreCase("Revista")) {
                int numarExemplare = Integer.parseInt(valori[4]);
                publicatii.add(new revista(titlu, autor, anPublicare, numarExemplare));
            }
        }

        reader.close();
        return publicatii;
    }

    // Scriere în fișier CSV
    public static void scrieInCSV(String fisier, List<Publicatie> publicatii) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fisier));

        for (Publicatie p : publicatii) {
            if (p instanceof Carte) {
                Carte carte = (Carte) p;
                writer.write("Carte," + carte.getTitlu() + "," + carte.getAutor() + "," + carte.getAnPublicare() + "," + carte.getNumarPagini());
            } else if (p instanceof revista) {
                revista revista = (revista) p;
                writer.write("Revista," + revista.getTitlu() + "," + revista.getAutor() + "," + revista.getAnPublicare() + "," + revista.getNumarExemplare());
            }
            writer.newLine();
        }

        writer.close();
    }
}
