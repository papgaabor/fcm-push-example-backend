package com.wanari.pushnotification;

public class Constants {

    // For the GCM connection
    public static final String FCM_SERVER = "fcm-xmpp.googleapis.com";
    public static final int FCM_PORT = 5236;
    public static final String FCM_ELEMENT_NAME = "gcm";
    public static final String FCM_NAMESPACE = "google:mobile:data";
    public static final String FCM_SERVER_CONNECTION = "gcm.googleapis.com";

    // For the processor factory
    public static final String PACKAGE = "com.wedevol";
    public static final String BACKEND_ACTION_REGISTER = PACKAGE + ".REGISTER";
    public static final String BACKEND_ACTION_ECHO = PACKAGE + ".ECHO";
    public static final String BACKEND_ACTION_MESSAGE = PACKAGE + ".MESSAGE";

    // For the app common payload message attributes (android - xmpp server)
    public static final String PAYLOAD_ATTRIBUTE_MESSAGE = "message";
    public static final String PAYLOAD_ATTRIBUTE_ACTION = "action";
    public static final String PAYLOAD_ATTRIBUTE_RECIPIENT = "recipient";
    public static final String PAYLOAD_ATTRIBUTE_ACCOUNT = "account";

    // For push notification message attributes
    public static final String NOTIFICATION_ATTRIBUTE_TITLE = "title";
    public static final String NOTIFICATION_ATTRIBUTE_BODY = "body";
    public static final String NOTIFICATION_ATTRIBUTE_CLICK_ACTION = "click_action";
}
