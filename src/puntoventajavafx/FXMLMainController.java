/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventajavafx;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author mq12
 */
public class FXMLMainController implements Initializable {
    
       @FXML
    private Button btnAceptar;

    @FXML
    private Label labelPassword;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label labelUsuario;

     @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField textFieldContraseña;
    @FXML
    void btnActionAceptar(ActionEvent event) {
        String usuario = textFieldUsuario.getText();
        String pass = textFieldContraseña.getText();
         
        
    Stage stage1 = (Stage) btnAceptar.getScene().getWindow();
    stage1.close();
        
      //   if(usuario.equals("admin") && pass.equals("Corona12")){
             JOptionPane.showMessageDialog(null, "Usuario = " + usuario + " Contraseña= " + pass);
              
   
            try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Principal.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    //stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle("ABC");
    stage.setScene(new Scene(root1));  
    stage.show();
                 
               
            } catch (IOException ex) {
                Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
      //   }
    }

    @FXML
    void btnActionCancelar(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
