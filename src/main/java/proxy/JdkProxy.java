package proxy;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理只能代理实现了某个接口的类,并且只能代理该接口的方法
 */
public class JdkProxy {
    public static void main(String[] args) throws IOException {

        Object target = new JspPage();
        Page pageProxy = (Page) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyHandler(target));
        pageProxy.doBeforeProcessing(2);
        System.out.println(pageProxy.toString());
        System.out.println(target);
        System.out.println("====================================");

        // JDK解决嵌套代理,核心思路是：把嵌套的方法改成代理对象上去调用该方法
        pageProxy.set(pageProxy);
        pageProxy.a();

        // 生成代理类的字节码
        byte[] byteCode = ProxyGenerator.generateProxyClass("generatedClassName",
                pageProxy.getClass().getInterfaces());
        FileOutputStream f = new FileOutputStream("proxy1222.class");
        f.write(byteCode);
        f.close();
    }
}

class MyHandler implements InvocationHandler {

    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        //System.out.println("result:" + result);
        return result;
    }
}


interface Page {


    public void doBeforeProcessing(int x);

    public void doAfterProcessing();

    void set(Page proxy);

    void a();


    void b();


    void c();

}

class JspPage implements Page {

    @Override
    public void doBeforeProcessing(int x) {
        System.out.println("JspPage doBeforeProcessing... " + x);
    }

    @Override
    public void doAfterProcessing() {
        System.out.println("JspPage doAfterProcessing...");
    }

    public static Page proxy = null;

    public void set(Page proxy) {
        JspPage.proxy = proxy;
    }

    @Override
    public void a() {
        System.out.println("A() invoked");
        proxy.b();
        System.out.println("After A() invoked");
    }


    @Override
    public void b() {
        System.out.println("B() invoked");
        proxy.c();
        System.out.println("After B() invoked");
    }


    @Override
    public void c() {
        System.out.println("C() invoked.");
    }


    public void doAction() {
        System.out.println("JspPage doAction...");
    }

}


