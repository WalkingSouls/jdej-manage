package com.miquankj.api.entity;

public class NoticeInfoWithBLOBs extends NoticeInfo {
    private String noticContent;

    private String noticRedCountent;

    public String getNoticContent() {
        return noticContent;
    }

    public void setNoticContent(String noticContent) {
        this.noticContent = noticContent;
    }

    public String getNoticRedCountent() {
        return noticRedCountent;
    }

    public void setNoticRedCountent(String noticRedCountent) {
        this.noticRedCountent = noticRedCountent;
    }
}