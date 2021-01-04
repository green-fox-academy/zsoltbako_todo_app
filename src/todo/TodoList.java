package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
    ArrayList<TodoItem> tasks;
    String path;

    TodoList(String path) throws IOException {
        this.path = path;
        Path todosPath = Paths.get(this.path);
        List<String> todosLines = Files.readAllLines(todosPath);

        this.tasks = new ArrayList();

        for (int i = 0; i < todosLines.size(); i++) {
            TodoItem todoItem = new TodoItem(todosLines.get(i));
            if (todosLines.get(i).length() > 0) {
                this.tasks.add(todoItem);
            }
        }
    }

    public void printList() {
        if (this.tasks.size() >0 ) {
            for (int i = 0; i < this.tasks.size(); i++) {
                System.out.println((i+1) + " - " + tasks.get(i).name);
            }
        } else {
            System.out.println("Nincs mára tennivalód! :)");
        }
    }

    public void OverWriteTodosFile() {
        try {
            Path filePath = Paths.get(this.path);
            List<String> updatedList = new ArrayList();
            for (int i = 0; i < tasks.size(); i++) {
                updatedList.add(tasks.get(i).name);
            }
            Files.write(filePath, updatedList);
        } catch (Exception e) {
            System.out.println("Uh-oh, could not write the file!");
        }
    }
}
