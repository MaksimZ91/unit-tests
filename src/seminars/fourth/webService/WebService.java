package seminars.fourth.webService;

public class WebService {
    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void getHTTP(String url){
        System.out.println(httpClient.getHTTPRequest(url));
    }
}
