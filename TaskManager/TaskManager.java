import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManager {

    private int id;
    private ArrayList<Task> tasks;
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    final String[] mainMenu = {
            "1 - создать задачу",
            "2 - удалить задачу",
            "3 - отредактировать задачу",
            "4 - вывести список всех задач",
            "5 - вывести список выполненных задач",
            "6 - вывести список невыполненных задач",
            "7 - просмотреть информацию о задаче",
            "0 - выход",
            "=================="
    };

    final String[] editMenu = {
            "Редактирование задачи: ",
            "1 - редактировать название",
            "2 - редактировать описание",
            "3 - изменить дату создания",
            "4 - изменить дату выполнения",
            "5 - отметить как выполненную",
            "0 - выход",
            "=================="
    };

    final String[] outputMenu = {
            "1 - все",
            "2 - по дате создания",
            "3 - по дате выполнения",
            "0 - выход",
            "=================="
    };

    TaskManager() {
        id = 1;
        tasks = new ArrayList<Task>();
    }

    // печать меню
    public void printMenu(String[] menu) {
        System.out.println("==================");
        System.out.println("Введите команду:");
        for (String item : menu) {
            System.out.println(item);
        }
    }

    // главная функция, запускающая основное меню
    public void start() {

        printMenu(mainMenu);

        loop: while (true) {
            try {
                int cmd = scanner.nextInt();
                switch (cmd) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                        editTask();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        output(cmd);
                        break;
                    case 7:
                        taskInfo();
                        break;
                    case 0:
                        break loop;
                    default:
                        System.out.println("Попробуйте еще раз");
                }
            } catch (InputMismatchException e) {
            }
        }
    }

    // проверка на ввод даты
    private LocalDate inputDate() {
        LocalDate finalDate;
        while (true) {
            try {
                System.out.println("Введите дату в формате ДД-ММ-ГГГГ: ");
                String date = scanner.next();
                finalDate = LocalDate.parse(date, formatter);
            } catch (java.time.format.DateTimeParseException e) {
                continue;
            }
            break;
        }
        return finalDate;
    }

    // добавление задачи
    private void addTask() {

        System.out.println("Введите имя задачи: ");
        String name = scanner.next();

        System.out.println("Введите описание: ");
        String description = scanner.next();

        LocalDate endDate;
        System.out.println("Введите дату выполнения: ");
        endDate = inputDate();
        tasks.add(new Task(id++, name, description, LocalDate.now(), endDate));

        printMenu(mainMenu);
    }

    // удадение задачи
    private void removeTask() {
        try {
            System.out.println("Введите номер задачи: ");
            tasks.remove(scanner.nextInt() - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса");
        }

        printMenu(mainMenu);
    }

    // редактирование задачи
    private void editTask() {

        System.out.println("Введите номер задачи: ");
        try {
            int taskId = scanner.nextInt() - 1;
            try {
                Task currTask = tasks.get(taskId);
                System.out.println(currTask);
                try {
                    printMenu(editMenu);
                    int cmd = scanner.nextInt();
                    switch (cmd) {
                        case 1:
                            System.out.println("Новое имя:");
                            currTask.setName(scanner.next());
                            break;
                        case 2:
                            System.out.println("Новое описание:");
                            currTask.setDescription(scanner.next());
                            break;
                        case 3:
                            System.out.println("Новая дата создания:");
                            currTask.setStartDate(inputDate());
                            break;
                        case 4:
                            System.out.println("Новая дата выполнения");
                            currTask.setEndDate(inputDate());
                        case 5:
                            System.out.println("Задача выполнена!");
                            currTask.isComplete = true;
                            currTask.setEndDate(LocalDate.now());
                            break;
                        case 0:
                            break;
                        default:
                            break;
                    }
                } catch (InputMismatchException e) {
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ошибка индекса");
            }
        } catch (InputMismatchException e) {
        }

        printMenu(mainMenu);
    }

    // меню вывода списка задач
    private void output(int mode) {
        // 4 - все задачи
        // 5 - все выполненные задачи
        // 6 - все невыполненные задачи
        LocalDate date = null;
        System.out.println("Какие задачи требуется показать? ");
        try {
            printMenu(outputMenu);
            int cmd = scanner.nextInt();
            switch (cmd) {
                case 1:
                    break;
                case 2:
                    date = inputDate();
                    break;
                case 3:
                    date = inputDate();
                    break;
                case 0:
                    break;
                default:
                    break;
            }

            switch (mode) {
                case 4: // вывести все задачи
                    if (date == null) {
                        showAllTasks();
                    } else {
                        showAllTasks(date, cmd);
                    }
                    break;
                case 5: // вывести выполненные задачи
                    if (date == null) {
                        showTasksDone(true);
                    } else {
                        showTasksDone(true, date, cmd);
                    }
                    break;
                case 6: // вывести невыполненные задачи
                    if (date == null) {
                        showTasksDone(false);
                    } else {
                        showTasksDone(false, date, cmd);
                    }
                    break;
            }
        } catch (InputMismatchException e) {}

        printMenu(mainMenu);
    }

    // показать все задачи вне зависимости от даты
    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список пустой");
            return;
        }

        System.out.println("Список задач: ");
        for (Task task : tasks) {
            System.out.println(task.getId() + " - " + task.getName());
        }
    }

    // показать все задачи на дату
    public void showAllTasks(LocalDate date, int cmd) {
        
        if (tasks.isEmpty()) {
            System.out.println("Список пустой");
            return;
        }

        System.out.println("Список задач: ");
        for (Task task : tasks) {
            if (cmd == 2) {
                if (task.getStartDate().equals(formatter.format(date)) ) {
                    System.out.println(task.getId() + " - " + task.getName());
                }
            } else if (cmd == 3) {
                if (task.getEndDate().equals(formatter.format(date)) ) {
                    System.out.println(task.getId() + " - " + task.getName());
                }
            }
        }
    }

    // показать все выполненные/невыполненные задачи вне зависимости от даты
    public void showTasksDone(boolean flag) {
        
        if (tasks.isEmpty()) {
            System.out.println("Список пустой");
            return;
        }

        System.out.println("Список задач: ");
        for (Task task : tasks) {
            if (task.isComplete == flag) {
                System.out.println(task.getId() + " - " + task.getName());
            }
        }
    }

    // показать выполненные/невыполненные задачи на дату
    public void showTasksDone(boolean flag, LocalDate date, int cmd) {
        
        if (tasks.isEmpty()) {
            System.out.println("Список пустой");
            return;
        }

        System.out.println("Список задач: ");
        for (Task task : tasks) {
            if (cmd == 2) {
                if (task.getStartDate().equals(formatter.format(date)) 
                    && task.isComplete == flag) {
                    System.out.println(task.getId() + " - " + task.getName());
                }
            } else if (cmd == 3) {
                if (task.getEndDate().equals(formatter.format(date)) 
                    && task.isComplete == flag) {
                    System.out.println(task.getId() + " - " + task.getName());
                }
            }
        }
    }

    // вывод подробной информации о задаче
    private void taskInfo() {
        System.out.println("Введите номер задачи: ");
        
        try {
            int taskId = scanner.nextInt() - 1;
            try {
                Task currTask = tasks.get(taskId);
                System.out.println(currTask);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ошибка индекса");
            }
        } catch (InputMismatchException e) {}

        printMenu(mainMenu);
    }
}
