package com.example.login;

public class UserHelper {
    String NIM, username, kelas;

    public UserHelper() {
//        this.NIM = NIM;
    }

    public UserHelper(String NIM, String username, String kelas) {
        this.NIM = NIM;
        this.username = username;
        this.kelas = kelas;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
