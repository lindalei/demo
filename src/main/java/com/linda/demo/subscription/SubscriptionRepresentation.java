package com.linda.demo.subscription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author Lei Xu
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionRepresentation {
  private String url;
  private String appName;
  private String consumerTenantId;
  private String state;
  private List<Dependency> dependencies;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public String getConsumerTenantId() {
    return consumerTenantId;
  }

  public void setConsumerTenantId(String consumerTenantId) {
    this.consumerTenantId = consumerTenantId;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public List<Dependency> getDependencies() {
    return dependencies;
  }

  public void setDependencies(List<Dependency> dependencies) {
    this.dependencies = dependencies;
  }
}
