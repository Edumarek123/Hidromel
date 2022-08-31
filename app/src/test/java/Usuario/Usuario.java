package Usuario;

import org.json.JSONException;
import org.json.JSONObject;


public class Usuario {
    //atributos
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String permissao;
    private boolean termosOK;

    private Tanque tanques;

    //metodos
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getSenha() {return senha;}
    public String getPermissao() {return permissao;}
    public boolean getTermosOK() {return termosOK;}

    public void setId(long id) {this.id=id;}
    public void setNome(String nome) {this.nome=nome;}
    public void setEmail(String email) {this.email=email;}
    public void setSenha(String senha) {this.senha=senha;}
    public void setPermissao(String permissao) {this.permissao=permissao;}
    public void setTermosOK(boolean termosOK) {this.termosOK=termosOK;}

    public JSONObject toJsonObject(){
        JSONObject arquivo=new JSONObject();
        try {
            arquivo.put("id", this.id);
            arquivo.put("name", this.nome);
            arquivo.put("email", this.email);
            arquivo.put("senha", this.senha);
            arquivo.put("permissao", this.permissao);
            arquivo.put("termosOK", this.termosOK);
        }catch (JSONException exception){
            exception.printStackTrace();
        }

        return arquivo;
    }

    //construtores
    public Usuario(){
        this.setId(0);
        this.setNome("");
        this.setEmail("");
        this.setSenha("");
        this.setPermissao("");
        this.setTermosOK(false);
    }

    public Usuario(JSONObject arquivo){
        try{
            this.setId((long) arquivo.get("id")); //aqui
            this.setNome((String) arquivo.get("nome"));
            this.setEmail((String) arquivo.get("email"));
            this.setSenha((String) arquivo.get("senha"));
            this.setPermissao((String) arquivo.get("permissao"));
            this.setTermosOK((boolean) arquivo.get("termosOK"));
        } catch (JSONException exception){
            exception.printStackTrace();
        }
    }

}
