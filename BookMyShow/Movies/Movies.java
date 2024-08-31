package problems.BookMyShow.Movies;

public class Movies {
    private String title;
    private String description;
    private double duration;
    private String lang;

    public Movies(String title, String description, double duration, String lang) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getDuration() {
        return duration;
    }

    public String getLang() {
        return lang;
    }
}
