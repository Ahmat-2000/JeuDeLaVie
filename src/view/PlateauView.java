package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;

import model.Cellule;
import model.Plateau;

/**
 * @author Ahmat Mahamat Ahmat
 * @version 1.0
 * Represents the visual component of the Plateau, displaying the grid of cells (Cellules) in the simulation.
 * This class extends JPanel and is responsible for creating and managing CelluleView components
 * based on the state of the Plateau model it represents.
 */
public class PlateauView extends JPanel {
    /**
     * The Plateau model this view is representing.
     */ 
    public Plateau plateau;

    /**
     * Constructs a PlateauView with a specified layout manager and a Plateau model.
     * Initializes the component, sets up its visual representation, and populates it with CelluleView components.
     *
     * @param layout The layout manager that dictates the layout of CelluleViews within this panel.
     * @param plateau The Plateau object that contains the grid of cells to be displayed.
     */
    public PlateauView(LayoutManager layout, Plateau plateau) {
        super(layout); 
        this.plateau = plateau; 
        this.addCelluleView(); 
        this.setBackground(Color.darkGray); 
    }

    /**
     * Enables or disables interaction with all CelluleView components within this PlateauView.
     * This can be used to prevent user interaction during certain states of the simulation.
     *
     * @param enable When true, all CelluleView components are enabled and interactive; when false, they are disabled.
     */
    public void enableCellulesView(boolean enable) {
        for (Component c : this.getComponents()) {
            c.setEnabled(enable); 
        }
    }

    /**
     * Populates the PlateauView with CelluleView components, each representing a cell (Cellule) in the Plateau's grid.
     * This method reads the current state of the Plateau model and creates a CelluleView for each cell in the grid.
     */
    private void addCelluleView() {
        Cellule[][] grille = this.plateau.getGrilleDeCellule(); 
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                CelluleView cel = new CelluleView(grille[i][j]); 
                this.add(cel); 
            }
        }
    }
}
