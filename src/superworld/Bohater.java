
package superworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.*;
import static superworld.Mapa.miasta;
import static superworld.Mapa.getStolica;
import static superworld.Mapa.skrzyzowania;

/**
 *
 * @author Zuzanna Sawala
 */
public class Bohater extends SuperCzlowiek implements Runnable{

    private JFrame frame; 
     private JFrame superCzlowiekFrame;
    private final ImageIcon image = new ImageIcon("Obrazy bohaterowie\\flash.png");
    private ImageIcon image1 = new ImageIcon("Obrazy bohaterowie\\ironman.png");
    private ImageIcon image2 = new ImageIcon("Obrazy bohaterowie\\capitanAmerica.png");
    private ImageIcon image3 = new ImageIcon("Obrazy bohaterowie\\bat.png");
    private ImageIcon image4 = new ImageIcon("Obrazy bohaterowie\\spiderman.png");
    private ImageIcon image5 = new ImageIcon("Obrazy bohaterowie\\superma.png");
    private ImageIcon image6 = new ImageIcon("Obrazy bohaterowie\\greenlantern.png");
    private final ImageIcon[] images = new ImageIcon[]{image3,image4,image5,image,image1,image6,image2};
    private ImageIcon obrazek;
    private JLabel imieL;
    private JLabel silaL;
    private JLabel inteligencjaL;
    private JLabel wytrzymaloscL;
    private JLabel szybkoscL;
    private JLabel umiejetnosciWalkiL;
    private JLabel zycieL;
    private Boolean wygral=false;
     private Skrzyzowanie zajeteSkrzyz;
    private int c;
    private int i;
    private int d;
    private int w;
    private JLayeredPane buttonPanel;
    private Thread watek;
    Bohater(JLayeredPane buttonPanel){
        this.buttonPanel = buttonPanel;
         String[] imiona = new String[]{"Batman","Spiderman","Superman","Flash","Iron Man","Green Lantern","Capitan America"};
        Random rand = new Random();
        c=rand.nextInt(7);
        obrazek = images[c];
        setImie(imiona[c]);
        setSila(rand.nextInt((100 - 10) + 1) + 10);
        setZycie(100);
        setWytrzymalosc(rand.nextInt((100 - 10) + 1) + 10);
        setSzybkosc(rand.nextInt((100 - 10) + 1) + 10);
        setUmiejetnosciWalki(rand.nextInt((100 - 10) + 1) + 10);
        setInteligencja(rand.nextInt((100 - 10) + 1) + 10);         
            this.setX(miasta.get(3).getX()+100);
            this.setY(miasta.get(3).getY()+198);
            this.Rysuj(this.getX(),this.getY(), this.getObrazek(), buttonPanel,2);
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
                      this.setSuperCzlowiekFrame(new JFrame());
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
                @Override
            public void mouseClicked(MouseEvent e) {                                                                                                                                                                                                        
                          this.getSuperCzlowiekFrame().setVisible(true); 
                    }

            private JFrame getSuperCzlowiekFrame() {
                return superCzlowiekFrame;
            }
                    });
        
              watek=new Thread(this);
              watek.start();
       
    }

private Random rand = new Random();
   
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run() {
           
        try {                               
            setI(0);
            setMiastowyjscX(miasta.get(getStolica()).getX());
            setMiastowyjscY(miasta.get(getStolica()).getY());
      for(  setD(0);getD()<14;setD(getD() + 1))
       {
           this.setY(this.getY()+2);
           this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                getButtonPanel().setVisible(true);
                getButtonPanel().repaint();
        Thread.sleep(20); 
       }
     
        while(true)
        {     
            // jezeli w przypadku wygranej w walce z zloczynca jego nastepnym celem jest stolica
            if( getWygral()==false){
                losujMiastoCel();
            }else{
             // jezeli nie bylo walki normalnie bohater losuje nowy cel
                setCelX(miasta.get(getStolica()).getX());
                setCelY(miasta.get(getStolica()).getY());
                    setWygral((Boolean) false);
            }
      
        
         while(((this.getX()!=getCelX()+96)&(this.getY()!=212))||((this.getX()!=getCelX()+96)&(this.getY()!=412))){            
             
         // jazda na skrzyżowaniach
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
 * Poruszanie się na pionowych drogach i zawracanie bez dodatków.
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
        Thread.sleep(20);
             }
             for(   setW(0);getW()<10;setW(getW() + 1)){
           this.setX(this.getX()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
       }
              for(  setW(0);getW()<32;setW(getW() + 1)){
       this.setY(this.getY()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20); 
              }
        }
          if(this.getY()>312){
               for( setW(0);getW()<11;setW(getW() + 1)){
                 this.setY(this.getY()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
             }
                for(setW(0);getW()<10;setW(getW() + 1)){
           this.setX(this.getX()+2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20);
       }
              for(  setW(0);getW()<25;setW(getW() + 1)){
                  
       this.setY(this.getY()-2);
        this.getImagelabel().setBounds(this.getX(),this.getY(),this.getImage().getIconWidth(),this.getImage().getIconHeight());
                        getButtonPanel().setVisible(true);
                        getButtonPanel().repaint();
        Thread.sleep(20); 
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
               for(setD(0);getD()<57;setD(getD() + 1))
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
               for(                 setD(0);getD()<40;setD(getD() + 1))
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
                 for(               setD(0);getD()<45;setD(getD() + 1))
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
     * @return the image
     */
    @Override
    public ImageIcon getImage() {
        return getObrazek();
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
     * @return the image1
     */
    public ImageIcon getImage1() {
        return image1;
    }

    /**
     * @param image1 the image1 to set
     */
    public void setImage1(ImageIcon image1) {
        this.image1 = image1;
    }

    /**
     * @return the image2
     */
    public ImageIcon getImage2() {
        return image2;
    }

    /**
     * @param image2 the image2 to set
     */
    public void setImage2(ImageIcon image2) {
        this.image2 = image2;
    }

    /**
     * @return the image3
     */
    public ImageIcon getImage3() {
        return image3;
    }

    /**
     * @param image3 the image3 to set
     */
    public void setImage3(ImageIcon image3) {
        this.image3 = image3;
    }

    /**
     * @return the image4
     */
    public ImageIcon getImage4() {
        return image4;
    }

    /**
     * @param image4 the image4 to set
     */
    public void setImage4(ImageIcon image4) {
        this.image4 = image4;
    }

    /**
     * @return the image5
     */
    public ImageIcon getImage5() {
        return image5;
    }

    /**
     * @param image5 the image5 to set
     */
    public void setImage5(ImageIcon image5) {
        this.image5 = image5;
    }

    /**
     * @return the image6
     */
    public ImageIcon getImage6() {
        return image6;
    }

    /**
     * @param image6 the image6 to set
     */
    public void setImage6(ImageIcon image6) {
        this.image6 = image6;
    }

    /**
     * @return the images
     */
    public ImageIcon[] getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(ImageIcon[] images) {
        this.setImages(images);
    }

    /**
     * @return the obrazek
     */
    public ImageIcon getObrazek() {
        return obrazek;
    }

    /**
     * @param obrazek the obrazek to set
     */
    public void setObrazek(ImageIcon obrazek) {
        this.obrazek = obrazek;
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
     * @return the wygral
     */
    public Boolean getWygral() {
        return wygral;
    }

    /**
     * @param wygral the wygral to set
     */
    public void setWygral(Boolean wygral) {
        this.wygral = wygral;
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

