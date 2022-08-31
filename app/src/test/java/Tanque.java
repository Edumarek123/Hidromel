import org.json.JSONException;
import org.json.JSONObject;

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

    private float[] temperatura;
    private float[] densidade;
    private long[] tempo;

    //metodos
    public String getNome() {return nome;}
    public String getBebida() {return bebida;}
    public String getEspecificacoes() {return especificacoes;}
    public float getVolume() {return volume;}
    public Date getDataInicio() {return dataInicio;}
    public Date getPrevisaoTermino() {return previsaoTermino;}
    public boolean getEstado() {return estado;}

    public void setId(long id) {this.id=id;}
    public void setNome(String nome) {this.nome=nome;}
    public void setBebida(String bebida) {this.bebida=bebida;}
    public void setEspecificacoes(String especificacoes) {this.especificacoes=especificacoes;}
    public void setVolume(float volume) {this.volume=volume;}
    public void setDataInicio(Date dataInicio) {this.dataInicio=dataInicio;}
    public void setEstado(boolean estado) {this.estado=estado;}

    public void setPrevisaoTermino() {

    }
    public void setDensidade() {

    }
    public void setTemperatura() {

    }
    public void setTempo() {

    }

    public JSONObject toJSONObject(){
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
        }catch (JSONException exception){
            exception.printStackTrace();
        }

        return arquivo;
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
