/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mq12
 */
public class PrincipalController implements Initializable {
    Node node;
     @FXML
    private AnchorPane anchorPaneContenido;
      @FXML
    private Button btnVender;
      @FXML
    void actionBtnVender(ActionEvent event) throws IOException {
       nodeVentas();
    }
     @FXML
    void actionBtnProductos(ActionEvent event) throws IOException {
        
        node = (Node)FXMLLoader.load(getClass().getResource("/views/Productos.fxml"));
        anchorPaneContenido.getChildren().setAll(node);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nodeVentas();
    }    
     private void nodeVentas(){
         try {
           
        node = (Node)FXMLLoader.load(getClass().getResource("/views/ventas.fxml"));
        anchorPaneContenido.getChildren().setAll(node);
         } catch (IOException ex) {
             Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
