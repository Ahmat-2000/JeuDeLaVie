package model;

/**
 * Represents the grid or board for a cellular automaton simulation, such as Conway's Game of Life.
 * This class manages a grid of cells, each of which can be in an active (alive) or inactive (dead) state.
 * It provides functionality to initialize the grid, reset it, calculate the next generation of cells based
 * on specific rules, and access the state of individual cells.
 */
public class Plateau {
    // A 2D array of Cellule objects representing the grid.
    Cellule[][] grilleDeCellule;
    // Dimensions of the grid.
    private int ligne, colonne;

    /**
     * Constructs a Plateau with the specified number of rows and columns.
     * Initializes the grid with Cellule objects.
     * 
     * @param ligne The number of rows in the grid.
     * @param colonne The number of columns in the grid.
     */
    public Plateau(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.grilleDeCellule = new Cellule[this.ligne][this.colonne];
        this.initialisationDeLaGrille();
    }

    /**
     * Initializes the grid by creating a new Cellule for each position.
     */
    private void initialisationDeLaGrille() {
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.grilleDeCellule[i][j] = new Cellule(i, j);
            }
        }
    }

    /**
     * Resets the grid by setting the state of all cells to false (dead).
     */
    public void reInitialisationDeLaGrille() {
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.grilleDeCellule[i][j].setEtat(false);
            }
        }
    }

    /**
     * Prints the state of the grid to the console.
     */
    public void afficheGrille() {
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                System.out.print(this.grilleDeCellule[i][j].getEtat() + "  ");
            }
            System.out.println("\n");
        }
    }

    /**
     * Counts the number of living neighbors around a given cell.
     * 
     * @param grille The grid of cells.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The number of living neighbors.
     */
    private int countLivingNeighbors(Cellule[][] grille, int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the cell itself.
                int r = row + i;
                int c = col + j;
                // Check boundaries.
                if (r >= 0 && r < this.ligne && c >= 0 && c < this.colonne) {
                    count += grille[r][c].getEtat() ? 1 : 0;
                }
            }
        }
        return count;
    }

    /**
     * Counts the number of living cells in the grid.
     * 
     * @param grille The grid of cells.
     * @return The number of living cells.
     */
    public int countLivingCellule(Cellule[][] grille) {
        int count = 0;
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                count += grille[i][j].getEtat() ? 1 : 0;
            }
        }
        return count;
    }

    /**
     * Creates a deep clone of the grid.
     * 
     * @return A clone of the current grid.
     */
    private Cellule[][] cloneArray() {
        Cellule[][] tmp = new Cellule[this.ligne][this.colonne];
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                tmp[i][j] = new Cellule(this.grilleDeCellule[i][j]);
            }
        }
        return tmp;
    }

    /**
     * Calculates the next generation of the grid based on the current state.
     * 
     * @return true if any cell's state has changed, otherwise false.
     */
    public boolean nextGeneration() {
        boolean change = false;
        Cellule[][] tmp = this.cloneArray();
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                int count = this.countLivingNeighbors(tmp, i, j);
                if (tmp[i][j].getEtat()) {
                    // Apply rules for living cells.
                    if (count != 2 && count != 3) {
                        this.grilleDeCellule[i][j].setEtat(false);
                        change = true;
                    }
                } else {
                    // Apply rules for dead cells.
                    if (count == 3) {
                        this.grilleDeCellule[i][j].setEtat(true);
                        change = true;
                    }
                }
            }
        }
        return change;
    }

    /** 
     * Returns the number of columns in the grid.
     * @return The number of columns.
     */
    public int getColonne() {
        return colonne;
    }
    /** 
     * Returns the 2D array representing the grid of cells.
     * @return The grid of cells.
     */
    public Cellule[][] getGrilleDeCellule() {
        return this.grilleDeCellule;
    }

    /** 
     * Returns the number of rows in the grid.
     * @return The number of rows.
     */
    public int getLigne() {
        return ligne;
    }

    /** 
     * Sets the grid of cells.
     * @param grilleDeCellule The new grid of cells.
     */
    public void setGrilleDeCellule(Cellule[][] grilleDeCellule) {
        this.grilleDeCellule = grilleDeCellule;
    }
   
}
