package sample;
/**
 * Created by ankush on 23-10-15.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


    public class Main extends Application {
       static Stage window;
        Scene scene1,scene2;
        javafx.scene.control.TextField name=new javafx.scene.control.TextField();
    @Override
    public void start(Stage primaryStage) throws Exception{

        window=primaryStage;
        window.setTitle("Bollywood Game");
        window.setOnCloseRequest(e-> {
            e.consume();
            closeProgram();
        });
        BorderPane layout=new BorderPane();
        layout.setPadding(new Insets(20,20,20,20));
        HBox headLayout =new HBox(30);
        Label hLabel = new Label("Welcome to Bollywood Game!");
        headLayout.setAlignment(Pos.TOP_LEFT);
        headLayout.setPadding(new Insets(30,10,10,30));
        headLayout.getChildren().add(hLabel);
        Label bLabel=new Label("Click Reset To Change Player Or  Next To Continue..");
        bLabel.setVisible(false);
        Label blabel2=new Label("Enter Your Name :");

        name.setPromptText(" Idiot ");
        name.setMaxWidth(200);


        Button reset=new Button(" Reset ");
        reset.setAlignment(Pos.BOTTOM_RIGHT);
        reset.setVisible(false);

        VBox bodyLayout =new VBox(10);
        bodyLayout.setAlignment(Pos.CENTER_LEFT);
        Button nextButton=new Button("  Next  ");
        nextButton.setVisible(false);
        nextButton.setOnAction(e->{
           scene2=Game.display(name());
           window.setScene(scene2);
        });
        Button enter =new Button(" Enter ");
        enter.setAlignment(Pos.BOTTOM_RIGHT);
        enter.setOnAction(e->{
            bLabel.setVisible(true);
            nextButton.setVisible(true);
            name.setVisible(false);
            blabel2.setText("Player Name :" + name());
            enter.setVisible(false);
            reset.setVisible(true);
        });
        reset.setOnAction(e->{
            name.clear();
            blabel2.setVisible(false);
            name.setVisible(true);
            bLabel.setVisible(true);
            nextButton.setVisible(false);
            enter.setVisible(true);

        });


        nextButton.setPadding(new Insets(10, 30, 30, 10));
        bodyLayout.getChildren().addAll(bLabel, blabel2, name, enter,reset);
        HBox bottomLayout =new HBox(100);
        bottomLayout.setPadding(new Insets(20,10,10,20));
        bottomLayout.setAlignment(Pos.BOTTOM_RIGHT);
        bottomLayout.getChildren().add(nextButton);
        layout.setTop(headLayout);
        layout.setCenter(bodyLayout);
        layout.setBottom(bottomLayout);
        scene1=new Scene(layout,500,330);
        scene1.getStylesheets().add("DarkTheme.css");
        window.setScene(scene1);
        window.show();

    }
    public  void closeProgram(){
        boolean confirm=Confirm.display();
        if(confirm)
            window.close();

    }
    public  String name(){

        return name.getText();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
