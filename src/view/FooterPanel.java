package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Plateau;

public class FooterPanel extends JPanel implements ActionListener{
    public JButton nextGeneration, clear,stop, auto; 
    private Plateau plateau ;
    private PlateauView plateauView ;
    boolean change = false;
    Timer timer;
    public FooterPanel(Plateau plateau,PlateauView plateauView) {
        this.plateau = plateau;
        this.plateauView = plateauView;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        this.setBackground(Color.darkGray);
        nextGeneration = new JButton("Next"); clear = new JButton("Clear"); auto = new JButton("Auto");
        stop = new JButton("Stop"); stop.addActionListener(this); stop.setEnabled(false);
        nextGeneration.addActionListener(this); clear.addActionListener(this); auto.addActionListener(this);
        this.add(auto); this.add(nextGeneration); this.add(clear); this.add(stop);
        timer = new Timer(700, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                change = plateau.nextGeneration();
                if (change == false) {
                    timer.stop();
                    nextGeneration.setEnabled(false); auto.setEnabled(false); clear.setEnabled(true); stop.setEnabled(false);
                    
                }
               
            }
            
        });
    }

    private void btnNextGeneration(){
        this.plateau.nextGeneration();
        this.plateauView.enableCellulesView(false);
    }

    private void btnAuto(){
        this.plateauView.enableCellulesView(false);
        nextGeneration.setEnabled(false); auto.setEnabled(false); clear.setEnabled(false); stop.setEnabled(true);
        timer.start();
    }

    private void btnClear(){
        this.plateau.reInitialisationDeLaGrille();
        this.plateauView.enableCellulesView(true);
        nextGeneration.setEnabled(true); auto.setEnabled(true); clear.setEnabled(true); stop.setEnabled(false);
    }

    private void btnStop(){
        timer.stop();
        nextGeneration.setEnabled(true); auto.setEnabled(true); clear.setEnabled(true); stop.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn == this.nextGeneration){
            this.btnNextGeneration();
        }
        else if(btn == this.auto){
            this.btnAuto();
        }
        else if(btn == this.stop){
            this.btnStop();
        }
        else{
            this.btnClear();
        }
    }
    
}
