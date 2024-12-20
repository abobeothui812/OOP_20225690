package Lab05.AimsProject.src.hust.soict.ite6.aims.screen;

import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import Lab05.AimsProject.src.hust.soict.ite6.aims.cart.Cart;
import Lab05.AimsProject.src.hust.soict.ite6.aims.exception.TotalCostException;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.disc;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.media;
import Lab05.AimsProject.src.hust.soict.ite6.aims.media.playable;
import Lab05.AimsProject.src.hust.soict.ite6.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CartScreenController {

    private Cart cart;
    private Store store;

    @FXML
    private TableView<media> tblMedia;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableColumn<media, Float> colCost;

    @FXML
    private TableColumn<media, String> colCategory;

    @FXML
    private TableColumn<media, String> colTitle;

    @FXML
    private Button btnPlay;
    @FXML
    private MenuItem viewStoreBtn;
    @FXML
    private Button btnRemove;

     @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFitler;

    @FXML
    private Button placeOrderBtn;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    
    @FXML
    private Label TotalCost;

    @FXML
    public void initialize() {
        colTitle.setCellValueFactory(new PropertyValueFactory<media, String>("title"));
        colCategory.setCellValueFactory(new PropertyValueFactory<media, String>("category"));
        colCost.setCellValueFactory(new PropertyValueFactory<media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemOrdered());
        try {
            TotalCost.setText(cart.totalCost() + "$");
        } catch (TotalCostException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<media>() {

                public void changed(ObservableValue<? extends media> observable, media oldValue, media newValue) {
                    if(newValue != null) {
                        btnRemove.setVisible(true);
                        if(newValue instanceof playable) {
                            btnPlay.setVisible(true);
                        } else {
                            btnPlay.setVisible(false);
                        }
                    }
                }}
            );
            
        @SuppressWarnings("unused")
        FilteredList<media> filteredList = new FilteredList<>(cart.getItemOrdered(), p -> true);
        tblMedia.setItems(filteredList);
        tfFitler.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filteredList.setPredicate(media -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (media.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (media.getCategory().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            }
        });

    }

     @FXML
    void removeBtnPressed(ActionEvent event) {
        media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            cart.removeItemFromCart(media);
            TotalCost.setText(cart.totalCost() + "$");
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to remove item from cart: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @SuppressWarnings("unused")
    @FXML
    void placeOrderPressed(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        try {
            alert.setContentText("Order placed successfully!\nTotal cost: " + cart.totalCost() + "$\nThanks for your purchase!");
        } catch (TotalCostException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        alert.showAndWait();
        alert.setOnHidden(e -> {
            Stage stage = (Stage) placeOrderBtn.getScene().getWindow();
            stage.close();
        });
        
    }

    @FXML
    void playBtnPressed(ActionEvent event) {
        media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof disc) {
            playMedia(selectedMedia);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Playing media");
            alert.setHeaderText(null);
            alert.setContentText("Media is not playable");
            alert.showAndWait();
        }
    }

    private void playMedia(media media) {
        try {
            Stage stage = new Stage();
            VBox vbox = new VBox(new Label("Now playing: " + media.getTitle()));
            vbox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vbox, 300, 100);
            stage.setScene(scene);
            stage.setTitle("Playing Media");
            stage.show();
        }catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to play media: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void viewStoreBtnPressed(ActionEvent event) {
        Stage stage = (Stage) btnRemove.getScene().getWindow();
        stage.close();

        StoreScreen storeScreen = new StoreScreen(store, cart);
        storeScreen.setVisible(true);

    }

}

