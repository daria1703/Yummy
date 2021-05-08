package com.example.yummy.Connect;

public class UserData {
    private final int idUser;
    private final String fullName;
    private final String nick;
    private final String email;
    private final String password;

    public UserData(int id_user, String fullName, String nick, String email, String password) {
        this.idUser = id_user;
        this.fullName = fullName;
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    public int getId_user() {
        return idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
