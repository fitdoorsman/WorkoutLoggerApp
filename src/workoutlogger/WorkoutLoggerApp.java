package workoutlogger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WorkoutLoggerApp extends Application {
    private WorkoutLog log = new WorkoutLog();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Workout Logger");

        // Labels and Input Fields
        Label titleLabel = new Label("Daily Workout Entry");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

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

        // Buttons
        Button logButton = new Button("Log Workout");
        Button viewProgressButton = new Button("View Progress");
        Button clearButton = new Button("Clear Output");

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        // Layout: GridPane for Inputs
        GridPane inputGrid = new GridPane();
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setPadding(new Insets(20));
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);

        // Label Widths
        typeLabel.setMinWidth(120);
        nameLabel.setMinWidth(120);
        durationLabel.setMinWidth(120);
        setsLabel.setMinWidth(120);
        repsLabel.setMinWidth(120);
        weightLabel.setMinWidth(120);
        notesLabel.setMinWidth(120);

        // Add to Grid
        inputGrid.add(typeLabel, 0, 0);
        inputGrid.add(typeBox, 1, 0);

        inputGrid.add(nameLabel, 0, 1);
        inputGrid.add(nameField, 1, 1);

        inputGrid.add(durationLabel, 0, 2);
        inputGrid.add(durationField, 1, 2);

        inputGrid.add(setsLabel, 0, 3);
        inputGrid.add(setsField, 1, 3);

        inputGrid.add(repsLabel, 0, 4);
        inputGrid.add(repsField, 1, 4);

        inputGrid.add(weightLabel, 0, 5);
        inputGrid.add(weightField, 1, 5);

        inputGrid.add(notesLabel, 0, 6);
        inputGrid.add(notesField, 1, 6);

        // Button Layout
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(logButton, viewProgressButton, clearButton);

        // Main Layout
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(titleLabel, inputGrid, buttonBox, outputArea);

        // Button Actions
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

                // Clear fields after logging
                typeBox.setValue(null);
                nameField.clear();
                durationField.clear();
                setsField.clear();
                repsField.clear();
                weightField.clear();
                notesField.clear();
            } catch (Exception ex) {
                outputArea.appendText("Error: Invalid input.\n");
            }
        });

        viewProgressButton.setOnAction(e -> {
            outputArea.appendText("\nWeekly Progress:\n");
            outputArea.appendText(log.getWeeklySummary() + "\n");
        });

        clearButton.setOnAction(e -> outputArea.clear());

        // Set and Show Scene
        Scene scene = new Scene(mainLayout, 500, 650); // Slightly taller to fit extra field
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}