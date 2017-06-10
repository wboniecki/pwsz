package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    Button dodaj;
    @FXML
    Button usun;
    @FXML
    Button edytuj;
    @FXML
    TextField name;
    @FXML
    TextField numer;
    @FXML
    TableView<Person> tableView;

    private ObservableList<Person> data;

    @FXML
    private void initialize() {
        dodaj.setOnMouseClicked(event -> {
            data.add(new Person(name.getText(), numer.getText()));
        });
        usun.setOnMouseClicked(event -> {
            data.remove(tableView.getSelectionModel().getSelectedItem());
        });
        edytuj.setOnMouseClicked(event -> {
            Person person = tableView.getSelectionModel().getSelectedItem();
            name.setText(person.getName());
            numer.setText(person.getPhone());
            data.remove(person);
        });

        tableView.setEditable(true);

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));

        TableColumn phoneCol = new TableColumn("Phone");
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("Phone")
        );

        data = FXCollections.observableArrayList();
        tableView.setItems(data);

        tableView.getColumns().addAll(nameCol, phoneCol);

    }
}
