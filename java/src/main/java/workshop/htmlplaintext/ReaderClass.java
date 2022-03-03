package workshop.htmlplaintext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderClass {
    String path;

    public ReaderClass(String path) {
        this.path = path;
    }

    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
