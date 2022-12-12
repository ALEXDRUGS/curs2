import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Service {
    private static final Map<Integer, Task> taskMap = new TreeMap<>();
    private PersonalTask personalTask;
    private WorkTask workTask;
    public Integer id;
    public static int count = 1;

    public Service() {
    }

    public void addTask(Integer taskType, String taskName, String description, LocalDate date, LocalTime time,
                        String repeatTask) {
        id = count++;
        if (taskType == 2) {
            personalTask = new PersonalTask(taskName, description, date, time, repeatTask, id);
            taskMap.put(personalTask.getId(), personalTask);
            System.out.println("Задача добавлена " + taskMap.get(personalTask.getId()));
        } else {
            workTask = new WorkTask(taskName, description, date, time, repeatTask, id);
            taskMap.put(workTask.getId(), workTask);
            System.out.println("Задача добавлена " + taskMap.get(workTask.getId()));
        }
    }

    public void getDateRepeatTask(LocalDate localDate) {
        for (Task task : taskMap.values()) {
            if (taskMap.values().iterator().next().getDate().equals(localDate)) {
                if (task.getRepeatTask().equals(" однократная ")) {
                    System.out.println(task);
                }
                if (task.getRepeatTask().equals(" ежедневная ")) {
                    System.out.println(task + " Следующая дата задачи: " + localDate.plusDays(1));
                }
                if (task.getRepeatTask().equals(" еженедельная ")) {
                    System.out.println(task + " Следующая дата задачи: " + localDate.plusWeeks(1));
                }
                if (task.getRepeatTask().equals(" ежемесячная ")) {
                    System.out.println(task + " Следующая дата задачи: " + localDate.plusMonths(1));
                }
                if (task.getRepeatTask().equals(" ежегодная ")) {
                    System.out.println(task + " Следующая дата задачи: " + localDate.plusYears(1));
                }

            }
        }
    }

    public void deleteTask(Integer id) {
        taskMap.remove(id, taskMap.get(id));
        System.out.println("Задача успешно удалена");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return personalTask.equals(service.personalTask) && workTask.equals(service.workTask) && id.equals(service.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalTask, workTask, id);
    }
}
