package Lab05.AimsProject.src.hust.soict.ite6.aims.screen;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Lab05.AimsProject.src.hust.soict.ite6.aims.media.CompactDisc;
import Lab05.AimsProject.src.hust.soict.ite6.aims.store.Store;

import java.awt.event.ActionEvent;

public class AddCDtoStoreScreen extends AddItemToStoreScreen{ 
    private JTextField artistField;
    private JTextField directorField;


    public AddCDtoStoreScreen(Store store) {
        super(store);
       
        JLabel artistLabel = new JLabel("Artist:");
        artistField = new JTextField();
        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField();
        

        

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String director = directorField.getText();
                String artist = artistField.getText();
                
                store.addItemtoStore(
                    new CompactDisc(title, category, director, cost, artist)
                );
                dispose();
                
            }
        });

        add(artistLabel);
        add(artistField);
        add(directorLabel);
        add(directorField);
        add(addButton);
    }

    
}
