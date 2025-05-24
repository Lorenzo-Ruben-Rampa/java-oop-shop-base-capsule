import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {
    //attributi Prodotto
   private String name;   
   private String description;
   private BigDecimal price;
   private BigDecimal iva;
   private final int code;
   private boolean isAvailable = false; 
   
// costruttore
    public Prodotto(String name, String description, BigDecimal iva) {
    this.code = generateRandomCode();
    this.name = name;
    this.description = description;
    this.iva = iva.setScale(2, RoundingMode.HALF_UP);
    this.isAvailable = false;
    generateNewBasePrice();
    }

// 2° Costruttore (IVA di default)
    public Prodotto(String name, String description) {
        this(name, description, new BigDecimal("0.22")); // IVA default 22%
    }

    // capacità prodotto

    // --- METODI PRIVATI (utilità interna) ---
    private int generateRandomCode() {
        return new Random().nextInt(99999);
    }

        //metodo per generare prezzo base casuale
    private void generateNewBasePrice() {
        Random rand = new Random();
        this.price = new BigDecimal(rand.nextInt(100) + 1).setScale(2, RoundingMode.HALF_UP);
    }
    
    // --- METODI PUBBLICI ---

    // disponibilità del prodotto
    public void available() {
        this.isAvailable = true;
        System.out.println("Il prodotto è disponibile");
    }

    //metodo per calcolare prezzo finale
    public BigDecimal generateFinalPrice() {
        if(price != null && iva != null) {
            return price.add(price.multiply(iva)).setScale(2, RoundingMode.DOWN);
        }   
    return null;
}
    // --- GETTER E SETTER ---

//   public int getCode() {
//         return code;
//     }

    // getter per comporre il nome del prodotto
    public String getName() {
        if (name != null) {
            return String.format("%05d", code) + "-" + name;
        }
        return "Prodotto senza nome";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    public BigDecimal getIva() {
	return iva;
    }

    public void setIva(BigDecimal iva) {	
            this.iva = iva;
    }

}