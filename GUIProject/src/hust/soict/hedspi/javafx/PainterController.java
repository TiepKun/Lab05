package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    private Color brushColor = Color.BLACK;
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup tool;

    @FXML
    void changeTool(ActionEvent event) {
        switch (((RadioButton) event.getSource()).getText()) {
            case "Pen":
                brushColor = Color.WHITE;
                break;
            case "Eraser":
            default:
                brushColor = Color.BLACK;
                break;
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Clear the drawing area
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Draw circles as the mouse is dragged
        Circle circle = new Circle(event.getX(), event.getY(), 4, brushColor);
        drawingAreaPane.getChildren().add(circle);
    }
}
