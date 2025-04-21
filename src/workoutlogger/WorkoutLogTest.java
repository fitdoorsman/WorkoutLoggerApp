package workoutlogger;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutLogTest {

    @Test
    void testAddAndRetrieveWorkout() {
        WorkoutLog log = new WorkoutLog();
        Workout workout = new Workout();
        LocalDate date = LocalDate.of(2025, 4, 21);
        workout.setDate(date);
        log.addWorkout(workout);

        Workout retrieved = log.getWorkoutByDate(date);
        assertEquals(workout, retrieved);
    }

    @Test
    void testGetAllWorkouts() {
        WorkoutLog log = new WorkoutLog();
        log.addWorkout(new Workout());
        log.addWorkout(new Workout());

        List<Workout> all = log.getAllWorkouts();
        assertEquals(2, all.size());
    }
}