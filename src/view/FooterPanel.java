package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Plateau;

/**
 * @author Ahmat Mahamat Ahmat
 * @version 1.0
 * The FooterPanel class provides a panel containing control buttons
 * to manage the simulation of the plateau. It includes functionality
 * to move to the next generation, clear the grid, automatically progress
 * through generations, and stop the automatic progression.
 */
public class FooterPanel extends JPanel implements ActionListener {
    /** Button to trigger the next generation in the simulation. */
    public JButton nextGeneration;

    /** Button to clear the simulation grid. */
    public JButton clear;

    /** Button to stop the automatic progression of generations. */
    public JButton stop;

    /** Button to start the automatic progression of generations. */
    public JButton auto;

    /** The simulation grid model. */
    private Plateau plateau;

    /** The visual representation of the simulation grid. */
    private PlateauView plateauView;

    /** Indicates whether there has been a change in the simulation state. Used to control the simulation flow. */
    boolean change = false;

    /** Timer used for the automatic progression of generations. */
    Timer timer;

    /**
     * Constructs a FooterPanel with the specified plateau and plateau view.
     *
     * @param plateau the Plateau object representing the grid or board state.
     * @param plateauView the PlateauView object for visual representation of the plateau.
     */
    public FooterPanel(Plateau plateau, PlateauView plateauView) {
        this.plateau = plateau;
        this.plateauView = plateauView;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        this.setBackground(Color.darkGray);

        // Initialize control buttons
        nextGeneration = new JButton("Next");
        clear = new JButton("Clear");
        auto = new JButton("Auto");
        stop = new JButton("Stop");

        // Add action listeners to buttons
        stop.addActionListener(this);
        nextGeneration.addActionListener(this);
        clear.addActionListener(this);
        auto.addActionListener(this);

        // Initially, the stop button is disabled
        stop.setEnabled(false);

        // Add buttons to the panel
        this.add(auto);
        this.add(nextGeneration);
        this.add(clear);
        this.add(stop);

        // Set up a timer for automatic generation progression
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                change = plateau.nextGeneration();
                // Stop the timer if no changes occur in the plateau
                if (!change) {
                    timer.stop();
                    nextGeneration.setEnabled(false);
                    auto.setEnabled(false);
                    clear.setEnabled(true);
                    stop.setEnabled(false);
                }
            }
        });
    }

    /**
     * Advances the simulation to the next generation and updates the visual representation.
     */
    private void btnNextGeneration() {
        plateau.nextGeneration();
        plateauView.enableCellulesView(false);
    }

    /**
     * Starts the automatic progression of generations and updates UI components to reflect the running state.
     */
    private void btnAuto() {
        plateauView.enableCellulesView(false);
        nextGeneration.setEnabled(false);
        auto.setEnabled(false);
        clear.setEnabled(false);
        stop.setEnabled(true);
        timer.start();
    }

    /**
     * Resets the simulation grid to its initial state and updates the UI components accordingly.
     */
    private void btnClear() {
        plateau.reInitialisationDeLaGrille();
        plateauView.enableCellulesView(true);
        nextGeneration.setEnabled(true);
        auto.setEnabled(true);
        clear.setEnabled(true);
        stop.setEnabled(false);
    }

    /**
     * Stops the automatic progression of generations and updates UI components to reflect the stopped state.
     */
    private void btnStop() {
        timer.stop();
        nextGeneration.setEnabled(true);
        auto.setEnabled(true);
        clear.setEnabled(true);
        stop.setEnabled(false);
    }

    /**
     * Handles action events triggered by button clicks. This method overrides the actionPerformed
     * method in the ActionListener interface.
     *
     * @param e the event to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == nextGeneration) {
            btnNextGeneration();
        } else if (btn == auto) {
            btnAuto();
        } else if (btn == stop) {
            btnStop();
        } else {
            btnClear();
        }
    }
}
