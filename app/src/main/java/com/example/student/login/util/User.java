package com.example.student.login.util;

import java.util.ArrayList;

/**
 * Created by 莉 on 2015/10/25.
 */
public class User {
    private ArrayList<Integer> _pwd = new ArrayList<>();

    public void reset_pwd() {
        this._pwd.clear();
    }

    public String get_pwd() {
        return this._pwd.toString().replaceAll("[^0-9]", "");
    }

    public void set_pwd(int num) {
        this._pwd.add(num);
    }

}
