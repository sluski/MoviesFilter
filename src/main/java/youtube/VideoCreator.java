package youtube;

import youtube.POJO.Video;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;


/**
 *
 * @author Sluski
 */
public class VideoCreator {

    private final DocumentDownloader docDownloader;
    private final DataFinder dataFinder;
    private List<Video> videos;
    private final SingleDataFinder singleDataFinder;

    public VideoCreator() throws IOException {
        videos = new ArrayList<Video>();
        docDownloader = new DocumentDownloader();
        dataFinder = new DataFinder();
        singleDataFinder = new SingleDataFinder();
    }

    public List<Video> getVideos(String pageUrl) throws IOException {
        createVideos(pageUrl);
        for(int i = 0; i < videos.size(); i++){
            if(videos.get(i).getLikes() == videos.get(i).getDislikes() - 1){
                videos.remove(i);
            }
        }
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    // Main method to create list videos with all veriables
    public void createVideos(String pageUrl) throws IOException {
        Document page = docDownloader.getPageDocument(pageUrl);
        List<Video> namesAndLinks = dataFinder.findLinksAndNames(page);

        for (int i = 0; i < namesAndLinks.size(); i++) {
           Video video_temp = singleDataFinder.findVideoDetail((namesAndLinks.get(i).getVideoLink()));
           video_temp.setVideoLink(namesAndLinks.get(i).getVideoLink());
           video_temp.setName(namesAndLinks.get(i).getName());
           videos.add(video_temp);
        }
    }
}
