package gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class QuestionTableController {

    @FXML
    private JFXButton addQuestionBtn;

    @FXML
    private JFXButton editQuestionBtn;

    @FXML
    private JFXButton closeBtn;

    @FXML
    private TableView<?> questionsTable;

    @FXML
    private TableColumn<?, ?> questionIdColumn;

    @FXML
    private TableColumn<?, ?> questionTxtColumn;

    @FXML
    private TableColumn<?, ?> answer1Column;

    @FXML
    private TableColumn<?, ?> answer2Column;

    @FXML
    private TableColumn<?, ?> answer3Column;

    @FXML
    private TableColumn<?, ?> answer4Column;

    @FXML
    private TableColumn<?, ?> correctAnswerColumn;

}
