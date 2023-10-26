package org.example;

public class Scientist {
    private final String surname;
    private final int year_of_birth;
    private final String paul;
    public Field_of_sciences field_of_sciences;

    public enum Field_of_sciences{
        Mathematics, Natural_science, Humanities
    }
    public String getSurname() {
        return surname;
    }

    public String getPaul() {
        return paul;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public Scientist(String name, int year_of_birth, String paul, Field_of_sciences field_of_sciences) {
        this.surname = name;
        this.year_of_birth = year_of_birth;
        this.paul = paul;
        this.field_of_sciences = field_of_sciences;
    }
}
