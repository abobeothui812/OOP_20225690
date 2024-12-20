package Lab05.GUIProject.src.hust.soict.ite6.javafx;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @SuppressWarnings("unused")
    private ToggleGroup indentical;
     private RadioButton penRadioButton;
    private boolean isEraser = false;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isEraser) {
            // Sử dụng tẩy: xóa các phần tử tại vị trí chuột
            drawingAreaPane.getChildren().removeIf(node -> node.contains(event.getX(), event.getY()));
        } else {
            // Sử dụng bút: vẽ hình tròn tại vị trí chuột
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();

    }

    @FXML
    void choosePen(ActionEvent event) {
        isEraser = false;
        penRadioButton.setSelected(true);
    }

    @FXML
    void chooseEraser(ActionEvent event) {
        isEraser = true;
        
    }

}
