package carShop.consoleCarShopHandlers;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by employee on 10/22/15.
 */
public class StreamFactory {
    public static InputStream getInputStream() {
        return System.in;
    }

    public static PrintStream getPrintStream() {
        return System.out;
    }
}
