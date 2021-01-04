package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Manual {
    String path;
    List<String> manualLines;

    Manual(String path) throws IOException {
        this.path = path;
        Path manualPath = Paths.get(this.path);
        this.manualLines = Files.readAllLines(manualPath);
    }

    public void printManual() {
        for (int i = 0; i < manualLines.size(); i++) {
            System.out.println(manualLines.get(i));
        }
    }
}
