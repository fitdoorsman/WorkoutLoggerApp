package workoutlogger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WorkoutLoggerApp extends Application {
    private WorkoutLog log = new WorkoutLog();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Workout Logger");
        primaryStage.getIcons().add(new Image(getClass().getResource("/images/icon.png").toString()));

        Label titleLabel = new Label("Daily Workout Entry");
        titleLabel.getStyleClass().add("title-label");

        Label typeLabel = new Label("Type:");
        ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Cardio", "Strength", "Flexibility");

        Label nameLabel = new Label("Exercise Name:");
        TextField nameField = new TextField();

        Label durationLabel = new Label("Duration (min):");
        TextField durationField = new TextField();

        Label setsLabel = new Label("Sets:");
        TextField setsField = new TextField();

        Label repsLabel = new Label("Reps:");
        TextField repsField = new TextField();

        Label weightLabel = new Label("Weight (lbs):");
        TextField weightField = new TextField();

        Label notesLabel = new Label("Notes:");
        TextField notesField = new TextField();

        Button logButton = new Button("Log Workout");
        Button viewProgressButton = new Button("View Progress");
        Button clearButton = new Button("Clear Output");

        logButton.getStyleClass().add("log-button");
        viewProgressButton.getStyleClass().add("progress-button");
        clearButton.getStyleClass().add("clear-button");

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.getStyleClass().add("text-area");

        GridPane inputGrid = new GridPane();
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setPadding(new Insets(20));
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);

        typeLabel.setMinWidth(120);
        nameLabel.setMinWidth(120);
        durationLabel.setMinWidth(120);
        setsLabel.setMinWidth(120);
        repsLabel.setMinWidth(120);
        weightLabel.setMinWidth(120);
        notesLabel.setMinWidth(120);

        inputGrid.add(typeLabel, 0, 0);         inputGrid.add(typeBox, 1, 0);
        inputGrid.add(nameLabel, 0, 1);         inputGrid.add(nameField, 1, 1);
        inputGrid.add(durationLabel, 0, 2);     inputGrid.add(durationField, 1, 2);
        inputGrid.add(setsLabel, 0, 3);         inputGrid.add(setsField, 1, 3);
        inputGrid.add(repsLabel, 0, 4);         inputGrid.add(repsField, 1, 4);
        inputGrid.add(weightLabel, 0, 5);       inputGrid.add(weightField, 1, 5);
        inputGrid.add(notesLabel, 0, 6);        inputGrid.add(notesField, 1, 6);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(logButton, viewProgressButton, clearButton);

        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(titleLabel, inputGrid, buttonBox, outputArea);

        logButton.setOnAction(e -> {
            try {
                Workout workout = new Workout();
                workout.setType(typeBox.getValue());
                workout.setName(nameField.getText());
                workout.setDuration(Integer.parseInt(durationField.getText()));
                workout.setSets(Integer.parseInt(setsField.getText()));
                workout.setReps(Integer.parseInt(repsField.getText()));
                workout.setWeight(Double.parseDouble(weightField.getText()));
                workout.setNotes(notesField.getText());
                workout.setDate(java.time.LocalDate.now());

                log.addWorkout(workout);
                outputArea.appendText("Workout logged: " + workout + "\n");

                typeBox.setValue(null);
                nameField.clear(); durationField.clear(); setsField.clear();
                repsField.clear(); weightField.clear(); notesField.clear();
            } catch (Exception ex) {
                outputArea.appendText("Error: Invalid input.\n");
            }
        });

        viewProgressButton.setOnAction(e ->
                outputArea.appendText("\nWeekly Progress:\n" + log.getWeeklySummary() + "\n")
        );

        clearButton.setOnAction(e -> outputArea.clear());

        Scene scene = new Scene(mainLayout, 500, 650);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}