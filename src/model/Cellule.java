package model;

import model.observer.AbstractListenableModel;

/**
 * Represents a cell in a grid-based simulation. This cell can either be active or inactive,
 * indicated by its state. It extends AbstractListenableModel to notify observers when its state changes.
 */
public class Cellule extends AbstractListenableModel {
    // The state of the cell, where true indicates active or "alive" and false indicates inactive or "dead".
    private boolean etat = false;
    
    // The x and y coordinates of the cell in the grid.
    private int x, y;

    /**
     * Constructs a Cellule with specified coordinates.
     *
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     */
    public Cellule(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a Cellule by copying another cell's coordinates and state.
     *
     * @param c The cell to copy from.
     */
    public Cellule(Cellule c) {
        this(c.getX(), c.getY());
        this.etat = c.getEtat();
    }

    /**
     * Returns the state of the cell.
     *
     * @return true if the cell is active, false otherwise.
     */
    public boolean getEtat() {
        return this.etat;
    }

    /**
     * Sets the state of the cell and notifies observers of the change.
     *
     * @param etat The new state of the cell.
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
        this.fireChange(); // Notify observers of the change.
    }

    /**
     * Returns the x-coordinate of the cell.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the cell.
     *
     * @param x The new x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of the cell.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the cell.
     *
     * @param y The new y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }
}
