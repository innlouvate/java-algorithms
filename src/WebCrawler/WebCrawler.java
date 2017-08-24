package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> queue;
    private List<String> discoveredWebsitesList;

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discoveredWebsitesList = new ArrayList<>();
    }

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsitesList.add(root);

        while (!queue.isEmpty()) {
            String v = this.queue.remove();
            String rawHtml = readURL(v);

            String regex = "http://(\\w\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()) {
                String url = matcher.group();

                if (!discoveredWebsitesList.contains(url)) {
                    discoveredWebsitesList.add(url);
                    queue.add(url);
                    System.out.println("Website has been found with url " +url);
                }
            }

        }
    }

    private String readURL(String v) {
        String rawHtml = "";

        try {
            URL url = new URL(v);
            URLConnection conn = url.openConnection();
            conn.addRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            conn.getInputStream()));

            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {
                rawHtml += inputLine;
            }

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rawHtml;
    }

}
