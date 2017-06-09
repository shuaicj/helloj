package shuaicj.hello.jce.policy;

import javax.crypto.Cipher;

/**
 * Default max allowed key length for AES is 128.
 * After applying JCE Unlimited Policy Files, it turns to be Integer.MAX_VALUE.
 * Refer to Oracle JCE 8.
 *
 * @author shuaicj 2017/06/09
 */
public class Application {

    public static void main(String[] args) throws Exception {
        System.out.println("Cipher.getMaxAllowedKeyLength " + Cipher.getMaxAllowedKeyLength("AES"));
    }
}
