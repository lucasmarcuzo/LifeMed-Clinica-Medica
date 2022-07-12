package controller;

import model.ModelFuncionarios;
import DAO.DAOFuncionarios;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author LucasMarcuzo
*/
public class ControllerFuncionarios {

    private DAOFuncionarios daoFuncionarios = new DAOFuncionarios();

    /**
    * grava Funcionarios
    * @param pModelFuncionarios
    * @return boolean
    */
    public boolean salvarFuncionariosController(ModelFuncionarios pModelFuncionarios){
        return this.daoFuncionarios.salvarFuncionariosDAO(pModelFuncionarios);
    }

    /**
    * recupera Funcionarios
    * @param pId_funcionarios
    * @return ModelFuncionarios
    */
    public ModelFuncionarios getFuncionariosController(int pId_funcionarios){
        return this.daoFuncionarios.getFuncionariosDAO(pId_funcionarios);
    }

    /**
    * recupera uma lista deFuncionarios
    * @return ArrayList
    */
    public ArrayList<ModelFuncionarios> getListaFuncionariosController(){
        return this.daoFuncionarios.getListaFuncionariosDAO();
    }

    /**
    * atualiza Funcionarios
    * @param pModelFuncionarios
    * @return boolean
    */
    public boolean atualizarFuncionariosController(ModelFuncionarios pModelFuncionarios){
        return this.daoFuncionarios.atualizarFuncionariosDAO(pModelFuncionarios);
    }

    /**
    * exclui Funcionarios
    * @param pId_funcionarios
    * @return boolean
    */
    public boolean excluirFuncionariosController(int pId_funcionarios){
        return this.daoFuncionarios.excluirFuncionariosDAO(pId_funcionarios);
    }
    
    /**
    * Proximo ID Funcionarios.
    * @return int
    */
    public int retornarProximoIDFuncionarios() {
        return this.daoFuncionarios.proximoID();
    }

    /**
     * Proximo número de Matricula Funcionarios.
     * @return int
     */
    public int retornarProximaMatriculaFuncionarios() {
        return this.daoFuncionarios.proximoMatricula();
    }
    
    /**
    * Faz pesquisa de Funcionario
    * @param pesquisa
    * @param localPesquisa
    * @return ArrayList
    */
    public List<ModelFuncionarios> realizarPesquisaController(String pesquisa, String localPesquisa) {
        return this.daoFuncionarios.getListaFuncionariosDAO(pesquisa, localPesquisa);
    }
}