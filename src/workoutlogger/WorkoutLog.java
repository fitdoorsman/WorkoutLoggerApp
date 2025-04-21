package workoutlogger;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkoutLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Workout> workouts;

    public WorkoutLog() {
        workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public Workout getWorkoutByDate(LocalDate date) {
        for (Workout workout : workouts) {
            if (workout.getDate().equals(date)) {
                return workout;
            }
        }
        return null;
    }

    public List<Workout> getAllWorkouts() {
        return workouts;
    }

    public String getWeeklySummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weekly Summary:\n");
        for (Workout workout : workouts) {
            sb.append(workout.toString()).append("\n");
        }
        return sb.toString();
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Workout log saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving workout log: " + e.getMessage());
        }
    }

    public static WorkoutLog loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (WorkoutLog) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading workout log: " + e.getMessage());
            return new WorkoutLog(); // Return empty log if failed
        }
    }
}