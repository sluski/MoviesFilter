package youtube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import youtube.POJO.Comment;
import youtube.POJO.Video;

/**
 *
 * @author Sluski
 */
public class SingleDataFinder {
    
    DocumentDownloader docDownloader;
    
    public SingleDataFinder(){
        docDownloader =  new DocumentDownloader();
    }
    
    public Video findVideoDetail(String videoUrl) throws IOException{
        Document page = docDownloader.getPageDocument(videoUrl);
        Video video = new Video();
        video.setLikes(findLikes(page));
        video.setDislikes(findDislikes(videoUrl));
        video.setViews(findViews(videoUrl));
        video.setComments(findCommetsNumber(videoUrl));
        video.setTopCommants(findBestComments(videoUrl)); 
        video.setAuthorLink(findAuthorLink(videoUrl));
        video.setAuthorName(findAuthorName(videoUrl));
        return video;
    }
    
    private int findLikes(Document page) throws IOException{
        List<String> temp = new ArrayList();
        for(int i = 0; i < page.select("div.watch7-views-info").size(); i++){
            temp.add(page.select("div.watch-view-count").text());
        }
        
        return 0;
    }
    
    private int findDislikes(String videoUrl) throws IOException{

        return 0;
    }
    
    private int findCommetsNumber(String videoUrl) throws IOException{

        return 0;
    }
    
    private List<Comment> findBestComments(String videoUrl) throws IOException{

        return null;
    }
    
    private double findLength(String videoUrl) throws IOException{

        return 0;
    }
    
    private int findViews(String videoUrl) throws IOException{

        return 0;
    }
    
    private String findAuthorName(String videoUrl) throws IOException{

        return null;
    }
    
    private String findAuthorLink(String videoUrl) throws IOException{

        return null;
    }
}
