package youtube;

import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Document;
import youtube.POJO.Comment;
import youtube.POJO.Video;

/**
 *
 * To do:
 * solve with string in findLikes  and findView 
 * convert to integer (class?) 
 * 
 * 
 * @author Sluski
 */
public class SingleDataFinder {

    DocumentDownloader docDownloader;

    public SingleDataFinder() {
        docDownloader = new DocumentDownloader();
    }

    public Video findVideoDetail(String videoUrl) throws IOException {
        Document page = docDownloader.getPageDocument(videoUrl);
        Video video = new Video();
        video.setLikes(findLikes(page));
        video.setDislikes(findDislikes(page));
        video.setViews(findViews(page));
        video.setComments(findCommetsNumber(page));
        video.setTopCommants(findBestComments(page));
        video.setAuthorLink(findAuthorLink(page));
        video.setAuthorName(findAuthorName(page));
        return video;
    }

    private int findLikes(Document page) throws IOException {
        String resultString = page.select("span.like-button-renderer ").select("span.yt-uix-clickcard").select("span.yt-uix-button-content").first().text();
        int result = Integer.parseInt(resultString.replaceAll("[^0-9.]", ""));
        return result;
    }

    private int findDislikes(Document page) throws IOException {
        String resultString = page.getElementsByAttributeValue("data-position", "bottomright").get(2).text();
        int result = Integer.parseInt(resultString.replaceAll("[^0-9.]", ""));
        return result;
    }

    private int findCommetsNumber(Document page) throws IOException {

        return 0;
    }

    private List<Comment> findBestComments(Document page) throws IOException {

        return null;
    }

    private double findLength(Document page) throws IOException {

        return 0;
    }

    private int findViews(Document page) throws IOException {
        String resultString = page.select("div#watch7-views-info").select("div.watch-view-count").text();
        int result =  Integer.parseInt(resultString.replaceAll("[^0-9.]", ""));
        return result;
    }

    private String findAuthorName(Document page) throws IOException {
        String result = page.select("div.yt-user-info").select("a").text();
        return result;
    }

    private String findAuthorLink(Document page) throws IOException {
        String result = page.select("div.yt-user-info").select("a").attr("href");
        return "https://www.youtube.com" + result;
    }
    
}
