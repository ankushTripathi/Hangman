package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by ankush on 23-10-2015.
 */
public class loose {
    public static void display(String name){
        Scene lost;
        HBox layout=new HBox(50);
        Label lbl=new Label("Sorry you Lost!");
        Button tryAgain=new Button(" Try Again ");
        tryAgain.setOnAction(e-> Game.display(name));
        layout.getChildren().addAll(lbl,tryAgain);
        lost=new Scene(layout,500,330);
        lost.getStylesheets().add("DarkTheme.css");
    }
}
