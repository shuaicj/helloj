package shuaicj.hello.ip.hostname;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;

/**
 * Get all IPs and hostnames of current machine.
 *
 * @author shuaicj 2018/10/11
 */
public class Application {

    public static void main(String[] args) throws Exception {
        for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            System.out.println("-------------- " + ni.getName() + " --------------");
            for (InetAddress ia : Collections.list(ni.getInetAddresses())) {
                System.out.println("hostname: " + ia.getHostName());
                System.out.println("ip: " + ia.getHostAddress());
            }
        }
    }
}
