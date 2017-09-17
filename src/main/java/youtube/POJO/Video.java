package youtube.POJO;

import java.util.List;

/**
 *
 * @author Sluski
 */
public class Video {
    private String videoLink;
    private String name;
    private String authorName;
    private String authorLink;
    private double lenght;
    private int views;
    private int likes;
    private int dislikes;
    private int komments;
    private List<String> topCommants;

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLink() {
        return authorLink;
    }

    public void setAuthorLink(String authorLink) {
        this.authorLink = authorLink;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getKomments() {
        return komments;
    }

    public void setKomments(int komments) {
        this.komments = komments;
    }

    public List<String> getTopCommants() {
        return topCommants;
    }

    public void setTopCommants(List<String> topCommants) {
        this.topCommants = topCommants;
    }

    
}
