package workoutlogger;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProgressTracker implements Serializable {
    private Map<LocalDate, Boolean> workoutDays;

    public ProgressTracker() {
        workoutDays = new HashMap<>();
    }

    public void updateProgress(LocalDate date) {
        workoutDays.put(date, true);
    }

    public String getProgressSummary() {
        StringBuilder summary = new StringBuilder("Progress Summary:\n");
        for (Map.Entry<LocalDate, Boolean> entry : workoutDays.entrySet()) {
            summary.append(entry.getKey()).append(": ")
                    .append(entry.getValue() ? "Worked Out" : "Rest Day").append("\n");
        }
        return summary.toString();
    }

    public int getDaysWorkedOut() {
        int count = 0;
        for (Boolean workedOut : workoutDays.values()) {
            if (workedOut) {
                count++;
            }
        }
        return count;
    }
}