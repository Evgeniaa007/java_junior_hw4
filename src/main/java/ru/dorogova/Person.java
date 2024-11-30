package ru.dorogova;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name="persons")
public class Person {


    private static final String[] names = new String[] {"Алиса", "Петр", "Кристина", "Александр", "Оксана", "Ирина", "Андрей"};
    private static final String[] occupations = new String[]{"Студент", "Врач", "Учитель", "Юрист", "Предприниматель", "Музыкант"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void updateAge(){
        age = random.nextInt(20, 26);
    }

    public void updateName(){
        name = names[random.nextInt(names.length)];
    }

    public void updateOccupation(){
        occupation = occupations[random.nextInt(occupations.length)];
    }

    public static Person createPerson(){
        return new Person(names[random.nextInt(names.length)], random.nextInt(20, 26), occupations[random.nextInt(occupations.length)]);
    }

    @Override
    public String toString() {
        return "Информация о человеке: " +
                "имя - " + name +
                ", возраст - " + age +
                ", род деятельности - " + occupation;
    }
}
