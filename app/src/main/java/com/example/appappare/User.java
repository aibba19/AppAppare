package com.example.appappare;

public class User {
    private String nomeU;
    private String emailU;
    private String passwordU;

    public User(String nome, String email, String password) {
        nomeU = nome;
        emailU = email;
        passwordU = password;
    }

    public String getEmailU() {
        return emailU;
    }

    public String getNomeU() {
        return nomeU;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setNomeU(String nomeU) {
        this.nomeU = nomeU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

}

