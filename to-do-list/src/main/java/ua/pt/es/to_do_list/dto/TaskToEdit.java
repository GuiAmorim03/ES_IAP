package ua.pt.es.to_do_list.dto;

import ua.pt.es.to_do_list.models.Priority;
import ua.pt.es.to_do_list.models.Status;

import java.time.LocalDateTime;


public class TaskToEdit {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private String category;
    private Priority priority;
    private Status status;

    public TaskToEdit(Long id, String title, String description, String deadline, String category, Priority priority, Status status) {
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
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.status = status;
    }

    public Long getId() {
        return id;
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

    public Status getStatus() {
        return status;
    }
    
}
