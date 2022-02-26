package com.yzy.qqzone.pojo;

import java.sql.Date;

/**
 * @ClassName UserDetail
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 10:36
 * @Version
 **/
public class UserDetail {
    private Integer id;
    private String realName;
    private String tel;
    private String email;
    //父类：util.Date 年月日时分秒
    //子类：sql.Date 年月日
    private Date birth;

    private String star;//星座

    public UserDetail() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
