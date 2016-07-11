package com.chat;

import org.primefaces.json.JSONObject;
import org.primefaces.push.Encoder;

/**
 * Created by shado on 7/11/2016.
 */
public final class MsgEncoder implements Encoder<Message, String> {

    //@Override
    public String encode(Message message) {
        return new JSONObject(message).toString();
    }
}