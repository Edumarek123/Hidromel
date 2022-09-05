package com.edumarek123.hidromel2.medicoes;

import java.util.Random;

public class Medicoes {
    //atributos
    private float[] temperatura;
    private float[] densidade;
    private float[] tempo;

    //metodos
    public void setDensidade(float[] densidade) {this.densidade=densidade;}
    public void setTemperatura(float[] temperatura) {this.temperatura=temperatura;}
    public void setTempo(float[] tempo) {this.tempo=tempo;}
    public float[] getDensidade() {return densidade;}
    public float[] getTemperatura() {return temperatura;}
    public float[] getTempo() {return tempo;}

    //construtores
    public Medicoes(){
        Random random=new Random();
        random.setSeed(100);

        float[] D=new float[100];
        float[] T=new float[100];
        float[] t=new float[100];

        for (int i=0; i<100;i++) {
            D[i] = random.nextInt(100);
            T[i] = random.nextInt(100);
            t[i]=i;
        }
        setTemperatura(D);
        setDensidade(T);
        setTempo(t);
    }
}
