package az.kanan.chatbot.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import az.kanan.chatbot.R;
import az.kanan.chatbot.pojo.Message;

/**
 * Created by Kanan on 2/2/2017.
 */

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Message> messagesItems;

    public ListAdapter(Context context, List<Message> navDrawerItems) {
        this.context = context;
        this.messagesItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return messagesItems.size();
    }

    @Override
    public Object getItem(int position) {
        return messagesItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message m = messagesItems.get(position);
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (!m.isPutDate()) {
            if (m.isSelf()) {
                convertView = mInflater.inflate(R.layout.list_item_message_right,
                        null);
            } else {
                convertView = mInflater.inflate(R.layout.list_item_message_left,
                        null);
            }

            TextView txtMsg = (TextView) convertView.findViewById(R.id.txtMsg);
            TextView txtTime = (TextView) convertView.findViewById(R.id.txtTime);
            txtMsg.setText(m.getMessage());
            txtTime.setText(m.getHoursAndMin());

        } else {
            convertView = mInflater.inflate(R.layout.list_item_time,
                    null);

            TextView txtTimeHeader = (TextView) convertView.findViewById(R.id.txtTime4Header);
            txtTimeHeader.setText(m.getDayAndMonth());
        }


        return convertView;
    }

}
