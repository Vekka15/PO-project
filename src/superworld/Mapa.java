
package superworld;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.*;
/**
 *
 * @author Zuzanna Sawala
 */
public class Mapa extends JLayeredPane {
        private int ii;
        private int kk;
        private int w;
        private int h;
        private int cc;
        private JLabel nazwa;
        private JLabel nazwa1;
        private JLabel tlo;
        private JLabel ulica;
        private JLabel ulica2;
        private JLabel ulica3;
        private JLabel ulica4;
        private JLabel ulicapion;
        private JLabel ulicapion2;
        private JLabel ulicapion3;
        private JLabel ulicapion4;
        private JLabel ulicapion5;
        private JLabel ulicapiondol;
        private JLabel ulicapiondol2;
        private JLabel ulicapiondol3;
        private JLabel ulicapiondol4;
        private JLabel ulicapiondol5;
        private JLabel ulicadozach;
        private JLabel ulicadowsch;
        static ArrayList<Integer> zniszczoneMiasta = new ArrayList<Integer>();
       static private int liczbaZniszczonychMiast=0;
        private int liczbaMiast=10;
        private static final int max_liczba_mocy=6;
          public static int getMax_Moc(){
        return getMax_liczba_mocy();
    }
	private static final int HEIGHT = 650;
	private static final int WIDTH = 1300;
        
     private static int stolica=3;
     static ArrayList<Bohater> bohaterowie = new ArrayList<Bohater>();
     static ArrayList<Skrzyzowanie> skrzyzowania = new ArrayList<Skrzyzowanie>();
      static CopyOnWriteArrayList<Cywil> cywile =new CopyOnWriteArrayList<Cywil>();
       static  ArrayList<Miasto> miasta = new ArrayList<Miasto>();
        static ArrayList<Zloczynca> zloczyncy = new ArrayList<Zloczynca>();
      static  String[] nazwy = new String[]{"Poznan","Gotham_City","Radom","Kalisz","Opole","New York","Warszawa","Empire_Bay","Sopot","Gdynia"};
   private JButton heroButton;
   private JButton cywilButton;
 
	public Mapa() {
            ImageIcon backimage = new ImageIcon("background.jpg");
            tlo = new JLabel(backimage);
            tlo.setBounds(0,0, backimage.getIconWidth(), backimage.getIconHeight());
            add(tlo,0,0);
            ImageIcon ulicaimage = new ImageIcon("ulica.png");
            ulica = new JLabel(ulicaimage);
            ulica.setBounds(230,334, ulicaimage.getIconWidth(), ulicaimage.getIconHeight());
            add(ulica,0,0);
            ulica2 = new JLabel(ulicaimage);
            ulica2.setBounds(480,334, ulicaimage.getIconWidth(), ulicaimage.getIconHeight());
            add(ulica2,0,0);
            ulica3 = new JLabel(ulicaimage);
            ulica3.setBounds(730,334, ulicaimage.getIconWidth(), ulicaimage.getIconHeight());
            add(ulica3,0,0);
            ulica4 = new JLabel(ulicaimage);
            ulica4.setBounds(980,334, ulicaimage.getIconWidth(), ulicaimage.getIconHeight());
            add(ulica4,0,0);
            ImageIcon ulicapionimage = new ImageIcon("ulicapionowa.png");
            ulicapion = new JLabel(ulicapionimage);
            ulicapion.setBounds(163,250, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapion,0,0);
            ulicapion2 = new JLabel(ulicapionimage);
            ulicapion2.setBounds(413,250, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapion2,0,0);
             ulicapion3 = new JLabel(ulicapionimage);
            ulicapion3.setBounds(663,250, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapion3,0,0);
             ulicapion4 = new JLabel(ulicapionimage);
            ulicapion4.setBounds(913,250, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapion4,0,0);
            ulicapion5 = new JLabel(ulicapionimage);
            ulicapion5.setBounds(1163,250, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapion5,0,0);
            ulicapiondol = new JLabel(ulicapionimage);
            ulicapiondol.setBounds(163,400, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapiondol,0,0);
            ulicapiondol2 = new JLabel(ulicapionimage);
            ulicapiondol2.setBounds(413,400, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapiondol2,0,0);
             ulicapiondol3 = new JLabel(ulicapionimage);
            ulicapiondol3.setBounds(663,400, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapiondol3,0,0);
             ulicapiondol4 = new JLabel(ulicapionimage);
            ulicapiondol4.setBounds(913,400, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapiondol4,0,0);
            ulicapiondol5 = new JLabel(ulicapionimage);
            ulicapiondol5.setBounds(1163,400, ulicapionimage.getIconWidth(), ulicapionimage.getIconHeight());
            add(ulicapiondol5,0,0);
            ImageIcon ulicazach = new ImageIcon("ulicadozachbrzeg.png");
            ulicadozach = new JLabel(ulicazach);
            ulicadozach.setBounds(0,333, ulicazach.getIconWidth(), ulicazach.getIconHeight());
            add(ulicadozach,0,0);
            ImageIcon ulicawsch = new ImageIcon("ulicadozachbrzeg.png");
            ulicadowsch = new JLabel(ulicazach);
            ulicadowsch.setBounds(1230,333, ulicawsch.getIconWidth(), ulicawsch.getIconHeight());
            add(ulicadowsch,0,0);
               heroButton = new BohaterButton(this);
               cywilButton = new CywilButton(this);
               nazwa = new JLabel();
               
		setLayout(null);
		setPreferredSize(new Dimension(getWIDTH(), getHEIGHT()));          
                 w=50;
                 h=50;
                   
               for(ii=0;ii<10;ii++)
                {
          
                    final int i=ii;
                    miasta.add( new Miasto() );                
                   miasta.get(i).setNazwa(nazwy[i]);
                   miasta.get(i).setNazwaLabel(new JLabel());
                    nazwa.setText("Nazwa: ");
                    nazwa.setBounds(10,10,100,20); 
                    miasta.get(i).getNazwaLabel().setText(miasta.get(i).getNazwa());
                    miasta.get(i).getNazwaLabel().setBounds(71,10,100,20);  
                    miasta.get(i).setLiczbaMieszkancowLabel(new JLabel("Liczba miesz.: " +miasta.get(i).getLiczbaMieszkańców()));
                        miasta.get(i).getLiczbaMieszkancowLabel().setBounds(10,40,200,20);
                        JLabel zrodlalabel=new JLabel("Zrodla miasta wraz z potencjalami:");
                         zrodlalabel.setBounds(10,70,200,20);
                    miasta.get(i).setX(w);
                    miasta.get(i).setY(h);  
                    miasta.get(i).Rysuj(miasta.get(i).getX(), miasta.get(i).getY(), miasta.get(i).getImage(), this,1);
                       miasta.get(i).getImagelabel().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {                                              
                        
                         miasta.get(i).setCityFrame(new JFrame());
                       miasta.get(i).getCityFrame().setLayout(null);
                        miasta.get(i).getCityFrame().setSize(300,300); 
                       miasta.get(i).getCityFrame().add(getNazwa());                       
                        miasta.get(i).getCityFrame().add(miasta.get(i).getLiczbaMieszkancowLabel());
                        miasta.get(i).getCityFrame().add(miasta.get(i).getNazwaLabel());
                         miasta.get(i).getCityFrame().add(zrodlalabel);
                        for(int k=0;k<miasta.get(i).getI();k++){
                      miasta.get(i).getCityFrame().add( miasta.get(i).zrodlaMiastaLabels.get(k));
                        }
                          miasta.get(i).getCityFrame().setVisible(true); 
                    }
                    });
                   
                    w=w+250;
                    if (w > WIDTH-200)
                    {
                        h=h+300;
                        w=50;
                    }
                   
                }
               
               for(cc=0;cc<5;cc++)
               {
                   final int c=cc;
                   skrzyzowania.add( new Skrzyzowanie() ); 
                   skrzyzowania.get(c).setX(miasta.get(c).getX()+80);
                   skrzyzowania.get(c).setY(300);
                   skrzyzowania.get(c).setPoziomyKoniecX(skrzyzowania.get(c).getX()+100);
                   skrzyzowania.get(c).setPoziomyStartX(skrzyzowania.get(c).getX());
                   skrzyzowania.get(c).setPionowyKoniecY(skrzyzowania.get(c).getY()+100);
                   skrzyzowania.get(c).setPionowyStartY(300);
                   skrzyzowania.get(c).Rysuj(skrzyzowania.get(c).getX(), skrzyzowania.get(c).getY(), skrzyzowania.get(c).getImage(), this,2);
               }
      
       }  

     
        
        
             
        @Override
      public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
           add(getHeroButton(),3,0); 
           add(getCywilButton(),3,0); 
        
    }   
      
      public void actionPerformed(ActionEvent e) {
                    
	}

    /**
     * @return the nazwa
     */
    public JLabel getNazwa() {
        return nazwa;
    }

    /**
     * @param nazwa the nazwa to set
     */
    public void setNazwa(JLabel nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * @return the nazwa1
     */
    public JLabel getNazwa1() {
        return nazwa1;
    }

    /**
     * @param nazwa1 the nazwa1 to set
     */
    public void setNazwa1(JLabel nazwa1) {
        this.nazwa1 = nazwa1;
    }

    /**
     * @return the tlo
     */
    public JLabel getTlo() {
        return tlo;
    }

    /**
     * @param tlo the tlo to set
     */
    public void setTlo(JLabel tlo) {
        this.tlo = tlo;
    }

    /**
     * @return the ulica
     */
    public JLabel getUlica() {
        return ulica;
    }

    /**
     * @param ulica the ulica to set
     */
    public void setUlica(JLabel ulica) {
        this.ulica = ulica;
    }

    /**
     * @return the ulica2
     */
    public JLabel getUlica2() {
        return ulica2;
    }

    /**
     * @param ulica2 the ulica2 to set
     */
    public void setUlica2(JLabel ulica2) {
        this.ulica2 = ulica2;
    }

    /**
     * @return the ulica3
     */
    public JLabel getUlica3() {
        return ulica3;
    }

    /**
     * @param ulica3 the ulica3 to set
     */
    public void setUlica3(JLabel ulica3) {
        this.ulica3 = ulica3;
    }

    /**
     * @return the ulica4
     */
    public JLabel getUlica4() {
        return ulica4;
    }

    /**
     * @param ulica4 the ulica4 to set
     */
    public void setUlica4(JLabel ulica4) {
        this.ulica4 = ulica4;
    }

    /**
     * @return the ulicapion
     */
    public JLabel getUlicapion() {
        return ulicapion;
    }

    /**
     * @param ulicapion the ulicapion to set
     */
    public void setUlicapion(JLabel ulicapion) {
        this.ulicapion = ulicapion;
    }

    /**
     * @return the ulicapion2
     */
    public JLabel getUlicapion2() {
        return ulicapion2;
    }

    /**
     * @param ulicapion2 the ulicapion2 to set
     */
    public void setUlicapion2(JLabel ulicapion2) {
        this.ulicapion2 = ulicapion2;
    }

    /**
     * @return the ulicapion3
     */
    public JLabel getUlicapion3() {
        return ulicapion3;
    }

    /**
     * @param ulicapion3 the ulicapion3 to set
     */
    public void setUlicapion3(JLabel ulicapion3) {
        this.ulicapion3 = ulicapion3;
    }

    /**
     * @return the ulicapion4
     */
    public JLabel getUlicapion4() {
        return ulicapion4;
    }

    /**
     * @param ulicapion4 the ulicapion4 to set
     */
    public void setUlicapion4(JLabel ulicapion4) {
        this.ulicapion4 = ulicapion4;
    }

    /**
     * @return the ulicapion5
     */
    public JLabel getUlicapion5() {
        return ulicapion5;
    }

    /**
     * @param ulicapion5 the ulicapion5 to set
     */
    public void setUlicapion5(JLabel ulicapion5) {
        this.ulicapion5 = ulicapion5;
    }

    /**
     * @return the ulicapiondol
     */
    public JLabel getUlicapiondol() {
        return ulicapiondol;
    }

    /**
     * @param ulicapiondol the ulicapiondol to set
     */
    public void setUlicapiondol(JLabel ulicapiondol) {
        this.ulicapiondol = ulicapiondol;
    }

    /**
     * @return the ulicapiondol2
     */
    public JLabel getUlicapiondol2() {
        return ulicapiondol2;
    }

    /**
     * @param ulicapiondol2 the ulicapiondol2 to set
     */
    public void setUlicapiondol2(JLabel ulicapiondol2) {
        this.ulicapiondol2 = ulicapiondol2;
    }

    /**
     * @return the ulicapiondol3
     */
    public JLabel getUlicapiondol3() {
        return ulicapiondol3;
    }

    /**
     * @param ulicapiondol3 the ulicapiondol3 to set
     */
    public void setUlicapiondol3(JLabel ulicapiondol3) {
        this.ulicapiondol3 = ulicapiondol3;
    }

    /**
     * @return the ulicapiondol4
     */
    public JLabel getUlicapiondol4() {
        return ulicapiondol4;
    }

    /**
     * @param ulicapiondol4 the ulicapiondol4 to set
     */
    public void setUlicapiondol4(JLabel ulicapiondol4) {
        this.ulicapiondol4 = ulicapiondol4;
    }

    /**
     * @return the ulicapiondol5
     */
    public JLabel getUlicapiondol5() {
        return ulicapiondol5;
    }

    /**
     * @param ulicapiondol5 the ulicapiondol5 to set
     */
    public void setUlicapiondol5(JLabel ulicapiondol5) {
        this.ulicapiondol5 = ulicapiondol5;
    }

    /**
     * @return the ulicadozach
     */
    public JLabel getUlicadozach() {
        return ulicadozach;
    }

    /**
     * @param ulicadozach the ulicadozach to set
     */
    public void setUlicadozach(JLabel ulicadozach) {
        this.ulicadozach = ulicadozach;
    }

    /**
     * @return the ulicadowsch
     */
    public JLabel getUlicadowsch() {
        return ulicadowsch;
    }

    /**
     * @param ulicadowsch the ulicadowsch to set
     */
    public void setUlicadowsch(JLabel ulicadowsch) {
        this.ulicadowsch = ulicadowsch;
    }

    /**
     * @return the liczbaMiast
     */
        @SuppressWarnings("InfiniteRecursion")
    public int getLiczbaMiast() {
        return getLiczbaMiast();
    }

    /**
     * @param liczbaMiast the liczbaMiast to set
     */
        @SuppressWarnings("InfiniteRecursion")
    public void setLiczbaMiast(int liczbaMiast) {
        this.setLiczbaMiast(liczbaMiast);
    }

    /**
     * @return the max_liczba_mocy
     */
    public static int getMax_liczba_mocy() {
        return max_liczba_mocy;
    }

    /**
     * @return the HEIGHT
     */
    public static int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * @return the WIDTH
     */
    public static int getWIDTH() {
        return WIDTH;
    }

    /**
     * @return the stolica
     */
    public static int getStolica() {
        return stolica;
    }

    /**
     * @param aStolica the stolica to set
     */
    public static void setStolica(int aStolica) {
        stolica = aStolica;
    }

    /**
     * @return the heroButton
     */
    public JButton getHeroButton() {
        return heroButton;
    }

    /**
     * @param heroButton the heroButton to set
     */
    public void setHeroButton(JButton heroButton) {
        this.heroButton = heroButton;
    }

    /**
     * @return the cywilButton
     */
    public JButton getCywilButton() {
        return cywilButton;
    }

    /**
     * @param cywilButton the cywilButton to set
     */
    public void setCywilButton(JButton cywilButton) {
        this.cywilButton = cywilButton;
    }

    /**
     * @return the ii
     */
    public int getIi() {
        return ii;
    }

    /**
     * @param ii the ii to set
     */
    public void setIi(int ii) {
        this.ii = ii;
    }

    /**
     * @return the kk
     */
    public int getKk() {
        return kk;
    }

    /**
     * @param kk the kk to set
     */
    public void setKk(int kk) {
        this.kk = kk;
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
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * @return the cc
     */
    public int getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(int cc) {
        this.cc = cc;
    }

    /**
     * @return the liczbaZniszczonychMiast
     */
    public static int getLiczbaZniszczonychMiast() {
        return liczbaZniszczonychMiast;
    }

    /**
     * @param aLiczbaZniszczonychMiast the liczbaZniszczonychMiast to set
     */
    public static void setLiczbaZniszczonychMiast(int aLiczbaZniszczonychMiast) {
        liczbaZniszczonychMiast = aLiczbaZniszczonychMiast;
    }


}
