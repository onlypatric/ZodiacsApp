import javax.swing.SwingUtilities;

/**
 * MainApp
 */
public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Application::new);
    }
}