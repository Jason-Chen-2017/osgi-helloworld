package com.osgi.client;

/**
 * Hello world!
 */

import com.osgi.server.Hello;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class App implements BundleActivator {

    public void start(BundleContext ctx) {
        System.out.println("----------------hello client start---------------------");
        ServiceReference ref = ctx.getServiceReference(Hello.class.getName());
        if (ref != null) {
            Hello hello = null;
            try {
                hello = (Hello) ctx.getService(ref);
                if (hello != null)
                    hello.sayHello();
                else
                    System.out.println("Service:Hello---object null");
            } catch (RuntimeException e) {
                e.printStackTrace();
            } finally {
                ctx.ungetService(ref);
                hello = null;
            }
        } else {
            System.out.println("Service:Hello---not exists");
        }
        System.out.println("----------------hello client start---------------------");
    }

    public void stop(BundleContext ctx) throws Exception {
        System.out.println("stop Service:Hello");
    }

}
