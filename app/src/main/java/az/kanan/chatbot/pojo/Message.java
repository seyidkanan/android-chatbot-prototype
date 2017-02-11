package az.kanan.chatbot.pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Kanan on 2/2/2017.
 */

public class Message {
    private String fromName, message;
    private boolean isSelf;

    private boolean isPutDate;


    public Message(String fromName, String message, boolean isSelf, boolean isPutDate) {
        this.fromName = fromName;
        this.message = message;
        this.isSelf = isSelf;
        this.isPutDate = isPutDate;
    }

    public Message(boolean isSelf, boolean isPutDate) {
        this.isSelf = isSelf;
        this.isPutDate = isPutDate;
    }

    public Message() {
    }

    public boolean isPutDate() {
        return isPutDate;
    }

    public void setPutDate(boolean putDate) {
        isPutDate = putDate;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSelf() {
        return isSelf;
    }

    public void setSelf(boolean self) {
        isSelf = self;
    }

    public String getHoursAndMin() {
        Calendar cc = Calendar.getInstance();
        return String.format(Locale.ENGLISH, "%02d:%02d",
                cc.get(Calendar.HOUR_OF_DAY),
                cc.get(Calendar.MINUTE));
    }

    public String getDayAndMonth() {
        Calendar cc = Calendar.getInstance();
        return new SimpleDateFormat("d MMMM", Locale.US).format(cc.getTime());
    }

    @Override
    public String toString() {
        return "Message{" +
                "fromName='" + fromName + '\'' +
                ", message='" + message + '\'' +
                ", isSelf=" + isSelf +
                ", isPutDate=" + isPutDate +
                '}';
    }
}
