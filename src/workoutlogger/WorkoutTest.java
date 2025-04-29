package workoutlogger;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class WorkoutTest {

    @Test
    public void testWorkoutGettersAndSetters() {
        Workout workout = new Workout();
        workout.setName("Bench Press");
        workout.setType("Strength");
        workout.setDuration(45);
        workout.setDate(LocalDate.of(2025, 4, 21));
        workout.setSets(3);
        workout.setReps(10);
        workout.setWeight(100.0);
        workout.setNotes("Leg day");

        assertEquals("Bench Press", workout.getName());
        assertEquals("Strength", workout.getType());
        assertEquals(45, workout.getDuration());
        assertEquals(LocalDate.of(2025, 4, 21), workout.getDate());
        assertEquals(3, workout.getSets());
        assertEquals(10, workout.getReps());
        assertEquals(100.0, workout.getWeight());
        assertEquals("Leg day", workout.getNotes());
    }

    @Test
    public void testToString() {
        Workout workout = new Workout();
        workout.setName("Deadlift");
        workout.setType("Strength");
        workout.setDuration(60);
        workout.setSets(4);
        workout.setReps(6);
        workout.setWeight(315.0);
        workout.setNotes("Heavy day");

        String output = workout.toString();
        assertTrue(output.contains("Deadlift"));
        assertTrue(output.contains("Strength"));
        assertTrue(output.contains("60"));
        assertTrue(output.contains("315.0"));
        assertTrue(output.contains("Heavy day"));
    }

    @Test
    public void testNameField() {
        Workout workout = new Workout();
        workout.setName("Squat");
        assertEquals("Squat", workout.getName());
    }

    @Test
    public void testToStringIncludesName() {
        Workout workout = new Workout();
        workout.setName("Overhead Press");
        workout.setType("Strength");
        workout.setDuration(30);
        workout.setSets(3);
        workout.setReps(8);
        workout.setWeight(95.0);
        workout.setNotes("Form check");

        String result = workout.toString();
        assertTrue(result.contains("Overhead Press"));
        assertTrue(result.contains("Strength"));
        assertTrue(result.contains("30"));
        assertTrue(result.contains("95.0"));
        assertTrue(result.contains("Form check"));
    }
}