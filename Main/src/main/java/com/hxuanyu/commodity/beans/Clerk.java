package com.hxuanyu.commodity.beans;

/**
 * 店员
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class Clerk {
    private Integer id;
    private String clerkName;
    /**
     * 男：1， 女：0
     */
    private int gender;
    private String phone;
    /**
     * 管理员：1， 普通店员：0
     */
    private int admin;
    private String passwd;

    public Clerk() {
    }

    public Clerk(int id, String clerkName, int gender, String phone, int admin, String passwd) {
        this(clerkName, gender, phone, admin, passwd);
        this.id = id;
    }

    public Clerk(String clerkName, int gender, String phone, int admin, String passwd) {
        this.clerkName = clerkName;
        this.gender = gender;
        this.phone = phone;
        this.admin = admin;
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "id=" + id +
                ", clerkName='" + clerkName + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", admin=" + admin +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
