package com.example.login.Models;

import java.time.LocalDate;
import java.time.Period;

public class Admin {
    private String fullName;
    private String email;
    private String telephone;
    private String Password;
    private LocalDate dateOfBirth;
    private int Age;
    private String Image;
    private String Ntele;

    public Admin(String fullName, String email, String telephone, int age ,LocalDate dateOfBirth, String password, String image) {
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.Password = password;
        this.Age = age;
        this.Image = image;
    }

    public String getImage() {
        return Image;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = Integer.parseInt(age);
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return Password;
    }

    public void setFullName(String newName) {
        this.fullName = newName;
    }

    public void setImage(String newImage) {
        this.Image = newImage;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setTelephone(String newTele) {
        this.telephone = newTele;
    }

    public void setDateOfBirth(LocalDate newDateBird) {
        this.dateOfBirth = newDateBird;
    }

    public LocalDate getDateMinusAge() {
        return LocalDate.now().minus(Period.ofYears(Age));
    }

    public void setPassword(String newPassword) {
        this.Password = newPassword;
    }

    public String getImagePath() {
        return Image;
    }

    public void setImagePath(String newImagePath) {
        this.Image = newImagePath;
    }

    public String getNtele() {
        return Ntele;
    }

    public void setNtele(String ntele) {
        this.Ntele = ntele;
    }
}
