package com.sqlist;

import com.sqlist.base.ElemType;
import com.sqlist.base.SqList;

public class Main {
    public static void main(String[] args) {
        SqList sl = new SqList();
        sl.init();
        Test test = new Test();

        int i = 1;
        ElemType e = new ElemType("张三",18);
        sl.listInsert(i++,e);
//        e = new ElemType("李四",20);
//        sl.listInsert(i++,e);
//        e = new ElemType("李四2",20);
//        sl.listInsert(i++,e);
//        e = new ElemType("李四3",20);
//        sl.listInsert(i++,e);
        for (int j = 0;j < 10;j++) {
            e = new ElemType("李四4", 20);
            sl.listInsert(i++, e);
        }
        e = new ElemType("王五",21);
        sl.listInsert(i++,e);
        e = new ElemType("刘备",1500);
        sl.listInsert(i++,e);
        e = new ElemType("庄周",2000);
        sl.listInsert(i++,e);
//        e = new ElemType("李四5",20);
//        sl.listInsert(i++,e);
//        e = new ElemType("李四6",20);
//        sl.listInsert(i++,e);

//        for (int j = 0;j < sl.getLength();j++){
//            System.out.println("姓名：" + sl.getData()[j].getName() + "；年龄：" + sl.getData()[j].getAge());
//        }

//        e = sl.listDelete(2);
//        System.out.println("删除的姓名：" + e.getName() + "；年龄：" + e.getAge());
//        e = sl.listDelete(4);
//        System.out.println("删除的姓名：" + e.getName() + "；年龄：" + e.getAge());

        //===========================第一题测试===============================
//        ElemType delete = test.deMinAge(sl);
//        System.out.println("===================正在删除====================");
//
//        if (delete == null){
//            return;
//        }
//        System.out.println("被删人名称：" + delete.getName() + "；年龄：" + delete.getAge());
        //===========================第一题测试===============================

        //第二题测试
//        test.reserve(sl);

        //第三题测试
//        test.deleteX(sl,20);

        //第四题测试
        test.deleteStB(sl,19,1500);

        System.out.println("==================操作后的结果=================");

        for (int j = 0;j < sl.getLength();j++){
            System.out.println("姓名：" + sl.getData()[j].getName() + "；年龄：" + sl.getData()[j].getAge());
        }

    }
}
