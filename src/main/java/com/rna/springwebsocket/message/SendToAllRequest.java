package com.rna.springwebsocket.message;

public class SendToAllRequest implements Message{
    public static final String TYPE = "SEND_TO_ALL_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;

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

    /**
     * 内容
     */
    private String content;

    // ... 省略 set/get 方法
}
