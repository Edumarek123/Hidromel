package com.edumarek123.hidromel2.singleton;

import com.edumarek123.hidromel2.usuario.Usuario;

public final class Singleton {
    private static Singleton instance;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

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