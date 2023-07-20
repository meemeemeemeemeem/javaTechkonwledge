package timer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author mei
 * @since 2023/7/18 16:41
 */
public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimerPrinter();
        ActionListener act =
                event -> System.out.println("Time is"+ Instant.ofEpochMilli(event.getWhen()));
        var timer = new Timer(1000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "quit program?");
        System.exit(0);
    }
}
