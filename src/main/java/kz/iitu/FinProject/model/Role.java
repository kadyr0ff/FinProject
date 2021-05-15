package kz.iitu.FinProject.model;

public enum Role {
    User("user"),
    Admin("admin");

    public final String role;

    Role(String role) {
        this.role = role;
    }

}
