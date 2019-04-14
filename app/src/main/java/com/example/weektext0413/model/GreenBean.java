package com.example.weektext0413.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/13 08:31:42
 * @Description:
 */
@Entity

public class GreenBean {

private int followMovie;

@Id(autoincrement = true)
    private Long id;
    private String imageUrl;
    private String name;
    private int rank;
    private long releaseTime;
    private String releaseTimeShow;
    private String summary;
    @Generated(hash = 1731849116)
    public GreenBean(int followMovie, Long id, String imageUrl, String name,
            int rank, long releaseTime, String releaseTimeShow, String summary) {
        this.followMovie = followMovie;
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.rank = rank;
        this.releaseTime = releaseTime;
        this.releaseTimeShow = releaseTimeShow;
        this.summary = summary;
    }
    @Generated(hash = 1002137420)
    public GreenBean() {
    }
    public int getFollowMovie() {
        return this.followMovie;
    }
    public void setFollowMovie(int followMovie) {
        this.followMovie = followMovie;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRank() {
        return this.rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public long getReleaseTime() {
        return this.releaseTime;
    }
    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }
    public String getReleaseTimeShow() {
        return this.releaseTimeShow;
    }
    public void setReleaseTimeShow(String releaseTimeShow) {
        this.releaseTimeShow = releaseTimeShow;
    }
    public String getSummary() {
        return this.summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
