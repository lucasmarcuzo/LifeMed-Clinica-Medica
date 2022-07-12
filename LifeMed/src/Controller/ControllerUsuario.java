package controller;

import model.ModelUsuario;
import DAO.DAOUsuario;
import java.util.ArrayList;

/**
*
* @author LucasMarcuzo
*/
public class ControllerUsuario {

    private DAOUsuario daoNovoLogin = new DAOUsuario();

    /**
    * grava NovoLogin
    * @param pModelNovoLogin
    * @return int
    */
    public int salvarNovoLoginController(ModelUsuario pModelNovoLogin){
        return this.daoNovoLogin.salvarNovoLoginDAO(pModelNovoLogin);
    }

//    /**
//    * recupera NovoLogin
//    * @param pId_novoLogin
//    * @return ModelUsuario
//    */
//    public ModelUsuario getNovoLoginController(int pId_novoLogin){
//        return this.daoNovoLogin.getNovoLoginDAO(pId_novoLogin);
//    }
//
//    /**
//    * recupera uma lista deNovoLogin
//    * @return ArrayList
//    */
//    public ArrayList<ModelNovoLogin> getListaNovoLoginController(){
//        return this.daoNovoLogin.getListaNovoLoginDAO();
//    }
//
//    /**
//    * atualiza NovoLogin
//    * @param pModelNovoLogin
//    * @return boolean
//    */
//    public boolean atualizarNovoLoginController(ModelUsuario pModelNovoLogin){
//        return this.daoNovoLogin.atualizarNovoLoginDAO(pModelNovoLogin);
//    }
//
//    /**
//    * exclui NovoLogin
//    * @param pId_novoLogin
//    * @return boolean
//    */
//    public boolean excluirNovoLoginController(int pId_novoLogin){
//        return this.daoNovoLogin.excluirNovoLoginDAO(pId_novoLogin);
//    }

    /**
     * Retorna próximo ID do login.
     * @return int
     */
    public int retornarProximoIDNovoLogin() {
        return this.daoNovoLogin.proximoIDNovoLogin();
    }
    
    /**
     * Validar Usuário do Login no BD (Menu).
     * @param modelUsuario
     * @return boolean
     */
    public boolean validarUsuarioController(ModelUsuario modelUsuario) {
       return this.daoNovoLogin.validarUsuario(modelUsuario);
    }
}