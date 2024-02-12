package view;

import java.awt.Color;
//import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Cellule;
import model.observer.ModelListener;

public class CelluleView extends JButton implements ModelListener , ActionListener{
    private Cellule cellule;
    public CelluleView(Cellule cellule/*int x, int y,int longueur, int largeur*/){
        this.cellule = cellule;
        this.cellule.addModelListener(this);
//        setPreferredSize(new Dimension(10,10));
        this.setBackground(Color.WHITE);
        this.addActionListener(this);
    }
    @Override
    public void somethinHasChanged(Object source) {
        if(this.cellule.getEtat()){
            this.setBackground(Color.BLACK);
        }else{
            this.setBackground(Color.WHITE);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setEnabled(false);
        this.cellule.setEtat(true);
    }
    
}
