package workoutlogger;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProgressTrackerTest {

    @Test
    void testUpdateAndCountDays() {
        ProgressTracker tracker = new ProgressTracker();
        tracker.updateProgress(LocalDate.of(2025, 4, 20));
        tracker.updateProgress(LocalDate.of(2025, 4, 21));

        assertEquals(2, tracker.getDaysWorkedOut());
    }

    @Test
    void testProgressSummary() {
        ProgressTracker tracker = new ProgressTracker();
        tracker.updateProgress(LocalDate.of(2025, 4, 20));
        tracker.updateProgress(LocalDate.of(2025, 4, 21));

        String summary = tracker.getProgressSummary();
        assertTrue(summary.contains("2025"));
    }
}