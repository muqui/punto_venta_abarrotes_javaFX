/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Producto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author mq12
 */
public class VentasController implements Initializable {

    Producto producto = new Producto();
    ObservableList<Producto> listProducto;

    //Estos 3 arraList son para llenar las tablas de venta
    ArrayList<Tab> tabArrayList = new ArrayList<Tab>(); // se crar un array de tabs.
    ArrayList<ObservableList<Producto>> observableListArrayList = new ArrayList<ObservableList<Producto>>(); // Se crea un array de ObsevableList
    ArrayList<List<Producto>> listaProductoArrayList = new ArrayList<List<Producto>>(); // Se crea una lista de lsita de productos

    @FXML
    private TextField txtCodigoBarras;

    @FXML
    TabPane tabPaneTicket;

    @FXML
    void ActionBtnCrearTicket(ActionEvent event) {

        int numTabs = tabPaneTicket.getTabs().size();
        if (numTabs < 10) {
            crearTicket("Ticket " + (numTabs + 1));
        }

    }

    @FXML
    void ActionBtnAgregarProducto(ActionEvent event) {
       // List<Producto> list = new ArrayList<>();
        String codigoBarras = txtCodigoBarras.getText();
        int tabSeleccionado = tabPaneTicket.getSelectionModel().getSelectedIndex(); // Selecciona el tab Seleccionado.
        System.out.println("Tab Seleccionado ............. " + tabSeleccionado);
        Node selectedContent = tabArrayList.get(tabSeleccionado).getContent();
        listaProductoArrayList.get(tabSeleccionado).add(new Producto(0, codigoBarras, codigoBarras, 0, 0, codigoBarras, 0, 0, 0, codigoBarras, true, 0, 0, 0, true, new Button(), new Button()));
        //list.add(new Producto(0, codigoBarras, codigoBarras, 0, 0, codigoBarras, 0, 0, 0, codigoBarras, true, 0, 0, 0, true, new Button(), new Button()));
        ObservableList<Producto> data = observableListArrayList.get(tabSeleccionado);
        data = FXCollections.observableList(listaProductoArrayList.get(tabSeleccionado));
        TableView tableView = (TableView) selectedContent.lookup("#miTabla");
        tableView.setItems(data);
        // tableView.getItems().add(new Producto(0, codigoBarras, codigoBarras, 0, 0, codigoBarras, 0, 0, 0, codigoBarras, true, 0, 0, 0, true, new Button(), new Button()));

    }

    @FXML
    void ActionBtnEliminarTicket(ActionEvent event) {

        int numTabs = tabPaneTicket.getTabs().size() - 1;
        if (numTabs > 0) // elimina todos los tickes exepto el primero
        {
            tabPaneTicket.getTabs().remove(numTabs);  
        }
        tabArrayList.remove(numTabs);
        listaProductoArrayList.remove(numTabs);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        crearTicket("Ticket 1");

    }

    public void crearTicket(String nombre) {
        TableView tableView = new TableView();
        tableView.setId("miTabla");
        int numTabs = tabPaneTicket.getTabs().size();
        TableColumn<Producto, String> column1 = new TableColumn<>("CODIGO");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        //COLUMNA
        TableColumn<Producto, String> column2 = new TableColumn<>("NOMBRE");
        column2.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        //COLUMNA
        TableColumn<Producto, String> column3 = new TableColumn<>("PRECIO");
        column3.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        //COLUMNA
        TableColumn<Producto, String> column4 = new TableColumn<>("CANTIDAD");
        column4.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        //COLUMNA
        TableColumn<Producto, String> column5 = new TableColumn<>("TOTAL");
        column5.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        //COLUMNA
        TableColumn<Producto, String> column6 = new TableColumn<>(" ");
        column6.setCellValueFactory(new PropertyValueFactory<>("botonAgregar"));
        //COLUMNA
        TableColumn<Producto, String> column7 = new TableColumn<>(" ");
        column7.setCellValueFactory(new PropertyValueFactory<>("botonBorrar"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);

        Tab tab = new Tab(nombre);

        StackPane tabLayout = new StackPane();
        tabLayout.getChildren().add(tableView);
        tab.setContent(tabLayout);
        tabArrayList.add(tab);
        // INSERTA observableList VACIO
        observableListArrayList.add(FXCollections.observableArrayList());
        listaProductoArrayList.add(new ArrayList<>());
        tabPaneTicket.getTabs().add(
                tabArrayList.get(numTabs)
        );

    }

}
