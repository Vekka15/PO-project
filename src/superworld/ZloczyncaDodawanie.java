/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import static superworld.Mapa.zloczyncy;

/**
 *
 * @author Zuzanna Sawala
 */
public class ZloczyncaDodawanie {
    private JLayeredPane panel;
    private static int zmiana;
    private static int bla;
     private Timer  timer;
     private int rozmiar;
    ZloczyncaDodawanie(int INTERVAL, JLayeredPane panel){
        this.panel=panel;     
       timer = new Timer(INTERVAL, new ActionListener() {
                public void actionPerformed(ActionEvent evt) { 
            zloczyncy.add(new Zloczynca(panel));
                setZmiana(1);
                 getTimer().stop();

    }    
        });
       
       timer.start();
        
    }

    /**
     * @return the panel
     */
    public JLayeredPane getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JLayeredPane panel) {
        this.panel = panel;
    }

    /**
     * @return the zmiana
     */
    public static int getZmiana() {
        return zmiana;
    }

    /**
     * @param aZmiana the zmiana to set
     */
    public static void setZmiana(int aZmiana) {
        zmiana = aZmiana;
    }

    /**
     * @return the bla
     */
    public static int getBla() {
        return bla;
    }

    /**
     * @param aBla the bla to set
     */
    public static void setBla(int aBla) {
        bla = aBla;
    }

    /**
     * @return the timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    /**
     * @return the rozmiar
     */
    public int getRozmiar() {
        return rozmiar;
    }

    /**
     * @param rozmiar the rozmiar to set
     */
    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }
}
