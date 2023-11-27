import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Numele fișierului în care vom scrie textul
        String numeFisier = "exemplu.txt";

        // Textul pe care îl vom scrie în fișier
        String textDeScris = "Hello Java filles";

        // Încercăm să scriem în fișier
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            // Scriem textul în fișier
            writer.write(textDeScris);

            // Afisăm un mesaj de succes
            System.out.println("Textul a fost scris în " + numeFisier);
        } catch (IOException e) {
            // În caz de eroare, afișăm un mesaj de eroare
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }

        // Punctul 1: Citirea textului din fisierul creat
        citesteSiAfiseazaFisier(numeFisier);

        // Punctul 2: Adăugarea unei noi linii în fisier
        adaugaLinieInFisier(numeFisier, "Adaugăm o nouă linie!");

        // Punctul 3: Citirea și afișarea noului conținut din fisierul modificat
        citesteSiAfiseazaFisier(numeFisier);
    }

    // Metoda pentru citirea și afișarea conținutului unui fisier
    private static void citesteSiAfiseazaFisier(String numeFisier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            System.out.println("Citirea din " + numeFisier + ":");
            String linie;
            while ((linie = reader.readLine()) != null) {
                System.out.println(linie);
            }
            System.out.println("---------------");
        } catch (IOException e) {
            System.err.println("Eroare la citirea din " + numeFisier + ": " + e.getMessage());
        }
    }

    // Metoda pentru adăugarea unei noi linii într-un fisier
    private static void adaugaLinieInFisier(String numeFisier, String textDeAdaugat) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.newLine(); // Adăugăm o linie nouă înainte de noul text
            writer.write(textDeAdaugat);

            System.out.println("Adăugat în " + numeFisier + ": " + textDeAdaugat);
        } catch (IOException e) {
            System.err.println("Eroare la adăugarea în " + numeFisier + ": " + e.getMessage());
        }
    }
}
