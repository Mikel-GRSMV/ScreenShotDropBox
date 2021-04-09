import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {

        String ACCESS_TOKEN = "----your token on drop box----";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        for (; ; ) {
            BufferedImage image = null;
            MyThread thread = new MyThread(image, client);
            thread.start();
            try {
                thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception in sleep");
                e.printStackTrace();
            }
        }


    }
}
