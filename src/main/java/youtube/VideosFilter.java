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
public class VideosFilter {

    private DocumentDownloader docDownloader;
    private DataFinder dataFinder;
    private List<Video> videos;
    private SingleDataFinder singleDataFinder;

    public VideosFilter() throws IOException {
        videos = new ArrayList<Video>();
        docDownloader = new DocumentDownloader();
        dataFinder = new DataFinder();
        singleDataFinder = new SingleDataFinder();
    }

    public List<Video> getVideos(String pageUrl) throws IOException {
        createVideos(pageUrl);
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    // Main method to create list videos with all veriables
    public void createVideos(String pageUrl) throws IOException {
        Document page = docDownloader.getPageDocument(pageUrl);
        List<String> links = dataFinder.findLinks(page);
        List<String> names = dataFinder.findNames(page);

        for (int i = 0; i < links.size(); i++) {
           Video video_temp = singleDataFinder.findVideoDetail(links.get(i));
           video_temp.setVideoLink(links.get(i));
           video_temp.setName(names.get(i));
           videos.add(video_temp);
        }
    }
}
