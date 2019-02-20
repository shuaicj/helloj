package shuaicj.hello.ip.hostname;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;

/**
 * Get all IPs and host names of current machine.
 *
 * @author shuaicj 2019/02/20
 */
public class Application {

    public static void main(String[] args) throws Exception {
        System.out.println("-------------- localhost --------------");
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("hostname   : " + localhost.getHostName());
        System.out.println("fqdn       : " + localhost.getCanonicalHostName());
        System.out.println("ip address : " + localhost.getHostAddress());
        System.out.println();

        for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            System.out.println("-------------- " + ni.getName() + " --------------");
            for (InetAddress ia : Collections.list(ni.getInetAddresses())) {
                System.out.println("hostname   : " + ia.getHostName());
                System.out.println("fqdn       : " + ia.getCanonicalHostName());
                System.out.println("ip address : " + ia.getHostAddress());
                System.out.println();
            }
        }
    }
}
