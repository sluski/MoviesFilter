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

    public VideosFilter() throws IOException {
        videos = new ArrayList<Video>();
        docDownloader = new DocumentDownloader();
        dataFinder = new DataFinder();
    }

    public List<Video> getVideos(String pageUrl) throws IOException {
        createVideos(pageUrl);
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public void createVideos(String pageUrl) throws IOException {
        Document page = docDownloader.getPageDocument(pageUrl);
        List<String> links = dataFinder.findLinks(page);
        List<String> names = dataFinder.findNames(page);
        for(int i = 0; i < links.size(); i++){
            Video video = new Video();
            video.setName(names.get(i));
            video.setVideoLink(links.get(i));
            videos.add(video);
        }
    }
}
