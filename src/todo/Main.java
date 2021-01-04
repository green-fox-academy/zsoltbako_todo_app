package todo;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {

        String todoFilePath = "C:\\Users\\zsolt\\code\\greenfox\\todo_app\\todos.txt";
        String manualFilePath = "C:\\Users\\zsolt\\code\\greenfox\\todo_app\\manual.txt";

        TodoList todoList = new TodoList(todoFilePath);
        Manual manual = new Manual(manualFilePath);

        if (args.length > 0) {
            if (args[0].equals("-l")) {
                //Print todo
                todoList.printList();
            } else if (args[0].equals("-a")) {
                //Add new todo item
                todoList.tasks.add(new TodoItem(args[1]));
                todoList.OverWriteTodosFile();
            } else if (args[0].equals("-r")) {
                //Remove todo item
                todoList.tasks.remove(parseInt(args[1])-1);
                todoList.OverWriteTodosFile();
            } else {
                System.out.println("Nem támogatott argumantum!");
                System.out.println("=============================");
                manual.printManual();
            }

        } else {
            manual.printManual();
        }
    }
}
