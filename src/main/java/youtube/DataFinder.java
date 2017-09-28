package youtube;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import youtube.POJO.Video;

/**
 *
 * @author Sluski
 */
public class DataFinder {

    public DataFinder() {

    }

    public List<Video> findLinksAndNames(Document pageDoc) {
        List<Video> returnList = new ArrayList();
        Elements elementsLinksNames = pageDoc.select("div.yt-lockup-content");
        Elements elementsLength = pageDoc.select("h3.yt-lockup-title ");
        List<String> names = new ArrayList();
        List<String> links = new ArrayList();
        for (int i = 0; i < elementsLinksNames.size(); i++) {
            if (elementsLinksNames.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("href").startsWith("/watch")) {
                links.add("https://www.youtube.com" + elementsLinksNames.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("href"));
                names.add(elementsLinksNames.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("title"));
            }
        }
        for (int i = 0; i < links.size(); i++) {
            Video video = new Video();
            video.setName(names.get(i));
            video.setVideoLink(links.get(i));
            returnList.add(video);
        }

        return returnList;
    }
}
