
package superworld;

import static superworld.Mapa.miasta;
import static superworld.Mapa.zniszczoneMiasta;
import java.util.Random;
import javax.swing.ImageIcon;
/**
 *
 * @author Zuzanna Sawala
 */
public abstract class Człowiek extends Polozenie{
     private String imie;
     private int celX;
     private int celY;
     private int miastowyjscX;
     private int miastowyjscY;
     private int g;
     private int wynik;
     private int lmiast;
      private Skrzyzowanie zajeteSkrzyz;
      private int d;
       private ImageIcon image;
       private int k;
     
       /**
     *  Poruszanie się po prostej poziomej drodze pomiędzy skrzyżowaniami.
     * @throws InterruptedException 
     */
   public void poruszanieSiePoProstej() throws InterruptedException{
         if((this.getX()<130)||((this.getX()>230)&(this.getX()<380))||((this.getX()>480)&(this.getX()<630))||((this.getX()>730)&(this.getX()<880))||((this.getX()>980)&(this.getX()<1130))){
         if(((          getCelX()<getMiastowyjscX())&(this.getY()==312))||((getCelX()<getMiastowyjscX())&(this.getY()==334))){
       this.setX(this.getX()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                         //   getButtonPanel().setVisible(true);
                        //    getButtonPanel().repaint();
        }
      
          if(((         getCelX()>getMiastowyjscX())&(this.getY()==312))||((getCelX()>getMiastowyjscX())&(this.getY()==334))){
       this.setX(this.getX()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                          //  getButtonPanel().setVisible(true);
                         //   getButtonPanel().repaint();
        }
        
    Thread.sleep(20); 
      }
    }
       
        /**
        * Sprawdza do którego miasta należą podane parametry X i Y.
        * @param wartX
        * @param wartY
        * @return 
        */
      public int sprawdzKtoreMiasto(int wartX,int wartY){
        setK(0);
        while((wartX!=miasta.get(getK()).getX())||(wartY!=miasta.get(getK()).getY())){
            setK(getK() + 1);
        }
        return getK();
    }
      
       /**
        * Losuje miasto które postać ma odiwedzić. 
        */
    public void losujMiastoCel(){
        Random rand = new Random();
            setLmiast(rand.nextInt(10));
                    setCelX(miasta.get(getLmiast()).getX());
                    setCelY(miasta.get(getLmiast()).getY());
                    setG(0);
                     while(getG()<zniszczoneMiasta.size()){
                                if(getLmiast()==zniszczoneMiasta.get(getG())){
                                    setWynik(0);
                                    break;
                                }
                                setG(getG() + 1);
                            }
                            if(getG()==zniszczoneMiasta.size()){
                                setWynik(1);
                            }
         if(((       getCelX()==getMiastowyjscX())&(getCelY()==getMiastowyjscY()))||(getWynik()==0)){
             while(((    getCelX()==getMiastowyjscX())&(getCelY()==getMiastowyjscY()))||(getWynik()==0)){
                            setLmiast(rand.nextInt(10));
                            setG(0);
                            while(getG()<zniszczoneMiasta.size()){
                                if(getLmiast()==zniszczoneMiasta.get(getG())){
                                    setWynik(0);
                                    break;
                                }
                                setG(getG() + 1);
                            }
                            if(getG()==zniszczoneMiasta.size()){
                                setWynik(1);
                            }
                            setCelX(miasta.get(getLmiast()).getX());
                            setCelY(miasta.get(getLmiast()).getY());
           }
                   }
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

    /**
     * @return the celX
     */
    public int getCelX() {
        return celX;
    }

    /**
     * @param celX the celX to set
     */
    public void setCelX(int celX) {
        this.celX = celX;
    }

    /**
     * @return the celY
     */
    public int getCelY() {
        return celY;
    }

    /**
     * @param celY the celY to set
     */
    public void setCelY(int celY) {
        this.celY = celY;
    }

    /**
     * @return the miastowyjscX
     */
    public int getMiastowyjscX() {
        return miastowyjscX;
    }

    /**
     * @param miastowyjscX the miastowyjscX to set
     */
    public void setMiastowyjscX(int miastowyjscX) {
        this.miastowyjscX = miastowyjscX;
    }

    /**
     * @return the miastowyjscY
     */
    public int getMiastowyjscY() {
        return miastowyjscY;
    }

    /**
     * @param miastowyjscY the miastowyjscY to set
     */
    public void setMiastowyjscY(int miastowyjscY) {
        this.miastowyjscY = miastowyjscY;
    }

    /**
     * @return the g
     */
    public int getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * @return the wynik
     */
    public int getWynik() {
        return wynik;
    }

    /**
     * @param wynik the wynik to set
     */
    public void setWynik(int wynik) {
        this.wynik = wynik;
    }

    /**
     * @return the lmiast
     */
    public int getLmiast() {
        return lmiast;
    }

    /**
     * @param lmiast the lmiast to set
     */
    public void setLmiast(int lmiast) {
        this.lmiast = lmiast;
    }

    /**
     * @return the zajeteSkrzyz
     */
    public Skrzyzowanie getZajeteSkrzyz() {
        return zajeteSkrzyz;
    }

    /**
     * @param zajeteSkrzyz the zajeteSkrzyz to set
     */
    public void setZajeteSkrzyz(Skrzyzowanie zajeteSkrzyz) {
        this.zajeteSkrzyz = zajeteSkrzyz;
    }

    /**
     * @return the d
     */
    public int getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(int d) {
        this.d = d;
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

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }
    
}
