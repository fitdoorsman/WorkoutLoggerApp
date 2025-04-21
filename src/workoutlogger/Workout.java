package workoutlogger;

import java.io.Serializable;
import java.time.LocalDate;

public class Workout implements Serializable {
    private String type;
    private int duration;
    private LocalDate date;
    private int sets;
    private int reps;
    private double weight;
    private String notes;

    public Workout() {
        this.date = LocalDate.now();
    }

    public Workout(String type, int duration, LocalDate date, int sets, int reps, double weight, String notes) {
        this.type = type;
        this.duration = duration;
        this.date = date != null ? date : LocalDate.now();
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.notes = notes;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

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
                "Date: %s\nWorkout Type: %s\nDuration: %d min\nSets: %d\nReps: %d\nWeight: %.1f lbs\nNotes: %s\n",
                date != null ? date.toString() : LocalDate.now(),
                type != null ? type : "N/A",
                duration, sets, reps, weight,
                (notes == null || notes.isEmpty()) ? "N/A" : notes
        );
    }
}