package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Confirm {

 static boolean confirm;

    public static boolean display(){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Whoa .. Slow  down");
        Label label = new Label();
        label.setText("Are You Sure you Want to Quit..");
        Button yesButton=new Button("yes..Im a Loser");
        Button noButton = new Button("NO..I'll Try Again");
        yesButton.setPadding(new Insets(20,20,20,20));
        noButton.setPadding(new Insets(20,20,20,20));
        yesButton.setOnAction(e->{
            confirm=true;
            window.close();
        });
        noButton.setOnAction(e->{
            confirm=false;
            window.close();
        });
        HBox hLayout = new HBox();
        hLayout.setPadding(new Insets(20,10,10,30));
        hLayout.getChildren().add(label);
        HBox bLayout=new HBox(20);
        bLayout.setPadding(new Insets(20,10,10,30));
        bLayout.getChildren().addAll(yesButton, noButton);
        bLayout.setAlignment(Pos.BOTTOM_RIGHT);
        BorderPane layout=new BorderPane();
        layout.setCenter(hLayout);
        layout.setBottom(bLayout);
        Scene scene=new Scene(layout,475,150);
        scene.getStylesheets().add("DarkTheme.css");
        window.setScene(scene);
        window.showAndWait();
        return confirm;
    }
}

