/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Zuzanna Sawala
 */
public class StopCywil extends JButton implements ActionListener{
    private final JFrame frame;
    private Cywil cywil;
    StopCywil(JFrame frame,Cywil cywil){
        super("Stop");
		this.frame = frame;
                this.cywil=cywil;
                setBounds(0,200,100,50);
		addActionListener(this);  
             //   numer=num;
    }
    public void actionPerformed(ActionEvent e) {              
        getCywil().setStop(1);
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
