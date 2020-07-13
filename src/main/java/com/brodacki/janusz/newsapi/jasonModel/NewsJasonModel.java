package com.brodacki.janusz.newsapi.jasonModel;

public class NewsJasonModel {


    private String type;
    private String sectionName;
    private String webTitle;

    public NewsJasonModel( String type, String sectionName, String webTitle) {

        this.type = type;
        this.sectionName = sectionName;
        this.webTitle = webTitle;
    }

    public NewsJasonModel() {
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



    @Override
    public String toString() {
        return "NewsJasonModel{" +
                ", type='" + type + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", webTitle='" + webTitle + '\'' +
                '}';
    }
}
