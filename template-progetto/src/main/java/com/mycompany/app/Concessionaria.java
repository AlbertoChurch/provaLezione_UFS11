import java.util.ArrayList;
import java.util.Calendar;

public class Concessionaria {
    private ArrayList<Veicolo> inventario;
    public Concessionaria() {
        Automobile auto1 = new Automobile("marca1","modello1","sportiva","elettrica",1999,2342,99);
        Automobile auto2 = new Automobile("marca2","modello2","berlina","benzina",1999,2311,111);
        Automobile auto3 = new Automobile("marca3","modello3","berlina","elettrica",1997,232,50);
        Motore motore1 = new Motore("marca4","modello4","sportiva","elettrica",2000,1112,60);
        Motore motore2 = new Motore("marca5","modello5","berlina","benzina",2012,9342,43);
        Motore motore3 = new Motore("marca6","modello6","sportiva","benzina",2020,5342,911);
        inventario = new ArrayList<Veicolo>();
        inventario.add(auto1);
        inventario.add(auto2);
        inventario.add(auto3);
        inventario.add(motore1);
        inventario.add(motore2);
        inventario.add(motore3);
    }

    public int calcoloInventario(){
        int prezzoTotale = 0;
        for ( Veicolo l : inventario){
             prezzoTotale += l.prezzoEffettivo();
        }
        return prezzoTotale;
    }
    public ArrayList filtroVeicoli(String ricerca){
        String[] parole = ricerca.split("\\s+"); // \\s+ serve a separare da uno o piu spazi le parole nella stringa
        ArrayList<Veicolo> risultati = new ArrayList<>();
        for (Veicolo l : inventario) {
            for(String p : parole){
                if (String.valueOf(l.getAnno().get(Calendar.YEAR)).contains(p) || l.getTipo().contains(p) || String.valueOf(l.getPrezzo()).contains(p)) {
                    risultati.add(l);
                    break;
                }
            }
        }
        return risultati;
    }

}
