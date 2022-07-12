package controller;

import model.ModelAtendimentoMedico;
import DAO.DAOAtendimentoMedico;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author LucasMarcuzo
*/
public class ControllerAtendimentoMedico {

    private DAOAtendimentoMedico daoAtendimentoMedico = new DAOAtendimentoMedico();

    /**
    * grava AtendimentoMedico
    * @param pModelAtendimentoMedico
    * @return boolean
    */
    public boolean salvarAtendimentoMedicoController(ModelAtendimentoMedico pModelAtendimentoMedico){
        return this.daoAtendimentoMedico.salvarAtendimentoMedicoDAO(pModelAtendimentoMedico);
    }

    /**
    * recupera AtendimentoMedico
    * @param pId_atendimentos_medicos
    * @return ModelAtendimentoMedico
    */
    public ModelAtendimentoMedico getAtendimentoMedicoController(int pId_atendimentos_medicos){
        return this.daoAtendimentoMedico.getAtendimentoMedicoDAO(pId_atendimentos_medicos);
    }

    /**
    * recupera uma lista deAtendimentoMedico
    * @param pId_atendimentos_medicos
    * @return ArrayList
    */
    public ArrayList<ModelAtendimentoMedico> getListaAtendimentoMedicoController(){
        return this.daoAtendimentoMedico.getListaAtendimentoMedicoDAO();
    }

    /**
    * atualiza AtendimentoMedico
    * @param pModelAtendimentoMedico
    * @return boolean
    */
    public boolean atualizarAtendimentoMedicoController(ModelAtendimentoMedico pModelAtendimentoMedico){
        return this.daoAtendimentoMedico.atualizarAtendimentoMedicoDAO(pModelAtendimentoMedico);
    }

    /**
    * exclui AtendimentoMedico
    * @param pId_atendimentos_medicos
    * @return boolean
    */
    public boolean excluirAtendimentoMedicoController(int pId_atendimentos_medicos){
        return this.daoAtendimentoMedico.excluirAtendimentoMedicoDAO(pId_atendimentos_medicos);
    }

    /**
     * Retorna a metrícula do médico logado.
     * @param login
     * @return Object
     */
    public Object retornarMatriculaMedico(String login) {
       return this.daoAtendimentoMedico.retornarMatriculaMedico(login);
    }

    /**
     * Retorna próximo Id Atend. Medico.
     * @return int
     */
    public int retornarProximoIDAtendMedico() {
        return this.daoAtendimentoMedico.proximoAtendimentoMedico();
    }

    /**
     * Retorna o número de consultas do dia do profissional.
     * @param matricula
     * @return int
     */
    public int retornarNumConsultasDoDia(String matricula) {
       return this.daoAtendimentoMedico.numConsultasDoDia(matricula);
    }

    /**
     * Retorna o histórico do paciente selecionado pelo médico.
     * @param pesquisa
     * @return ModelAtendimentoMedico
     */
    public List<ModelAtendimentoMedico> getListaAtendimentoMedController(String pesquisa) {
       return this.daoAtendimentoMedico.getHistoricoPacienteAtendMedico(pesquisa);
    }


}