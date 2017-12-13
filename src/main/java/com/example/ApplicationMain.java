package com.example;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import com.wanari.pushnotification.CcsOutMessage;
import com.wanari.pushnotification.Constants;
import com.wanari.pushnotification.FcmClient;
import com.wanari.pushnotification.MessageHelper;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ApplicationMain {

    public static void main(String[] args) throws InterruptedException, IOException, SmackException, XMPPException {
        ActorSystem system = ActorSystem.create("MyActorSystem");
        ActorRef pingActor = system.actorOf(PingActor.props(), "pingActor");
        pingActor.tell(new PingActor.Initialize(), null);
        // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
        // see counter logic in PingActor
        system.awaitTermination();

        String fcmSenderId = "<put your sender id here>";
        String fcmServerKey = "<put your server key here>";
        FcmClient fcmClient = FcmClient.prepareClient(fcmSenderId, fcmServerKey, true);
        fcmClient.connect();

        String messageId = UUID.randomUUID().toString();
        Map<String, String> dataPayload = new HashMap<String, String>();
        dataPayload.put(Constants.PAYLOAD_ATTRIBUTE_MESSAGE, "This is the simple sample message");

        String toRegId = "<put your fcm token here>";

        CcsOutMessage message = new CcsOutMessage(toRegId, messageId, dataPayload);

        Map<String, String> notificationPayload = new HashMap<>();
        notificationPayload.put(Constants.NOTIFICATION_ATTRIBUTE_TITLE, "Push test");
        notificationPayload.put(Constants.NOTIFICATION_ATTRIBUTE_BODY, "Notification body");
        message.setNotificationPayload(notificationPayload);

        String jsonRequest = MessageHelper.createJsonOutMessage(message);
        fcmClient.send(jsonRequest);
        Thread.sleep(10000);
    }

}