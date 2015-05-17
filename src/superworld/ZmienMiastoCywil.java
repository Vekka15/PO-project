
package superworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Zuzanna Sawala
 */
public class ZmienMiastoCywil extends JButton implements ActionListener{
    
   private JPanel buttonPanel;
   private JFrame frame;
   private JFrame frame2;
   private int numer;
   private JTextField insertText;
   private JLabel label1;
   private JLabel label2;
   private Cywil cywil;
    ZmienMiastoCywil(JFrame frame,Cywil cywil){
                super("Zmien Miasto");
		this.frame = frame;
                this.cywil=cywil;
                setBounds(100,150,100,50);
		addActionListener(this);  
    }
    @Override
    public void actionPerformed(ActionEvent e) {             
                 setFrame2(new JFrame()); 
                 getFrame2().setLayout(null);
                 getFrame2().setSize(300,200);            
                 setLabel1(new JLabel("Wybierz następne miasto do odwiedzin:"));
                 getLabel1().setBounds(10,30,250,25);
                 getFrame2().add(getLabel1());
                  setLabel2(new JLabel("Aby zaakceptowadź wciśnij enter."));
                 getLabel2().setBounds(10,100,200,25);
                 getFrame2().add(getLabel2());   
                 setInsertText(new TextField(getFrame2(), getCywil(), getLabel2()));
                 getFrame2().add(getInsertText());               
                 
                 getFrame2().setVisible(true);
}

    /**
     * @return the buttonPanel
     */
    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    /**
     * @param buttonPanel the buttonPanel to set
     */
    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
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
     * @return the frame2
     */
    public JFrame getFrame2() {
        return frame2;
    }

    /**
     * @param frame2 the frame2 to set
     */
    public void setFrame2(JFrame frame2) {
        this.frame2 = frame2;
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
     * @return the insertText
     */
    public JTextField getInsertText() {
        return insertText;
    }

    /**
     * @param insertText the insertText to set
     */
    public void setInsertText(JTextField insertText) {
        this.insertText = insertText;
    }

    /**
     * @return the label1
     */
    public JLabel getLabel1() {
        return label1;
    }

    /**
     * @param label1 the label1 to set
     */
    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    /**
     * @return the label2
     */
    public JLabel getLabel2() {
        return label2;
    }

    /**
     * @param label2 the label2 to set
     */
    public void setLabel2(JLabel label2) {
        this.label2 = label2;
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
