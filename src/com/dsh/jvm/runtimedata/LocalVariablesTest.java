package com.dsh.jvm.runtimedata;

import java.util.Date;

/**
 * 局部变量表
 */
public class LocalVariablesTest {

    private int count = 1;

    public static void testStatic() {
        //编译错误，因为this变量不存在与当前方法的局部变量表中！！！
//        System.out.println(this.count);
    }

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    //关于slot的理解
    public LocalVariablesTest() {
        this.count = 1;
    }

    private void test1() {
        Date date = new Date();
        String name1 = "test1";
        test2(date,name1);
        System.out.println(date+name1);
    }

    private String test2(Date dateP,String name2) {
        dateP = null;
        name2 = "123";
        double weight = 130.5;
        char gender = '男';
        return dateP + name2;
    }

    public void test4(){
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用之前以及经销毁的变量b占据的slot位置
        int c = a + 1;
    }

}
