package lk.icptechnologies.carergo.campusbackend.dto;

import java.time.LocalDateTime;

public class Alert {

    private String id;
    private String type;
    private String message;
    private String severity;
    private LocalDateTime timestamp;

    public Alert() {
    }

    public Alert(String id, String type, String message, String severity, LocalDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.severity = severity;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
