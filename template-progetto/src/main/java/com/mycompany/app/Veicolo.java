import java.util.Calendar;
import java.util.Objects;

public abstract class Veicolo {
    private String marca;
    private String modello;
    private String tipo;
    private String alimentzione;
    private  int annoImmatricolazione;
    private  int prezzo;
    private  int cilindrata;
    private Calendar anno = Calendar.getInstance();
    private int annoAttuale = anno.get(Calendar.YEAR);
    private int assicurazione = 500;

    public  Veicolo(String marca, String modello, String tipo, String alimentzione, int annoImmatricolazione, int prezzo, int cilindrata) {
        this.marca = marca;
        this.modello = modello;
        this.tipo = tipo;
        this.alimentzione = alimentzione;
        this.annoImmatricolazione = annoImmatricolazione;
        this.prezzo = prezzo;
        this.cilindrata = cilindrata;
    }

    public int prezzoEffettivo(){
        for ( int i = annoImmatricolazione; i <= annoAttuale; i++ ){
            prezzo += (prezzo / 100) * 10;
        }
        if (Objects.equals(alimentzione, "elettrica") && this instanceof Automobile){
            if ((prezzo / 100) * 25 <= 5000) {
            prezzo -= (prezzo / 100) * 25;
            }
            prezzo -= 5000;
        }
        return prezzo;
    }
    // calcolo dell'asicurazione, se l'auto è sportiva + 20% in piu costa -
// lato moto l'assicurazione aumenta in base alla cilindrata
    public int assicurazioneAuto(){
        if (tipo == "sportiva" && this instanceof Automobile){
            return assicurazione += (assicurazione / 100) * 20;
        }else if (cilindrata > 125  && this instanceof Motore){
             assicurazione += (assicurazione / 100) * 10;
            if ( cilindrata > 500 ){
             assicurazione += (assicurazione / 100) * 10;
            }
            if ( cilindrata > 1000 ){
                assicurazione += (assicurazione / 100) * 10;
            }
        }
        return assicurazione;
    }
    // <editor-fold defaultstate="collapsed" desc="Tutti i Get e Set">
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getAlimentzione() {
        return alimentzione;
    }
    public void setAlimentzione(String alimentzione) {
        this.alimentzione = alimentzione;
    }
    public Calendar getAnno() {
        return anno;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    // </editor-fold>
}
