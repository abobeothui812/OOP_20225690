package Lab05.AimsProject.src.hust.soict.ite6.aims.screen;

import Lab05.AimsProject.src.hust.soict.ite6.aims.media.book;
import Lab05.AimsProject.src.hust.soict.ite6.aims.store.Store;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class AddBookToStoreScreen extends AddItemToStoreScreen{ 
    

    public AddBookToStoreScreen(Store store) {
        super(store);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                
                store.addItemtoStore(
                    new book(title, category,  cost)
                );
                dispose();
                
            }
        });
        add(addButton);
    }
}
