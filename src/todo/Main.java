package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> content = new ArrayList();
        content.add("Kutyát sétáltatni");
        content.add("Tejet venni");
        content.add("Megcsinálni a leckét");

        try {
            Path filePath = Paths.get("C:\\Users\\zsolt\\code\\greenfox\\todo_app\\todos.txt");
            Files.write(filePath, content);
        } catch (Exception e) {
            System.out.println("Uh-oh, could not write the file!");
        }

        if (args.length > 0) {
            System.out.println("Hello" + args[0]);

            if (args[0].equals("-l")) {
                Path todosPath = Paths.get("C:\\Users\\zsolt\\code\\greenfox\\todo_app\\todos.txt");
                List<String> todoLines = Files.readAllLines(todosPath);

                for (int i = 0; i < todoLines.size(); i++) {
                    System.out.println(i+1 + " - " + todoLines.get(i));
                }
            }

        } else {
            Path manualPath = Paths.get("C:\\Users\\zsolt\\code\\greenfox\\todo_app\\manual.txt");
            List<String> manualLines = Files.readAllLines(manualPath);

            for (int i = 0; i < manualLines.size(); i++) {
                System.out.println(manualLines.get(i));
            }
        }
    }
}
