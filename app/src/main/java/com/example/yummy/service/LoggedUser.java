package com.example.yummy.service;

import com.example.yummy.Connect.UserData;

public abstract class LoggedUser {

    private static int idUser;
    private static String fullName;
    private static String nick;
    private static String email;
    private static String password;

    public static void create(UserData userData) {
        idUser = userData.getId_user();
        fullName = userData.getFullName();
        nick = userData.getNick();
        email = userData.getEmail();
        password = userData.getPassword();
    }

    public static int getIdUser() {
        return idUser;
    }

    public static String getFullName() {
        return fullName;
    }

    public static String getNick() {
        return nick;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}
