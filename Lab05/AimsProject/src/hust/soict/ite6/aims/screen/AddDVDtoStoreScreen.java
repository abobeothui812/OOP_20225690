package Lab05.AimsProject.src.hust.soict.ite6.aims.screen;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Lab05.AimsProject.src.hust.soict.ite6.aims.media.DigitalVideoDisc;
import Lab05.AimsProject.src.hust.soict.ite6.aims.store.Store;
import java.awt.event.ActionEvent;

public class AddDVDtoStoreScreen extends AddItemToStoreScreen{ 
    private JTextField directorField;
    private JTextField lengthField;

    public AddDVDtoStoreScreen(Store store) {
        super(store);
        
        
        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField();
        JLabel lengthLabel = new JLabel("Length:");
        lengthField = new JTextField();
        

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String director = directorField.getText();
                int length = Integer.parseInt(lengthField.getText());
                store.addItemtoStore(
                    new DigitalVideoDisc(title, category, director, cost, length)
                );
                dispose();
                
            }
        });

        add(directorLabel);
        add(directorField);
        add(lengthLabel);
        add(lengthField);
        
        add(addButton);
    }

    
}
