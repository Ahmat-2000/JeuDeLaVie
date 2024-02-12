package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;

import model.Cellule;
import model.Plateau;

public class PlateauView extends JPanel{
    public Plateau plateau ;
    // public static final int LARGEUR = 10 ;
    // public static final int LONGUEUR = 10;
    public PlateauView(LayoutManager layout, Plateau plateau) {
        super(layout);
        this.plateau = plateau;
        this.addCelluleView();
        this.setBackground(Color.darkGray);
    }
    public void enableCellulesView(boolean enable){
        for (Component c :  this.getComponents()) {
            c.setEnabled(enable);
        }
    }
    private void addCelluleView(){
        Cellule [][] grille = this.plateau.getGrilleDeCellule();
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                CelluleView cel = new CelluleView(grille[i][j]);
                this.add(cel);
            }
        }
    }
}
