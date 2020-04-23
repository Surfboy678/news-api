package com.brodacki.janusz.newsapi.jasonModel;

public class NewsJasonModel {

    private Long id;
    private String type;
    private String sectionName;
    private String webTitle;
    private String webUrl;

    public NewsJasonModel(Long id, String type, String sectionName, String webTitle, String webUrl) {
        this.id = id;
        this.type = type;
        this.sectionName = sectionName;
        this.webTitle = webTitle;
        this.webUrl = webUrl;
    }

    public NewsJasonModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long resId) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        return "NewsJasonModel{" +
                "resId=" + id +
                ", type='" + type + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", webTitle='" + webTitle + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
