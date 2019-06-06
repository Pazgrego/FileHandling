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
        int index = 1;

        while ((line = br.readLine()) != null) {
            CreateJSONFile(gson, line, index);
            index++;
        }
    }

    private static void CreateJSONFile(Gson gson, String line, int index) throws IOException {
        GithubRepository repo = gson.fromJson(line, GithubRepository.class);
        FileWriter writer = new FileWriter("SecurityResultGitHub-" + index  + " " + getCurrentTime() + ".txt");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(gson.toJson(repo));

        bw.flush();
        bw.close();
    }

    private static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH mm ss");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

    public static void main(String[] args) throws Exception {
        ReadAndFilterFile("C:/Users/PAZ/IdeaProjects/tryselenium/src/SecurityResultGitHub 06-06-19 18 11.txt");
    }
}
