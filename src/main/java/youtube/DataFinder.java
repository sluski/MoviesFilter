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
    
    public List<Video> findLinksAndNames(Document pageDoc){
        List<Video> returnList = new ArrayList();
        Elements elements = pageDoc.select("div.yt-lockup-content");
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("href").startsWith("/watch")) {
                Video video = new Video();
                video.setVideoLink("https://www.youtube.com" + elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("href"));
                video.setName(elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("title"));
                returnList.add(video);
            }
        }
        return returnList;
    }

//    private List<String> findLinks(Document pageDoc) {
//        List<String> resultList = new ArrayList<String>();
//        Elements elements = pageDoc.select("div.yt-lockup-content");
//        for (int i = 0; i < elements.size(); i++) {
//            if (elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("href").startsWith("/watch")) {
//                resultList.add("https://www.youtube.com" + elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("href"));
//            }
//        }
//        return resultList;
//    }
//
//    private List<String> findNames(Document pageDoc) {
//        List<String> resultList = new ArrayList<String>();
//        Elements elements = pageDoc.select("div.yt-lockup-content");
//        while(elements.size() > 20){
//            elements.remove(0);
//        }
//            for (int i = 0; i < elements.size(); i++) {
//                resultList.add(elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("title"));
//            }
//        return resultList;
//    }

}
