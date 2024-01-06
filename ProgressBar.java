import java.awt.Color;

import javax.swing.JProgressBar;

/**
* A class used to create a progress bar while the user waits for ChatGPT's response
* @see Gui#openResponseFrame()
*/

public class ProgressBar extends Thread {
    
    //Different messages shown while the bar is filling up
    static String s1 = "Composing the prompt";
    static String s2 = "Sending your message to ChatGPT";
    static String s3 = "Preparing the response";
    static String s4 = "Communicating with Pavlos";
    static String s5 = "Gathering information about OPA";
    static String s6 = "Asking graduate students";
    static String s7 = "Getting results from exams";
    static String s8 = "Counting answers";
    static String s9 = "Scanning facial characteristics";
    static String s10 = "Calculating shortest route from your house";

    static String[] barMessages = new String[] {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};

    public JProgressBar bar;

    /**
    * Default constructor utilizing the default constructor of the JProgressBar class
    * @see javax.swing.JProgressBar
    */
    
    public ProgressBar() {
        this.bar = new JProgressBar();
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setForeground(new Color(158, 22, 22));
        bar.setBackground(Color.WHITE);
        bar.setBounds(568, 382, 400, 100);
    }

    /**
    * Method used to simulate the filling of the bar
    * Overrides the run() of the Thread class
    * @see Thread#run()
    */
    
    @Override
    public void run() {
        int value = bar.getValue();
        int i = 0;
        while (value <= 100) {
            bar.setValue(value);
            value = bar.getValue();
            bar.setString(barMessages[i]);
            if (value ==  100) {
                bar.setString("Done");
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            value += 1;

            //Selecting a random integer from 0 to 9 in order to show different messages
            i = (int)(Math.random()*10);
        }

        bar.setVisible(false);
    }
}
