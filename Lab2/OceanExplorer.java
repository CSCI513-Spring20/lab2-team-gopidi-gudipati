import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.String;

public class OceanExplorer extends Application {
    public static void main(String[]args){
        launch(args);
    }
    @Override
    public void start(Stage oceanStage) throws Exception {

        AnchorPane root = new AnchorPane();
      Scene  scene = new Scene( root,500 ,500);
        oceanStage.setTitle("Empty Scene");
        oceanStage.setScene(scene);
        oceanStage.show();
    }
}
