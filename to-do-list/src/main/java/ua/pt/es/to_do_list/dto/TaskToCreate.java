package ua.pt.es.to_do_list.dto;

import ua.pt.es.to_do_list.models.Priority;
import java.time.LocalDateTime;


public class TaskToCreate {
    private String title;
    private String description;
    private LocalDateTime deadline;
    private String category;
    private Priority priority;
    private Long personId;

    public TaskToCreate(String title, String description, String deadline, String category, Priority priority, Long personId) {
        if (deadline == "" || deadline == null) {
            this.deadline =  null;
        } else {
            String fullDate[] = deadline.split("T");
            String[] date = fullDate[0].split("-");
            if (fullDate.length > 1) {
                String[] time = fullDate[1].split(":");
                this.deadline = LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), Integer.parseInt(time[0]), Integer.parseInt(time[1]));
            } else {
                this.deadline = LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), 23, 59);
            }
        }
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getCategory() {
        return category;
    }

    public Priority getPriority() {
        return priority;
    }

    public Long getPersonId() {
        return personId;
    }
    
}
