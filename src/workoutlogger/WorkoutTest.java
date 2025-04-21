package workoutlogger;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {

    @Test
    void testWorkoutGettersAndSetters() {
        Workout workout = new Workout();
        workout.setType("Strength");
        workout.setDuration(45);
        workout.setDate(LocalDate.of(2025, 4, 21));
        workout.setSets(4);
        workout.setReps(10);
        workout.setWeight(100.0);
        workout.setNotes("Leg day");

        assertEquals("Strength", workout.getType());
        assertEquals(45, workout.getDuration());
        assertEquals(LocalDate.of(2025, 4, 21), workout.getDate());
        assertEquals(4, workout.getSets());
        assertEquals(10, workout.getReps());
        assertEquals(100.0, workout.getWeight(), 0.001);
        assertEquals("Leg day", workout.getNotes());
    }

    @Test
    void testToString() {
        Workout workout = new Workout();
        workout.setType("Cardio");
        workout.setDuration(30);
        workout.setDate(LocalDate.of(2025, 4, 22));
        workout.setSets(0);
        workout.setReps(0);
        workout.setWeight(0.0);
        workout.setNotes("Morning jog");

        String result = workout.toString();
        assertTrue(result.contains("Cardio"));
        assertTrue(result.contains("Morning jog"));
    }
}