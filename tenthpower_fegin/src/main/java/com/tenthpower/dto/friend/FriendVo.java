package com.tenthpower.dto.friend;


public class FriendVo {
    private String id;

    private String userid;

    private String friendid;

    private Integer islike;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }

    public Integer getIslike() {
        return islike;
    }

    public void setIslike(Integer islike) {
        this.islike = islike;
    }
}
