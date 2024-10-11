package ua.pt.es.to_do_list.models;

public class TaskPk {
    private Long id;
    private Person person;

    public TaskPk() {
    }

    public TaskPk(Long id, Person person) {
        this.id = id;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskPk)) return false;

        TaskPk taskPk = (TaskPk) o;

        if (id != null ? !id.equals(taskPk.id) : taskPk.id != null) return false;
        return person != null ? person.equals(taskPk.person) : taskPk.person == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }
}
