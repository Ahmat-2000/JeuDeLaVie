import java.awt.GridLayout;

import model.Plateau;
import view.FooterPanel;
import view.PlateauView;
import view.Screen;

public class Main {
    public static final int x =55;
    public static final int y = 55;
    public static final int width = 800;
    public static final int height = 800;

    public static void main(String[] args) {
        Plateau plateau = new Plateau(x, y);
        PlateauView plateauView = new PlateauView(new GridLayout(x,y), plateau);
        FooterPanel footeur = new FooterPanel(plateau,plateauView);
        Screen window = new Screen("Jeu de la vie", width, height, plateauView,footeur);
        window.setVisible(true);
    }
}
