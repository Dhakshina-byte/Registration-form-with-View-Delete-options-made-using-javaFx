import javafx.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class main {
    String Input = "";
    Stage primaryStage;

    @FXML
    private AnchorPane DynamicPane;

    @FXML
    private TextField AGE;

    @FXML
    private TextField CONTRACT;

    @FXML
    private TextField EMAIL;

    @FXML
    private TextField FULLNAME;

    @FXML
    void VIEW(ActionEvent event) throws IOException {
        setDynamicPane(FXMLLoader.load(getClass().getResource("view.fxml")));
    }

    private void setDynamicPane(AnchorPane DynamicPane) {

        this.DynamicPane.getChildren().clear();
        this.DynamicPane.getChildren().add(DynamicPane);
    }

    @FXML
    void SUBMIT(ActionEvent event) {
        SUBMIT();

    }

    public void data() {
        String Name = FULLNAME.getText();
        String Age = AGE.getText();
        String Number = CONTRACT.getText();
        String email = EMAIL.getText();
        FULLNAME.setText("");
        AGE.setText("");
        CONTRACT.setText("");
        EMAIL.setText("");
        Input = (Name + "," + Age + "," + Number + "," + email + System.lineSeparator());
    }

    public void SUBMIT() {
        data();
        try {
            File file = new File("Info.txt");

            if (!file.exists()) {
                file.createNewFile();
                String TitleData = ("Name,Age,Number,email" + System.lineSeparator());
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(TitleData);
                bw.close();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Input);
            bw.close();
        } catch (IOException el) {
            el.printStackTrace();
        }
    }

}
