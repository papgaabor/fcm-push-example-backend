package com.wanari.pushnotification;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;

public class FcmPacketExtension implements ExtensionElement {
    private String json;

    public FcmPacketExtension(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    @Override
    public String toXML() {
        // TODO: Do we need to scape the json? StringUtils.escapeForXML(json)
        return String.format("<%s xmlns=\"%s\">%s</%s>", getElementName(), getNamespace(), json, Constants.FCM_ELEMENT_NAME);
    }

    public Stanza toPacket() {
        Message message = new Message();
        message.addExtension(this);
        return message;
    }

    @Override
    public String getElementName() {
        return Constants.FCM_ELEMENT_NAME;
    }

    @Override
    public String getNamespace() {
        return Constants.FCM_NAMESPACE;
    }
}
