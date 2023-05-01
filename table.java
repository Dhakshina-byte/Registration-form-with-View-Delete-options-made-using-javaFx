import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class table {

    @FXML
    private TableColumn<InputData, String> Age;

    @FXML
    private TableColumn<?, ?> delete;

    @FXML
    private TableColumn<InputData, String> Con;

    @FXML
    private AnchorPane DynamicPane;

    @FXML
    private TableColumn<InputData, String> FullN;

    @FXML
    private TableView<InputData> Table;

    @FXML
    private TableColumn<InputData, String> mail;

    @FXML
    void ret(ActionEvent event) throws IOException {
        setDynamicPane(FXMLLoader.load(getClass().getResource("FORM REG.fxml")));

    }

    private void setDynamicPane(AnchorPane DynamicPane) {
        this.DynamicPane.getChildren().clear();
        this.DynamicPane.getChildren().add(DynamicPane);
    }

    public void initialize() throws IOException {
        Collection<InputData> list = Files.readAllLines(new File("Info.txt").toPath())
                .stream()
                .map(line -> {
                    String[] details = line.split(",");
                    InputData cd = new InputData();
                    cd.setDataName(details[0]);
                    cd.setDataAge(details[1]);
                    cd.setDataPhoneNumber(details[2]);
                    cd.setDataemail(details[3]);
                    return cd;
                })
                .collect(Collectors.toList());

        ObservableList<InputData> details = FXCollections.observableArrayList(list);

        Con.setCellValueFactory(data -> data.getValue().DataPhoneNumberProperty());
        Age.setCellValueFactory(data -> data.getValue().DataAgeProperty());
        FullN.setCellValueFactory(data -> data.getValue().DataNameProperty());
        mail.setCellValueFactory(data -> data.getValue().DataemailProperty());

        System.out.println(details);

        Table.setItems(details);
    }

}
