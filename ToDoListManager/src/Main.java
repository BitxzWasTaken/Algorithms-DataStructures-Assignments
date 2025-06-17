import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];
    private static int userCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Create User");
            System.out.println("2. Select User");
            System.out.println("3. View All Users");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> createUser();
                case "2" -> selectUser();
                case "3" -> viewUsers();
                case "4" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please enter 1–4.");
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter new username: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        if (getUserByName(name) != null) {
            System.out.println("User with name '" + name + "' already exists.");
            return;
        }

        if (userCount >= users.length) {
            System.out.println("User limit reached.");
            return;
        }

        users[userCount++] = new User(name);
        System.out.println("User '" + name + "' created successfully.");
    }

    private static void selectUser() {
        System.out.print("Enter username to select: ");
        String name = scanner.nextLine().trim();
        User user = getUserByName(name);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        while (true) {
            System.out.println("\n--- User Menu (" + user.getName() + ") ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Tasks");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine().trim();
                    if (!desc.isEmpty()) {
                        user.addTask(desc);
                        System.out.println("Task added.");
                    } else {
                        System.out.println("Task description cannot be empty.");
                    }
                }
                case "2" -> {
                    System.out.print("Enter task to mark as completed: ");
                    String desc = scanner.nextLine().trim();
                    user.completeTask(desc);
                }
                case "3" -> user.printTasks();
                case "4" -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewUsers() {
        if (userCount == 0) {
            System.out.println("No users created yet.");
            return;
        }

        System.out.println("Existing users:");
        for (int i = 0; i < userCount; i++) {
            System.out.println("- " + users[i].getName());
        }
    }

    private static User getUserByName(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }
}