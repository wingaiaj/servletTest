package com.bean;

/**
 * @ClassName fruit
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/10 15:43
 * @Version 1.0
 */
public class fruit {
    String fName;
    int price;
    int fCount;
    String remark;

    public fruit() {
    }

    public fruit(String fName, int price, int fCount, String remark) {
        this.fName = fName;
        this.price = price;
        this.fCount = fCount;
        this.remark = remark;
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getremark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
