import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandling {
    private static void ReadAndFilterFile (String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String line;
        while ((line = br.readLine()) != null) {
        }
    }
    public static void main(String[] args) throws Exception {
        ReadAndFilterFile("C:/Users/PAZ/IdeaProjects/tryselenium/src/SecurityResultGitHub 06-06-19 18 11.txt");
    }
}
