
package superworld;


import javax.swing.*;
import java.awt.event.*;
import static superworld.Mapa.bohaterowie;
/**
 *
 * @author Zuzanna Sawala
 */
class BohaterButton extends JButton implements ActionListener {
      
	private JLayeredPane buttonPanel;   
	BohaterButton(JLayeredPane buttonPanel) {
		super("Dodaj hero");
		this.buttonPanel = buttonPanel;
                setBounds(0,600,150,50);
		addActionListener(this);              
	}
        
	@Override
	public void actionPerformed(ActionEvent e) {            
                     
            bohaterowie.add(new Bohater(getButtonPanel()));
               getButtonPanel().setVisible(true);
                getButtonPanel().repaint();  
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

}