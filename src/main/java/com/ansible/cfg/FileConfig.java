package com.ansible.cfg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by maybo on 2016/11/23.
 */
@ConfigurationProperties(prefix = "file",locations = "classpath:application.properties")
@Configuration
public class FileConfig {

    private String shellFilePath;
    private String saveFilePath;

    public void setSaveFilePath(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

    public void setShellFilePath(String shellFilePath) {
        this.shellFilePath = shellFilePath;
    }

    public String getSaveFilePath() {
        return saveFilePath;
    }

    public String getShellFilePath() {
        return shellFilePath;
    }
}
