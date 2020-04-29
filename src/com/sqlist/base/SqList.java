package com.sqlist.base;

public class SqList {
    private ElemType[] data;

    private int length;

    public void init() {
        data = new ElemType[Size.MaxSize.getNum()];
        length = 0;
    }

    /**
     * 顺序表——插入
     * @param i    插入位置
     * @param e    插入的新元素
     * @return
     */
    public boolean listInsert(int i, ElemType e) {
        if (i < 1 || i > length + 1) {         //插入位置非法判断
            return false;
        }

        for (int j = length; j > i - 1; j--) {     //i是逻辑位置，因为是采用数组作为底层数据结构，因此实际的下标要减1
            data[j] = data[j - 1];
        }
        data[i - 1] = e;
        length++;
        return true;
    }

    /**
     * 顺序表——删除
     */
    public ElemType listDelete(int i) {
        if (i < 1 || i > length) {
            return null;
        }
        ElemType e = data[i-1];
        for (int j = i; j < length;j++) {   //逻辑的位置关系
            data[j-1] = data[j];            //通过j-1转换为物理的下标
        }
        length--;
        return e;
    }

    /**
     * 顺序表——按值查找
     *
     * @param e
     * @return
     */
    public int locateElem(ElemType e) {
        if (e == null) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            if (e.equals(data[i])) {
                return i + 1;
            }
        }
        return 0;
    }

    public boolean isEmpty(){
        if (data == null || length == 0){
            return true;
        }
        return false;
    }

    public ElemType[] getData() {
        return data;
    }

    public void setData(ElemType[] data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
