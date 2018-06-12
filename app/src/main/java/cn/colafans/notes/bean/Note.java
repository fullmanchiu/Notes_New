package cn.colafans.notes.bean;

import org.litepal.crud.LitePalSupport;

public class Note extends LitePalSupport{
    private String title;
    private String summary;
    private int sort;
    private long timestamp;
    private boolean isSync;

    public Note(){
        this.sort = 0;
        this.isSync = false;
    }
    public Note(String title, String summary, int sort, long timestamp) {
        this.title = title;
        this.summary = summary;
        this.sort = sort;
        this.timestamp = timestamp;
        this.isSync = false;
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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }
}
