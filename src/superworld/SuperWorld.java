

package superworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static superworld.Mapa.zniszczoneMiasta;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import javax.swing.Timer;
import java.io.*;
import java.awt.*;
import java.util.Collections;
import java.util.Random;
import java.util.TimerTask;
import static superworld.ZloczyncaDodawanie.getZmiana;
import static superworld.ZloczyncaDodawanie.setZmiana;

/**
 *
 * @author Zuzanna Sawala
 */
public class SuperWorld extends TimerTask{
   static private Random rand = new Random();
  static private ZloczyncaDodawanie zd = null;
static private int ktoryPane=0;
static private  int INTERVAL;
static private Timer timerGlowny;
static private int zaczac;
    static String linia;
    static private Timer timer ;
    static private int x;
    private static long tStart;
    private static int trzecipane=1;
   private static String imie;
   private static String wynik;
   private static int u=0;
   private static int y;

     @Override
    public void run() {
         
    }
    public static void main(String[] args) throws IOException {
       ArrayList<Wynik> wyniki = new ArrayList<Wynik>();
     ArrayList<Wynik> wyniki5ros = new ArrayList<Wynik>();
      ArrayList<Wynik> wyniki5male = new ArrayList<Wynik>();
   FileOutputStream fout = new FileOutputStream("plik.xml") ;
    FileReader fr = new FileReader("wyniki.txt");
    BufferedReader bfr = new BufferedReader(fr);
    
    // zczytywanie z pliku z wynikami 
   
     while((linia = bfr.readLine()) != null){
         if((getU()==0)||((getU()%2)==0)){
                setImie(linia);
     }
         if((getU()%2)==1){
            
                setWynik(linia);
         wyniki.add(new Wynik(getWynik(), getImie()));  
     }
            setU(getU() + 1); 
     }
      try {
                         fr.close();
                         } catch (IOException e) {
                         System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
                         System.exit(3);
                            }
    
        Collections.sort(wyniki);
     
     // zapisywanie do xmla wyniki ktore uzyskalismy z poprzednich symulacji(jezeli jakies sa)   
        
       XStream xstream = new XStream(new DomDriver("Unicode"));
       if(wyniki.size()>5){
            setX(0);
           while(getX()<5){
               wyniki5ros.add(new Wynik(wyniki.get(getX()).getWynik(),wyniki.get(getX()).getImie()));
                setX(getX() + 1);
           }
           for(setY(4);getY()>=0;setY(getY() - 1)){
              wyniki5male.add(wyniki5ros.get(getY()));
           }
           xstream.toXML(wyniki5male,fout); 
       }else{
           for(setY(wyniki.size()-1);getY()>=0;setY(getY() - 1)){
              wyniki5male.add(wyniki.get(getY()));
           }
           xstream.toXML(wyniki5male,fout);
       }
        
      FileWriter fw = new FileWriter("wyniki.txt",true);
      BufferedWriter bw = new BufferedWriter(fw);
      
      // frame
        JFrame frame= new JFrame();           
       frame.setSize(1300,650);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel mainPanel=new JPanel();
      CardLayout  card=new CardLayout();
     JLayeredPane  menu = new Menu();
     JLayeredPane  panel = new Mapa();
     frame.add(mainPanel);
    mainPanel.setLayout(card);
    mainPanel.add(menu, "one"); // id one refers panelOne
    mainPanel.add(panel, "two");
   card.show(mainPanel,"one")  ; 
        
       
                settStart(System.currentTimeMillis());
          
       // liczenie czasu, ostateczna serializacja do xmla, zamykanie programu itp itd   
          
        setINTERVAL(1);
        
        setTimerGlowny(new Timer(getINTERVAL(), new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (getZaczac() == 1) {
                    Random rand = new Random();
                    Integer next = rand.nextInt(20000) + 10000;
                    setZd(new ZloczyncaDodawanie(next,panel));
                    setZaczac(0);
                    getTimerGlowny().stop();
                }
            }
        }));
           int INTERVAL1 = 1;
                Timer    timer2 = new Timer(INTERVAL1, new ActionListener() {
                public void actionPerformed(ActionEvent evt) { 
                    if(getKtoryPane()==1){
                   card.show(mainPanel, "two");
                                    setZaczac(1);
                                    setKtoryPane(0);
                    }
                    
                    // dodwanie zloczyncow co losowy odstep czasu
                    
                    if(getZmiana()==1){
                       setZd(null);
                         Integer next = getRand().nextInt(20000) + 10000;
                        setZd(new ZloczyncaDodawanie(next,panel));
                  }
                    setZmiana(0);
                     
                    if(zniszczoneMiasta.size()==10){
                        long tEnd = System.currentTimeMillis();
                        long tDelta = tEnd - gettStart();
                        double elapsedSeconds = tDelta / 1000.0;
                        String wyn = Double.toString(elapsedSeconds);                    
                       if(getTrzecipane()==1){  
                           JFrame podajImie = new JFrame();
                           podajImie.setVisible(true);
                           podajImie.setSize(400,200);
                           podajImie.setVisible(true);
                           podajImie.setLayout(null);
                           JLabel naglowek = new JLabel("To już jest koniec. Podaj swoje imię:");
                           naglowek.setBounds(25,50, 300, 25);
                            podajImie.add(naglowek,0,0);
                         JTextField   imieUzytkownika = new JTextField();
                          imieUzytkownika.setBounds(50,100, 100, 25);
            podajImie.add(imieUzytkownika,0,0);
           imieUzytkownika.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){
                 String input = imieUzytkownika.getText();
                    wyniki.add(new Wynik(wyn,input));
                     int rozm = wyniki.size();
                         try {
                              bw.write(wyniki.get(rozm-1).getImie());
                             bw.newLine();
                             bw.write(wyniki.get(rozm-1).getWynik());
                             bw.newLine();
                             
                         } catch (IOException e) {
                         e.printStackTrace();
                        }
                          try {
                            bw.close();
                         } catch (IOException e) {
                         System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
                         System.exit(3);
                            }                        
                          String puste = "";
                           try {
                          fout.write(puste.getBytes());
                           } catch (IOException e) {
                         e.printStackTrace();
                        }
                             if(wyniki.size()>5){
                                setX(0);
                            Collections.sort(wyniki);
                             while(getX()<5){
                                 wyniki5ros.add(new Wynik(wyniki.get(getX()).getWynik(),wyniki.get(getX()).getImie()));
                                    setX(getX() + 1);
                            }
                        for(        setY(4);getY()>=0;setY(getY() - 1)){
                     wyniki5male.add(wyniki5ros.get(getY()));
                        }
                            xstream.toXML(wyniki5male,fout); 
                        }else{
                                 for(int y=wyniki.size()-1;y>=0;y--){
                         wyniki5male.add(wyniki.get(y));
                        }
                        xstream.toXML(wyniki5male,fout);
                        }
                    frame.dispose();
                        System.exit(0);
                    
            }
            });
                           setTrzecipane(0);

                        }
                    }
                }
                });
        getTimerGlowny().start();        
       timer2.start();
          frame.pack();
      frame.setVisible(true);
       frame.setLayout(null);
       frame.setResizable(true);
     
    }

    /**
     * @return the rand
     */
    public static Random getRand() {
        return rand;
    }

    /**
     * @param aRand the rand to set
     */
    public static void setRand(Random aRand) {
        rand = aRand;
    }

    /**
     * @return the zd
     */
    public static ZloczyncaDodawanie getZd() {
        return zd;
    }

    /**
     * @param aZd the zd to set
     */
    public static void setZd(ZloczyncaDodawanie aZd) {
        zd = aZd;
    }

    /**
     * @return the ktoryPane
     */
    public static int getKtoryPane() {
        return ktoryPane;
    }

    /**
     * @param aKtoryPane the ktoryPane to set
     */
    public static void setKtoryPane(int aKtoryPane) {
        ktoryPane = aKtoryPane;
    }

    /**
     * @return the INTERVAL
     */
    public static int getINTERVAL() {
        return INTERVAL;
    }

    /**
     * @param aINTERVAL the INTERVAL to set
     */
    public static void setINTERVAL(int aINTERVAL) {
        INTERVAL = aINTERVAL;
    }

    /**
     * @return the timerGlowny
     */
    public static Timer getTimerGlowny() {
        return timerGlowny;
    }

    /**
     * @param aTimerGlowny the timerGlowny to set
     */
    public static void setTimerGlowny(Timer aTimerGlowny) {
        timerGlowny = aTimerGlowny;
    }

    /**
     * @return the zaczac
     */
    public static int getZaczac() {
        return zaczac;
    }

    /**
     * @param aZaczac the zaczac to set
     */
    public static void setZaczac(int aZaczac) {
        zaczac = aZaczac;
    }

    /**
     * @return the linia
     */
    public static String getLinia() {
        return linia;
    }

    /**
     * @param aLinia the linia to set
     */
    public static void setLinia(String aLinia) {
        linia = aLinia;
    }

    /**
     * @return the timer
     */
    public static Timer getTimer() {
        return timer;
    }

    /**
     * @param aTimer the timer to set
     */
    public static void setTimer(Timer aTimer) {
        timer = aTimer;
    }

    /**
     * @return the x
     */
    public static int getX() {
        return x;
    }

    /**
     * @param aX the x to set
     */
    public static void setX(int aX) {
        x = aX;
    }

    /**
     * @return the tStart
     */
    public static long gettStart() {
        return tStart;
    }

    /**
     * @param atStart the tStart to set
     */
    public static void settStart(long atStart) {
        tStart = atStart;
    }

    /**
     * @return the trzecipane
     */
    public static int getTrzecipane() {
        return trzecipane;
    }

    /**
     * @param aTrzecipane the trzecipane to set
     */
    public static void setTrzecipane(int aTrzecipane) {
        trzecipane = aTrzecipane;
    }

    /**
     * @return the imie
     */
    public static String getImie() {
        return imie;
    }

    /**
     * @param aImie the imie to set
     */
    public static void setImie(String aImie) {
        imie = aImie;
    }

    /**
     * @return the wynik
     */
    public static String getWynik() {
        return wynik;
    }

    /**
     * @param aWynik the wynik to set
     */
    public static void setWynik(String aWynik) {
        wynik = aWynik;
    }

    /**
     * @return the u
     */
    public static int getU() {
        return u;
    }

    /**
     * @param aU the u to set
     */
    public static void setU(int aU) {
        u = aU;
    }
    
  
    /**
     * @return the y
     */
    public static int getY() {
        return y;
    }

    /**
     * @param aY the y to set
     */
    public static void setY(int aY) {
        y = aY;
    }
   
    
}
