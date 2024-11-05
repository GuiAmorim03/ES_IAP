package ua.pt.es.to_do_list.dto;

public class PersonToCreate {

    private String name;
    private String email;

    public PersonToCreate(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }

}
