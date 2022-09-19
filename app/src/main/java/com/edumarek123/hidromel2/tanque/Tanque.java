package com.edumarek123.hidromel2.tanque;

import com.edumarek123.hidromel2.medicoes.Leitura;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.Date;

public class Tanque {
    //atributos
    private long id;
    private String nome;
    private String bebida;
    private String especificacoes;
    private float volume;
    private Date dataInicio;
    private Date previsaoTermino;
    private boolean estado;

    private ArrayList<Leitura> leitura;

    //metodos
    public String getNome() {return nome;}
    public String getBebida() {return bebida;}
    public String getEspecificacoes() {return especificacoes;}
    public float getVolume() {return volume;}
    public Date getDataInicio() {return dataInicio;}
    public Date getPrevisaoTermino() {return previsaoTermino;}
    public boolean getEstado() {return estado;}
    public ArrayList<Leitura> getLeitura() {return leitura;}

    public void setId(long id) {this.id=id;}
    public void setNome(String nome) {this.nome=nome;}
    public void setBebida(String bebida) {this.bebida=bebida;}
    public void setEspecificacoes(String especificacoes) {this.especificacoes=especificacoes;}
    public void setVolume(float volume) {this.volume=volume;}
    public void setDataInicio(Date dataInicio) {this.dataInicio=dataInicio;}
    public void setEstado(boolean estado) {this.estado=estado;}
    public void setLeitura(ArrayList<Leitura> leitura) {this.leitura=leitura;}

    public void setPrevisaoTermino() {

    }

    //construtores
    public Tanque(){
        this.setId(0);
        this.setNome("");
        this.setBebida("");
        this.setEspecificacoes("");
        this.setVolume(0);
        this.setDataInicio(null);
        this.setPrevisaoTermino();
        this.setEstado(false);
        leitura=null;
    }

    public JSONObject toJsonObject(){
        JSONObject arquivo=new JSONObject();
        try {
            arquivo.put("id", this.id);
            arquivo.put("nome", this.nome);
            arquivo.put("bebida", this.bebida);
            arquivo.put("especificacoes", this.especificacoes);
            arquivo.put("volume", this.volume);
            arquivo.put("dataInicio", this.dataInicio);
            arquivo.put("previsaoTermino", this.previsaoTermino);
            arquivo.put("estado", this.estado);
            //arquivo.put("Leituras", this.leitura);
        }catch (JSONException exception){
            exception.printStackTrace();
        }

        return arquivo;
    }

    public Tanque(JSONObject arquivo){
        try{
            this.setId((long) arquivo.get("id"));
            this.setNome((String) arquivo.get("nome"));
            this.setBebida((String) arquivo.get("bebida"));
            this.setEspecificacoes((String) arquivo.get("especificacoes"));
            this.setVolume((float) arquivo.get("volume"));
            this.setDataInicio((Date) arquivo.get("dataInicio"));
            this.setPrevisaoTermino();
            this.setEstado((boolean) arquivo.get("estado"));



        } catch (JSONException exception){
            exception.printStackTrace();
        }
    }

}
