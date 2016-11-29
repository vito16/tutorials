package com.vito16.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by vito on 16/7/5.
 */
@ConfigurationProperties(prefix = YijiBootProperties.PREFIX)
public class YijiBootProperties {
    public static final String PREFIX="vito.jdbc";

    private String url;

    private String username;

    private String password;

    private String driver;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
