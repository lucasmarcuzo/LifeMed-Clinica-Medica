package controller;

import model.ModelAgendamentos;
import DAO.DAOAgendamentos;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author LucasMarcuzo
*/
public class ControllerAgendamentos {

    private DAOAgendamentos daoAgendamentos = new DAOAgendamentos();

    /**
    * grava Agendamentos
    * @param pModelAgendamentos
    * @return boolean
    */
    public boolean salvarAgendamentosController(ModelAgendamentos pModelAgendamentos){
        return this.daoAgendamentos.salvarAgendamentosDAO(pModelAgendamentos);
    }

    /**
    * recupera Agendamentos
    * @param pId_agendamento
    * @return ModelAgendamentos
    */
    public ModelAgendamentos getAgendamentosController(int pId_agendamento){
        return this.daoAgendamentos.getAgendamentosDAO(pId_agendamento);
    }

    /**
    * recupera uma lista deAgendamentos
    * @return ArrayList
    */
    public ArrayList<ModelAgendamentos> getListaAgendamentosController(){
        return this.daoAgendamentos.getListaAgendamentosDAO();
    }

    /**
    * atualiza Agendamentos
    * @param pModelAgendamentos
    * @return boolean
    */
    public boolean atualizarAgendamentosController(ModelAgendamentos pModelAgendamentos){
        return this.daoAgendamentos.atualizarAgendamentosDAO(pModelAgendamentos);
    }

    /**
    * exclui Agendamentos
    * @param pId_agendamento
    * @return boolean
    */
    public boolean excluirAgendamentosController(int pId_agendamento){
        return this.daoAgendamentos.excluirAgendamentosDAO(pId_agendamento);
    }

    /**
     * retorna próximo Id Agendamento.
     * @return int
     */
    public int retornarProximoIDAgendamentos() {
        return this.daoAgendamentos.proximoAgendamento();
    }

    /**
     * Faz pesquisa de Agendamento.
     * @param pesquisa
     * @param localPesquisa
     * @return ModelAgendamentos
     */
    public List<ModelAgendamentos> realizarPesquisaAgendamentosController(String pesquisa, String localPesquisa) {
        return this.daoAgendamentos.getListaAgendamentosDAO(pesquisa, localPesquisa);
    }
    
 
}