
package superworld;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Zuzanna Sawala
 */
public class Miasto extends Polozenie{
    private String nazwa;
    private int liczbaMieszkańców;
     private int x,y;
     private int liczbaAktywnychMocy;
    private ImageIcon image = new ImageIcon("miasto.png");
    private JFrame cityFrame;
    private JLabel nazwaLabel;
    private JLabel liczbaMieszkancowLabel;
    ArrayList<ZrodloMocy> zrodlaMiasta = new ArrayList<ZrodloMocy>();
    ArrayList<JLabel> zrodlaMiastaLabels = new ArrayList<JLabel>();
    Set<Integer> generated = new LinkedHashSet<Integer>();
    private JLabel zrodloL;
    private int i;
     private int liczbaZrodel;
     private Boolean zniszczone=false;
     private int w;
    Miasto(){
           i=0;
        w=100;
        this.liczbaMieszkańców=0;
        Random rand = new Random();
        liczbaZrodel=rand.nextInt(4) + 1;      
        while (generated.size() < liczbaZrodel)
        {
    Integer next = rand.nextInt(6) + 0;
    generated.add(next);
        }
        Integer[] tablica = generated.toArray(new Integer[generated.size()]);
        while(i<generated.size()){
        zrodlaMiasta.add(new ZrodloMocy(tablica[getI()]));
        zrodlaMiastaLabels.add(new JLabel(zrodlaMiasta.get(getI()).getTyp()+":    " +zrodlaMiasta.get(getI()).getPotencjal()));
        zrodlaMiastaLabels.get(i).setBounds(10,w,200,20);
            i++;
    w=w+20;
        }

        
    }
 
    /*Gettery i settery*/

    /**
     * @return the nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * @param nazwa the nazwa to set
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the liczbaAktywnychMocy
     */
    public int getLiczbaAktywnychMocy() {
        return liczbaAktywnychMocy;
    }

    /**
     * @param liczbaAktywnychMocy the liczbaAktywnychMocy to set
     */
    public void setLiczbaAktywnychMocy(int liczbaAktywnychMocy) {
        this.liczbaAktywnychMocy = liczbaAktywnychMocy;
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
     * @return the liczbaMieszkancowLabel
     */
    public JLabel getLiczbaMieszkancowLabel() {
        return liczbaMieszkancowLabel;
    }

    /**
     * @param liczbaMieszkancowLabel the liczbaMieszkancowLabel to set
     */
    public void setLiczbaMieszkancowLabel(JLabel liczbaMieszkancowLabel) {
        this.liczbaMieszkancowLabel = liczbaMieszkancowLabel;
    }


    /**
     * @return the zrodloL
     */
    public JLabel getZrodloL() {
        return zrodloL;
    }

    /**
     * @param zrodloL the zrodloL to set
     */
    public void setZrodloL(JLabel zrodloL) {
        this.zrodloL = zrodloL;
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * @return the liczbaZrodel
     */
    public int getLiczbaZrodel() {
        return liczbaZrodel;
    }

    /**
     * @param liczbaZrodel the liczbaZrodel to set
     */
    public void setLiczbaZrodel(int liczbaZrodel) {
        this.liczbaZrodel = liczbaZrodel;
    }

    /**
     * @return the zniszczone
     */
    public Boolean getZniszczone() {
        return zniszczone;
    }

    /**
     * @param zniszczone the zniszczone to set
     */
    public void setZniszczone(Boolean zniszczone) {
        this.zniszczone = zniszczone;
    }

    /**
     * @return the w
     */
    public int getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * @return the cityFrame
     */
    public JFrame getCityFrame() {
        return cityFrame;
    }

    /**
     * @param cityFrame the cityFrame to set
     */
    public void setCityFrame(JFrame cityFrame) {
        this.cityFrame = cityFrame;
    }

    /**
     * @return the nazwaLabel
     */
    public JLabel getNazwaLabel() {
        return nazwaLabel;
    }

    /**
     * @param nazwaLabel the nazwaLabel to set
     */
    public void setNazwaLabel(JLabel nazwaLabel) {
        this.nazwaLabel = nazwaLabel;
    }

    /**
     * @return the liczbaMieszkańców
     */
    public int getLiczbaMieszkańców() {
        return liczbaMieszkańców;
    }

    /**
     * @param liczbaMieszkańców the liczbaMieszkańców to set
     */
    public void setLiczbaMieszkańców(int liczbaMieszkańców) {
        this.liczbaMieszkańców = liczbaMieszkańców;
    }
}

