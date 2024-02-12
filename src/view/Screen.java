package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame{
    public JPanel screenContaineur ;
    public Screen(String title, int largeur, int hauteur, PlateauView plateauView, FooterPanel footeur){
        this.setTitle(title);
        this.setSize(largeur, hauteur);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setLayout(new BorderLayout());
        
        this.setIconImage(new ImageIcon("icon.png").getImage());

        this.screenContaineur = (JPanel) this.getContentPane();
        this.screenContaineur.add(plateauView);
        this.screenContaineur.add(footeur,BorderLayout.NORTH);
        // this.setVisible(true);
        
    }
    
}
