package view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Ahmat Mahamat Ahmat
 * @version 1.0
 * Screen serves as the main application window, encapsulating the entire user interface.
 * It is responsible for setting up the window properties, such as title and size, and organizing
 * the primary UI components, including PlateauView for displaying the game grid and FooterPanel
 * for user interactions.
 */
public class Screen extends JFrame {
    /** The main container panel for the application's UI components. */
    public JPanel screenContaineur;

    /**
     * Constructs the Screen with the specified parameters, initializing the main window and its content.
     * The constructor is responsible for configuring the window's properties, such as its title, size,
     * and layout, as well as adding the main UI components.
     * 
     * @param title The title of the window, appearing in the window's title bar.
     * @param largeur The width of the window in pixels.
     * @param hauteur The height of the window in pixels.
     * @param plateauView The visual representation of the game's grid or plateau.
     * @param footeur The panel containing control buttons for user interaction.
     */
    public Screen(String title, int largeur, int hauteur, PlateauView plateauView, FooterPanel footeur) {
        setTitle(title);
        setSize(largeur, hauteur);
        setLocationRelativeTo(null); // Centers the window on the screen.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Set an icon for the application window.
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
        setIconImage(icon.getImage());

        // Initialize the main container and add the primary UI components.
        screenContaineur = (JPanel) getContentPane();
        screenContaineur.add(plateauView, BorderLayout.CENTER);
        screenContaineur.add(footeur, BorderLayout.NORTH);
    }
}
