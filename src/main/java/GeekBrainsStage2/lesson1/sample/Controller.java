package GeekBrainsStage2.lesson1.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    TextArea mainTextArea;

    @FXML
    TextField messageField;

    public void sendBouttonOnClickAction(ActionEvent actionEvent) {
        if (!messageField.getText().trim().isEmpty()) {
            mainTextArea.appendText(messageField.getText().trim() + "\n");
            messageField.clear();
        } else {
            messageField.clear();
        }
    }

}
