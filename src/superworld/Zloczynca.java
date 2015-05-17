
package superworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.*;
import static superworld.Mapa.cywile;
import static superworld.Mapa.miasta;
import static superworld.Mapa.skrzyzowania;
import java.util.*;
import static superworld.Mapa.bohaterowie;
import static superworld.Mapa.zniszczoneMiasta;
import static superworld.Mapa.zloczyncy;

/**
 *
 * @author Zuzanna Sawala
 */
public class Zloczynca extends SuperCzlowiek implements Runnable{
 
   private JLabel imieL;
   private JLabel silaL;
   private JLabel inteligencjaL;
   private JLabel wytrzymaloscL;
   private JLabel szybkoscL;
   private JLabel umiejetnosciWalkiL;
   private JLabel zycieL;
      private int w;
      private int numerOdwiedzanegoMiasta;
      private int k;
      private JLayeredPane buttonPanel;
      private int numerTab;
      private int toDead=0;
      private Skrzyzowanie zajeteSkrzyz;
      private int i;
      private int d;
      private int numb;
      private int ciosZ;
      private int ciosB;
      private int z;
      private int num;
      private int c;
      private JFrame superCzlowiekFrame;
      private Thread watek;
     Zloczynca(JLayeredPane buttonPanel){
          setImage(new ImageIcon("villain.png"));
          this.buttonPanel = buttonPanel;
      //    this.numerZloczyncy=liczbaZloczyncow;
              String[] imiona = new String[]{"Joker","Two Face","Poison Ivy","Catwoman","Lex Luthor","Bane"};
        Random rand = new Random();
        c=rand.nextInt(6);
        setImie(imiona[c]);
        setSila(rand.nextInt((100 - 10) + 1) + 10);
        setZycie(100);
        setWytrzymalosc(rand.nextInt((100 - 10) + 1) + 10);
        setSzybkosc(rand.nextInt((100 - 10) + 1) + 10);
        setUmiejetnosciWalki(rand.nextInt((100 - 10) + 1) + 10);
        setInteligencja(rand.nextInt((100 - 10) + 1) + 10);
         //  zloczyncyThread.add(new Thread(this));   
            this.setX(0);
            this.setY(334);
            this.Rysuj(this.getX(),this.getY(), this.getImage(),buttonPanel,2);
            this.setImieL(new JLabel("Imie: " +this.getImie()));
            this.setSilaL(new JLabel("Sila: " +this.getSila()));
            this.setInteligencjaL(new JLabel("Inteligencja: " +this.getInteligencja()));
            this.setWytrzymaloscL(new JLabel("Wytrzymalosc: " +this.getWytrzymalosc()));
            this.setZycieL(new JLabel("Zycie:" +this.getZycie()));
            this.setUmiejetnosciWalkiL(new JLabel("Umiejetnosci walki: " +this.getUmiejetnosciWalki()));
            this.setSzybkoscL(new JLabel("Szybkosc: " +this.getSzybkosc()));
            this.getImieL().setBounds(10,10,200,20);
            this.getZycieL().setBounds(10, 30, 200, 20);
            this.getSilaL().setBounds(10,50,100,20);
            this.getWytrzymaloscL().setBounds(10,70,200,20);
            this.getInteligencjaL().setBounds(10,90,200,20);
            this.getUmiejetnosciWalkiL().setBounds(10,110,200,20);
            this.getSzybkoscL().setBounds(10,130,200,20);
             this.setSuperCzlowiekFrame(new JFrame());// = new JFrame();
                       this.getSuperCzlowiekFrame().setLayout(null);
                        this.getSuperCzlowiekFrame().setSize(300,300); 
                      this.getSuperCzlowiekFrame().add(this.getImieL());
                       this.getSuperCzlowiekFrame().add(this.getZycieL());
                       this.getSuperCzlowiekFrame().add(this.getSilaL());
                      this.getSuperCzlowiekFrame().add(this.getSzybkoscL());
                       this.getSuperCzlowiekFrame().add(this.getWytrzymaloscL());
                       this.getSuperCzlowiekFrame().add(this.getInteligencjaL());
                       this.getSuperCzlowiekFrame().add(this.getUmiejetnosciWalkiL());      
            
            this.getImagelabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {                                              
                                                                                                                                                                                      
                          this.getSuperCzlowiekFrame().setVisible(true); 
                    }

              private JFrame getSuperCzlowiekFrame() {
                 return superCzlowiekFrame;
              }
                    });
        watek= new Thread(this);
        watek.start();
            //    zloczyncyThread.get(liczbaZloWat).start(); 
                
    
    }
     
   @SuppressWarnings("SleepWhileInLoop")
   /**
    * Metoda run zawiera całe poruszanie się po mapie złoczyńcy w skład którego wchodzą: poruszanie się po skrzyżowaniach
    */
     public void run() {
           
        try {
         
                  
             Random rand = new Random();
            setI(0);
            setMiastowyjscX(0);
            setMiastowyjscY(334);
    
      

        while(true)
        {           
           if(  getMiastowyjscX()==0){
                    setCelX(miasta.get(0).getX());
                    setCelY(miasta.get(0).getY());
                             
           }else{
                losujMiastoCel();
           }
        
         while(((this.getX()!=getCelX()+96)&(this.getY()!=212))||((this.getX()!=getCelX()+96)&(this.getY()!=412))){  
                    
             zabijCywila();         
          
             walka();

             poruszanieSiePoSkrzyzowaniach();
      
             poruszanieSiePoProstej();
    
      if(((this.getX()==getCelX()+100)&(this.getY()==390))||((this.getX()==getCelX()+120)&(this.getY()==268))){
          break;
      }
         }

                setMiastowyjscX(getCelX());
                setMiastowyjscY(getCelY());

                zawracanie();
         
        } 
        }
         catch (InterruptedException e) {            
             Thread.currentThread().interrupt();
         
}
    }
     
     /**
      * Zawracanie obsługuje poruszanie się obiektów po pionowych drogach oraz zatrzymywanie się w mieście wraz z pochłanianiem mocy.
      * @throws InterruptedException 
      */
   @SuppressWarnings("SleepWhileInLoop")
   public  void zawracanie() throws InterruptedException{
          if(this.getY()<312){
             for(   setW(0);getW()<28;setW(getW() + 1)){
                 this.setY(this.getY()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
        zabijCywilaPionowo();
        walka();
             }
             //pochlanianie mocy
                   pochlanianieMocy();
              
             for(   setW(0);getW()<10;setW(getW() + 1)){
           this.setX(this.getX()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
        zabijCywilaPionowo();
        walka();
       }
              for(  setW(0);getW()<32;setW(getW() + 1)){
       this.setY(this.getY()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20); 
        zabijCywilaPionowo();
        walka();
              }
        }
          if(this.getY()>312){
               for( setW(0);getW()<11;setW(getW() + 1)){
                 this.setY(this.getY()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
        zabijCywilaPionowo();
        walka();
             }
               //pochlanianie mocy
                  pochlanianieMocy();
                  
                for(setW(0);getW()<10;setW(getW() + 1)){
           this.setX(this.getX()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
        zabijCywilaPionowo();
        walka();
       }
              for(  setW(0);getW()<25;setW(getW() + 1)){                
       this.setY(this.getY()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20); 
        zabijCywilaPionowo();
        walka();
              }
        }
     }
     
     /**
      * Realizuje kradzież potencjałów mocy przez złoczyńce oraz zabijanie wszystkich cywilów przebywających w tym momencie w mieście.
      * @throws InterruptedException 
      */
   public  void pochlanianieMocy() throws InterruptedException{
         setZ(sprawdzKtoreMiasto(getMiastowyjscX(), getMiastowyjscY()));
               if(miasta.get(getZ()).getZniszczone()==false){
               //tutaj bedzie pochlanianie mocy
                    setK(0);
              while((miasta.get(getLmiast()).getLiczbaMieszkańców()>0)||(getK()<miasta.get(getLmiast()).getLiczbaZrodel())){
                zabijCywilaPionowo();
               walka();
                   if(  getK()<miasta.get(getLmiast()).getLiczbaZrodel()){
                 while(miasta.get(getLmiast()).zrodlaMiasta.get(getK()).getPotencjal()>0){          
             this.zabierzMoc(   getK());
              
                 }
                   }
                   Thread.sleep(100);
                        setK(getK() + 1);
                 if((miasta.get(getLmiast()).getLiczbaMieszkańców()==0)&(miasta.get(getLmiast()).getLiczbaZrodel()==getK())){
                     miasta.get(getLmiast()).setZniszczone((Boolean) true);
                     zniszczoneMiasta.add(getLmiast());
                     break;
                 }
                     
         }
               }
     }
     
     /**
      * Walka zloczyńcy z bohaterem. Zaczyna ten, który ma większą szybkość, a następnie wymieniają sięciosami dopóki któryś polegnie.
      */
    public void walka(){
             setNumb(0);
       for( Iterator<Bohater> iterBohater = bohaterowie.iterator();iterBohater.hasNext();){
                   Bohater b = iterBohater.next();
                 if((b!=null)&(this.getX()<=b.getX()+30)&&(this.getX()>=b.getX())&&(((this.getY()>=312)&(this.getY()<=334)&(b.getY()>=312)&(b.getY()<=334))||(((this.getY()>334)||(b.getY()<312))&((b.getY()>334)||(b.getY()<312))&(this.getY()==b.getY())))&(this.getToDead()==0)){  
                     if(this.getSzybkosc()>b.getSzybkosc()){              
                         while((b.getZycie()>0)||(this.getZycie()>0)){
                            setCiosZ((this.getInteligencja()*this.getUmiejetnosciWalki())-b.getWytrzymalosc());
                            b.setZycie(b.getZycie() -getCiosZ());
                            if(b.getZycie()<=0){
                                   if(b.getZajeteSkrzyz()!=null){
                                    b.getZajeteSkrzyz().setZajete(false);
                                     }
                                    b.getImagelabel().setIcon(null);
                                    b.getWatek().interrupt();
                                 bohaterowie.remove(b);                             
                               break;
                            }
                            setCiosB((b.getInteligencja()*b.getUmiejetnosciWalki())-this.getWytrzymalosc());
                            this.setZycie(this.getZycie() -getCiosB());                            
                            if(this.getZycie()<=0){  
                                if(b.getZajeteSkrzyz()!=null){
                                    b.getZajeteSkrzyz().setZajete(false);
                                     }
                                        this.getImagelabel().setIcon(null); 
                                        this.getWatek().interrupt();
                                        zloczyncy.remove(this);                                                                       
                                       setToDead(1);
                                break;
                            }
                         }                       
                     
                 
                     }else{
                           System.out.println("cios");
                         while((b.getZycie()>0)||(this.getZycie()>0)){
                            setCiosB((b.getInteligencja()*b.getUmiejetnosciWalki())-this.getWytrzymalosc());
                            this.setZycie(this.getZycie() -getCiosB());
                             if(this.getZycie()<=0){                                             
                                       this.getImagelabel().setIcon(null);
                                       this.getWatek().interrupt();
                                        zloczyncy.remove(this);
                                        setToDead(1);
                                break;
                            }
                            setCiosZ((this.getInteligencja()*this.getUmiejetnosciWalki())-b.getWytrzymalosc());
                            b.setZycie(b.getZycie() -getCiosZ());
                            if(b.getZycie()<=0){
                                 if(b.getZajeteSkrzyz()!=null){
                                    b.getZajeteSkrzyz().setZajete(false);
                                     }
                                b.getImagelabel().setIcon(null);
                               b=null;
                               b.getWatek().interrupt();
                                  bohaterowie.remove(b);
                               break;
                            }
                           
                         }
                                            
                     }
                     break;      
                 }
                 setNumb(getNumb() + 1);
             }

     }
     
     /**
      * Zabija cywili na poziomych drogach.
      */
      public void zabijCywila(){
           setNum(0);
           
             for ( Iterator<Cywil> it = cywile.iterator();it.hasNext(); ) {
    Cywil c = it.next();
    if((c!=null)&(this!=null)){
   if((this.getX()>=c.getX())&(this.getX()<=c.getX()+30)&(this.getY()>=312)&(this.getY()<=334)&(c.getY()>=312)&(c.getY()<=334)){
        c.getImagelabel().setIcon(null);
        if(c.getZajeteSkrzyz()!=null){
        c.getZajeteSkrzyz().setZajete(false);
        c.setZajeteSkrzyz(null);
        }
        cywile.remove(c);              
          break;
    }
    }
            setNum(getNum() + 1);
}
    }
       
       /**
        * Zabija cywili na pionowych drogach.
        */
      public  void zabijCywilaPionowo(){
           setNum(0);
           
             for ( Iterator<Cywil> it = cywile.iterator();it.hasNext(); ) {
    Cywil c = it.next();
    if((c!=null)&(this!=null)){
   if((this.getX()>=c.getX())&(this.getX()<=c.getX())&((this.getY()>334)||(c.getY()<312))&((c.getY()>334)||(c.getY()<312))&(this.getY()==c.getY())){
       if(((miasta.get(c.getNumerMiasta()).getX()+100==this.getX())&(this.getY()==412))||((this.getY()==212)&(miasta.get(c.getNumerMiasta()).getX()+120==this.getX()))){
       miasta.get(c.getNumerMiasta()).setLiczbaMieszkańców(miasta.get(c.getNumerMiasta()).getLiczbaMieszkańców()-1);
       miasta.get(c.getNumerMiasta()).getLiczbaMieszkancowLabel().setText("Liczba miesz.: " +miasta.get(c.getNumerMiasta()).getLiczbaMieszkańców());
       }
        c.getImagelabel().setIcon(null);
         if(c.getZajeteSkrzyz()!=null){
        c.getZajeteSkrzyz().setZajete(false);
        c.setZajeteSkrzyz(null);
         }
        cywile.remove(c);                
          break;
    }
    }
            setNum(getNum() + 1);
}
    }
        
        /**
         * Zabiera potencjał źródłu mocy z miasta i daje złoczyńcy.
         * @param k 
         */
      public void zabierzMoc(int k){
           miasta.get(getLmiast()).zrodlaMiasta.get(k).dajMoc(this);
           miasta.get(getLmiast()).zrodlaMiasta.get(k).setPotencjal(miasta.get(getLmiast()).zrodlaMiasta.get(k).getPotencjal()-1);
           miasta.get(getLmiast()).zrodlaMiastaLabels.get(k).setText(miasta.get(getLmiast()).zrodlaMiasta.get(k).getTyp()+":    " +miasta.get(getLmiast()).zrodlaMiasta.get(k).getPotencjal());          
       }           
       
       /**
        * Jazda po skrzyżowaniach z obsługą każdego wariantu skręcania oraz z zsynchronizowanym zajmowaniem skrzyżowania tak aby inne obiakty nie miały do niego dostępu podczas wykorzystywania przez jeden obiekt.
        * @throws InterruptedException 
        */
   @SuppressWarnings("SleepWhileInLoop")
      public void poruszanieSiePoSkrzyzowaniach() throws InterruptedException{
         for(Skrzyzowanie s: skrzyzowania){
      
            if((((this.getY()+25)>=s.getPionowyStartY())&&((this.getY()+25)<=s.getPionowyKoniecY())&&((this.getX())>=s.getPoziomyStartX())&&((this.getX()<=s.getPoziomyKoniecX())))){
                
                zabijCywila();
                walka();
                
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
               for(                 setD(0);getD()<51;setD(getD() + 1))
       {
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                 for(               setD(0);getD()<18;setD(getD() + 1))
       {
           this.setX(this.getX()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                 for(               setD(0);getD()<41;setD(getD() + 1))
       {        
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<22;setD(getD() + 1))
       {
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<39;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<33;setD(getD() + 1))
       {
           this.setY(this.getY()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                for(                setD(0);getD()<28;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                 for(               setD(0);getD()<39;setD(getD() + 1))
       {        
           this.setX(this.getX()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
        Thread.sleep(20); 
       }
                 for(               setD(0);getD()<50;setD(getD() + 1))
       {        
           this.setX(this.getX()-2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                                        getButtonPanel().setVisible(true);
                                        getButtonPanel().repaint();
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
       
       
       //gettery i settery
       
        /**
     * @return the superCzlowiekFrame
     */
    public JFrame getSuperCzlowiekFrame() {
        return superCzlowiekFrame;
    }

    /**
     * @param superCzlowiekFrame the superCzlowiekFrame to set
     */
    public void setSuperCzlowiekFrame(JFrame superCzlowiekFrame) {
        this.superCzlowiekFrame = superCzlowiekFrame;
    }
    /**
     * @return the imieL
     */
    public JLabel getImieL() {
        return imieL;
    }

    /**
     * @param imieL the imieL to set
     */
    public void setImieL(JLabel imieL) {
        this.imieL = imieL;
    }

    /**
     * @return the silaL
     */
    public JLabel getSilaL() {
        return silaL;
    }

    /**
     * @param silaL the silaL to set
     */
    public void setSilaL(JLabel silaL) {
        this.silaL = silaL;
    }

    /**
     * @return the inteligencjaL
     */
    public JLabel getInteligencjaL() {
        return inteligencjaL;
    }

    /**
     * @param inteligencjaL the inteligencjaL to set
     */
    public void setInteligencjaL(JLabel inteligencjaL) {
        this.inteligencjaL = inteligencjaL;
    }

    /**
     * @return the wytrzymaloscL
     */
    public JLabel getWytrzymaloscL() {
        return wytrzymaloscL;
    }

    /**
     * @param wytrzymaloscL the wytrzymaloscL to set
     */
    public void setWytrzymaloscL(JLabel wytrzymaloscL) {
        this.wytrzymaloscL = wytrzymaloscL;
    }

    /**
     * @return the szybkoscL
     */
    public JLabel getSzybkoscL() {
        return szybkoscL;
    }

    /**
     * @param szybkoscL the szybkoscL to set
     */
    public void setSzybkoscL(JLabel szybkoscL) {
        this.szybkoscL = szybkoscL;
    }

    /**
     * @return the umiejetnosciWalkiL
     */
    public JLabel getUmiejetnosciWalkiL() {
        return umiejetnosciWalkiL;
    }

    /**
     * @param umiejetnosciWalkiL the umiejetnosciWalkiL to set
     */
    public void setUmiejetnosciWalkiL(JLabel umiejetnosciWalkiL) {
        this.umiejetnosciWalkiL = umiejetnosciWalkiL;
    }

    /**
     * @return the zycieL
     */
    public JLabel getZycieL() {
        return zycieL;
    }

    /**
     * @param zycieL the zycieL to set
     */
    public void setZycieL(JLabel zycieL) {
        this.zycieL = zycieL;
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
     * @return the numerOdwiedzanegoMiasta
     */
    public int getNumerOdwiedzanegoMiasta() {
        return numerOdwiedzanegoMiasta;
    }

    /**
     * @param numerOdwiedzanegoMiasta the numerOdwiedzanegoMiasta to set
     */
    public void setNumerOdwiedzanegoMiasta(int numerOdwiedzanegoMiasta) {
        this.numerOdwiedzanegoMiasta = numerOdwiedzanegoMiasta;
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
     * @return the buttonPanel
     */
    public JLayeredPane getButtonPanel() {
        return buttonPanel;
    }

    /**
     * @param buttonPanel the buttonPanel to set
     */
    public void setButtonPanel(JLayeredPane buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    /**
     * @return the numerTab
     */
    public int getNumerTab() {
        return numerTab;
    }

    /**
     * @param numerTab the numerTab to set
     */
    public void setNumerTab(int numerTab) {
        this.numerTab = numerTab;
    }

    /**
     * @return the toDead
     */
    public int getToDead() {
        return toDead;
    }

    /**
     * @param toDead the toDead to set
     */
    public void setToDead(int toDead) {
        this.toDead = toDead;
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
     * @return the numb
     */
    public int getNumb() {
        return numb;
    }

    /**
     * @param numb the numb to set
     */
    public void setNumb(int numb) {
        this.numb = numb;
    }

    /**
     * @return the ciosZ
     */
    public int getCiosZ() {
        return ciosZ;
    }

    /**
     * @param ciosZ the ciosZ to set
     */
    public void setCiosZ(int ciosZ) {
        this.ciosZ = ciosZ;
    }

    /**
     * @return the ciosB
     */
    public int getCiosB() {
        return ciosB;
    }

    /**
     * @param ciosB the ciosB to set
     */
    public void setCiosB(int ciosB) {
        this.ciosB = ciosB;
    }

    /**
     * @return the z
     */
    public int getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
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
