package WebCrawler;

public class App {

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();
        String rootUrl = "http://www.website.com";
        webCrawler.discoverWeb(rootUrl);
    }
}
