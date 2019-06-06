import java.util.List;

public class GithubRepository {
    String title;
    transient String description;
    List<String> tags;
    transient String time;
    String language;
    transient String stars;

    public GithubRepository (String title, String description,List<String> tags, String time, String language, String stars) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.time = time;
        this.language = language;
        this.stars = stars;
    }
}
