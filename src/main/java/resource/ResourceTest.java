package resource;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author mei
 * @since 2023/7/12 15:15
 */
public class ResourceTest {
    public static void main(String[] args) throws IOException {
        Class cl = ResourceTest.class;
        URL url=cl.getResource("about.gif");
        var icon =new ImageIcon(url);

        InputStream stream=cl.getResourceAsStream("/data/about.txt");
        var about = new String(stream.readAllBytes(),"UTF-8");

        InputStream stream2=cl.getResourceAsStream("/corejava/title.txt");
        var title=new String(stream2.readAllBytes(), StandardCharsets.UTF_8).trim();

        JOptionPane.showMessageDialog(null,about,title,JOptionPane.INFORMATION_MESSAGE,icon);
    }
}
