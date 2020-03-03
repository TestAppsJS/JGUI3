import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class BodyCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        Insets padding = new Insets(100, 30, 30, 100);
        gridPane.setPadding(padding);
        ChoiceBox<String> textFieldSex = new ChoiceBox<String>();
        textFieldSex.getItems().addAll("M", "F");
        TextField textFieldHeight = new TextField();
        Button button = new Button("Calculeaza");
        Label label = new Label();

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String sex = textFieldSex.getValue();
                String height= textFieldHeight.getText();
                int x =Integer.parseInt(height);

                if(sex.equalsIgnoreCase("M") &&  x < 160) {
                        int weight = x - 100;
                        label.setText("Trebuie sa ai " + weight);
                }
                if(sex.equalsIgnoreCase("F") &&  x < 150) {
                    int weight = x - 100;
                    label.setText("Trebuie sa ai " + weight);
                }
                if(sex.equalsIgnoreCase("M") &&  x >= 160) {
                  double weight = (x-100) * 0.9;
                    label.setText("Trebuie sa ai " + weight);
                }

                if(sex.equalsIgnoreCase("F") &&  x >= 150) {
                    double weight = (x-100) * 0.9;
                    label.setText("Trebuie sa ai " + weight);
                }
            }
        });

        GridPane.setConstraints(textFieldSex, 0, 0);
        GridPane.setConstraints(textFieldHeight, 0, 1);
        GridPane.setConstraints(button, 0, 2);
        GridPane.setConstraints(label, 0, 3);
        gridPane.getChildren().addAll(textFieldSex, textFieldHeight, button, label);
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.show();


    }
}
