package shuaicj.hello.resource.path;

/**
 * A helper to access the resource files.
 *
 * @author shuaicj 2017/01/20
 */
public class ResourceHelper {

    public String getAbsolutePath(String file) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResource(file).getPath();
    }
}
