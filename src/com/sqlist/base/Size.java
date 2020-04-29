package com.sqlist.base;

public enum Size {
    MaxSize(2000000),InitSize(100);

    private int num;
    private Size(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
