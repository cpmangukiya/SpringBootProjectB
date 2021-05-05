package org.example.messaging;

import javax.jms.*;
import javax.naming.InitialContext;

public class MyReceiver {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("myQueueConnectionFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();
            QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue t = (Queue) ctx.lookup("myQueue");
            QueueReceiver receiver = ses.createReceiver(t);

            MyListener listener = new MyListener();
            receiver.setMessageListener(listener);

            System.out.println("Receiver1 is ready, waiting for messages...");
            System.out.println("press Ctrl+c to shutdown...");
            while (true) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

class MyListener implements MessageListener {
    public void onMessage(Message m) {
        try {
            TextMessage msg = (TextMessage) m;
            System.out.println("following message is received:" + msg.getText());
        } catch (JMSException e) {
            System.out.println(e);
        }
    }
}
