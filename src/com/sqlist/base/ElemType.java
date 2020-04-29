package com.sqlist.base;

public class ElemType {
    private String name;
    private int age;
    public ElemType(){}

    public ElemType(String name,int age){
        this.name = name;
        this.age = age;
    }

    public boolean equals(ElemType e) {
        if (this.name == null) {
            if (e.name == null && this.age == e.age) {
                return true;
            } else {
                return false;
            }
        } else if (this.name.equals(e.name) && this.age == e.age) {
            return true;
        }
        return false;
    }

    public ElemType copy(){
        ElemType e = new ElemType();
        e.setAge(this.age);
        e.setName(this.name);
        return e;
    }

    public void copy(ElemType e){
        e.setAge(this.age);
        e.setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void paste(ElemType e){
        this.age = e.getAge();
        this.name = e.getName();
    }
}
