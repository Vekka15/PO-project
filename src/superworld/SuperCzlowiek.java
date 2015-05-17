
package superworld;

import javax.swing.*;

/**
 *
 * @author Zuzanna Sawala
 */
public abstract class SuperCzlowiek extends Człowiek{
  
    private int zycie;
    private int inteligencja;
    private int wytrzymalosc;
    private int sila; 
    private int umiejetnosciWalki;
    private int szybkosc;
    private int x,y;
    private ImageIcon image = new ImageIcon("C:/Users/Zuzanna Sawala/Moje dokumenty/NetBeansProjects/SuperWorld/mysz.jpg");
   
    

    /**
     * @return the zycie
     */
    public int getZycie() {
        return zycie;
    }

    /**
     * @param zycie the zycie to set
     */
    public void setZycie(int zycie) {
        this.zycie = zycie;
    }

    /**
     * @return the inteligencja
     */
    public int getInteligencja() {
        return inteligencja;
    }

    /**
     * @param inteligencja the inteligencja to set
     */
    public void setInteligencja(int inteligencja) {
        this.inteligencja = inteligencja;
    }

    /**
     * @return the wytrzymalosc
     */
    public int getWytrzymalosc() {
        return wytrzymalosc;
    }

  

    /**
     * @param wytrzymalosc the wytrzymalosc to set
     */
    public void setWytrzymalosc(int wytrzymalosc) {
        this.wytrzymalosc = wytrzymalosc;
    }

    /**
     * @return the sila
     */
    public int getSila() {
        return sila;
    }

    /**
     * @param sila the sila to set
     */
    public void setSila(int sila) {
        this.sila = sila;
    }

    /**
     * @return the umiejetnosciWalki
     */
    public int getUmiejetnosciWalki() {
        return umiejetnosciWalki;
    }

    /**
     * @param umiejetnosciWalki the umiejetnosciWalki to set
     */
    public void setUmiejetnosciWalki(int umiejetnosciWalki) {
        this.umiejetnosciWalki = umiejetnosciWalki;
    }

    /**
     * @return the szybkosc
     */
    public int getSzybkosc() {
        return szybkosc;
    }

    /**
     * @param szybkosc the szybkosc to set
     */
    public void setSzybkosc(int szybkosc) {
        this.szybkosc = szybkosc;
    }

    /**
     * @return the image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    
}
