package com.zx.Servlet.jdbc.bean;

/**
 * @ClassName Fruit
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/8 17:48
 * @Version 1.0
 */
public class Fruit {
    String fName;
    int price;
    int fCount;
    String remark;

    public Fruit(String fName, int price, int fCount, String remark) {
        this.fName = fName;
        this.price = price;
        this.fCount = fCount;
        this.remark = remark;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getfCount() {
        return fCount;
    }

    public void setfCount(int fCount) {
        this.fCount = fCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
