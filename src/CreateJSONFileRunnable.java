import java.io.IOException;

public class CreateJSONFileRunnable implements Runnable{
    String line;
    int index;

    public CreateJSONFileRunnable(String line, int index) {
        this.line = line;
        this.index = index;
    }

    public void run() {
        try {
            FileHandling.CreateJSONFile(line, index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
