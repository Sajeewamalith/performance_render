package com.fruity.performance_render;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Picture;
import android.printservice.CustomPrinterIconCallback;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.nio.channels.Pipe;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


/**
 * A custom adapter that is backed by an array of Chat objects. References a TextView with the name
 * of a chat author (a Droid), a TextView with a chat's text, another TextView with the chat's
 * timestamp, and an ImageView for the chat author's avatar.
 */

public class ChatAdapter extends ArrayAdapter<Chat> {




    public ChatAdapter(Context context, ArrayList<Chat> chats) {
        super(context, 0, chats);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Chat chat = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.chat_item, parent, false);
        }

        // Find the UI widgets for a chat item.
        TextView chat_author_name = (TextView) view.findViewById(R.id.chat_author_name);
        TextView chat_text = (TextView) view.findViewById(R.id.chat_text);
        TextView chat_datetime = (TextView) view.findViewById(R.id.chat_datetime);
        ImageView chat_author_avatar = (ImageView) view.findViewById(R.id.chat_author_avatar);

        // Display the author's name using the color associated with the author.
        chat_author_name.setText(chat.getAuthor().getName());
        chat_author_name.setTextColor(chat.getAuthor().getColor());

        // Display the chat text.
        chat_text.setText(chat.getText());

        // Set the timestamp for the chat in "x minutes ago" format.
        chat_datetime.setText(DateUtils.getRelativeTimeSpanString(
                chat.getDatetime().getTime(),
                new Date().getTime(),
                DateUtils.MINUTE_IN_MILLIS,
                DateUtils.FORMAT_ABBREV_RELATIVE));


        // Display the chat author's avatar (a droid image) and a background color associated with
        // the author.
        if (chat.getAuthor().getAvatarId() == 0) {
            Picasso.with(getContext()).load(android.R.color.transparent).into(chat_author_avatar);
            chat_author_avatar.setBackgroundColor(chat.getAuthor().getColor());
        } else {
            Picasso.with(getContext()).load(chat.getAuthor().getAvatarId()).into(
                    chat_author_avatar);
            chat_author_avatar.setBackgroundColor(Color.TRANSPARENT);
        }

        return view;
    }


}
