package shuaicj.hello.sshj;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Test the library: SSHJ.
 *
 * @author shuaicj 2016/12/28
 */
public class Application {

    private SSHClient ssh = new SSHClient();

    public Application() throws IOException {
        ssh.loadKnownHosts();
        ssh.connect("127.0.0.1", 2222);
        ssh.authPassword("shuai", "shuai");
    }

    public void exec() throws IOException {
//        try (final Session session = ssh.startSession()) {
//            final Session.Command cmd = session.exec("/vagrant/xx aa");
//            final Session.Command cmd = session.exec("java -jar /vagrant/java/xx.jar aa");
//            cmd.join(5, TimeUnit.SECONDS);
//            System.out.println("exit code: " + cmd.getExitStatus());
//            System.out.println("exit msg: " + cmd.getExitErrorMessage());
//            String stdout = IOUtils.readFully(cmd.getInputStream()).toString();
//            String stderr = IOUtils.readFully(cmd.getErrorStream()).toString();
//            System.out.println("stdout: " + stdout);
//            System.out.println("stderr: " + stderr);
//        }
        try (final Session session = ssh.startSession()) {
//            final Session.Command cmd = session.exec("/vagrant/xx");
//            final Session.Command cmd = session.exec("java -jar /vagrant/java/xx.jar");
//            final Session.Command cmd = session.exec("cat /proc/cpuinfo | grep \"processor\" | wc -l");
//            final Session.Command cmd = session.exec("free | grep Mem | awk '{print $4}'");
            final Session.Command cmd = session.exec("/usr/bin/time --quiet --format '%P,%K,%r,%s,%e,%x' /vagrant/xx");
            cmd.join(5, TimeUnit.SECONDS);
            System.out.println("exit code: " + cmd.getExitStatus());
            System.out.println("exit msg: " + cmd.getExitErrorMessage());
            String stdout = IOUtils.readFully(cmd.getInputStream()).toString().trim();
            String stderr = IOUtils.readFully(cmd.getErrorStream()).toString().trim();
            System.out.println("stdout: " + stdout);
            System.out.println("stderr: " + stderr);
        }
    }

    public void close() throws IOException {
        ssh.close();
    }
}
