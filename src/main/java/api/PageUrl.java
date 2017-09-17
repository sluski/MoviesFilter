package api;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import youtube.POJO.Video;
import youtube.VideosFilter;

/**
 * REST Web Service
 *
 * @author Sluski
 */
@Path("videos")
public class PageUrl {
    private String path;
    private VideosFilter videosFilter;

    @Context
    private UriInfo context;

    public PageUrl() {
    }

    public String getPath() {
        return path;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getJson() throws IOException {
        videosFilter = new VideosFilter();
        return videosFilter.getVideos("https://www.youtube.com/results?search_query=+Create+Java+client+for+RESTful+web+service");
    }
}
