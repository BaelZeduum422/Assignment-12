package com.Homework_11;
import java.io.*;
import java.util.*;

class Contact implements Serializable {
    private static final long serialVersionUID = 1L; // for version control
    String name;
    String phoneNumber;
    String email;
    Date dateOfBirth;

    public Contact(String name, String phoneNumber, String email, Date dateOfBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nDOB: " + dateOfBirth.toString() + "\nEmail: " + email;
    }
}
