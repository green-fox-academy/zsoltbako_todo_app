package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<TodoItem> todoList = new ArrayList();

        Path todosPath = Paths.get("C:\\Users\\zsolt\\code\\greenfox\\todo_app\\todos.txt");
        List<String> todosLines = Files.readAllLines(todosPath);

        for (int i = 0; i < todosLines.size(); i++) {
            TodoItem todoItem = new TodoItem(todosLines.get(i));
            if (todosLines.get(i).length() > 0) {
                todoList.add(todoItem);
            }
        }

        if (args.length > 0) {
            System.out.println("CLI argument: " + args[0]);

            if (args[0].equals("-l")) {
                //Print todos
                if (todoList.size() == 0) {
                    System.out.println("Nincs mára tennivalód! :)");
                } else {
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + " - " + todoList.get(i).name);
                    }
                }
            } else if (args[0].equals("-a")) {
                //Add new todo item
                todoList.add(new TodoItem(args[1]));
                OverwriteTodosFile(todoList);
            } else if (args[0].equals("-r")) {
                //Remove todo item
                todoList.remove(parseInt(args[1])-1);
                System.out.println(todoList.size());
                OverwriteTodosFile(todoList);
            }

        } else {
            PrintManual();
        }
    }

    public static void PrintManual() throws IOException {
        Path manualPath = Paths.get("C:\\Users\\zsolt\\code\\greenfox\\todo_app\\manual.txt");
        List<String> manualLines = Files.readAllLines(manualPath);

        for (int i = 0; i < manualLines.size(); i++) {
            System.out.println(manualLines.get(i));
        }
    }

    public static void OverwriteTodosFile(ArrayList<TodoItem> todoList) {
        try {
            Path filePath = Paths.get("C:\\Users\\zsolt\\code\\greenfox\\todo_app\\todos.txt");
            List<String> todoListString = new ArrayList();
            for (int i = 0; i < todoList.size(); i++) {
                todoListString.add(todoList.get(i).name);
            }
            Files.write(filePath, todoListString);
        } catch (Exception e) {
            System.out.println("Uh-oh, could not write the file!");
        }
    }
}
