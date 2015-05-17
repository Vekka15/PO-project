
package superworld;

/**
 *
 * @author Zuzanna Sawala
 */
public class ZrodloMocy {
    
    private int potencjal;
   private String typ;
 private int numermocy;
 
   ZrodloMocy(int numermocy){
       this.numermocy=numermocy;
       if(numermocy==1){          
           this.typ="Krypton";
       }
        if(numermocy==2){          
           this.typ="Latarnia Zielonej Latarni";
       }
         if(numermocy==3){          
           this.typ="Kamien potęgi";
       }
          if(numermocy==4){          
           this.typ="Health Potion";
       }
           if(numermocy==5){          
           this.typ="Speed Potion";
       }
           if(numermocy==6){          
           this.typ="Sweter Odporności";
       }
           this.potencjal=5;
       
   }
   
   void dajMoc(Zloczynca zly){
       if(this.getNumermocy()==1){
       zly.setInteligencja(zly.getInteligencja()+1);
       zly.getInteligencjaL().setText("Inteligencja: " +zly.getInteligencja());
       }
       if(this.getNumermocy()==2){
       zly.setSila(zly.getSila()+2);
      zly.getSilaL().setText("Sila: " +zly.getSila());
       }
       if(this.getNumermocy()==3){
       zly.setWytrzymalosc(zly.getWytrzymalosc()+1);
       zly.getWytrzymaloscL().setText("Wytrzymalosc: " +zly.getWytrzymalosc());
       }
       if(this.getNumermocy()==4){
       zly.setZycie(zly.getZycie()+1);
       zly.getZycieL().setText("Zycie:" +zly.getZycie());
       }
       if(this.getNumermocy()==5){
       zly.setSzybkosc(zly.getSzybkosc()+1);
       zly.getSzybkoscL().setText("Szybkosc: " +zly.getSzybkosc());
       }
       if(this.getNumermocy()==6){
       zly.setUmiejetnosciWalki(zly.getUmiejetnosciWalki()+1);
       zly.getUmiejetnosciWalkiL().setText("Umiejetnosci walki: " +zly.getUmiejetnosciWalki());
       }           
   }   
   
    /**
     * @return the potencjal
     */
    public int getPotencjal() {
        return potencjal;
    }

    /**
     * @param potencjal the potencjal to set
     */
    public void setPotencjal(int potencjal) {
        this.potencjal = potencjal;
    }

    /**
     * @return the typ
     */
    public String getTyp() {
        return typ;
    }

    /**
     * @param typ the typ to set
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * @return the numermocy
     */
    public int getNumermocy() {
        return numermocy;
    }

    /**
     * @param numermocy the numermocy to set
     */
    public void setNumermocy(int numermocy) {
        this.numermocy = numermocy;
    }
}
