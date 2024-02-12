package model;


public class Plateau {
    Cellule [][] grilleDeCellule;
    private int ligne, colonne;
    public Plateau(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.grilleDeCellule = new Cellule[this.ligne][this.colonne];
        this.initialisationDeLaGrille();
    }

    private void initialisationDeLaGrille(){
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.grilleDeCellule[i][j] = new Cellule(i,j);
            }
        }
    }
    public void reInitialisationDeLaGrille(){
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.grilleDeCellule[i][j].setEtat(false);;
            }
        }
    }
    public void afficheGrille(){
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                System.out.print(this.grilleDeCellule[i][j].getEtat() + "  ");
            }
            System.out.println("\n");
        }

    }
    /**
     * C'est une méthode privée utiliser par la méthode nextGeneration
     * Elle compte le nombre des voisines vivantes d'une cellule et renvoie ce nombre
     * @param row la ligne
     * @param col la colonne
     * @return
     */
    private int countLivingNeighbors(Cellule[][] grille, int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    // C'est la cellule elle même
                    continue;
                }
                int r = row + i;
                int c = col + j;
                // vérifier qu'on deborde pas la grille pour éviter IndexOutOfBoundsException
                if (r >= 0 && r < this.ligne && c >= 0 && c < this.colonne) {
                    count += grille[r][c].getEtat() ? 1 : 0;
                }
            }
        }
        return count;
    }
    /**
     * Compte le nombre des cellules vivantes dans la grille et retourne ce nombre
     * @return 
     */
    public int countLivingCellule(Cellule[][] grille){
        int count = 0;
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                count += grille[i][j].getEtat() ? 1 : 0;
            }
        }
        return count;
    }
    private Cellule[][] cloneArray(){
        Cellule[][] tmp = new Cellule[this.ligne][this.colonne];
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                tmp[i][j] = new Cellule(this.grilleDeCellule[i][j]);
            }
        }
        return tmp;
    }
    /**
     * Calcule la génération suivante
     * @return
     */
    public boolean nextGeneration(){
        boolean change = false;
        Cellule[][] tmp = this.cloneArray();
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                int count = this.countLivingNeighbors(tmp,i, j);
                if (tmp[i][j].getEtat()) {
                    if (count != 2 && count != 3) {
                        this.grilleDeCellule[i][j].setEtat(false);
                        change = true;
                    }
                }
                else {
                    if( count == 3){
                        this.grilleDeCellule[i][j].setEtat(true);
                        change = true;
                    }
                }
            }
        }
        return change;
    }
    public Cellule [][] getGrilleDeCellule() {
        return this.grilleDeCellule;
    }

    public void setGrilleDeCellule(Cellule [][] grilleDeCellule) {
        this.grilleDeCellule = grilleDeCellule;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
}
