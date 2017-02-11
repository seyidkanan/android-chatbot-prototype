package az.kanan.chatbot;

import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import az.kanan.chatbot.pojo.Message;
import az.kanan.chatbot.util.ListAdapter;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    ListView listView;
    ListAdapter listAdapter;
    List<Message> messageList;

    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.inputMsg);
        button = (Button) findViewById(R.id.btnSend);
        listView = (ListView) findViewById(R.id.list_view_messages);
        messageList = new ArrayList<>();
        listAdapter = new ListAdapter(this, messageList);
        listView.setAdapter(listAdapter);

        addTime();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = editText.getText().toString().trim();
                if (!message.isEmpty())
                    addMessage(new Message("You", message, true, false));

                editText.setText("");
                processReply(message);
            }
        });

    }

    private void startTimer() {
        addMessage(new Message("Bot", "...", false, false));
        CountDownTimer counter = new CountDownTimer(500, 1000) {
            public void onTick(long millisUntilDone) {

            }

            public void onFinish() {
                messageList.remove(messageList.size() - 1);
                listAdapter.notifyDataSetChanged();
                addMessage(new Message("Bot", "Hi", false, false));
                listAdapter.notifyDataSetChanged();
            }
        }.start();
    }

    private void processReply(String message) {
        startTimer();
    }

    public void addMessage(Message m) {
        messageList.add(m);
        listAdapter.notifyDataSetChanged();
    }

    public void addTime() {
        messageList.add(new Message(false, true));
        listAdapter.notifyDataSetChanged();
    }

}
