
package superworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static superworld.Mapa.cywile;

/**
 *
 * @author Zuzanna Sawala
 */
public class WznowCywil extends JButton implements ActionListener{
    private final JFrame frame;
    private int numer;
    private Cywil cywil;
    WznowCywil(JFrame frame,Cywil cywil){
        super("Wznow");
		this.frame = frame;
                this.cywil=cywil;
                setBounds(0,150,100,50);
		addActionListener(this);  
              //  numer=num;
    }
    public void actionPerformed(ActionEvent e) {             
         getCywil().setStop(0);         
    }

    /**
     * @return the numer
     */
    public int getNumer() {
        return numer;
    }

    /**
     * @param numer the numer to set
     */
    public void setNumer(int numer) {
        this.numer = numer;
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @return the cywil
     */
    public Cywil getCywil() {
        return cywil;
    }

    /**
     * @param cywil the cywil to set
     */
    public void setCywil(Cywil cywil) {
        this.cywil = cywil;
    }
}
