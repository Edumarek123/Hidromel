package com.edumarek123.hidromel2.medicoes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class Leitura {
    //atributos
    private float temperatura;
    private float densidade;
    private float tempo;

    //metodos
    public void setDensidade(float densidade) {this.densidade=densidade;}
    public void setTemperatura(float temperatura) {this.temperatura=temperatura;}
    public void setTempo(float tempo) {this.tempo=tempo;}
    public float getDensidade() {return densidade;}
    public float getTemperatura() {return temperatura;}
    public float getTempo() {return tempo;}

    //construtores
    public Leitura(){
       temperatura=0;
       densidade=0;
       tempo=0;
    }

    public JSONObject toJsonObject(){
        JSONObject arquivo=new JSONObject();
        try {
            arquivo.put("temperatura", this.temperatura);
            arquivo.put("densidade", this.densidade);
            arquivo.put("tempo", this.tempo);
        }catch (JSONException exception){
            exception.printStackTrace();
        }

        return arquivo;
    }

    public Leitura(JSONObject arquivo){
        try{
            this.setTemperatura((float) arquivo.get("temperatura"));
            this.setDensidade((float) arquivo.get("densidade"));
            this.setTempo((float) arquivo.get("tempo"));
        } catch (JSONException exception){
            exception.printStackTrace();
        }
    }
}
