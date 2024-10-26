package bt61;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
    int option = JOptionPane.showConfirmDialog(null,
            "Do you want to change to the first class ticket?",
            "Choose an option",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
            );
    JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}

