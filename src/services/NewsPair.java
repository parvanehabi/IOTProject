package services;

import java.sql.Timestamp;

public class NewsPair {

    private Timestamp timestamp;
    private String description;

    public NewsPair(Timestamp timestamp, String description) {
        this.timestamp = timestamp;
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int compareTo(NewsPair o){
        return o.timestamp.compareTo(this.timestamp);
    }
}
