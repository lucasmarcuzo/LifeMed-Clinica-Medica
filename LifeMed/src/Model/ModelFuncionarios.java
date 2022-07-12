package model;
/**
*
* @author LucasMarcuzo
*/
public class ModelFuncionarios {

    private int id_funcionarios;
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
    private String setor;
    private String funcao;
    private int matricula;
    private String data_adm;
    private String data_dem;
    private int ctps;
    private String serie_uf;
    private int pis;
    private String dt_funcionario_desde;

    /**
    * Construtor
    */
    public ModelFuncionarios(){}

    /**
    * seta o valor de id_funcionarios
    * @param pId_funcionarios
    */
    public void setId_funcionarios(int pId_funcionarios){
        this.id_funcionarios = pId_funcionarios;
    }
    /**
    * @return pk_id_funcionarios
    */
    public int getId_funcionarios(){
        return this.id_funcionarios;
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
    * seta o valor de etado_civil
    * @param pEtado_civil
    */
    public void setEstado_civil(String pEtado_civil){
        this.estado_civil = pEtado_civil;
    }
    /**
    * @return etado_civil
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
    * seta o valor de tipoLogradouro
    * @param pTipoLogradouro
    */
    public void setTipoLogradouro(String pTipoLogradouro){
        this.tipoLogradouro = pTipoLogradouro;
    }
    /**
    * @return tipoLogradouro
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
    * seta o valor de numeroCasa
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
    * seta o valor de setor
    * @param pSetor
    */
    public void setSetor(String pSetor){
        this.setor = pSetor;
    }
    /**
    * @return setor
    */
    public String getSetor(){
        return this.setor;
    }

    /**
    * seta o valor de funcao
    * @param pFuncao
    */
    public void setFuncao(String pFuncao){
        this.funcao = pFuncao;
    }
    /**
    * @return funcao
    */
    public String getFuncao(){
        return this.funcao;
    }

    /**
    * seta o valor de matricula
    * @param pMatricula
    */
    public void setMatricula(int pMatricula){
        this.matricula = pMatricula;
    }
    /**
    * @return matricula
    */
    public int getMatricula(){
        return this.matricula;
    }

    /**
    * seta o valor de data_adm
    * @param pData_adm
    */
    public void setData_adm(String pData_adm){
        this.data_adm = pData_adm;
    }
    /**
    * @return data_adm
    */
    public String getData_adm(){
        return this.data_adm;
    }

    /**
    * seta o valor de data_dem
    * @param pData_dem
    */
    public void setData_dem(String pData_dem){
        this.data_dem = pData_dem;
    }
    /**
    * @return data_dem
    */
    public String getData_dem(){
        return this.data_dem;
    }

    /**
    * seta o valor de ctps
    * @param pCtps
    */
    public void setCtps(int pCtps){
        this.ctps = pCtps;
    }
    /**
    * @return ctps
    */
    public int getCtps(){
        return this.ctps;
    }

    /**
    * seta o valor de serie_uf
    * @param pSerie_uf
    */
    public void setSerie_uf(String pSerie_uf){
        this.serie_uf = pSerie_uf;
    }
    /**
    * @return serie_uf
    */
    public String getSerie_uf(){
        return this.serie_uf;
    }

    /**
    * seta o valor de pis
    * @param pPis
    */
    public void setPis(int pPis){
        this.pis = pPis;
    }
    /**
    * @return pis
    */
    public int getPis(){
        return this.pis;
    }

    /**
    * seta o valor de dt_funcionario_desde
    * @param pDt_funcionario_desde
    */
    public void setDt_funcionario_desde(String pDt_funcionario_desde){
        this.dt_funcionario_desde = pDt_funcionario_desde;
    }
    /**
    * @return dt_funcionario_desde
    */
    public String getDt_funcionario_desde(){
        return this.dt_funcionario_desde;
    }

    @Override
    public String toString(){
        return "ModelFuncionarios {" + "::id_funcionarios = " + this.id_funcionarios + "::nome = " + this.nome + "::sexo = " + this.sexo + "::dt_nascimento = " + this.dt_nascimento + "::etado_civil = " + this.estado_civil + "::cpf = " + this.cpf + "::rg = " + this.rg + "::orgao_exp = " + this.orgao_exp + "::nacionalidade = " + this.nacionalidade + "::naturalidade = " + this.naturalidade + "::tel_fixo = " + this.tel_fixo + "::tel_celular = " + this.tel_celular + "::tel_contato = " + this.tel_contato + "::email = " + this.email + "::cep = " + this.cep + "::uf = " + this.uf + "::cidade = " + this.cidade + "::bairro = " + this.bairro + "::tipoLogradouro = " + this.tipoLogradouro + "::logradouro = " + this.logradouro + "::numeroCasa = " + this.numeroCasa + "::complemento = " + this.complemento + "::setor = " + this.setor + "::funcao = " + this.funcao + "::matricula = " + this.matricula + "::data_adm = " + this.data_adm + "::data_dem = " + this.data_dem + "::ctps = " + this.ctps + "::serie_uf = " + this.serie_uf + "::pis = " + this.pis + "::dt_funcionario_desde = " + this.dt_funcionario_desde +  "}";
    }
}