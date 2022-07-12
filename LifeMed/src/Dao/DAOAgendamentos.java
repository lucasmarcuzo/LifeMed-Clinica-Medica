package DAO;

import model.ModelAgendamentos;
import util.Conexao;
import java.util.ArrayList;
import java.util.List;
/**
*
* @author LucasMarcuzo
*/
public class DAOAgendamentos extends Conexao {

    /**
    * grava Agendamentos
    * @param pModelAgendamentos
    * @return boolean
    */
    public boolean salvarAgendamentosDAO(ModelAgendamentos pModelAgendamentos){
        try {
            this.conectar();
            this.insertSQL(
                "INSERT INTO tbl_agendamentos ("
                    + "pk_id_agendamento,"
                    + "data_agendamento,"
                    + "hora_agendamento,"
                    + "fk_paciente,"
                    + "tel_fixo,"
                    + "tel_celular,"
                    + "tel_contato,"
                    + "especialidade,"
                    + "especialista,"
                    + "tipo_procedimento,"
                    + "procedimento,"
                    + "tipo_atendimento,"
                    + "convenio,"
                    + "observacoes,"
                    + "status_agendamento,"
                    + "dt_realizacao_agendamento"
                + ") VALUES ("
                    + "'" + pModelAgendamentos.getId_agendamento() + "',"
                    + "'" + pModelAgendamentos.getData_agendamento() + "',"
                    + "'" + pModelAgendamentos.getHora_agendamento() + "',"
                    + "'" + pModelAgendamentos.getPaciente() + "',"
                    + "'" + pModelAgendamentos.getTel_fixo() + "',"
                    + "'" + pModelAgendamentos.getTel_celular() + "',"
                    + "'" + pModelAgendamentos.getTel_contato() + "',"
                    + "'" + pModelAgendamentos.getEspecialidade() + "',"
                    + "'" + pModelAgendamentos.getEspecialista() + "',"
                    + "'" + pModelAgendamentos.getTipo_procedimento() + "',"
                    + "'" + pModelAgendamentos.getProcedimento() + "',"
                    + "'" + pModelAgendamentos.getTipo_atendimento() + "',"
                    + "'" + pModelAgendamentos.getConvenio() + "',"
                    + "'" + pModelAgendamentos.getObservacoes() + "',"
                    + "'" + pModelAgendamentos.getStatus_agendamento() + "',"
                    + "'" + pModelAgendamentos.getDt_realizacao_agendamento()+ "'"
                + ");"
            );
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Agendamentos
    * @param pId_agendamento
    * @return ModelAgendamentos
    */
    public ModelAgendamentos getAgendamentosDAO(int pId_agendamento){
        ModelAgendamentos modelAgendamentos = new ModelAgendamentos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_agendamento,"
                    + "data_agendamento,"
                    + "hora_agendamento,"
                    + "fk_paciente,"
                    + "tel_fixo,"
                    + "tel_celular,"
                    + "tel_contato,"
                    + "especialidade,"
                    + "especialista,"
                    + "tipo_procedimento,"
                    + "procedimento,"
                    + "tipo_atendimento,"
                    + "convenio,"
                    + "observacoes,"
                    + "status_agendamento,"
                    + "dt_realizacao_agendamento"
                 + " FROM"
                     + " tbl_agendamentos"
                 + " WHERE"
                     + " pk_id_agendamento = '" + pId_agendamento + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAgendamentos.setId_agendamento(this.getResultSet().getInt(1));
                modelAgendamentos.setData_agendamento(this.getResultSet().getString(2));
                modelAgendamentos.setHora_agendamento(this.getResultSet().getString(3));
                modelAgendamentos.setPaciente(this.getResultSet().getString(4));
                modelAgendamentos.setTel_fixo(this.getResultSet().getString(5));
                modelAgendamentos.setTel_celular(this.getResultSet().getString(6));
                modelAgendamentos.setTel_contato(this.getResultSet().getString(7));
                modelAgendamentos.setEspecialidade(this.getResultSet().getString(8));
                modelAgendamentos.setEspecialista(this.getResultSet().getString(9));
                modelAgendamentos.setTipo_procedimento(this.getResultSet().getString(10));
                modelAgendamentos.setProcedimento(this.getResultSet().getString(11));
                modelAgendamentos.setTipo_atendimento(this.getResultSet().getString(12));
                modelAgendamentos.setConvenio(this.getResultSet().getString(13));
                modelAgendamentos.setObservacoes(this.getResultSet().getString(14));
                modelAgendamentos.setStatus_agendamento(this.getResultSet().getString(15));
                modelAgendamentos.setDt_realizacao_agendamento(this.getResultSet().getString(16));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelAgendamentos;
    }

    /**
    * recupera uma lista de Agendamentos
        * @return ArrayList
    */
    public ArrayList<ModelAgendamentos> getListaAgendamentosDAO(){
        ArrayList<ModelAgendamentos> listamodelAgendamentos = new ArrayList();
        ModelAgendamentos modelAgendamentos = new ModelAgendamentos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_agendamento,"
                    + "data_agendamento,"
                    + "hora_agendamento,"
                    + "fk_paciente,"
                    + "tel_fixo,"
                    + "tel_celular,"
                    + "tel_contato,"
                    + "especialidade,"
                    + "especialista,"
                    + "tipo_procedimento,"
                    + "procedimento,"
                    + "tipo_atendimento,"
                    + "convenio,"
                    + "observacoes,"
                    + "status_agendamento,"
                    + "dt_realizacao_agendamento"
                 + " FROM"
                     + " tbl_agendamentos"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAgendamentos = new ModelAgendamentos();
                modelAgendamentos.setId_agendamento(this.getResultSet().getInt(1));
                modelAgendamentos.setData_agendamento(this.getResultSet().getString(2));
                modelAgendamentos.setHora_agendamento(this.getResultSet().getString(3));
                modelAgendamentos.setPaciente(this.getResultSet().getString(4));
                modelAgendamentos.setTel_fixo(this.getResultSet().getString(5));
                modelAgendamentos.setTel_celular(this.getResultSet().getString(6));
                modelAgendamentos.setTel_contato(this.getResultSet().getString(7));
                modelAgendamentos.setEspecialidade(this.getResultSet().getString(8));
                modelAgendamentos.setEspecialista(this.getResultSet().getString(9));
                modelAgendamentos.setTipo_procedimento(this.getResultSet().getString(10));
                modelAgendamentos.setProcedimento(this.getResultSet().getString(11));
                modelAgendamentos.setTipo_atendimento(this.getResultSet().getString(12));
                modelAgendamentos.setConvenio(this.getResultSet().getString(13));
                modelAgendamentos.setObservacoes(this.getResultSet().getString(14));
                modelAgendamentos.setStatus_agendamento(this.getResultSet().getString(15));
                modelAgendamentos.setDt_realizacao_agendamento(this.getResultSet().getString(16));
                listamodelAgendamentos.add(modelAgendamentos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAgendamentos;
    }

    /**
    * atualiza Agendamentos
    * @param pModelAgendamentos
    * @return boolean
    */
    public boolean atualizarAgendamentosDAO(ModelAgendamentos pModelAgendamentos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_agendamentos SET "
                    + "pk_id_agendamento = '" + pModelAgendamentos.getId_agendamento() + "',"
                    + "data_agendamento = '" + pModelAgendamentos.getData_agendamento() + "',"
                    + "hora_agendamento = '" + pModelAgendamentos.getHora_agendamento() + "',"
                    + "fk_paciente = '" + pModelAgendamentos.getPaciente() + "',"
                    + "tel_fixo = '" + pModelAgendamentos.getTel_fixo() + "',"
                    + "tel_celular = '" + pModelAgendamentos.getTel_celular() + "',"
                    + "tel_contato = '" + pModelAgendamentos.getTel_contato() + "',"
                    + "especialidade = '" + pModelAgendamentos.getEspecialidade() + "',"
                    + "especialista = '" + pModelAgendamentos.getEspecialista() + "',"
                    + "tipo_procedimento = '" + pModelAgendamentos.getTipo_procedimento() + "',"
                    + "procedimento = '" + pModelAgendamentos.getProcedimento() + "',"
                    + "tipo_atendimento = '" + pModelAgendamentos.getTipo_atendimento() + "',"
                    + "convenio = '" + pModelAgendamentos.getConvenio() + "',"
                    + "observacoes = '" + pModelAgendamentos.getObservacoes() + "',"
                    + "status_agendamento = '" + pModelAgendamentos.getStatus_agendamento() + "',"
                    + "dt_realizacao_agendamento = '" + pModelAgendamentos.getDt_realizacao_agendamento() + "'"
                + " WHERE "
                    + "pk_id_agendamento = '" + pModelAgendamentos.getId_agendamento() + "'"
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
    * exclui Agendamentos
    * @param pId_agendamento
    * @return boolean
    */
    public boolean excluirAgendamentosDAO(int pId_agendamento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_agendamentos "
                + " WHERE "
                    + "pk_id_agendamento = '" + pId_agendamento + "'"
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
     * Retorna o próximo número de Agendamento.
     * @return int
     */
    public int proximoAgendamento() {
        try {
            this.conectar();
            return this.lastInsertId(
                "SELECT MAX(pk_id_agendamento) FROM tbl_agendamentos;"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    public List<ModelAgendamentos> getListaAgendamentosDAO(String pesquisa, String localPesquisa) {
        ArrayList<ModelAgendamentos> listaModelAgendamentos = new ArrayList<>();
        ModelAgendamentos modelAgendamentos = null;

        try {
            this.conectar();
            switch(localPesquisa){
            case "ID":
                localPesquisa = "pk_id_agendamento";
                break;
            case "NOME":
                localPesquisa = "fk_paciente";
                break;
            case "ESPECIALISTA":
                localPesquisa = "especialista";
                break;
            default:
                return null;
        }
            
        if(localPesquisa.equals("nome")){
             this.executarSQL(
                 "SELECT * FROM tbl_agendamentos WHERE "+ localPesquisa +" LIKE '%"+ pesquisa +"%'"
             );
        }
        else{
             this.executarSQL(
                 "SELECT * FROM tbl_agendamentos WHERE "+ localPesquisa +" LIKE '"+ pesquisa +"'"
             );
        }

        while (this.getResultSet().next()) {
            modelAgendamentos = new ModelAgendamentos();
            modelAgendamentos.setId_agendamento(this.getResultSet().getInt(1));
            modelAgendamentos.setData_agendamento(this.getResultSet().getString(2));
            modelAgendamentos.setHora_agendamento(this.getResultSet().getString(3));
            modelAgendamentos.setPaciente(this.getResultSet().getString(4));
            modelAgendamentos.setTel_fixo(this.getResultSet().getString(5));
            modelAgendamentos.setTel_celular(this.getResultSet().getString(6));
            modelAgendamentos.setTel_contato(this.getResultSet().getString(7));
            modelAgendamentos.setEspecialidade(this.getResultSet().getString(8));
            modelAgendamentos.setEspecialista(this.getResultSet().getString(9));
            modelAgendamentos.setTipo_procedimento(this.getResultSet().getString(10));
            modelAgendamentos.setProcedimento(this.getResultSet().getString(11));
            modelAgendamentos.setTipo_atendimento(this.getResultSet().getString(12));
            modelAgendamentos.setConvenio(this.getResultSet().getString(13));
            modelAgendamentos.setObservacoes(this.getResultSet().getString(14));
            modelAgendamentos.setStatus_agendamento(this.getResultSet().getString(15));
            modelAgendamentos.setDt_realizacao_agendamento(this.getResultSet().getString(16));
            listaModelAgendamentos.add(modelAgendamentos);
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelAgendamentos;
    }
}