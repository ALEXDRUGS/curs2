import java.time.LocalDate;
import java.time.LocalTime;

public class PersonalTask extends Task {
    private final Integer id;

    public PersonalTask(String taskName, String description, LocalDate date, LocalTime time,
                        String repeatTask, Integer id) {
        super(taskName, description, date, time, repeatTask);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + getId();
    }

}
