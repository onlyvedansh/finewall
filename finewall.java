
import javafx.scene.control.TextArea;
import javafx.scene.Parent;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.concurrent.Task;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.Scene;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;



 public class finewall extends Application
{
    //linking to external css
   

    //button method to add button in Panes :::button ( "button name" , Pane name)::
   public void buttonM (String name , Pane parent)
   {
    Button button = new Button (name);
    parent.getChildren().add(button);
    

   }
    void mainWindow()
    {
   
        Stage mainStage = new Stage();
        mainStage.setTitle("Finewall");
        Pane outerPane = new Pane();
        //outerPane.setLayoutX(50);outerPane.setLayoutY(50); 
        outerPane.setPrefSize(1000,500);

        HBox navBar = new HBox();
        buttonM("home",navBar);
        buttonM("About",navBar);
        outerPane.getChildren().add(navBar);
        Scene scene = new Scene (outerPane, 500,500);
        mainStage.show();
        mainStage.setScene(scene);

    }

    void loadingWindow()
    {     
         Pane loadingOuterPane  = new Pane();
         Scene scene = new Scene(loadingOuterPane,500,500);
        Stage loadingStage = new Stage ();
        scene.getStylesheets().add(getClass().getResource("finewall.css").toExternalForm());
        
        loadingStage.setResizable(false);
        loadingStage.show();
        
        Pane loadingInnerPane = new Pane ();
        TextArea email = new TextArea();email.setPromptText("Enter email");

        TextArea password = new TextArea();password.setPromptText("Enter email");
        loadingOuterPane.getChildren().add(loadingInnerPane);
        loadingInnerPane.getChildren().addAll(email,password);
        buttonM("submit",loadingInnerPane);


        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(e -> {
           loadingStage.close();
            mainWindow();
         });
          delay.play();
    }
     @Override
    public void start(Stage primaryStage) {
        // Call the loading window method when the app starts
        loadingWindow();
    }
    public static void main(String[]args)
    {
            launch(args);
    }

}   
    