package com.fruity.performance_render;

import java.util.Date;

/**
 * Describes a Chat message written by a Droid author, consisting of some text and a timestamp.
 */
public class Chat {
    /**
     * The author of the chat.
     */
    private Droid author;

    /**
     * The chat content. This is hardcoded in this sample (see ChatsFragment.java).
     */
    private String text;

    /**
     * The time a chat was posted to the chat board.
     */
    private Date datetime;

    public Chat(Droid author, String text, Date datetime) {
        this.author = author;
        this.text = text;
        this.datetime = datetime;
    }

    public Droid getAuthor() {return author;}
    public String getText() {return text;}
    public Date getDatetime() {return datetime;}


}
