/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author mq12
 */
public class TablaVentaController implements Initializable {

       @FXML
    private TableView<Producto> tableViewProducto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @return the tableViewProducto
     */
    public TableView<Producto> getTableViewProducto() {
        return tableViewProducto;
    }

    /**
     * @param tableViewProducto the tableViewProducto to set
     */
    public void setTableViewProducto(TableView<Producto> tableViewProducto) {
        this.tableViewProducto = tableViewProducto;
    }
    public void saludo(String saludo){
        System.out.println("Saludo = "+ saludo);
    }
}
