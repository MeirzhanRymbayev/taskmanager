package kz.attractor.lab56.taskmanager.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document("tasks")
public class Task {

    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;

    @DBRef
    private User user;
    private Status status;

    public enum Status {
        NEW, IN_PROGRESS, DONE
    }
}
