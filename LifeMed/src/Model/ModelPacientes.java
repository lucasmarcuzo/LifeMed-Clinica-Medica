package model;

/**
*
* @author LucasMarcuzo
*/
public class ModelPacientes {

    private int id_paciente;
    private String nome;
    private String sexo;
    private String dt_nascimento;
    private String estado_civil;
    private String cpf;
    private String rg;
    private String orgao_exp;
    private String nacionalidade;
    private String naturalidade;
    private String tel_fixo;
    private String tel_celular;
    private String tel_contato;
    private String email;
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String tipoLogradouro;
    private String logradouro;
    private int numeroCasa;
    private String complemento;
    private String dt_cliente_desde;

    /**
    * Construtor
    */
    public ModelPacientes(){}

    /**
    * seta o valor de id_paciente
    * @param pId_paciente
    */
    public void setId_paciente(int pId_paciente){
        this.id_paciente = pId_paciente;
    }
    /**
    * @return pk_id_paciente
    */
    public int getId_paciente(){
        return this.id_paciente;
    }

    /**
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * @return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de sexo
    * @param pSexo
    */
    public void setSexo(String pSexo){
        this.sexo = pSexo;
    }
    /**
    * @return sexo
    */
    public String getSexo(){
        return this.sexo;
    }

    /**
    * seta o valor de dt_nascimento
    * @param pDt_nascimento
    */
    public void setDt_nascimento(String pDt_nascimento){
        this.dt_nascimento = pDt_nascimento;
    }
    /**
    * @return dt_nascimento
    */
    public String getDt_nascimento(){
        return this.dt_nascimento;
    }

    /**
    * seta o valor de estado_civil
    * @param pEstado_civil
    */
    public void setEstado_civil(String pEstado_civil){
        this.estado_civil = pEstado_civil;
    }
    /**
    * @return estado_civil
    */
    public String getEstado_civil(){
        return this.estado_civil;
    }

    /**
    * seta o valor de cpf
    * @param pCpf
    */
    public void setCpf(String pCpf){
        this.cpf = pCpf;
    }
    /**
    * @return cpf
    */
    public String getCpf(){
        return this.cpf;
    }

    /**
    * seta o valor de rg
    * @param pRg
    */
    public void setRg(String pRg){
        this.rg = pRg;
    }
    /**
    * @return rg
    */
    public String getRg(){
        return this.rg;
    }

    /**
    * seta o valor de orgao_exp
    * @param pOrgao_exp
    */
    public void setOrgao_exp(String pOrgao_exp){
        this.orgao_exp = pOrgao_exp;
    }
    /**
    * @return orgao_exp
    */
    public String getOrgao_exp(){
        return this.orgao_exp;
    }

    /**
    * seta o valor de nacionalidade
    * @param pNacionalidade
    */
    public void setNacionalidade(String pNacionalidade){
        this.nacionalidade = pNacionalidade;
    }
    /**
    * @return nacionalidade
    */
    public String getNacionalidade(){
        return this.nacionalidade;
    }

    /**
    * seta o valor de naturalidade
    * @param pNaturalidade
    */
    public void setNaturalidade(String pNaturalidade){
        this.naturalidade = pNaturalidade;
    }
    /**
    * @return naturalidade
    */
    public String getNaturalidade(){
        return this.naturalidade;
    }

    /**
    * seta o valor de tel_fixo
    * @param pTel_fixo
    */
    public void setTel_fixo(String pTel_fixo){
        this.tel_fixo = pTel_fixo;
    }
    /**
    * @return tel_fixo
    */
    public String getTel_fixo(){
        return this.tel_fixo;
    }

    /**
    * seta o valor de tel_celular
    * @param pTel_celular
    */
    public void setTel_celular(String pTel_celular){
        this.tel_celular = pTel_celular;
    }
    /**
    * @return tel_celular
    */
    public String getTel_celular(){
        return this.tel_celular;
    }

    /**
    * seta o valor de tel_contato
    * @param pTel_contato
    */
    public void setTel_contato(String pTel_contato){
        this.tel_contato = pTel_contato;
    }
    /**
    * @return tel_contato
    */
    public String getTel_contato(){
        return this.tel_contato;
    }

    /**
    * seta o valor de email
    * @param pEmail
    */
    public void setEmail(String pEmail){
        this.email = pEmail;
    }
    /**
    * @return email
    */
    public String getEmail(){
        return this.email;
    }

    /**
    * seta o valor de cep
    * @param pCep
    */
    public void setCep(String pCep){
        this.cep = pCep;
    }
    /**
    * @return cep
    */
    public String getCep(){
        return this.cep;
    }

    /**
    * seta o valor de uf
    * @param pUf
    */
    public void setUf(String pUf){
        this.uf = pUf;
    }
    /**
    * @return uf
    */
    public String getUf(){
        return this.uf;
    }

    /**
    * seta o valor de cidade
    * @param pCidade
    */
    public void setCidade(String pCidade){
        this.cidade = pCidade;
    }
    /**
    * @return cidade
    */
    public String getCidade(){
        return this.cidade;
    }

    /**
    * seta o valor de bairro
    * @param pBairro
    */
    public void setBairro(String pBairro){
        this.bairro = pBairro;
    }
    /**
    * @return bairro
    */
    public String getBairro(){
        return this.bairro;
    }

    /**
    * seta o valor de tipo
    * @param pTipoLogradouro
    */
    public void setTipoLogradouro(String pTipoLogradouro){
        this.tipoLogradouro = pTipoLogradouro;
    }
    /**
    * @return tipo
    */
    public String getTipoLogradouro(){
        return this.tipoLogradouro;
    }

    /**
    * seta o valor de logradouro
    * @param pLogradouro
    */
    public void setLogradouro(String pLogradouro){
        this.logradouro = pLogradouro;
    }
    /**
    * @return logradouro
    */
    public String getLogradouro(){
        return this.logradouro;
    }

    /**
    * seta o valor de numero
    * @param pNumeroCasa
    */
    public void setNumeroCasa(int pNumeroCasa){
        this.numeroCasa = pNumeroCasa;
    }
    /**
    * @return numeroCasa
    */
    public int getNumeroCasa(){
        return this.numeroCasa;
    }

    /**
    * seta o valor de complemento
    * @param pComplemento
    */
    public void setComplemento(String pComplemento){
        this.complemento = pComplemento;
    }
    /**
    * @return complemento
    */
    public String getComplemento(){
        return this.complemento;
    }

    /**
    * seta o valor de dt_cliente_desde
    * @param pDt_cliente_desde
    */
    public void setDt_cliente_desde(String pDt_cliente_desde){
        this.dt_cliente_desde = pDt_cliente_desde;
    }
    /**
    * @return dt_cliente_desde
    */
    public String getDt_cliente_desde(){
        return this.dt_cliente_desde;
    }

    @Override
    public String toString(){
        return "ModelPacientes {" + "::id_paciente = " + this.id_paciente + "::nome = " + this.nome + "::sexo = " + this.sexo + "::dt_nascimento = " + this.dt_nascimento + "::estado_civil = " + this.estado_civil + "::cpf = " + this.cpf + "::rg = " + this.rg + "::orgao_exp = " + this.orgao_exp + "::nacionalidade = " + this.nacionalidade + "::naturalidade = " + this.naturalidade + "::tel_fixo = " + this.tel_fixo + "::tel_celular = " + this.tel_celular + "::tel_contato = " + this.tel_contato + "::email = " + this.email + "::cep = " + this.cep + "::uf = " + this.uf + "::cidade = " + this.cidade + "::bairro = " + this.bairro + "::tipo = " + this.tipoLogradouro + "::logradouro = " + this.logradouro + "::numero = " + this.numeroCasa + "::complemento = " + this.complemento + "::dt_cliente_desde = " + this.dt_cliente_desde +  "}";
    }
}