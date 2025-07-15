
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

//class tools 
//{
//    void background-p()
//   {
//
//   }
//
//   
//}
//
//class windows
//{
//
//}

class Panes
{
    public void home(Pane parent)
    {
        Pane Homepane = new Pane();
       Homepane.prefHeightProperty().bind(parent.heightProperty());
      Homepane.prefWidthProperty().bind(parent.widthProperty());
      Homepane.setLayoutY(50);
      finewall f =new finewall();
      
      Label l1 ,l2,l3,l4,l5 , l6 ;
      l1 = new Label(" My IPv4"); l1.setLayoutX(30); l1.setLayoutY(0);
      l2 = new Label(" My Gateway"); l2.setLayoutX(30); l2.setLayoutY(30);
      l3 = new Label(" My Network IP");l3.setLayoutX(30); l3.setLayoutY(60);
      l4 = new Label(" Devices Connected");l4.setLayoutX(30); l4.setLayoutY(90);
      l5 = new Label(" Blocked Devices");l5.setLayoutX(30); l5.setLayoutY(120);
      l6 = new Label(" Devices Names ");l6.setLayoutX(30); l6.setLayoutY(220);
       f.buttonM("My ipv4", Homepane);


      Homepane.getChildren().addAll(l1,l2,l3,l4,l5,l6);
       parent.getChildren().add(Homepane);


    }
}

 public class finewall extends Application
{
    //linking to external css
   

    //button method to add button in Panes :::button ( "button name" , Pane name)::
   public void buttonM (String buttonName , Pane parentName  )
   {
    
    Button button = new Button (buttonName);
    parentName.getChildren().add(button);
    

   }
  
    void mainWindow()
    {


        Stage mainStage = new Stage();
        mainStage.setTitle("Finewall");
        Pane outerPane = new Pane();
        outerPane.setStyle("-fx-background-color :rgb(222, 222, 102)");
        
        HBox navBar = new HBox(5);
        navBar.prefWidthProperty().bind(outerPane.widthProperty());
        navBar.setLayoutX(200); navBar.setLayoutY(4); //navBar.setPrefSize();
        navBar.setStyle(" -fx-background-color: rgb(222, 222, 102);");
        buttonM("Home",navBar);
        buttonM("About",navBar); 
        buttonM("Tools",navBar);
        buttonM("More",navBar);
        Panes n = new Panes();
        n.home(outerPane);

       


        outerPane.getChildren().add(navBar);
        navBar.toFront();
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
        loadingOuterPane.setStyle("-fx-background-color:rgb(222, 222, 102)");
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
        mainWindow();
    }
    public static void main(String[]args)
    {
            launch(args);
    }

}   
    