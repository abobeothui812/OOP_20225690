package Lab05.AimsProject.src.hust.soict.ite6.aims.screen;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Lab05.AimsProject.src.hust.soict.ite6.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {
    public JTextField titleField;
    public JTextField categoryField;
    public JTextField costField;
    


    public AddItemToStoreScreen(Store store) {
        setTitle("Add Item to Store");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField();

        

       

        add(titleLabel);
        add(titleField);
        add(categoryLabel);
        add(categoryField);
        add(costLabel);
        add(costField);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Store store = new Store();
                new AddItemToStoreScreen(store).setVisible(true);
            }
        });
    }

    
}
