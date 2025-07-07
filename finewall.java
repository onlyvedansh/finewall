import java.awt.Panel;
import javafx.scene.control.TextArea;
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
   
   public Button buttonM (String name , Pane parent)
   {
    Button button = new Button (name);
    parent.getChildren().add(button);
    return button;

   }
    void loadingWindow()
    {
   
        Stage loadingStage = new Stage();
        loadingStage.setTitle("Finewall");
        Pane outerPane = new Pane();
        //outerPane.setLayoutX(50);outerPane.setLayoutY(50); 
        outerPane.setPrefSize(1000,500);

        HBox navBar = new HBox();
        Button b=buttonM("home",navBar);
        Button c =buttonM("About",navBar);
        outerPane.getChildren().add(navBar);
        Scene scene = new Scene (outerPane, 500,500);
        loadingStage.show();
        loadingStage.setScene(scene);

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
    