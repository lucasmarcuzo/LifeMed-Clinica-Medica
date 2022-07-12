package controller;

import model.ModelPacientes;
import Dao.DAOPacientes;
import java.util.ArrayList;

/**
*
* @author LucasMarcuzo
*/
public class ControllerPacientes {

    private DAOPacientes daoPacientes = new DAOPacientes();

    /**
    * grava Pacientes
    * @param pModelPacientes
    * @return int
    */
    public boolean salvarPacientesController(ModelPacientes pModelPacientes){
        return this.daoPacientes.salvarPacientesDAO(pModelPacientes);
    }

    /**
    * recupera Pacientes
    * @param pId_paciente
    * @return ModelPacientes
    */
    public ModelPacientes getPacientesController(int pId_paciente){
        return this.daoPacientes.getPacientesDAO(pId_paciente);
    }

    /**
    * recupera uma lista dePacientes
    * @return ArrayList
    */
    public ArrayList<ModelPacientes> getListaPacientesController(){
        return this.daoPacientes.getListaPacientesDAO();
    }

    /**
    * atualiza Pacientes
    * @param pModelPacientes
    * @return boolean
    */
    public boolean atualizarPacientesController(ModelPacientes pModelPacientes){
        return this.daoPacientes.atualizarPacientesDAO(pModelPacientes);
    }

    /**
    * exclui Pacientes
    * @param pId_paciente
    * @return boolean
    */
    public boolean excluirPacientesController(int pId_paciente){
        return this.daoPacientes.excluirPacientesDAO(pId_paciente);
    }
    
    /**
    * Proximo ID Pacientes
    * @return int
    */
    public int retornarProximoIDPacientes(){
        return this.daoPacientes.proximoID();
    }
    
    /**
    * Faz pesquisa de Paciente
    * @param pesquisa
    * @param localPesquisa
    * @return ArrayList
    */
    public ArrayList<ModelPacientes> pesquisarPacienteController(String pesquisa, String localPesquisa){
        return this.daoPacientes.getListaPacientesDAO(pesquisa, localPesquisa);
    }
}