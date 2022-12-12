import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Task {
    private final String taskName;
    private final String description;
    private final LocalDate date;
    private final LocalTime time;
    private final String repeatTask;

    public Task(String taskName, String description, LocalDate date, LocalTime time, String repeatTask) {
        this.taskName = taskName;
        this.description = description;
        this.date = date;
        this.time = time;
        this.repeatTask = repeatTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getRepeatTask() {
        return repeatTask;
    }

    @Override
    public String toString() {
        return taskName + " "
                + description + " "
                + date + " "
                + time + " Повторяемость "
                + repeatTask + " id ";
    }
}
