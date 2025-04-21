# WorkoutLoggerApp

## Overview
The Workout Logger App is a JavaFX desktop application that allows users to log daily workout sessions, including type, duration, sets, reps, weight, and notes. The app saves workout data using serialization and provides progress tracking with a weekly summary.

## Features
- Add and log workouts
- Save/load workouts from a file
- View weekly workout summaries
- Clear output
- Built with JavaFX

## How to Run
1. Ensure you have Java 17+ and JavaFX SDK installed.
2. Open the project in IntelliJ.
3. Create a JAR by following the steps below.

## Creating a Runnable JAR
1. Go to `File > Project Structure > Artifacts`.
2. Click the `+` icon > `JAR > From modules with dependencies`.
3. Choose your main class: `workoutlogger.WorkoutLoggerApp`.
4. Check “Extract to the target JAR”.
5. Specify the JAR location (e.g., `WorkoutLoggerApp.jar`).
6. Click OK and then `Build > Build Artifacts > Build`.

## Running the JAR
From terminal or command prompt:
```bash
java --module-path /path/to/javafx-sdk-XX.X.X/lib --add-modules javafx.controls,javafx.fxml -jar WorkoutLoggerApp.jar