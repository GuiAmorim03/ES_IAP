package ua.pt.es.to_do_list.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
@IdClass(TaskPk.class)
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    @ManyToOne
    private Person person;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Date deadline;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    
    public Task() {
    }

    public Task(String title, String description, Status status, Date deadline, String category, Priority priority, Person person) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
        this.creationDate = new Date();
        this.category = category;
        this.priority = priority;
        this.person = person;
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

    public Status getStatus() {
        return status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCategory() {
        return category;
    }

    public Priority getPriority() {
        return priority;
    }

    public Person getUser() {
        return person;
    }

    @Override
    public String toString() {
        return "[" + id + "] (" + person.getName() + ") " + title;        
    }
    
}
