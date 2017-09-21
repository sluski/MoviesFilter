package youtube;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Sluski
 */
public class DocumentDownloader {
    
    private String pageUrl;
    
    public DocumentDownloader(){
    }
 
    // Method to download Document form web site specified as link pageUrl
    public Document getPageDocument(String pageUrl) throws IOException {
        Connection connect = Jsoup.connect(pageUrl);
        return connect.get();
    }
}
