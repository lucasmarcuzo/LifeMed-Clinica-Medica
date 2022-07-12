package model;
/**
*
* @author LucasMarcuzo
*/
public class ModelAgendamentos {

    private int id_agendamento;
    private String data_agendamento;
    private String hora_agendamento;
    private String paciente;
    private String tel_fixo;
    private String tel_celular;
    private String tel_contato;
    private String especialidade;
    private String especialista;
    private String tipo_procedimento;
    private String procedimento;
    private String tipo_atendimento;
    private String convenio;
    private String observacoes;
    private String status_agendamento;
    private String dt_realizacao_agendamento;


    /**
    * Construtor
    */
    public ModelAgendamentos(){}

    /**
    * seta o valor de id_agendamento
    * @param pId_agendamento
    */
    public void setId_agendamento(int pId_agendamento){
        this.id_agendamento = pId_agendamento;
    }
    /**
    * @return pk_id_agendamento
    */
    public int getId_agendamento(){
        return this.id_agendamento;
    }

    /**
    * seta o valor de data_agendamento
    * @param pData_agendamento
    */
    public void setData_agendamento(String pData_agendamento){
        this.data_agendamento = pData_agendamento;
    }
    /**
    * @return data_agendamento
    */
    public String getData_agendamento(){
        return this.data_agendamento;
    }

    /**
    * seta o valor de hora_agendamento
    * @param pHora_agendamento
    */
    public void setHora_agendamento(String pHora_agendamento){
        this.hora_agendamento = pHora_agendamento;
    }
    /**
    * @return hora_agendamento
    */
    public String getHora_agendamento(){
        return this.hora_agendamento;
    }

    /**
    * seta o valor de paciente
    * @param pPaciente
    */
    public void setPaciente(String pPaciente){
        this.paciente = pPaciente;
    }
    /**
    * @return fk_paciente
    */
    public String getPaciente(){
        return this.paciente;
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
    * seta o valor de especialidade
    * @param pEspecialidade
    */
    public void setEspecialidade(String pEspecialidade){
        this.especialidade = pEspecialidade;
    }
    /**
    * @return especialidade
    */
    public String getEspecialidade(){
        return this.especialidade;
    }

    /**
    * seta o valor de especialista
    * @param pEspecialista
    */
    public void setEspecialista(String pEspecialista){
        this.especialista = pEspecialista;
    }
    /**
    * @return especialista
    */
    public String getEspecialista(){
        return this.especialista;
    }

    /**
    * seta o valor de tipo_procedimento
    * @param pTipo_procedimento
    */
    public void setTipo_procedimento(String pTipo_procedimento){
        this.tipo_procedimento = pTipo_procedimento;
    }
    /**
    * @return tipo_procedimento
    */
    public String getTipo_procedimento(){
        return this.tipo_procedimento;
    }

    /**
    * seta o valor de tipo_atendimento
    * @param pTipo_atendimento
    */
    public void setTipo_atendimento(String pTipo_atendimento){
        this.tipo_atendimento = pTipo_atendimento;
    }
    /**
    * @return tipo_atendimento
    */
    public String getTipo_atendimento(){
        return this.tipo_atendimento;
    }

    /**
    * seta o valor de convenio
    * @param pConvenio
    */
    public void setConvenio(String pConvenio){
        this.convenio = pConvenio;
    }
    /**
    * @return convenio
    */
    public String getConvenio(){
        return this.convenio;
    }

    /**
    * seta o valor de observacoes
    * @param pObservacoes
    */
    public void setObservacoes(String pObservacoes){
        this.observacoes = pObservacoes;
    }
    /**
    * @return observacoes
    */
    public String getObservacoes(){
        return this.observacoes;
    }

    /**
    * seta o valor de status_agendamento
    * @param pStatus_agendamento
    */
    public void setStatus_agendamento(String pStatus_agendamento){
        this.status_agendamento = pStatus_agendamento;
    }
    /**
    * @return status_agendamento
    */
    public String getStatus_agendamento(){
        return this.status_agendamento;
    }
    
    /**
     *
     * @return procedimento
     */
    public String getProcedimento() {
        return procedimento;
    }

    /**
     * seta o valor de procedimento
     * @param procedimento
     */
    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }
    
    /**
     *
     * @return dt_realizacao_agendamento
     */
    public String getDt_realizacao_agendamento() {
        return dt_realizacao_agendamento;
    }

    /**
     * seta o valor de dt_realizacao_agendamento
     * @param dt_realizacao_agendamento
     */
    public void setDt_realizacao_agendamento(String dt_realizacao_agendamento) {
        this.dt_realizacao_agendamento = dt_realizacao_agendamento;
    }

    @Override
    public String toString(){
        return "ModelAgendamentos {" + "::id_agendamento = " + this.id_agendamento + "::data_agendamento = " + this.data_agendamento + "::hora_agendamento = " + this.hora_agendamento + "::paciente = " + this.paciente + "::tel_fixo = " + this.tel_fixo + "::tel_celular = " + this.tel_celular + "::tel_contato = " + this.tel_contato + "::especialidade = " + this.especialidade + "::especialista = " + this.especialista + "::tipo_procedimento = " + this.tipo_procedimento + "::procedimento = " + this.procedimento + "::tipo_atendimento = " + this.tipo_atendimento + "::convenio = " + this.convenio + "::observacoes = " + this.observacoes + "::status_agendamento = " + this.status_agendamento +  "}";
    }
}