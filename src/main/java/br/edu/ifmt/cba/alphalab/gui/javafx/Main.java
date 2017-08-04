
package br.edu.ifmt.cba.alphalab.gui.javafx;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.gui.javafx.controller.exemplo.FrmPrincipal;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public static void main(String[] args) {
    	//Locale.setDefault(Locale.ENGLISH);
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane frmPrincipal = null;
        
        try{
            frmPrincipal = FXMLLoader.load(FrmPrincipal.class.getClassLoader().getResource("gui//FrmPrincipal.fxml"),
            		ResourceBundle.getBundle(FrmPrincipal.LINGUA_PORTUGUES));
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        primaryStage.setTitle("AlphaLab");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        
        Scene scene = new Scene(frmPrincipal);
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override public void handle(WindowEvent t) {
                System.exit(0);
            }
        });        
        
        primaryStage.show();
    }
}