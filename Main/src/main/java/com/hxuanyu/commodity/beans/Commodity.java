package com.hxuanyu.commodity.beans;

import java.util.Date;

/**
 * 商品实体类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class Commodity {
    /**
     * 商品id
     */
    private int id;
    /**
     * 商品名
     */
    private String commodityName;
    /**
     * 商品产地
     */
    private String origin;
    /**
     * 生产日期
     */
    private Date productionDate;
    /**
     * 保质期
     */
    private int shelfLife;

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", commodityName='" + commodityName + '\'' +
                ", origin='" + origin + '\'' +
                ", productionDate=" + productionDate +
                ", shelfLife=" + shelfLife +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Commodity() {
    }

    public Commodity(int id, String commodityName, String origin, Date productionDate, int shelfLife) {
        this(commodityName, origin, productionDate, shelfLife);
        this.id = id;
    }

    public Commodity(String commodityName, String origin, Date productionDate, int shelfLife) {
        this.commodityName = commodityName;
        this.origin = origin;
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
    }
}
