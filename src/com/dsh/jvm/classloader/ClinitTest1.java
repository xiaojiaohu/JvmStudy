package com.dsh.jvm.classloader;

public class ClinitTest1 {
    static class Father{
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father{
        public static int B = A;
    }



    public static void main(String[] args) {
        //加载Father类，其次加载Son类
        System.out.println(Son.B);

        Runnable r= ()->{
          System.out.println(Thread.currentThread().getName()+"开始");
          C c= new C();
          System.out.println(Thread.currentThread().getName()+"结束");
        };
        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");
        t1.start();
        t2.start();
    }

}
class C {
    static {
        int i =1;
        System.out.println(Thread.currentThread().getName()+" 加载C了");
    }
}
