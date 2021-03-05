package com.linda.demo.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {
  @JsonProperty("access_token")
  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}
