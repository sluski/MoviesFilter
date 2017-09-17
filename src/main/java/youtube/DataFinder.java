package youtube;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Sluski
 */
public class DataFinder {

    public DataFinder() {

    }

    public List<String> findLinks(Document pageDoc) {
        List<String> resultList = new ArrayList<String>();
        Elements elements = pageDoc.select("div.yt-lockup-content");
        for (int i = 0; i < elements.size(); i++) {
            resultList.add("https://www.youtube.com" + elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("href"));

        }
        return resultList;
    }

    public List<String> findNames(Document pageDoc) {
        List<String> resultList = new ArrayList<String>();
        Elements elements = pageDoc.select("div.yt-lockup-content");
        for (int i = 0; i < elements.size(); i++) {
            resultList.add(elements.get(i).select("h3.yt-lockup-title").select("a[href]").first().attr("title"));
        }
        return resultList;
    }

}
