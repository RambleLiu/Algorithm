package com.sqlist;

import com.sqlist.base.ElemType;
import com.sqlist.base.SqList;

public class Test {
    //王道p18.1
    public ElemType deMinAge(SqList list){
        if (isEmpty(list)){
            System.out.println("错误！！！顺序表为空，不能删除");
            return null;
        }
        ElemType[] data = list.getData();
        ElemType min = data[0];
        int p = 0;
        for (int i = 0;i < list.getLength();i++){
            if (min.getAge() > data[i].getAge()){
                min = data[i];
                p = i;
            }
        }
        ElemType result = min.copy();
        list.setLength(list.getLength()-1);
        data[p] = data[list.getLength()];
        return result;
    }

    //王道p18.2
    public void reserve(SqList list){
        if (isEmpty(list)){
            System.out.println("错误！！！顺序表为空，不能删除");
            return;
        }
        int front = 0;
        int rear = list.getLength()-1;
        ElemType[] data = list.getData();
        ElemType tmp = new ElemType();
        while (front < rear){
            data[rear].copy(tmp);
            data[rear--].paste(data[front]);
            data[front++].paste(tmp);
        }
    }

    //王道p18.3
    //删除顺序表中所有年龄为x的元素
    public void deleteX(SqList list,int x){
        if (isEmpty(list)){
            return;
        }
        ElemType[] data = list.getData();
        int k = 0,i = 0;
        for (;i < list.getLength();i++){
            if (data[i].getAge() != x){
                data[k].paste(data[i]);
                k++;
            }
        }
        list.setLength(list.getLength() - (i-k));
    }

    /**
     * 王道p18.4
     * 删除(s,t)间的所有值(s<t)，list为按年龄有序的顺序表
     * 本机测试删除100W条数据，耗时11ms
     */
    public boolean deleteSt(SqList list,int s,int t){
        long b = System.currentTimeMillis();
        if (isEmpty(list) || s >= t){
            return false;
        }
        ElemType[] data = list.getData();
        //k作为覆盖下标，把要保留的数存放在k中，要删除的部分则直接覆盖掉
        int k = 0;
        //记录删除了几个元素
        int deCount = 0;
        for (int i = 0;i < list.getLength();i++){
            if (data[i].getAge() <= s || data[i].getAge() >= t){
                data[k].paste(data[i]);
                k++;
            }else {
                deCount++;
            }
        }
        list.setLength(list.getLength() - deCount);
        long e = System.currentTimeMillis();
        System.out.println("有序顺序表删除耗时：" + (e-b) + "ms");
        return true;
    }

    /**
     * 王道p18.4 标准答案
     * 删除(s,t)间的所有值(s<t)，list为按年龄有序的顺序表
     * 该解法为王道标答，但由于跑了三次循环，其耗时远超deleteSt(Sqlist list,int s,int t)
     * 本机测试删除100W条数据，耗时11ms
     *
     * 结论：该方法适用于写操作耗时远大于比较的场景，否则三遍for循环耗时过大
     */
    public boolean deleteStPro(SqList list,int s,int t){
        long b = System.currentTimeMillis();
        if (isEmpty(list) || s >= t){
            return false;
        }
        ElemType[] data = list.getData();
        //k作为覆盖下标，把要保留的数存放在k中，要删除的部分则直接覆盖掉
        //记录删除了几个元素
        int begin = 0,end = 0;
        //找到第一个要删除的元素，即第一个年龄大于s的元素
        for (;data[begin].getAge() <= s;begin++);
        //找到后半段第一个不用删除的元素，即后半段第一个>=t的元素
        for (end = begin;data[end].getAge() < t;end++);

        list.setLength(list.getLength() - (end - begin));

        while (begin < end){
            data[begin++].paste(data[end]);
        }
        long e = System.currentTimeMillis();
        System.out.println("有序顺序表删除Pro耗时：" + (e-b) + "ms");
        return true;
    }

    public boolean isEmpty(SqList list){
        if (list == null || list.isEmpty()){
            return true;
        }
        return false;
    }
}
