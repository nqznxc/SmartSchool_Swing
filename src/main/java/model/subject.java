package model;

public class subject {
    private Integer id;
    private String subject;

    public subject(){}

    public subject(Integer id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "subject{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
