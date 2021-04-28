/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Producto;
import dao.tblProducto;
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
    tblProducto tblProducto = new tblProducto();
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
        insetarProductoTicket();
    }

    @FXML
    void ActionBtnEliminarTicket(ActionEvent event) {

        int numTabs = tabPaneTicket.getTabs().size() - 1;
        if (numTabs > 0) // elimina todos los tickes exepto el primero
        {
            tabPaneTicket.getTabs().remove(numTabs);
            tabArrayList.remove(numTabs);
            listaProductoArrayList.remove(numTabs);
        }

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
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // NECESARIO PARA CAMBIAR EL ANCHO DE LA TABLA
        int numTabs = tabPaneTicket.getTabs().size();
        TableColumn<Producto, String> column1 = new TableColumn<>("CODIGO");
        column1.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        column1.setMaxWidth(1f * Integer.MAX_VALUE * 20);
        //COLUMNA
        TableColumn<Producto, String> column2 = new TableColumn<>("NOMBRE");
        column2.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        column2.setMaxWidth(1f * Integer.MAX_VALUE * 30);
        //COLUMNA
        TableColumn<Producto, String> column3 = new TableColumn<>("PRECIO");
        column3.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        column3.setMaxWidth(1f * Integer.MAX_VALUE * 20);
        //COLUMNA
        TableColumn<Producto, String> column4 = new TableColumn<>("CANTIDAD");
        column4.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        column4.setMaxWidth(1f * Integer.MAX_VALUE * 10);
        //COLUMNA
        TableColumn<Producto, String> column5 = new TableColumn<>("TOTAL");
        column5.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
        column5.setMaxWidth(1f * Integer.MAX_VALUE * 10);
        //COLUMNA
        TableColumn<Producto, String> column6 = new TableColumn<>(" ");
        column6.setCellValueFactory(new PropertyValueFactory<>("botonAgregar"));
        column6.setMaxWidth(1f * Integer.MAX_VALUE * 5);
        //COLUMNA
        TableColumn<Producto, String> column7 = new TableColumn<>(" ");
        column7.setCellValueFactory(new PropertyValueFactory<>("botonBorrar"));
        column7.setMaxWidth(1f * Integer.MAX_VALUE * 5);

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
    
    /*
    *
    * Agrega producto al ticket
    *
    */
    public void insetarProductoTicket(){
         String codigoBarras = txtCodigoBarras.getText();
        int tabSeleccionado = tabPaneTicket.getSelectionModel().getSelectedIndex(); // Selecciona el tab Seleccionado.        
        Node selectedContent = tabArrayList.get(tabSeleccionado).getContent();
        listaProductoArrayList.get(tabSeleccionado).add(tblProducto.getProducto(codigoBarras));
        
        ObservableList<Producto> data = observableListArrayList.get(tabSeleccionado);
        data = FXCollections.observableList(listaProductoArrayList.get(tabSeleccionado));
        TableView tableView = (TableView) selectedContent.lookup("#miTabla");
        tableView.setItems(data);
        
        
        
    }

}
