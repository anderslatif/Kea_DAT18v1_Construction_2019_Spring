package edu.kea.cats.model;

import javax.persistence.*;

@Entity
@Table(name = "cats")
public class Cat {

    public Cat() {
    }

    public Cat(int age, String name, String introText) {
        this.age = age;
        this.name = name;
    }

    public Cat(int age, String name, String introText, String profilePicture) {
        this.age = age;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int age;

    private String name;

    private String introText;

    private String profilePicture;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroText() {
        return introText;
    }

    public void setIntroText(String introText) {
        this.introText = introText;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
