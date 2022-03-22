package com.rna.springwebsocket.message;

public class SendToUserRequest implements Message{
    public static final String TYPE = "SEND_TO_USER_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;

    public SendToUserRequest(String msgId, String content) {
        this.msgId = msgId;
        this.content = content;
    }

    // ... 省略 set/get 方法

    public static String getTYPE() {
        return TYPE;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
