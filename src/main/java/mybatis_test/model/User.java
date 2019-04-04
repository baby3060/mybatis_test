package model;

public class User {
    private String userId;
    private String userPass;
    private String userName;

    public String getUserId() {
        return this.userId;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int result = 31;

        return result + userId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null ) {
            return false;
        }

        if( obj instanceof User ) {
            User tmp = (User)obj;

            return this.getUserId().equals(tmp.getUserId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Id : (" + this.userId + "), Name : " + this.userName + ", Password : " + this.userPass;
    }

}