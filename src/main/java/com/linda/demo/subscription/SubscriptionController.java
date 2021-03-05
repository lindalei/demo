package com.linda.demo.subscription;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;

/**
 * @author Lei Xu
 */

@RestController
//@CacheConfig(cacheNames = {"subscriptionCache"}, cacheManager = "5minCache")
public class SubscriptionController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionController.class);
  private final RestTemplate template = new RestTemplate();
  private static final String oauthUrl =
      "https://dpp-development.authentication.sap.hana.ondemand.com";
  private static final String clientId =
      "sb-DPG-Launchpad-e2e-dev-clone!b1073|lps-registry-broker!b13";
  private static final String clientSecret = "2XkEmqwJygSczXgTcPKT0SKOugM=";
  private static final String saasRegistryUrlUrl =
      "https://saas-manager.cfapps.sap.hana.ondemand.com/saas-manager/v1/application/subscriptions";
  private String token;

  public SubscriptionController() {
    new Timer().scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        try {
          getToken(oauthUrl, clientId, clientSecret);
        } catch (Throwable e) {
          e.printStackTrace();
        }
      }
    }, 0L, (long) 24e6);
  }

  @GetMapping("/subscriptions")
  //  @Cacheable(key = "#encodedUrl")
  public List<SubscriptionRepresentation> getSubscriptionRepresentation() {

    LOGGER.info("get subscriptions");
    return getSubscriptions(saasRegistryUrlUrl);
  }

  private String getToken(String url, String clientId, String clientSecret) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setBasicAuth(clientId, clientSecret);
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

    ResponseEntity<Token> responseEntity = template
        .exchange(url + "/oauth/token?grant_type=client_credentials", HttpMethod.GET, entity,
            Token.class);
    this.token = responseEntity.getBody().getAccessToken();

    return this.token;
  }

  public List<SubscriptionRepresentation> getSubscriptions(String url) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    String authToken = getToken(oauthUrl, clientId, clientSecret);
    headers.setBearerAuth(authToken);
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    ResponseEntity<String> responseEntity =
        template.exchange(url, HttpMethod.GET, entity, String.class);
    List<SubscriptionRepresentation> subscriptions = parseSubscriptionList(responseEntity);
    return subscriptions;
  }

  private List<SubscriptionRepresentation> parseSubscriptionList(
      ResponseEntity<String> responseEntity) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      Map<String, List<SubscriptionRepresentation>> listMap = mapper
          .readValue(responseEntity.getBody(),
              new TypeReference<Map<String, List<SubscriptionRepresentation>>>() {
              });
      return listMap.get("subscriptions");
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error: parse response of subscription!", e);
    }
  }

  private String performOAuth2Request(String encodedUrl, String authToken) {
    try {
      URL url = new URL(encodedUrl);

      HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

      if (authToken != null && authToken.trim().length() > 0) {
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + authToken);
      }
      httpURLConnection.setDoOutput(true);
      httpURLConnection.setAllowUserInteraction(false);

      if (httpURLConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(httpURLConnection.getInputStream()))) {
          LOGGER.info("request {} with Http Status Code {}", encodedUrl,
              httpURLConnection.getResponseCode());
          return br.lines().collect(Collectors.joining());
        }
      } else {
        LOGGER.error("request {} with Http Status Code {}", encodedUrl,
            httpURLConnection.getResponseCode());
      }
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
