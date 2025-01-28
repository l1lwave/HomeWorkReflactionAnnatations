package task2;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface SaveTo {
    String path();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Saver {}


@SaveTo(path = "file.txt")
class TextContainer {
    String text = "Hello I love Java";

    @Saver
    public void saveText(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        try {
            writer.write(text);
        } finally {
            writer.close();
        }

    }
}
