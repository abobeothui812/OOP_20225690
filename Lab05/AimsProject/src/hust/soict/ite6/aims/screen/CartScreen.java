package Lab05.AimsProject.src.hust.soict.ite6.aims.screen;

import javax.swing.JFrame;
import Lab05.AimsProject.src.hust.soict.ite6.aims.cart.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class CartScreen extends JFrame{
    @SuppressWarnings("unused")
    private Cart cart ;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxpanel = new JFXPanel();
        this.add(fxpanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxpanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        
    }

    public static void main(String[] args) {
        Cart cart = new Cart();

        

        Platform.startup(() -> new CartScreen(cart)); 
        
    } 
    
}
