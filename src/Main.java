import java.awt.GridLayout;
import model.Plateau;
import view.FooterPanel;
import view.PlateauView;
import view.Screen;

public class Main {
    // Constants for grid dimensions and window size
    public static final int x = 55; // Number of rows in the grid
    public static final int y = 55; // Number of columns in the grid
    public static final int width = 800; // Width of the application window
    public static final int height = 800; // Height of the application window

    public static void main(String[] args) {
        // Initialize the grid model with the specified dimensions
        Plateau plateau = new Plateau(x, y);

        // Create a visual representation of the grid using GridLayout
        PlateauView plateauView = new PlateauView(new GridLayout(x, y), plateau);

        // Initialize the footer panel with control buttons, passing in the grid and its view
        FooterPanel footer = new FooterPanel(plateau, plateauView);

        // Set up the main application window with the specified title, size, grid view, and footer panel
        Screen window = new Screen("Jeu de la vie", width, height, plateauView, footer);

        // Make the application window visible to start the simulation
        window.setVisible(true);
    }
}
