package sample;
/**
 * Created by ankush on 23-10-15.
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Random;

public class Game{

        static int lives=9;
    static Label hlabel2;
    static Scene scene;
    static  String ename,p,g;
    public static Scene display(String name){


        Scene scene;
        BorderPane layout = new BorderPane();
        HBox headLayout=new HBox(100);
        Label hLabel1=new Label(name);
        Label hlabel3=new Label();
        headLayout.getChildren().addAll(hLabel1, hlabel3);
        headLayout.setPadding(new Insets(20,20,20,20));

        String[] wd=new String[5];
        wd[0]="sheep";
        wd[1]="goat";
        wd[2]="computer";
        wd[3]="india";
        wd[4]="watermelon";
       
        TextField w =new TextField();
        Label blabel1=new Label("Guess The Word! ");
        Label blabel2=new Label();
        w.setPromptText("Guess the word");
        w.setMaxWidth(40);
        Random rand = new Random();
        int n = rand.nextInt(5);
        String word= wd[n];
        char[] guess=new char[word.length()];
        for (int i = 0; i <word.length() ; i++) {
            switch (word.charAt(i))
            {
                case ' ': guess[i]=' ';
                    break;
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':guess[i]=word.charAt(i);
                    break;
                default:
                    guess[i]='_';
            }
        }

        p=String.valueOf(guess);

        blabel2.setText(p);


        Button button1=new Button(" Click ");



        button1.setOnAction(e -> {

            g = w.getText();

            char[] b = new char[g.length()];
            for (int i = 0; i < g.length(); i++) {
                b[i] = g.charAt(i);
            }
            for (int i = 0; i < guess.length; i++) {

                if (word.charAt(i) == b[0]) {
                    guess[i] = b[0];

                } else {
                    setLives();
                }

            }
            p = String.valueOf(guess);
            blabel2.setText(p);
            int flag = 1;
            for (int i = 0; i < word.length(); i++) {
                if (p.charAt(i) != word.charAt(i)) {
                    flag = 0;
                    System.out.println(flag);
                    break;
                }

            }
            if (flag == 1) {
                win.display(name);
            }

        });


        VBox bodyLayout=new VBox(10);
        bodyLayout.getChildren().addAll(blabel1,w,blabel2,button1);
        layout.setTop(headLayout);
        layout.setCenter(bodyLayout);
        scene=new Scene(layout,500,330);
        scene.getStylesheets().add("DarkTheme.css");
       return scene;
    }


    public static void setLives(){

        lives--;



    }
}