
import javafx.scene.Parent;
import javafx.stage.StageStyle;

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
        outerPane.setStyle("-fx-background-color :rgb(222, 222, 102)");
        
        HBox navBar = new HBox(5);
        navBar.setLayoutX(2); //navBar.setLayoutY(20); navBar.setPrefSize();
        buttonM("Home",navBar);
        buttonM("About",navBar); 
        buttonM("Tools",navBar);
        buttonM("More",navBar);

       


        outerPane.getChildren().add(navBar);
        Scene scene = new Scene (outerPane, 1000,500);
                scene.getStylesheets().add(getClass().getResource("finewall.css").toExternalForm());

         mainStage.centerOnScreen();
       
        mainStage.setScene(scene);
         mainStage.show();

    }

    void loadingWindow()
    {     
         Pane loadingOuterPane  = new Pane();
         Scene scene = new Scene(loadingOuterPane,500,500);
         Stage loadingStage = new Stage ();
         scene.getStylesheets().add(getClass().getResource("finewall.css").toExternalForm());
        Label area = new Label("FineWall");
        area.setPrefSize(370,100);
        area.setLayoutX(100); area.setLayoutY(100);
        loadingOuterPane.getChildren().add(area);
        loadingStage.initStyle(StageStyle.UNDECORATED);
        loadingStage.setScene(scene);
        loadingStage.setResizable(false);
        loadingStage.centerOnScreen();
        loadingStage.show();


        PauseTransition delay = new PauseTransition(Duration.seconds(3));
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
    