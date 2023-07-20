package timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author mei
 * @since 2023/7/18 16:41
 */
public class TimerPrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("time is"+ Instant.ofEpochMilli(e.getWhen()));

    }
}
