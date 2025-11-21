import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Creiamo una concessionaria con i veicoli predefiniti
        Concessionaria concessionaria = new Concessionaria();

        // Testiamo il calcolo del valore totale dell'inventario
        System.out.println("Valore totale dell'inventario: " + concessionaria.calcoloInventario());

        // Testiamo il metodo di filtro
        String ricerca = "sportiva 2020 elettrica";
        System.out.println("\nRisultati della ricerca per: \"" + ricerca + "\"");
        ArrayList<Veicolo> risultati = concessionaria.filtroVeicoli(ricerca);
        for (Veicolo v : risultati) {
            System.out.println(v.getMarca() + " " + v.getModello() + " - " + v.getTipo());
        }

        System.out.println(concessionaria.calcoloInventario());
/*
        // Testiamo il calcolo dell'assicurazione
        System.out.println("\nTest assicurazione:");
        for (Veicolo v : concessionaria.getInventario()) {
            System.out.println(v.getMarca() + " " + v.getModello() + " - Assicurazione: " + v.assicurazioneAuto());
        }

 */
    }
}
