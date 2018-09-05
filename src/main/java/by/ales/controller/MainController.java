package by.ales.controller;

import by.ales.model.Person;
import by.ales.service.PersonService;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainController implements Initializable {

    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn lastNameCol;
    @FXML
    private TableColumn roleCol;
    @FXML
    private TableColumn counterCol;
    @FXML
    private TableView personTable;


    private PersonService personService = new PersonService();

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public TableView getPersonTable() {
        return personTable;
    }

    public void setPersonTable(TableView personTable) {
        this.personTable = personTable;
    }

    public void initialize(URL location, ResourceBundle resources) {

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        roleCol.setCellValueFactory(new PropertyValueFactory<Person, String>("role"));
        counterCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("counter"));

        counterCol.setCellFactory( column -> new TableCell<Person, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null && item > 10) {
                    setStyle("-fx-background-color: red");
//                    setTextFill(Color.BLACK);
                }
                setText(item == null? "" : item.toString());
            }
        });


        ObservableList<Person> personObservableList = personService.getAllPersons();
        personObservableList.add(personService.generatePerson());

        personTable.setItems(personObservableList);

    }

    public void addPersonToList(ActionEvent actionEvent) {

        executorService.submit(new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                personService.getAllPersons().add(personService.generatePerson());
                return null;
            }
        });
    }

    public void modifyList(ActionEvent actionEvent) {

        executorService.submit(new Task<Void>() {
            @Override
            protected Void call() throws Exception {
//                Thread.sleep(4000);
                for (Person person : personService.getAllPersons()) {
                    person.setCounter(person.getCounter()+1);
                }
                return null;
            }
        });
    }
}
