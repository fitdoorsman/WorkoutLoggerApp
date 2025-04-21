package workoutlogger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class WorkoutLoggerApp extends Application {

    private final WorkoutLog workoutLog = new WorkoutLog();
    private final ProgressTracker progressTracker = new ProgressTracker();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Workout Logger");

        // Input fields
        TextField typeField = new TextField();
        TextField durationField = new TextField();
        TextField setsField = new TextField();
        TextField repsField = new TextField();
        TextField weightField = new TextField();
        TextArea notesField = new TextArea();

        typeField.setPrefWidth(250);
        notesField.setPrefRowCount(3);
        notesField.setWrapText(true);

        // Buttons
        Button logButton = new Button("Log Workout");
        Button viewProgressButton = new Button("View Progress");
        Button clearOutputButton = new Button("Clear Output");

        // Output area
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);
        outputArea.setPrefHeight(160);

        // Layout
        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);

        inputGrid.add(new Label("Type:"), 0, 0);
        inputGrid.add(typeField, 1, 0);

        inputGrid.add(new Label("Duration (min):"), 0, 1);
        inputGrid.add(durationField, 1, 1);

        inputGrid.add(new Label("Sets:"), 0, 2);
        inputGrid.add(setsField, 1, 2);

        inputGrid.add(new Label("Reps:"), 0, 3);
        inputGrid.add(repsField, 1, 3);

        inputGrid.add(new Label("Weight (lbs):"), 0, 4);
        inputGrid.add(weightField, 1, 4);

        inputGrid.add(new Label("Notes:"), 0, 5);
        inputGrid.add(notesField, 1, 5);

        HBox buttonRow = new HBox(10, logButton, viewProgressButton, clearOutputButton);
        VBox layout = new VBox(15, inputGrid, buttonRow, new Label("Logged Workouts & Progress:"), outputArea);
        layout.setPadding(new Insets(20));

        // Button Actions
        logButton.setOnAction(e -> {
            try {
                Workout workout = new Workout();
                workout.setType(typeField.getText());
                workout.setDuration(Integer.parseInt(durationField.getText()));
                workout.setSets(Integer.parseInt(setsField.getText()));
                workout.setReps(Integer.parseInt(repsField.getText()));
                workout.setWeight(Double.parseDouble(weightField.getText()));
                workout.setNotes(notesField.getText());

                workoutLog.addWorkout(workout);
                progressTracker.updateProgress(workout.getDate());

                outputArea.appendText(workout.toString() + "\n");

                typeField.clear();
                durationField.clear();
                setsField.clear();
                repsField.clear();
                weightField.clear();
                notesField.clear();
            } catch (Exception ex) {
                outputArea.appendText("Error: Please enter valid numbers for duration, sets, reps, and weight.\n\n");
            }
        });

        viewProgressButton.setOnAction(e -> {
            String summary = progressTracker.getProgressSummary();
            int totalDays = progressTracker.getDaysWorkedOut();
            outputArea.appendText("Total Days Worked Out: " + totalDays + "\n" + summary + "\n");
        });

        clearOutputButton.setOnAction(e -> outputArea.clear());

        primaryStage.setScene(new Scene(layout, 620, 600));
        primaryStage.setMinWidth(600);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}