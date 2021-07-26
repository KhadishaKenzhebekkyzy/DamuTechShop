package com.damu.shop.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    public User(Long userid, String useremail, String userpassword) {
        this.userid = userid;
        this.useremail = useremail;
        this.userpassword = userpassword;
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(name = "user_email")
    private String useremail;

    @Column(name = "user_password")
    private String userpassword;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
