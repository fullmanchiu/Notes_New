package cn.colafans.notes.bean;

import java.util.Date;

public class Notes {
    private String title;
    private String summary;
    private String sort;
    private long timestamp;

    public Notes(String title, String summary, String sort, long timestamp) {
        this.title = title;
        this.summary = summary;
        this.sort = sort;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
