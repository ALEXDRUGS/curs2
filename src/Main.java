import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static java.time.LocalDate.parse;

public class Main {
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            System.out.print("Введите id задачи: ");
                            Integer id = scanner.nextInt();
                            Service service1 = new Service();
                            service1.deleteTask(id);
                            break;
                        case 3:
                            try {
                                System.out.print("Введите дату: ");
                                String localDateString = scanner.next();
                                LocalDate localDate = readDate(localDateString);
                                Service service = new Service();
                                service.getDateRepeatTask(localDate);
                            } catch (DateTimeParseException e) {
                                System.out.println("Неверный ввод. Введите дату: ");
                            }
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        try {
            System.out.print("1. Рабочая задача\n2. Личная задача\nВведите тип задачи: ");
            Integer taskType = scanner.nextInt();
            System.out.print("Введите название задачи: ");
            String taskName = scanner.next();
            System.out.print("Опишите задачу: ");
            String description = scanner.next();
            System.out.print("Введите дату в формате дд.мм.гггг: ");
            String taskDate = scanner.next();
            LocalDate date = readDate(taskDate);
            System.out.print("Введите время задачи в формате ЧЧ:мм: ");
            String taskTime = scanner.next();
            LocalTime time = readTime(taskTime);
            System.out.print("1.Одновременная задача\n2.Ежедневная задача\n3.Еженедельная задача\n4.Ежемесячная задача\n5.Ежегодная задача\nВведите повторяемость задачи: ");
            String repeatTask = readRepeatTask(scanner.next());
            Service taskService = new Service();
            taskService.addTask(taskType, taskName, description, date, time, repeatTask);
        } catch (Exception e) {
            System.out.println(" Неверный ввод ");
        }
    }

    private static String readRepeatTask(String repeatTask) {
        switch (repeatTask) {
            case "1":
                repeatTask = " однократная ";
                break;
            case "2":
                repeatTask = " ежедневная ";
                break;
            case "3":
                repeatTask = " еженедельная ";
                break;
            case "4":
                repeatTask = " ежемесячная ";
                break;
            case "5":
                repeatTask = " ежегодная ";
                break;
            default:
                return " однократная ";
        }
        return repeatTask;
    }

    private static LocalTime readTime(String taskTime) {
        return LocalTime.parse(taskTime, timeFormatter);
    }

    private static LocalDate readDate(String next) {
        return parse(next, dateFormatter);
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n0. Выход ");
    }
}