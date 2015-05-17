

package superworld;

import javax.swing.*;

/**
 *
 * @author Zuzanna Sawala
 */
public class Skrzyzowanie extends Polozenie{
    
    private int x,y;
     private int poziomyStartX;
    private int poziomyKoniecX;
    private int dlugoscPozioma;
    private int pionowyStartY;
    private int pionowyKoniecY;
    private int dlugoscPionowa;
    private volatile boolean zajete;
    private ImageIcon image=new ImageIcon("skrzyzowanie1.png");
    
    void ustawNaSrodek()
    {
        setX(getX()-25);
    }
    /**
     * @return the poziomyStartX
     */
    public int getPoziomyStartX() {
        return poziomyStartX;
    }

    /**
     * @param poziomyStartX the poziomyStartX to set
     */
    public void setPoziomyStartX(int poziomyStartX) {
        this.poziomyStartX = poziomyStartX;
    }

    /**
     * @return the poziomyKoniecX
     */
    public int getPoziomyKoniecX() {
        return poziomyKoniecX;
    }

    /**
     * @param poziomyKoniecX the poziomyKoniecX to set
     */
    public void setPoziomyKoniecX(int poziomyKoniecX) {
        this.poziomyKoniecX = poziomyKoniecX;
    }

    /**
     * @return the dlugoscPozioma
     */
    public int getDlugoscPozioma() {
        return dlugoscPozioma;
    }

    /**
     * @param dlugoscPozioma the dlugoscPozioma to set
     */
    public void setDlugoscPozioma(int dlugoscPozioma) {
        this.dlugoscPozioma = dlugoscPozioma;
    }

    /**
     * @return the pionowyStartY
     */
    public int getPionowyStartY() {
        return pionowyStartY;
    }

    /**
     * @param pionowyStartY the pionowyStartY to set
     */
    public void setPionowyStartY(int pionowyStartY) {
        this.pionowyStartY = pionowyStartY;
    }

    /**
     * @return the pionowyKoniecY
     */
    public int getPionowyKoniecY() {
        return pionowyKoniecY;
    }

    /**
     * @param pionowyKoniecY the pionowyKoniecY to set
     */
    public void setPionowyKoniecY(int pionowyKoniecY) {
        this.pionowyKoniecY = pionowyKoniecY;
    }

    /**
     * @return the dlugoscPionowa
     */
    public int getDlugoscPionowa() {
        return dlugoscPionowa;
    }

    /**
     * @param dlugoscPionowa the dlugoscPionowa to set
     */
    public void setDlugoscPionowa(int dlugoscPionowa) {
        this.dlugoscPionowa = dlugoscPionowa;
    }

    /**
     * @return the zajete
     */
    public boolean isZajete() {
        return zajete;
    }

    /**
     * @param zajete the zajete to set
     */
    public void setZajete(boolean zajete) {
        this.zajete = zajete;
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
