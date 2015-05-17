
package superworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static superworld.Mapa.cywile;


/**
 *
 * @author Zuzanna Sawala
 */
public class CywilUsunButton extends JButton implements ActionListener{
    
     private Cywil cywil;
    CywilUsunButton(Cywil cywil){
        super("Usun");
                this.cywil=cywil;
                setBounds(100,200,100,50);
		addActionListener(this); 
                
    }
    public void actionPerformed(ActionEvent e) {  
         if(getCywil().getZajeteSkrzyz()!=null){
            getCywil().getZajeteSkrzyz().setZajete(false);
            getCywil().setZajeteSkrzyz(null);
         }
        getCywil().getImagelabel().setIcon(null);
       cywile.remove(getCywil());
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
