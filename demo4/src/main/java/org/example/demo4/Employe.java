package org.example.demo4;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;

    @ElementCollection
    private List<String> skills;

    @Enumerated(EnumType.STRING)
    private Post post;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


}
