package seminars.fourth.httpService;

import org.junit.jupiter.api.Test;
import seminars.fourth.webService.HttpClient;
import seminars.fourth.webService.WebService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class HttpServiceTest {

    @Test
    void httpRequestTest(){
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.getHTTPRequest(anyString())).thenReturn("Site");
        String url = "pam.com";
        webService.getHTTP(url);
        verify(httpClient, times(1)).getHTTPRequest(url);
    }
}
