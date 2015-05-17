
package superworld;

import javax.swing.*;
import java.awt.event.*;
import static superworld.Mapa.cywile;

/**
 *
 * @author Zuzanna Sawala
 */
class CywilButton extends JButton implements ActionListener {

       private JLayeredPane buttonPanel;
	CywilButton(JLayeredPane buttonPanel) {
		super("Dodaj cywila");
		this.buttonPanel = buttonPanel;
                setBounds(151,600,150,50);
		addActionListener(this);              
	}

	@Override
	public void actionPerformed(ActionEvent e) {            
            cywile.add(new Cywil(getButtonPanel()) );           
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