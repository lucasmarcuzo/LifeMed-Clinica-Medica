package DAO;

import java.sql.SQLException;
import model.ModelAtendimentoMedico;
import util.Conexao;
import java.util.ArrayList;
import java.util.List;
/**
*
* @author LucasMarcuzo
*/
public class DAOAtendimentoMedico extends Conexao {

    /**
    * grava AtendimentoMedico
    * @param pModelAtendimentoMedico
    * @return boolean
    */
    public boolean salvarAtendimentoMedicoDAO(ModelAtendimentoMedico pModelAtendimentoMedico){
        try {
            this.conectar();
            this.insertSQL(
                "INSERT INTO tbl_atendimentos_medicos ("
                    + "pk_id_atendimentos_medicos,"
                    + "fk_matricula_medico,"
                    + "num_consulta_dia,"
                    + "data_consulta,"
                    + "fk_nome_paciente,"
                    + "sexo_paciente,"
                    + "dt_nasc_paciente,"
                    + "pk_registro_atendimento,"
                    + "logradouro_paciente,"
                    + "diagnostico,"
                    + "doencas_cronicas"
                + ") VALUES ("
                    + "'" + pModelAtendimentoMedico.getId_atendimentos_medicos() + "',"
                    + "'" + pModelAtendimentoMedico.getMatricula_medico() + "',"
                    + "'" + pModelAtendimentoMedico.getNum_consulta_dia() + "',"
                    + "'" + pModelAtendimentoMedico.getData_consulta() + "',"
                    + "'" + pModelAtendimentoMedico.getNome_paciente() + "',"
                    + "'" + pModelAtendimentoMedico.getSexo_paciente() + "',"
                    + "'" + pModelAtendimentoMedico.getDt_nasc_paciente() + "',"
                    + "'" + pModelAtendimentoMedico.getRegistro_atendimento()+ "',"
                    + "'" + pModelAtendimentoMedico.getLogradouro_paciente() + "',"
                    + "'" + pModelAtendimentoMedico.getDiagnostico() + "',"
                    + "'" + pModelAtendimentoMedico.getDoencas_cronicas() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
        return true;
    }

    /**
    * recupera AtendimentoMedico
    * @param pId_atendimentos_medicos
    * @return ModelAtendimentoMedico
    */
    public ModelAtendimentoMedico getAtendimentoMedicoDAO(int pId_atendimentos_medicos){
        ModelAtendimentoMedico modelAtendimentoMedico = new ModelAtendimentoMedico();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_atendimentos_medicos,"
                    + "fk_matricula_medico,"
                    + "num_consulta_dia,"
                    + "data_consulta,"
                    + "fk_nome_paciente,"
                    + "sexo_paciente,"
                    + "dt_nasc_paciente,"
                    + "pk_registro_atendimento,"
                    + "logradouro_paciente,"
                    + "diagnostico,"
                    + "doencas_cronicas"
                 + " FROM"
                     + " tbl_atendimentos_medicos"
                 + " WHERE"
                     + " pk_id_atendimentos_medicos = '" + pId_atendimentos_medicos + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAtendimentoMedico.setId_atendimentos_medicos(this.getResultSet().getInt(1));
                modelAtendimentoMedico.setMatricula_medico(this.getResultSet().getInt(2));
                modelAtendimentoMedico.setNum_consulta_dia(this.getResultSet().getInt(3));
                modelAtendimentoMedico.setData_consulta(this.getResultSet().getString(4));
                modelAtendimentoMedico.setNome_paciente(this.getResultSet().getString(5));
                modelAtendimentoMedico.setSexo_paciente(this.getResultSet().getString(6));
                modelAtendimentoMedico.setDt_nasc_paciente(this.getResultSet().getString(7));
                modelAtendimentoMedico.setRegistro_atendimento(this.getResultSet().getString(8));
                modelAtendimentoMedico.setLogradouro_paciente(this.getResultSet().getString(9));
                modelAtendimentoMedico.setDiagnostico(this.getResultSet().getString(10));
                modelAtendimentoMedico.setDoencas_cronicas(this.getResultSet().getString(11));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelAtendimentoMedico;
    }

    /**
    * recupera uma lista de AtendimentoMedico
        * @return ArrayList
    */
    public ArrayList<ModelAtendimentoMedico> getListaAtendimentoMedicoDAO(){
        ArrayList<ModelAtendimentoMedico> listamodelAtendimentoMedico = new ArrayList();
        ModelAtendimentoMedico modelAtendimentoMedico = new ModelAtendimentoMedico();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_atendimentos_medicos,"
                    + "fk_matricula_medico,"
                    + "num_consulta_dia,"
                    + "data_consulta,"
                    + "fk_nome_paciente,"
                    + "sexo_paciente,"
                    + "dt_nasc_paciente,"
                    + "pk_registro_atendimento,"
                    + "logradouro_paciente,"
                    + "diagnostico,"
                    + "doencas_cronicas"
                 + " FROM"
                     + " tbl_atendimentos_medicos"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAtendimentoMedico = new ModelAtendimentoMedico();
                modelAtendimentoMedico.setId_atendimentos_medicos(this.getResultSet().getInt(1));
                modelAtendimentoMedico.setMatricula_medico(this.getResultSet().getInt(2));
                modelAtendimentoMedico.setNum_consulta_dia(this.getResultSet().getInt(3));
                modelAtendimentoMedico.setData_consulta(this.getResultSet().getString(4));
                modelAtendimentoMedico.setNome_paciente(this.getResultSet().getString(5));
                modelAtendimentoMedico.setSexo_paciente(this.getResultSet().getString(6));
                modelAtendimentoMedico.setDt_nasc_paciente(this.getResultSet().getString(7));
                modelAtendimentoMedico.setRegistro_atendimento(this.getResultSet().getString(8));
                modelAtendimentoMedico.setLogradouro_paciente(this.getResultSet().getString(9));
                modelAtendimentoMedico.setDiagnostico(this.getResultSet().getString(10));
                modelAtendimentoMedico.setDoencas_cronicas(this.getResultSet().getString(11));
                listamodelAtendimentoMedico.add(modelAtendimentoMedico);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAtendimentoMedico;
    }

    /**
    * atualiza AtendimentoMedico
    * @param pModelAtendimentoMedico
    * @return boolean
    */
    public boolean atualizarAtendimentoMedicoDAO(ModelAtendimentoMedico pModelAtendimentoMedico){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_atendimentos_medicos SET "
                    + "pk_id_atendimentos_medicos = '" + pModelAtendimentoMedico.getId_atendimentos_medicos() + "',"
                    + "fk_matricula_medico = '" + pModelAtendimentoMedico.getMatricula_medico() + "',"
                    + "num_consulta_dia = '" + pModelAtendimentoMedico.getNum_consulta_dia() + "',"
                    + "data_consulta = '" + pModelAtendimentoMedico.getData_consulta() + "',"
                    + "fk_nome_paciente = '" + pModelAtendimentoMedico.getNome_paciente() + "',"
                    + "sexo_paciente = '" + pModelAtendimentoMedico.getSexo_paciente() + "',"
                    + "dt_nasc_paciente = '" + pModelAtendimentoMedico.getDt_nasc_paciente() + "',"
                    + "pk_registro_atendimento = '" + pModelAtendimentoMedico.getRegistro_atendimento() + "',"
                    + "logradouro_paciente = '" + pModelAtendimentoMedico.getLogradouro_paciente() + "',"
                    + "diagnostico = '" + pModelAtendimentoMedico.getDiagnostico() + "',"
                    + "doencas_cronicas = '" + pModelAtendimentoMedico.getDoencas_cronicas() + "'"
                + " WHERE "
                    + "pk_id_atendimentos_medicos = '" + pModelAtendimentoMedico.getId_atendimentos_medicos() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui AtendimentoMedico
    * @param pId_atendimentos_medicos
    * @return boolean
    */
    public boolean excluirAtendimentoMedicoDAO(int pId_atendimentos_medicos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_atendimentos_medicos "
                + " WHERE "
                    + "pk_id_atendimentos_medicos = '" + pId_atendimentos_medicos + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
     * Retorna a matricula do médico logado.
     * @param login
     * @return Object
     */
    public Object retornarMatriculaMedico(String login) {
         try {
            this.conectar();
            return this.returnConsultaBD(
                    "SELECT fk_matricula "
                    + "FROM lifemed.tbl_usuarios "
                    + "WHERE login ='" + login +"';"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
     * Retorna o próximo número do Atend. Médico.
     * @return int
     */
    public int proximoAtendimentoMedico() {
         try {
            this.conectar();
            return this.lastInsertId(
                "SELECT MAX(pk_id_atendimentos_medicos) FROM tbl_atendimentos_medicos;"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    public int numConsultasDoDia(String matricula) {
        try {
            this.conectar();
            return this.returnConsultaBD(
                "SELECT count(hora_agendamento) "
                + "FROM lifemed.tbl_agendamentos "
                + "INNER JOIN lifemed.tbl_funcionarios "
                + "ON lifemed.tbl_agendamentos.especialista = lifemed.tbl_funcionarios.nome "
                + "WHERE lifemed.tbl_funcionarios.pk_matricula = '"+ matricula +"' "
                + "GROUP BY lifemed.tbl_funcionarios.nome;"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
     * Pesquisa o historico do paciente selecionado e retorna seu histórico.
     * @param pesquisa
     * @return
     */
    public List<ModelAtendimentoMedico> getHistoricoPacienteAtendMedico(String pesquisa) {
        ArrayList<ModelAtendimentoMedico> listaModelAtendimentoMedico = new ArrayList<>();
        ModelAtendimentoMedico modelAtendimentoMedico = null;
        try{
            this.conectar();

            this.executarSQL(
                "SELECT * FROM tbl_atendimentos_medicos WHERE fk_nome_paciente LIKE '%"+ pesquisa +"%'"
            );

            while(this.getResultSet().next()) {
                modelAtendimentoMedico = new ModelAtendimentoMedico();
                modelAtendimentoMedico.setId_atendimentos_medicos(this.getResultSet().getInt(1));
                modelAtendimentoMedico.setMatricula_medico(this.getResultSet().getInt(2));
                modelAtendimentoMedico.setNum_consulta_dia(this.getResultSet().getInt(3));
                modelAtendimentoMedico.setData_consulta(this.getResultSet().getString(4));
                modelAtendimentoMedico.setNome_paciente(this.getResultSet().getString(5));
                modelAtendimentoMedico.setSexo_paciente(this.getResultSet().getString(6));
                modelAtendimentoMedico.setDt_nasc_paciente(this.getResultSet().getString(7));
                modelAtendimentoMedico.setLogradouro_paciente(this.getResultSet().getString(8));
                modelAtendimentoMedico.setRegistro_atendimento(this.getResultSet().getString(9));
                modelAtendimentoMedico.setDiagnostico(this.getResultSet().getString(10));
                modelAtendimentoMedico.setDoencas_cronicas(this.getResultSet().getString(11));
                listaModelAtendimentoMedico.add(modelAtendimentoMedico);
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelAtendimentoMedico;
    }
}