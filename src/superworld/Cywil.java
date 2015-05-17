
package superworld;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.*;
import static superworld.Mapa.cywile;
import static superworld.Mapa.nazwy;
import static superworld.Mapa.getStolica;
import static superworld.Mapa.skrzyzowania;
import static superworld.Mapa.miasta;
import static superworld.Mapa.zniszczoneMiasta;

/**
 *
 * @author Zuzanna Sawala
 */
public class Cywil extends Człowiek implements Runnable{
    int usun =0;
    private String nazwisko;
    private String miastoRodzinne;
    private final ImageIcon image = new ImageIcon("cywil.png");
    private JLabel imielabel;
    private JLabel nazwiskolabel;
    private JLabel miastoRodzinneLabel;
    private JFrame cywilframe;
    private JFrame frame;
    private final JLayeredPane buttonPanel;
    private Random rand;
    private int numerMiasta;
   private int stop=0; 
    private int nastepnyCelX;
    private int nastepnyCelY;
    private int w;
    private int wynik;
    private int numerDoc;
    private Skrzyzowanie zajeteSkrzyz;
    private Boolean zmienioneMiasto=false;
    private int numerPoprzedniegoMiasta;
    private Boolean zawracanie=false;
    private int o;
    private int l;
    private int i;
    private int d;
    private int k;
     private      JButton usunButton;
     private JButton stopButton;
     private  JButton wznowButton;
     private   JButton zmienMiastoButton;
    private Thread watek;
    Cywil(JLayeredPane buttonPanel){
        this.buttonPanel = buttonPanel;
      //  numerCywila=numer;

      
        
       rand = new Random();  
       //szukanie miasta domowego tak zeby nie było zniszczone 
       numerMiasta=rand.nextInt(9) + 0;
                    setG(0);
                    if(zniszczoneMiasta.size()>0){
                     while(getG()<zniszczoneMiasta.size()){
                                if(numerMiasta==zniszczoneMiasta.get(getG())){
                                    wynik=0;
                                    break;
                                }
                              setG(getG()+1);
                            }
                            if(getG()==zniszczoneMiasta.size()){
                                wynik=1;
                            }
         if(  wynik==0){
             while(wynik==0){
                           numerMiasta=rand.nextInt(9) + 0;
                           
                            setG(0);
                            while(getG()<zniszczoneMiasta.size()){
                                if(numerMiasta==zniszczoneMiasta.get(getG())){
                                    wynik=0;
                                    break;
                                }
                              setG(getG()+1);
                            }
                            if(getG()==zniszczoneMiasta.size()){
                                wynik=1;
                                break;
                            }
           }
                   }
                    }
         
        String[] imiona = new String[]{"Jan","Sebastian","Pawel","Piotr","Karol"};
        String[] nazwiska = new String[]{"Kowalski","Nowak","Cebula","Targ","Kwaitkowski"};       
        setImie(imiona[rand.nextInt(5)]);
        setNazwisko(nazwiska[rand.nextInt(5)]);
        setMiastoRodzinne(nazwy[numerMiasta]);
        
                cywilframe=new JFrame();
        cywilframe.setLayout(null);
        cywilframe.setSize(300,300);
        if(miasta.get(this.getNumerMiasta()).getY()<300){
               
                   this.setX((miasta.get(this.getNumerMiasta()).getX())+100); 
                    this.setY((miasta.get(this.getNumerMiasta()).getY())+198); 
           }
           if(miasta.get(this.getNumerMiasta()).getY()>300){
               this.setX((miasta.get(this.getNumerMiasta()).getX())+120); 
                    this.setY((miasta.get(this.getNumerMiasta()).getY()+100)); 
           }
            this.setImielabel(new JLabel("Imie: " +this.getImie()));                
                    this.getImielabel().setBounds(10,10,200,20);  
                     this.setNazwiskolabel(new JLabel("Nazwisko: " +this.getNazwisko()));
                    this.getNazwiskolabel().setBounds(10,30,200,20);
                   this.setMiastoRodzinneLabel(new JLabel("Miasto rodzinne: " +this.getMiastoRodzinne()));
                    this.getMiastoRodzinneLabel().setBounds(10,50,200,20);
                    //Label - obrazek na mapie
                    //Mouse listener
                     this.getCywilframe().add(this.getImielabel());
                       this.getCywilframe().add(this.getNazwiskolabel());
                      this.getCywilframe().add(this.getMiastoRodzinneLabel()); 
                      this.setUsunButton(new CywilUsunButton(this));
                         this.getCywilframe().add(this.getUsunButton());
                         this.setStopButton(new StopCywil(this.getCywilframe(), this));
                         this.getCywilframe().add(this.getStopButton());
                          this.setWznowButton(new WznowCywil(this.getCywilframe(), this));
                         this.getCywilframe().add(this.getWznowButton());
                        this.setZmienMiastoButton(new ZmienMiastoCywil(this.getCywilframe(), this));
                         this.getCywilframe().add(this.getZmienMiastoButton());
                        this. getZmienMiastoButton().setBounds(100,150,100,50);
                        this.getCywilframe().add(this.getZmienMiastoButton());
                        this.Rysuj(this.getX(), this.getY(), this.getImage(), getButtonPanel(),2);
             this.getImagelabel().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {                                                                    
                        this.getCywilframe().setVisible(true);
                    }

            private JFrame getCywilframe() {
               return cywilframe;
            }
                    });  
             watek=new Thread(this);
             watek.start();
    }
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
           
        try {                             
            setI(0);
            setMiastowyjscX(miasta.get(this.getNumerMiasta()).getX());
            setMiastowyjscY(miasta.get(this.getNumerMiasta()).getY());
      if(   getMiastowyjscY()<300){
      for(      setD(0);getD()<14;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                    getButtonPanel().setVisible(true);
                    getButtonPanel().repaint();
        Thread.sleep(20); 
       }
      }
      if(   getMiastowyjscY()>300){
      for(      setD(0);getD()<44;setD(getD() + 1))
       {
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                    getButtonPanel().setVisible(true);
                    getButtonPanel().repaint();
        Thread.sleep(20); 
       }
      }
      
      //losowanie miasta docelowego i nastepnego docelowego po raz pierwszy
      
         losujMiastoCel(); 
            setNastepnyCelX(miasta.get(this.getNumerMiasta()).getX());
            setNastepnyCelY(miasta.get(this.getNumerMiasta()).getY());
      
        while(true)
        {                 
        // zatrzymywanie i wznawianie na przycisk
            
         while(((this.getX()!=getCelX()+96)&(this.getY()!=212))||((this.getX()!=getCelX()+96)&(this.getY()!=412))){
            
             zmienMiasto();
             
         //   stop();
             if(    this.getStop()==1){
                 while( this.getStop()==1){
                Thread.sleep(1);
                 }
             }  
             
             // zatrzymywanie sie w przypadku napotkania innego cywila
            
             zatrzymajSie();
      
             // jazda na skrzyżowaniach
            poruszanieSiePoSkrzyzowaniach();

            poruszanieSiePoProstej();
      
      if(((this.getX()==getCelX()+100)&(this.getY()==390))||((this.getX()==getCelX()+120)&(this.getY()==268))){
          break;
      }
         }  
     // ustalanie nowego miasta wyjsciowego, nowego celu i nowego nastepnego celu    
                setMiastowyjscX(getCelX());
                setMiastowyjscY(getCelY());
               setL(sprawdzKtoreMiasto(getMiastowyjscX(), getMiastowyjscY()));
       //jezeli miasto do ktorego cywil przybyl jest zniszczone
       if((miasta.get(getL()).getZniszczone()==true)&(getZawracanie()==false)){
           setCelX(getNastepnyCelX());
                setCelY(getNastepnyCelY());
                losujMiastoCel();
       }
       
       //jezeli jedzie zawrocic w bylym miescie rodzinnym i zmienil miasto rodzinne po dotarciu do miasta docelowego
       if((miasta.get(getL()).getZniszczone()==true)&(getZawracanie()==true)){
           setCelX(getNastepnyCelX());
                setCelY(getNastepnyCelY());
                setNastepnyCelX(miasta.get(this.getNumerMiasta()).getX());
                setNastepnyCelY(miasta.get(this.getNumerMiasta()).getY());
                    setZawracanie((Boolean) false);
       
       }
       
       //jak wszystko jest normalne itp
       if((miasta.get(getL()).getZniszczone()==false)&(getZawracanie()==false)){
           //jezeli miasto do ktorego przybyl cywil nie jest zniszczone
                setCelX(getNastepnyCelX());
                setCelY(getNastepnyCelY());
                //jezeli jest w swoim miescie domowym to
        if(((this.getX()>miasta.get(this.getNumerMiasta()).getX())&(this.getX()<miasta.get(this.getNumerMiasta()).getX()+200)&(((this.getY()>334)&(miasta.get(this.getNumerMiasta()).getY()>334))||((this.getY()<312)&(miasta.get(this.getNumerMiasta()).getY()<312))))){
                    setNastepnyCelX(miasta.get(this.getNumerMiasta()).getX());
                    setNastepnyCelY(miasta.get(this.getNumerMiasta()).getY());
            
        }else{
            //jezeli jest w innym miescie niz domowe ale nie jest zniszczone
   //losowanie nowego nastepnego miasta z pominięciem zniszczonych miast                               
                     losujMiastoNastepnyCel();
             }
                 
       } 
                    //zawracanie
                    zawracanie();
        } 
        }
         catch (InterruptedException e) {            
             Thread.currentThread().interrupt();
         
}
    }
    
    /**
     * Metoda jedynie po upłynięciu czasu odwiedzin zmniejsza w mieście rodzinnym w którym przebywał liczbe mieszkańców o jeden oraz zmienia Labele.
     */
  public  void wyjedzZMiasta(){
         if(((miasta.get(this.getNumerMiasta()).getX()+100==this.getX())&(this.getY() ==412))||((miasta.get(this.getNumerMiasta()).getX()+120==this.getX())&(this.getY() ==212))){
              miasta.get(this.getNumerMiasta()).setLiczbaMieszkańców(miasta.get(this.getNumerMiasta()).getLiczbaMieszkańców()-1);
                    miasta.get(this.getNumerMiasta()).getLiczbaMieszkancowLabel().setText("Liczba miesz.: " +miasta.get(this.getNumerMiasta()).getLiczbaMieszkańców());
        }
    }
   
    /**
     * Cywil jeżeli odwiedza jakieś miasto, które istnieje, bez względu czy jest jego rodzinnym czy nie pozostaje tam na jakiś wylosowany czas.
     * @throws InterruptedException 
     */
  public  void odwiedzMiasto() throws InterruptedException{
         setO(sprawdzKtoreMiasto(getMiastowyjscX(), getMiastowyjscY()));
        if(    miasta.get(getO()).getZniszczone()==false){
                 Integer next = getRand().nextInt(5000) + 1000;
                   Thread.sleep(next);
                  
        } 
    }
    
    /**
     * Jezeli okaże się, miasto w którym przebywa cywil jest ostatnim istniejącym zostaje tam do zakończenia symulacji.
     * @throws InterruptedException 
     */
   public void zostanWOstatnimMiescie() throws InterruptedException{
         setO(sprawdzKtoreMiasto(getMiastowyjscX(), getMiastowyjscY()));
         if((zniszczoneMiasta.size()==9)&(miasta.get(getO()).getZniszczone()==false)){
             while((zniszczoneMiasta.size()==9)&(miasta.get(getO()).getZniszczone()==false)){
                 Thread.sleep(1);
             }
         }
    }
    
    
    /**
     * Zmienia miasto w przypadku, gdy miasto rodzinne cywila zostało zniszczone.
     */
  public  void zmienMiasto(){
        if(miasta.get(this.getNumerMiasta()).getZniszczone()==true){
            // jezeli naszym ostatnim odwiedzonym miastem bylo miasto rodzinne 
             if((getMiastowyjscX()==miasta.get(this.getNumerMiasta()).getX())&(getMiastowyjscY()==miasta.get(this.getNumerMiasta()).getY())){
                 setZmienioneMiasto((Boolean) true);
                 setNumerPoprzedniegoMiasta(getNumerMiasta());
                 setNumerDoc(sprawdzKtoreMiasto(getCelX(), getCelY())); 
               if(miasta.get(getNumerDoc()).getZniszczone()==false){
                 setNumerMiasta(getNumerDoc());
                 setMiastoRodzinne(nazwy[getNumerMiasta()]);
                 this.getMiastoRodzinneLabel().setText("Miasto rodzinne: " +this.getMiastoRodzinne());
                 //losujemy nowe nastepne miasto
                    losujMiastoNastepnyCel();
                 }else{
                     setNumerDoc(sprawdzKtoreMiasto(getNastepnyCelX(), getNastepnyCelY()));
                     setNumerMiasta(getNumerDoc());
                 setMiastoRodzinne(nazwy[getNumerMiasta()]);
                 this.getMiastoRodzinneLabel().setText("Miasto rodzinne: " +this.getMiastoRodzinne());
                 }
                   
              // jezeli naszym ostatnim odwiedzonym miastem bylo miasto docelowe (zawraca przy poprzednim miescie rodzinnym i jedzie do jakiegos celu aby powrocic do miasta)  
            }else{
                 //jezeli miasto rodzinne zostalo zniszczone po odwiedzeniu miasta docelowego to cywil jedzie do bylego miasta rodzinnego zawrocic i nastepnie do nowego miasta docelowego
                 setNumerPoprzedniegoMiasta(getNumerMiasta());
                 setNumerDoc(sprawdzKtoreMiasto(getMiastowyjscX(), getMiastowyjscY()));
                 // jezeli miasto w ktorego wyszlismy nie jest zniszczone to po prostu staje sie ono naszym miastem rodzinnym, naszym celem staje sie stare miasto rodzinne(w celu zawrócenia), a naszym nastepnym celem zostaje jakies randomowe miasto
               if(miasta.get(getNumerDoc()).getZniszczone()==false){
                 setNumerMiasta(getNumerDoc());
                 setMiastoRodzinne(nazwy[getNumerMiasta()]);
                 this.getMiastoRodzinneLabel().setText("Miasto rodzinne: " +this.getMiastoRodzinne());
                    setCelX(miasta.get(getNumerPoprzedniegoMiasta()).getX());
                    setCelY(miasta.get(getNumerPoprzedniegoMiasta()).getY());
                    setZawracanie((Boolean) true);

                       losujMiastoNastepnyCel();
          }else{
                     //jezeli miasto ktore odwiedzilismy dopiero co jest zniszczone i nasze miasto rodzinne jest zniszczone to naszym miastem rodzinnym staje sie nasz nastepny cel ktory jeszcze istnieje
                    setNumerDoc(sprawdzKtoreMiasto(getCelX(), getCelY()));
                  setNumerMiasta(getNumerDoc());
                 setMiastoRodzinne(nazwy[getNumerMiasta()]);
                 this.getMiastoRodzinneLabel().setText("Miasto rodzinne: " +this.getMiastoRodzinne());
                 
                 losujMiastoNastepnyCel();
                  } 
             }                              
        }
    }
     
    
    /**
     * Metoda wykorzystywana do zatrzymywania i wznawiania poruszania się cywila. Przyciski, które są wykorzystywane w tym celu zmieniają jedynie zmienną która wpływa na trwanie lub przerwa pętli.
     * @throws InterruptedException 
     */
    @SuppressWarnings("SleepWhileInLoop")
 public  void stop() throws InterruptedException{
       if(    this.getStop()==1){
                 while( this.getStop()==1){
                Thread.sleep(1);
                 }
             }  
   }
   
   /**
    * Metoda sprawdzająca czy drogę zastąpił nam jakiś inny cywil i w przypadku napotkania takowego zatrzymanie się. Obiekt powinien stać w miejscu dopóki cywil przed nim nie odblokuje drogi.
    * @throws InterruptedException 
    */
    @SuppressWarnings("SleepWhileInLoop")
  public  void zatrzymajSie() throws InterruptedException{
         for(Cywil c: cywile){
                 if((this.getX()==c.getX())&(c.getY()!=212)&(c.getY()!=412)){
                     while((this.getY()==c.getY()+30)||(this.getY()+30==c.getY())){
                         Thread.sleep(1);
                     } 
                 }
                 if((this.getY()==312)&(c.getY()==312)){
                     while(c.getX()+30==this.getX()){
                         Thread.sleep(1);
                     }
                 }
                 if((this.getY()==334)&(c.getY()==334)){
                     while(c.getX()==this.getX()+30){
                         Thread.sleep(1);
                     }
                 }                           
         }
    }
   
    /**
     * Zwieksza potencjał wszystkich źródeł mocy miasta, które jest na górze, do którego przybył cywil.
     */
  public void zwiekszPotencjalMiastGornych(){
         if(miasta.get(this.getNumerMiasta()).getX()+120==this.getX()&(miasta.get(this.getNumerMiasta()).getY()+200>this.getY())){
                   miasta.get(this.getNumerMiasta()).setLiczbaMieszkańców(miasta.get(this.getNumerMiasta()).getLiczbaMieszkańców()+1);
                    miasta.get(this.getNumerMiasta()).getLiczbaMieszkancowLabel().setText("Liczba miesz.: " +miasta.get(this.getNumerMiasta()).getLiczbaMieszkańców());
                        setW(0);
                 while( getW()<miasta.get(this.getNumerMiasta()).zrodlaMiasta.size()){
                 miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).setPotencjal(miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).getPotencjal()+1);
                    miasta.get(this.getNumerMiasta()).zrodlaMiastaLabels.get(getW()).setText(miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).getTyp()+":    " + miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).getPotencjal());
                            setW(getW() + 1);
        }
        }
   }
   
   /**
    * Zwieksza potencjał wszystkich źródeł mocy miasta, które jest na dole, do którego przybył cywil.
    */
 public void zwiekszPotencjalMiastDolnych(){
        
         if(miasta.get(this.getNumerMiasta()).getX()+100==this.getX()&(miasta.get(this.getNumerMiasta()).getY()<this.getY())){ 
             miasta.get(this.getNumerMiasta()).setLiczbaMieszkańców(miasta.get(this.getNumerMiasta()).getLiczbaMieszkańców()+1);
                    miasta.get(this.getNumerMiasta()).getLiczbaMieszkancowLabel().setText("Liczba miesz.: " +miasta.get(this.getNumerMiasta()).getLiczbaMieszkańców());
                        setW(0);
                 while( getW()<miasta.get(this.getNumerMiasta()).zrodlaMiasta.size()){
                 miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).setPotencjal(miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).getPotencjal()+1);
                    miasta.get(this.getNumerMiasta()).zrodlaMiastaLabels.get(getW()).setText(miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).getTyp()+":    " + miasta.get(this.getNumerMiasta()).zrodlaMiasta.get(getW()).getPotencjal());
                            setW(getW() + 1);
        }
        }
    }
 
 /**
  * Losuje nastepny cel dla cywila, który osiągnie po dotarciu do obecnego celu. 
  * Metoda uwzględnia pomijanie miast, które zostały zniszczone oraz miasta domowego cywila.
  */
  public  void losujMiastoNastepnyCel(){
        setLmiast(getRand().nextInt(10));
                    setNastepnyCelX(miasta.get(getLmiast()).getX());
                    setNastepnyCelY(miasta.get(getLmiast()).getY());
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
         if(((       getNastepnyCelX()==miasta.get(this.getNumerMiasta()).getX())&(getNastepnyCelY()==miasta.get(this.getNumerMiasta()).getY()))||(getWynik()==0)){
             while(((    getNastepnyCelX()==miasta.get(this.getNumerMiasta()).getX())&(getNastepnyCelY()==miasta.get(this.getNumerMiasta()).getY()))||(getWynik()==0)){
                            setLmiast(getRand().nextInt(10));
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
                            setNastepnyCelX(miasta.get(getLmiast()).getX());
                            setNastepnyCelY(miasta.get(getLmiast()).getY());
           }
                   }
}
    
    
    
    /**
     * Metoda obsługuje poruszanie się pionowo oraz zawracanie przy mieście. Zawiera również metody zatrzymajSie() oraz stop() jako, że mogą zajść w trakcie wykonywania zawracania.
     * @throws InterruptedException 
     */
    @SuppressWarnings("SleepWhileInLoop")
   public void zawracanie() throws InterruptedException{
         if(this.getY()<312){
             for(   setW(0);getW()<28;setW(getW() + 1)){
                 this.setY(this.getY()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
                         zmienMiasto();
                        Thread.sleep(20);
                        zatrzymajSie();
                         stop();
             }
             
             //jezeli cywil trafia do miasta rodzinnego to zwieksza wartosc wszystkich potencjałów i mieszkańców miasta
             
      zwiekszPotencjalMiastGornych();
             
                
                //jezeli miasto w ktorym jestesmy jest jedynym ocalalym miastem to cywil zostaje tam dopoki nie umrze
                  zostanWOstatnimMiescie();  
            
        //jezeli dowiedzane miasto nie jest zniszczone to zostaje tam na dluzej
        
        odwiedzMiasto();
        
        //jeżeli wyjezdza z miasta domowego to liczba jego mieszkancow zmniejsza sie o 1
        
       wyjedzZMiasta();
        
             for(   setW(0);getW()<10;setW(getW() + 1)){
           this.setX(this.getX()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
         zmienMiasto();
         zatrzymajSie();
          stop();
       }
              for(  setW(0);getW()<32;setW(getW() + 1)){
       this.setY(this.getY()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20); 
         zmienMiasto();
         zatrzymajSie();
          stop();
              }
        }
          if(this.getY()>312){
               for( setW(0);getW()<11;setW(getW() + 1)){
                 this.setY(this.getY()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
         zmienMiasto();
         zatrzymajSie();
          stop();
             }
               
               //jezeli cywil trafia do miasta rodzinnego to zwieksza wartosc wszystkich potencjałów i mieszkańców miasta
               
              zwiekszPotencjalMiastDolnych();
               
               //jezeli miasto w ktorym jestesmy jest jedynym ocalalym miastem to cywil zostaje tam dopoki nie umrze
                 zostanWOstatnimMiescie();  
         
         //jezeli dowiedzane miasto nie jest zniszczone to zostaje tam na dluzej
                odwiedzMiasto();
        
         //jeżeli wyjezdza z miasta domowego to liczba jego mieszkancow zmniejsza sie o 1
                wyjedzZMiasta();
              
                for(setW(0);getW()<10;setW(getW() + 1)){
           this.setX(this.getX()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
         zmienMiasto();
         zatrzymajSie();
          stop();
       }
              for(  setW(0);getW()<25;setW(getW() + 1)){
       this.setY(this.getY()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20); 
         zmienMiasto();
         zatrzymajSie();
          stop();
              }
        }
    }
    
    /**
     * Poruszanie się po skrzyżowaniach z uwzglednieniem skrecania we wszystkich możliwych wariantach.
     * @throws InterruptedException 
     */
    @SuppressWarnings("SleepWhileInLoop")
   public void poruszanieSiePoSkrzyzowaniach() throws InterruptedException{
                for(Skrzyzowanie s: skrzyzowania){
      
            if((((this.getY()+25)>=s.getPionowyStartY())&&((this.getY()+25)<=s.getPionowyKoniecY())&&((this.getX())>=s.getPoziomyStartX())&&((this.getX()<=s.getPoziomyKoniecX())))){
                
                if(s.isZajete()==false){
                    
                    synchronized(s){
                s.setZajete(true);
                                    setZajeteSkrzyz(s);
                    }
                //jezda z dolu do gory
                if((            getMiastowyjscY()>getCelY())&(getMiastowyjscX()==getCelX())){
               for(                 setD(0);getD()<47;setD(getD() + 1))
       {          
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                         Thread.sleep(20); 
                                         
       }
                  synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                 break;
                }
                
                // jazda z gory na dol
               if((             getMiastowyjscY()<getCelY())&(getMiastowyjscX()==getCelX())){
               for(                 setD(0);getD()<57;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                      
        Thread.sleep(20); 
       }
                synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                 break;
                }
               
                // jechanie prosto z prawej na lewo
                 if((((s.getPoziomyKoniecX()>(getCelX()+180)))&(this.getX()-100!=getMiastowyjscX()))&(this.getY()==312)&(this.getX()>getCelX())){
               for(                 setD(0);getD()<51;setD(getD() + 1))
       {
           this.setX(this.getX()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                      
        Thread.sleep(20); 
       }
              synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                 break;
                }
                 
                 // jechanie prosto z lewej na prawo
                 if((((s.getPoziomyStartX()!=(getCelX()+80)))&(this.getX()-100!=getMiastowyjscX()))&(this.getY()==334)&&(this.getX()+25<getCelX())){
               for(                 setD(0);getD()<40;setD(getD() + 1))
       {
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                      
        Thread.sleep(20); 
        
       }
              synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  } 
                 break;
                }
                 
          // skrecanie w lewo od gory
                if(((this.getX()>getCelX()))&(this.getX()-100==getMiastowyjscX())&(this.getY()<330)){
                for(                setD(0);getD()<18;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                      
        Thread.sleep(20);        
       }
                 for(               setD(0);getD()<18;setD(getD() + 1))
       {
           this.setX(this.getX()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                       
        Thread.sleep(20); 
          
       }
                  synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  } 
                   break;
                }
                
                //skrecanie w prawo od gory
                if(((this.getX()<getCelX()))&(this.getX()-100==getMiastowyjscX())&(this.getY()<330)){
                for(                setD(0);getD()<29;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                   
        Thread.sleep(20);
       }
                 for(               setD(0);getD()<41;setD(getD() + 1))
       {        
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                      
        Thread.sleep(20); 
       }
                synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  } 
                   break;
                }
                
                 //skrecanie w gore od prawej
               if(((s.getPoziomyKoniecX()==(getCelX()+180)))&(this.getX()-100!=getMiastowyjscX())&(getCelY()<330)&(getCelX()<getMiastowyjscX())){
                    for(            setD(0);getD()<30;setD(getD() + 1))
       {          
           this.setX(this.getX()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                        
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<22;setD(getD() + 1))
       {
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                    
        Thread.sleep(20);
       }          
                synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  } 
                  break;
                }
               
               //skrecanie w dol od prawej
                 if(((s.getPoziomyKoniecX()==(getCelX()+180)))&(this.getX()-100!=getMiastowyjscX())&(getCelY()>330)&(getCelX()<getMiastowyjscX())){                      
                    for(            setD(0);getD()<40;setD(getD() + 1))
       {          
           this.setX(this.getX()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                      
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<39;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                   
        Thread.sleep(20); 
       }      
                 synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                  break;
                }
                 
               //skrecanie w gore od lewej
                 if(((s.getPoziomyStartX()==(getCelX()+80)))&(this.getX()-100!=getMiastowyjscX())&(getCelY()<330)&(getCelX()>getMiastowyjscX())){
                    for(            setD(0);getD()<20;setD(getD() + 1))
       {
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                 
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<33;setD(getD() + 1))
       {
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                     
        Thread.sleep(20);
       }     
                synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                  break;
                }
                 
                 //skrecanie w dol od lewej
                 if(((s.getPoziomyStartX()==(getCelX()+80)))&(this.getX()-100!=getMiastowyjscX())&(getCelY()>330)&(getCelX()>getMiastowyjscX())){
                    for(            setD(0);getD()<10;setD(getD() + 1))
       {
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                         zmienMiasto();
                                      
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<28;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                        zmienMiasto();
        Thread.sleep(20); 
       }      
                 synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                  break;
                }
                 
                 //skrecanie w prawo od dolu
                if(((this.getX()<getCelX()))&(this.getX()-120==getMiastowyjscX())&(this.getY()+25>330)){
                for(                setD(0);getD()<14;setD(getD() + 1))
       {
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                        zmienMiasto();
        Thread.sleep(20); 
       }
                 for(               setD(0);getD()<45;setD(getD() + 1))
       {        
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                        zmienMiasto();
        Thread.sleep(20); 
       }
                  synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                   break;
                }
                
                 //skrecanie w lewo od dolu
                if(((this.getX()>getCelX()))&(this.getX()-120==getMiastowyjscX())&(this.getY()+25>330)){
                for(                setD(0);getD()<25;setD(getD() + 1))
       {
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                        zmienMiasto();
        Thread.sleep(20); 
       }
                 for(               setD(0);getD()<50;setD(getD() + 1))
       {        
           this.setX(this.getX()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
                                        zmienMiasto();
        Thread.sleep(20);
       }
                synchronized(s){
                s.setZajete(false);
                                        setZajeteSkrzyz(null);
                  }
                   break;
                                   
                }
                                             
            }
        
       }
    }
    }
    // gettery i settery
    
     /**
     * @return the nazwisko
     */
    String getNazwisko(){
        return nazwisko;
    }
    
    /**
     * @param nazwisko the nazwisko to set
     */
    void setNazwisko(String nazwisko){
        this.nazwisko=nazwisko;
    }
    
    /**
     * @return the miastoRodzinne
     */
    String getMiastoRodzinne(){
        return miastoRodzinne;
    }
    
    /**
     * @param miastoRodzinne the miastoRodzinne to set
     */
    void setMiastoRodzinne(String miasto_rodzinne){
        this.miastoRodzinne=miasto_rodzinne;
    }

    /**
     * @return the image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * @return the imielabel
     */
    public JLabel getImielabel() {
        return imielabel;
    }

    /**
     * @param imielabel the imielabel to set
     */
    public void setImielabel(JLabel imielabel) {
        this.imielabel = imielabel;
    }

    /**
     * @return the nazwiskolabel
     */
    public JLabel getNazwiskolabel() {
        return nazwiskolabel;
    }

    /**
     * @param nazwiskolabel the nazwiskolabel to set
     */
    public void setNazwiskolabel(JLabel nazwiskolabel) {
        this.nazwiskolabel = nazwiskolabel;
    }

    /**
     * @return the miastoRodzinneLabel
     */
    public JLabel getMiastoRodzinneLabel() {
        return miastoRodzinneLabel;
    }

    /**
     * @param miastoRodzinneLabel the miastoRodzinneLabel to set
     */
    public void setMiastoRodzinneLabel(JLabel miastoRodzinneLabel) {
        this.miastoRodzinneLabel = miastoRodzinneLabel;
    }

    /**
     * @return the cywilframe
     */
    public JFrame getCywilframe() {
        return cywilframe;
    }

    /**
     * @param cywilframe the cywilframe to set
     */
    public void setCywilframe(JFrame cywilframe) {
        this.cywilframe = cywilframe;
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     * @return the buttonPanel
     */
    public JLayeredPane getButtonPanel() {
        return buttonPanel;
    }

    /**
     * @return the rand
     */
    public Random getRand() {
        return rand;
    }

    /**
     * @param rand the rand to set
     */
    public void setRand(Random rand) {
        this.rand = rand;
    }

    /**
     * @return the numerMiasta
     */
    public int getNumerMiasta() {
        return numerMiasta;
    }

    /**
     * @param numerMiasta the numerMiasta to set
     */
    public void setNumerMiasta(int numerMiasta) {
        this.numerMiasta = numerMiasta;
    }

    /**
     * @return the stop
     */
    public int getStop() {
        return stop;
    }

    /**
     * @param stop the stop to set
     */
    public void setStop(int stop) {
        this.stop = stop;
    }

    /**
     * @return the nastepnyCelX
     */
    public int getNastepnyCelX() {
        return nastepnyCelX;
    }

    /**
     * @param nastepnyCelX the nastepnyCelX to set
     */
    public void setNastepnyCelX(int nastepnyCelX) {
        this.nastepnyCelX = nastepnyCelX;
    }

    /**
     * @return the nastepnyCelY
     */
    public int getNastepnyCelY() {
        return nastepnyCelY;
    }

    /**
     * @param nastepnyCelY the nastepnyCelY to set
     */
    public void setNastepnyCelY(int nastepnyCelY) {
        this.nastepnyCelY = nastepnyCelY;
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
     * @return the numerDoc
     */
    public int getNumerDoc() {
        return numerDoc;
    }

    /**
     * @param numerDoc the numerDoc to set
     */
    public void setNumerDoc(int numerDoc) {
        this.numerDoc = numerDoc;
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
     * @return the zmienioneMiasto
     */
    public Boolean getZmienioneMiasto() {
        return zmienioneMiasto;
    }

    /**
     * @param zmienioneMiasto the zmienioneMiasto to set
     */
    public void setZmienioneMiasto(Boolean zmienioneMiasto) {
        this.zmienioneMiasto = zmienioneMiasto;
    }

    /**
     * @return the numerPoprzedniegoMiasta
     */
    public int getNumerPoprzedniegoMiasta() {
        return numerPoprzedniegoMiasta;
    }

    /**
     * @param numerPoprzedniegoMiasta the numerPoprzedniegoMiasta to set
     */
    public void setNumerPoprzedniegoMiasta(int numerPoprzedniegoMiasta) {
        this.numerPoprzedniegoMiasta = numerPoprzedniegoMiasta;
    }

    /**
     * @return the zawracanie
     */
    public Boolean getZawracanie() {
        return zawracanie;
    }

    /**
     * @param zawracanie the zawracanie to set
     */
    public void setZawracanie(Boolean zawracanie) {
        this.zawracanie = zawracanie;
    }

    /**
     * @return the o
     */
    public int getO() {
        return o;
    }

    /**
     * @param o the o to set
     */
    public void setO(int o) {
        this.o = o;
    }

    /**
     * @return the l
     */
    public int getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(int l) {
        this.l = l;
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

    /**
     * @return the usunButton
     */
    public JButton getUsunButton() {
        return usunButton;
    }

    /**
     * @param usunButton the usunButton to set
     */
    public void setUsunButton(JButton usunButton) {
        this.usunButton = usunButton;
    }

    /**
     * @return the stopButton
     */
    public JButton getStopButton() {
        return stopButton;
    }

    /**
     * @param stopButton the stopButton to set
     */
    public void setStopButton(JButton stopButton) {
        this.stopButton = stopButton;
    }

    /**
     * @return the wznowButton
     */
    public JButton getWznowButton() {
        return wznowButton;
    }

    /**
     * @param wznowButton the wznowButton to set
     */
    public void setWznowButton(JButton wznowButton) {
        this.wznowButton = wznowButton;
    }

    /**
     * @return the zmienMiastoButton
     */
    public JButton getZmienMiastoButton() {
        return zmienMiastoButton;
    }

    /**
     * @param zmienMiastoButton the zmienMiastoButton to set
     */
    public void setZmienMiastoButton(JButton zmienMiastoButton) {
        this.zmienMiastoButton = zmienMiastoButton;
    }

    /**
     * @return the watek
     */
    public Thread getWatek() {
        return watek;
    }

    /**
     * @param watek the watek to set
     */
    public void setWatek(Thread watek) {
        this.watek = watek;
    }
 

}
