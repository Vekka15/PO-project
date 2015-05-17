
package superworld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static superworld.SuperWorld.setKtoryPane;

/**
 *
 * @author Zuzanna Sawala
 */
public class Menu extends JLayeredPane implements ActionListener{
           private JLabel labelMenu;
           private JButton startButton;
           private JButton wynikiButton;
    	private static final int HEIGHT = 650;
	private static final int WIDTH = 1300;
        private JLabel tlo;
    Menu(){
        setLayout(null);
		setPreferredSize(new Dimension(getWIDTH(), getHEIGHT()));
         ImageIcon backImage = new ImageIcon("tloMenu.jpg");
         ImageIcon startImage = new ImageIcon("start.png");
         ImageIcon menuImage = new ImageIcon("menu.png");
         ImageIcon wynikiImage = new ImageIcon("wyniki.png");
            tlo = new JLabel(backImage);
            tlo.setBounds(0,0, backImage.getIconWidth(), backImage.getIconHeight());
            add(tlo,0,0);
           labelMenu = new JLabel(menuImage);
            labelMenu.setBounds(450,50, menuImage.getIconWidth(),menuImage.getIconHeight());
            add(labelMenu,1,0);
        startButton = new JButton(startImage);
        startButton.addActionListener( new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
       setKtoryPane(1);
    }
    });
        startButton.setBorderPainted(false); 
        startButton.setContentAreaFilled(false); 
        startButton.setFocusPainted(false); 
        startButton.setOpaque(false);
        startButton.setBounds(480,300, startImage.getIconWidth(),startImage.getIconHeight());
            add(startButton,1,0);
             wynikiButton = new JButton(wynikiImage);
             wynikiButton.addActionListener( new ActionListener(){
                 
    public void actionPerformed(ActionEvent e)
    {
        try { 
            String[] commands = {"cmd", "/c", "start", "iexplore.exe","-nohome", "C:\\Users\\Zuzanna Sawala\\Dropbox\\SuperWorld1\\SuperWorld1\\plik.xml"};
    Runtime.getRuntime().exec(commands);
            } catch (Exception ae) { 	
        ae.printStackTrace(); 
        } 
    }
    });
   
              wynikiButton.setBorderPainted(false); 
        wynikiButton.setContentAreaFilled(false); 
        wynikiButton.setFocusPainted(false); 
        wynikiButton.setOpaque(false);
        wynikiButton.setBounds(475,400, startImage.getIconWidth(),startImage.getIconHeight());
             add(wynikiButton,1,0);
    }
    
    public void actionPerformed(ActionEvent e) {
    
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;       
    }

    /**
     * @return the HEIGHT
     */
    public static int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * @return the WIDTH
     */
    public static int getWIDTH() {
        return WIDTH;
    }

    /**
     * @return the tlo
     */
    public JLabel getTlo() {
        return tlo;
    }

    /**
     * @param tlo the tlo to set
     */
    public void setTlo(JLabel tlo) {
        this.tlo = tlo;
    }
    
}
