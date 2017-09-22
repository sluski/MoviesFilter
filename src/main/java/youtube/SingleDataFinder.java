package youtube;

import java.io.IOException;
import java.util.ArrayList;
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
        video.setDislikes(findDislikes(videoUrl));
        video.setViews(findViews(page));
        video.setComments(findCommetsNumber(videoUrl));
        video.setTopCommants(findBestComments(videoUrl));
        video.setAuthorLink(findAuthorLink(videoUrl));
        video.setAuthorName(findAuthorName(videoUrl));
        return video;
    }

    private int findLikes(Document page) throws IOException {
        Integer result = 0;
        String resultString = page.select("span.like-button-renderer ").select("span.yt-uix-clickcard").select("span.yt-uix-button-content").first().text();
        List test = new ArrayList();
        char[] resultTable = new char[result];
        for (int i = 0; i < resultString.length(); i++) {
            resultTable = resultString.toCharArray();
        }
        for (int j = 0; j < resultTable.length; j++) {
            if(resultTable[j] != ' ') test.add(resultTable[j]);
        }
        result = Integer.parseInt(test.toString());
        return result;
    }

    private int findDislikes(String videoUrl) throws IOException {

        return 0;
    }

    private int findCommetsNumber(String videoUrl) throws IOException {

        return 0;
    }

    private List<Comment> findBestComments(String videoUrl) throws IOException {

        return null;
    }

    private double findLength(String videoUrl) throws IOException {

        return 0;
    }

    private int findViews(Document page) throws IOException {
        String result = page.select("div#watch7-views-info").select("div.watch-view-count").text();
        return result;
    }

    private String findAuthorName(String videoUrl) throws IOException {

        return null;
    }

    private String findAuthorLink(String videoUrl) throws IOException {

        return null;
    }
}
