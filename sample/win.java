package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by ankush on 23-10-2015.
 */
public class win {
    public static void display(String name){
        Scene win;
        HBox layout=new HBox(50);
        Label lbl=new Label("Hurray! you won");
        Button tryAgain=new Button(" Try Again ");
        tryAgain.setOnAction(e-> Game.display(name));
        layout.getChildren().addAll(lbl,tryAgain);
        win=new Scene(layout,500,330);
        win.getStylesheets().add("DarkTheme.css");
        Main.window.setScene(win);
}
}
