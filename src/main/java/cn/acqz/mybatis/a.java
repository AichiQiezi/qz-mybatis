package cn.acqz.mybatis;

public class a {
    // 用来同步的对象
    static Object obj = new Object();
    // t2 运行标记， 代表 t2 是否执行过
    static boolean t2runed = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                while (!t2runed) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(1);
        });
        Thread t2 = new Thread(() -> {
            System.out.println(2);
                t2runed = true;
                obj.notifyAll();
        });
        t1.start();
        t2.start();
    }
}
