import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileHandling {
    private static void ReadAndFilterFile (String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int index = 1;

        while ((line = br.readLine()) != null) {
           CreateJSONFileRunnable th = new CreateJSONFileRunnable(line, index);
           new Thread(th).start();
           index++;
        }
    }

    public static void CreateJSONFile( String line, int index) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

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
        if(args != null && args.length > 0){
            ReadAndFilterFile(args[0]);
        }
        else {
            System.out.println("Enter a path to JSON file");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            ReadAndFilterFile(path.substring(1, path.length()-2));
        }
    }
}
