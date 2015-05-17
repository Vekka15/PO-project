
package superworld;

/**
 *
 * @author Zuzanna Sawala
 */
public class Wynik implements Comparable<Wynik>{    
    private String imie;
    private String wynik;
    Wynik(String wynikA, String imie){
        this.wynik=wynikA;
        this.imie=imie;
    }

   @Override
    public int compareTo(Wynik o) {
        int porownaneWyniki = getWynik().compareTo(o.getWynik()); 
        return porownaneWyniki;
    }

    /**
     * @return the wynik
     */
    public String getWynik() {
        return wynik;
    }

    /**
     * @param wynik the wynik to set
     */
    public void setWynik(String wynik) {
        this.wynik = wynik;
    }

    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }
}
