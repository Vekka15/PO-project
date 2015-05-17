
package superworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import static superworld.Mapa.cywile;
import static superworld.Mapa.miasta;

/**
 *
 * @author Zuzanna Sawala
 */
public class TextField extends JTextField implements ActionListener{
    
    private final JFrame frame;
    private String input;
    private int i=0;
    private Cywil cywil;
    TextField(JFrame frame,Cywil cywil,JLabel label){
		this.frame = frame;
                this.cywil=cywil;
                setBounds(25,60,100,25);
		addActionListener(this);  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
            setInput(this.getText());
            while(!miasta.get(i).getNazwa().equals(input)){
                setI(getI() + 1);
            } 
            getCywil().setNastepnyCelX(miasta.get(getI()).getX());
            getCywil().setNastepnyCelY(miasta.get(getI()).getY());                     
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        this.input = input;
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
