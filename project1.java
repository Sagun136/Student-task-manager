import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean isCompleted;

    Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
}

public class project1 {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Task
    public static void addTask() {
        System.out.print("Enter task: ");
        String name = sc.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added successfully!");
    }

    // View Tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }

        System.out.println("\n--- Task List ---");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println((i + 1) + ". " + t.name + " [" + (t.isCompleted ? "Done" : "Pending") + "]");
        }
    }

    // Complete Task
    public static void completeTask() {
        viewTasks();
        System.out.print("Enter task number to mark complete: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n < 1 || n > tasks.size()) {
            System.out.println("Invalid task number!");
            return;
        }

        tasks.get(n - 1).isCompleted = true;
        System.out.println("Task marked as completed!");
    }

    // Delete Task
    public static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n < 1 || n > tasks.size()) {
            System.out.println("Invalid task number!");
            return;
        }

        tasks.remove(n - 1);
        System.out.println("Task deleted successfully!");
    }

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("\n==== Student Task Manager ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: completeTask(); break;
                case 4: deleteTask(); break;
                case 5: 
                    System.out.println("Goodbye!");
                    return;
                default: 
                    System.out.println("Invalid choice!");
            }
        }
    }
}
