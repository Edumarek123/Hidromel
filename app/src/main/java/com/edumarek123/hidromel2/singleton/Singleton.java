package com.edumarek123.hidromel2.singleton;

import com.edumarek123.hidromel2.tanque.Tanque;
import com.edumarek123.hidromel2.usuario.Usuario;

public final class Singleton {
    private static Singleton instance;
    private Usuario usuario;
    private Tanque tanque;

    public Usuario getUsuario() {
        return usuario;
    }
    public Tanque getTanque() {
        return tanque;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setTanque(Tanque tanque) {this.tanque=tanque;}

    private Singleton() {
        this.usuario = null;

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}