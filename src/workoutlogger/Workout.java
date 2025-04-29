package workoutlogger;

import java.io.Serializable;
import java.time.LocalDate;

public class Workout implements Serializable {
    private String type;
    private String name;     // NEW - Exercise Name
    private int duration;
    private LocalDate date;
    private int sets;
    private int reps;
    private double weight;
    private String notes;

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }

    public int getReps() { return reps; }
    public void setReps(int reps) { this.reps = reps; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return String.format(
                "Workout Type: %s | Name: %s | Duration: %d min | Sets: %d | Reps: %d | Weight: %.1f lbs | Notes: %s",
                type,
                (name == null || name.isEmpty()) ? "N/A" : name,
                duration,
                sets,
                reps,
                weight,
                (notes == null || notes.isEmpty()) ? "N/A" : notes
        );
    }
}