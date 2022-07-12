package model;
/**
*
* @author LucasMarcuzo
*/
public class ModelUsuario {

    private int id_novoLogin;
    private String login;
    private String senha;
    private int matricula;
    private boolean loginOk;


    /**
    * Construtor
    */
    public ModelUsuario(){}

    /**
    * seta o valor de id_novoLogin
    * @param pId_novoLogin
    */
    public void setId_novoLogin(int pId_novoLogin){
        this.id_novoLogin = pId_novoLogin;
    }
    /**
    * @return pk_id_novoLogin
    */
    public int getId_novoLogin(){
        return this.id_novoLogin;
    }

    /**
    * seta o valor de login
    * @param pLogin
    */
    public void setLogin(String pLogin){
        this.login = pLogin;
    }
    /**
    * @return login
    */
    public String getLogin(){
        return this.login;
    }

    /**
    * seta o valor de senha
    * @param pSenha
    */
    public void setSenha(String pSenha){
        this.senha = pSenha;
    }
    /**
    * @return senha
    */
    public String getSenha(){
        return this.senha;
    }

    /**
    * seta o valor de matricula
    * @param pMatricula
    */
    public void setMatricula(int pMatricula){
        this.matricula = pMatricula;
    }
    /**
    * @return fk_matricula
    */
    public int getMatricula(){
        return this.matricula;
    }
    
    /**
     * @return boolean
     */
    public boolean isLoginOk() {
        return loginOk;
    }

    /**
     * Seta confirmação de Login.
     * @param loginOk
     */
    public void setLoginOk(boolean loginOk) {
        this.loginOk = loginOk;
    }

    @Override
    public String toString(){
        return "ModelNovoLogin {" + "::id_novoLogin = " + this.id_novoLogin + "::login = " + this.login + "::senha = " + this.senha + "::matricula = " + this.matricula +  "}";
    }
}