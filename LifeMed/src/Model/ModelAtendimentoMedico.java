package model;
/**
*
* @author LucasMarcuzo
*/
public class ModelAtendimentoMedico {

    private int id_atendimentos_medicos;
    private int matricula_medico;
    private int num_consulta_dia;
    private String data_consulta;
    private String nome_paciente;
    private String sexo_paciente;
    private String dt_nasc_paciente;
    private String registro_atendimento;
    private String logradouro_paciente;
    private String diagnostico;
    private String doencas_cronicas;

    /**
    * Construtor
    */
    public ModelAtendimentoMedico(){}

    /**
    * seta o valor de id_atendimentos_medicos
    * @param pId_atendimentos_medicos
    */
    public void setId_atendimentos_medicos(int pId_atendimentos_medicos){
        this.id_atendimentos_medicos = pId_atendimentos_medicos;
    }
    /**
    * @return pk_id_atendimentos_medicos
    */
    public int getId_atendimentos_medicos(){
        return this.id_atendimentos_medicos;
    }

    /**
    * seta o valor de matricula_medico
    * @param pMatricula_medico
    */
    public void setMatricula_medico(int pMatricula_medico){
        this.matricula_medico = pMatricula_medico;
    }
    /**
    * @return fk_matricula_medico
    */
    public int getMatricula_medico(){
        return this.matricula_medico;
    }

    /**
    * seta o valor de num_consulta_dia
    * @param pNum_consulta_dia
    */
    public void setNum_consulta_dia(int pNum_consulta_dia){
        this.num_consulta_dia = pNum_consulta_dia;
    }
    /**
    * @return num_consulta_dia
    */
    public int getNum_consulta_dia(){
        return this.num_consulta_dia;
    }

    /**
    * seta o valor de data_consulta
    * @param pData_consulta
    */
    public void setData_consulta(String pData_consulta){
        this.data_consulta = pData_consulta;
    }
    /**
    * @return data_consulta
    */
    public String getData_consulta(){
        return this.data_consulta;
    }

    /**
    * seta o valor de nome_paciente
    * @param pNome_paciente
    */
    public void setNome_paciente(String pNome_paciente){
        this.nome_paciente = pNome_paciente;
    }
    /**
    * @return fk_nome_paciente
    */
    public String getNome_paciente(){
        return this.nome_paciente;
    }

    /**
    * seta o valor de sexo_paciente
    * @param pSexo_paciente
    */
    public void setSexo_paciente(String pSexo_paciente){
        this.sexo_paciente = pSexo_paciente;
    }
    /**
    * @return sexo_paciente
    */
    public String getSexo_paciente(){
        return this.sexo_paciente;
    }

    /**
    * seta o valor de dt_nasc_paciente
    * @param pDt_nasc_paciente
    */
    public void setDt_nasc_paciente(String pDt_nasc_paciente){
        this.dt_nasc_paciente = pDt_nasc_paciente;
    }
    /**
    * @return dt_nasc_paciente
    */
    public String getDt_nasc_paciente(){
        return this.dt_nasc_paciente;
    }

    /**
    * seta o valor de registro_atendimento
     * @param pRegistro_atendimento
    */
    public void setRegistro_atendimento(String pRegistro_atendimento){
        this.registro_atendimento = pRegistro_atendimento;
    }
    /**
    * @return pk_registro_atendimento
    */
    public String getRegistro_atendimento(){
        return this.registro_atendimento;
    }

    /**
    * seta o valor de logradouro_paciente
    * @param pLogradouro_paciente
    */
    public void setLogradouro_paciente(String pLogradouro_paciente){
        this.logradouro_paciente = pLogradouro_paciente;
    }
    /**
    * @return logradouro_paciente
    */
    public String getLogradouro_paciente(){
        return this.logradouro_paciente;
    }

    /**
    * seta o valor de diagnostico
    * @param pDiagnostico
    */
    public void setDiagnostico(String pDiagnostico){
        this.diagnostico = pDiagnostico;
    }
    /**
    * @return diagnostico
    */
    public String getDiagnostico(){
        return this.diagnostico;
    }

    /**
    * seta o valor de doencas_cronicas
    * @param pDoencas_cronicas
    */
    public void setDoencas_cronicas(String pDoencas_cronicas){
        this.doencas_cronicas = pDoencas_cronicas;
    }
    /**
    * @return doencas_cronicas
    */
    public String getDoencas_cronicas(){
        return this.doencas_cronicas;
    }

    @Override
    public String toString(){
        return "ModelAtendimentoMedico {" + "::id_atendimentos_medicos = " + this.id_atendimentos_medicos + "::matricula_medico = " + this.matricula_medico + "::num_consulta_dia = " + this.num_consulta_dia + "::data_consulta = " + this.data_consulta + "::nome_paciente = " + this.nome_paciente + "::sexo_paciente = " + this.sexo_paciente + "::dt_nasc_paciente = " + this.dt_nasc_paciente + "::registro_paciente = " + this.registro_atendimento + "::logradouro_paciente = " + this.logradouro_paciente + "::diagnostico = " + this.diagnostico + "::doencas_cronicas = " + this.doencas_cronicas +  "}";
    }
}