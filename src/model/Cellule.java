package model;

import model.observer.AbstractListenableModel;

public class Cellule extends AbstractListenableModel{
    private boolean etat = false;
    private int x,y;

    public Cellule(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public Cellule(Cellule c){
        this(c.getX(), c.getY());
        this.etat = c.getEtat();
    }
    public boolean getEtat() {
        return this.etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
        // dispatcher le changement
        this.fireChange();
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
