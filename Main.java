package publicatii;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Inițializarea unei liste pentru publicatii
        List<Publicatie> publicatii = new ArrayList<>();
        String fisier = "C:\\Users\\Carina\\IdeaProjects\\sistem de manegement\\src\\publicatii\\publicatii.csv"; // Numele fișierului CSV pentru salvarea datelor

        // Citirea publicațiilor din fișier
        try {
            publicatii = GestionarePublicatii.citesteDinCSV(fisier);
        } catch (IOException e) {
            System.out.println("Nu s-au putut citi datele din fișier: " + e.getMessage());
        }

        // Scanner pentru citirea inputului utilizatorului
        Scanner scanner = new Scanner(System.in);
        boolean ruleaza = true;

        // Meniul interactiv
        while (ruleaza) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișează toate publicațiile");
            System.out.println("2. Filtrează publicațiile după anul publicării");
            System.out.println("3. Afișează doar cărțile");
            System.out.println("4. Afișează doar revistele");
            System.out.println("5. Adaugă o nouă publicație");
            System.out.println("6. Afișează revista cu cele mai multe exemplare");
            System.out.println("7. Ieșire");

            System.out.print("Alege o opțiune: ");
            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumă newline-ul rămas

            switch (optiune) {
                case 1 -> {
                    System.out.println("Toate publicațiile:");
                    publicatii.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Introdu anul pentru filtrare: ");
                    int an = scanner.nextInt();
                    System.out.println("Publicațiile din anul " + an + ":");
                    publicatii.stream()
                            .filter(p -> p.getAnPublicare() == an)
                            .forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Cărțile disponibile:");
                    publicatii.stream()
                            .filter(p -> p instanceof Carte)
                            .forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("Revistele disponibile:");
                    publicatii.stream()
                            .filter(p -> p instanceof revista)
                            .forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Tipul publicației (Carte/Revista): ");
                    String tip = scanner.nextLine();
                    System.out.print("Titlu: ");
                    String titlu = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("An publicare: ");
                    int an = scanner.nextInt();
                    scanner.nextLine(); // Consumă newline-ul rămas

                    if (tip.equalsIgnoreCase("Carte")) {
                        System.out.print("Număr de pagini: ");
                        int pagini = scanner.nextInt();
                        publicatii.add(new Carte(titlu, autor, an, pagini));
                    } else if (tip.equalsIgnoreCase("Revista")) {
                        System.out.print("Număr de exemplare: ");
                        int exemplare = scanner.nextInt();
                        publicatii.add(new revista(titlu, autor, an, exemplare));
                    } else {
                        System.out.println("Tipul specificat nu este valid.");
                    }

                    // Scriere în fișier după adăugare
                    try {
                        GestionarePublicatii.scrieInCSV(fisier, publicatii);
                    } catch (IOException e) {
                        System.out.println("Nu s-a putut salva în fișier: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("Revista cu cele mai multe exemplare:");
                    publicatii.stream()
                            .filter(p -> p instanceof revista)
                            .map(p -> (revista) p)
                            .max(Comparator.comparingInt(revista::getNumarExemplare))
                            .ifPresent(System.out::println);
                }
                case 7 -> {
                    ruleaza = false;
                    System.out.println("La revedere!");
                }
                default -> System.out.println("Opțiune invalidă. Încearcă din nou.");
            }
        }

        scanner.close();
    }
}
