package com.linda.demo.subscription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dependency {
  private String xsappname;
  private String appName;

  @JsonProperty(value = "error", required = false)
  private String error;

  private Dependency[] dependencies;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getXsappname() {
    return xsappname;
  }

  public void setXsappname(String xsappname) {
    this.xsappname = xsappname;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public Dependency[] getDependencies() {
    return dependencies;
  }

  public void setDependencies(Dependency[] dependencies) {
    this.dependencies = dependencies;
  }
}
