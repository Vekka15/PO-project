/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superworld;

import javax.swing.*;
import javax.swing.JLabel;

/**
 *
 * @author Zuzanna Sawala
 */
public abstract class Polozenie {
    
private int x,y;
private JLabel imagelabel;


    void Rysuj(int picturex, int picturey, ImageIcon image, JLayeredPane panel, int w)
        {
            setImagelabel(new JLabel(image));
            getImagelabel().setBounds(picturex,picturey, image.getIconWidth(), image.getIconHeight());
            panel.add(getImagelabel(),w,0);
            panel.repaint();
        }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the imagelabel
     */
    public JLabel getImagelabel() {
        return imagelabel;
    }

    /**
     * @param imagelabel the imagelabel to set
     */
    public void setImagelabel(JLabel imagelabel) {
        this.imagelabel = imagelabel;
    }


   
}
