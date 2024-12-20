package Lab05.AimsProject.src.hust.soict.ite6.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Lab05.AimsProject.src.hust.soict.ite6.aims.cart.Cart;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.CompactDisc;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.DigitalVideoDisc;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.book;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.media;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.playable;
import Lab05.AimsProject.src.hust.soict.ite6.aims.store.Store;

import javax.swing.JFrame;

public class StoreScreen extends JFrame {
    private Store store ;
    private Cart MyCart;
    private JButton playBtn;
    private JButton addToCartBtn;
    
    

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
       JMenu menu = new JMenu("Options");

       JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store);
                addBookScreen.setVisible(true);
                }
            });
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    AddCDtoStoreScreen addCDScreen = new AddCDtoStoreScreen(store);
                    addCDScreen.setVisible(true);
                }
            });
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    AddDVDtoStoreScreen addDVDScreen = new AddDVDtoStoreScreen(store);
                    addDVDScreen.setVisible(true);
                }
            });
       smUpdateStore.add(addBook);
       smUpdateStore.add(addCD);
       smUpdateStore.add(addDVD);

       menu.add(smUpdateStore);
       menu.add(new JMenuItem("View store"));
       JMenuItem viewCart = new JMenuItem("View Cart");
       menu.add(viewCart);
       viewCart.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               CartScreen cartScreen = new CartScreen(MyCart);
               cartScreen.setVisible(true);
               dispose();
           }
       });


       JMenuBar menuBar = new JMenuBar();
       menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
       menuBar.add(menu);

       return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Aims");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View Cart");
        cart.setPreferredSize(new Dimension(100,50));
        cart.setMaximumSize(new Dimension(100,50));
        cart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CartScreen cartScreen = new CartScreen(MyCart);
                cartScreen.setVisible(true);
                dispose();
            }
        });
        
        
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }



    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<media> mediaInStore = store.getItemsInStore();
        for(int i =0;i<9;i++){
            if(i >= mediaInStore.size()){
                break;
            }
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public class MediaStore extends JPanel{
        private media media;
        public MediaStore(media media){
            this.media = media;
            
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
            addToCartBtn = new JButton("Add to Cart");
            container.add(addToCartBtn);
            addToCartBtn.addActionListener(new CartMediaListener(this.media));
            
            if(media instanceof playable){
                playBtn = new JButton("Play");
                container.add(playBtn);
                playBtn.addActionListener(new PlayMediaListener(this.media));
            }


            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    private class CartMediaListener implements ActionListener{
        private media media;
        JDialog dialog = new JDialog();
        
        public CartMediaListener(media media) {
            this.media = media;
        }

        public void actionPerformed(ActionEvent e) { 
            dialog.setPreferredSize(new Dimension(200, 100)); // thiết lập kích thước ưa thích thành 400x300 pixels
            dialog.setLayout(new FlowLayout());
            dialog.add(new JLabel("Added " + media.getTitle() + " to your cart"));
            MyCart.addItemtoCart(media);
            dialog.pack();
            dialog.setVisible(true);
        }

    }

    private class PlayMediaListener implements ActionListener{
        private media media;
        JDialog dialog = new JDialog();
        
        public PlayMediaListener(media media) {
            this.media = media;
        }

        public void actionPerformed(ActionEvent e) { 
            dialog.setPreferredSize(new Dimension(300, 200)); // thiết lập kích thước ưa thích thành 400x300 pixels
            dialog.setLayout(new FlowLayout());
            dialog.add(new JLabel("Playing " + media.getTitle()));
            dialog.pack();
            dialog.setVisible(true);
        }

    }

    public StoreScreen(Store store, Cart cart) {
            this.store = store;
            this.MyCart = cart;
            Container cp = getContentPane();
            cp.setLayout(new BorderLayout());
            cp.add(createNorth(), BorderLayout.NORTH);
            cp.add(createCenter(), BorderLayout.CENTER);
            
            setVisible(true);
            setTitle("Store");
            setSize(1024,768);  
        }

        public static void main(String[] args) {
            
            Store store = new Store();
            Cart cart = new Cart();
            store.addItemtoStore(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f, 124));
            store.addItemtoStore(new CompactDisc("Greatest Hits", "Music","Michael Jackson",12, "Michael Jackson"));
            store.addItemtoStore(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f, 87));
            store.addItemtoStore(new book("Java Programming", "Education", 500));
            store.addItemtoStore(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 14.99f, 148));
            store.addItemtoStore(new CompactDisc("Thriller", "Music", "Quincy Jones", 9.99f, "Michael Jackson"));
            store.addItemtoStore(new DigitalVideoDisc("Interstellar", "Adventure", "Christopher Nolan", 18.50f, 169));
            store.addItemtoStore(new book("Effective Java", "Education", 45.00f));
            
            new StoreScreen(store,cart);
        }
}
