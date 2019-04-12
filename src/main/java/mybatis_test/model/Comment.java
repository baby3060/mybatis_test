package model;

import java.util.Date;

public class Comment {
    private long commentNo;
    private String userId;
    private String commentContent;
    private Date regDate;

    public long getCommentNo() {
        return commentNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setCommentNo(long commentNo) {
        this.commentNo = commentNo;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null ) {
            return false;
        }

        if( obj instanceof Comment ) {
            Comment tmp = (Comment)obj;

            return (this.getCommentNo() == tmp.getCommentNo());
        } else {
            return false;
        }
    }
}