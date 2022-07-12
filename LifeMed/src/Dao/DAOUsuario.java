package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ModelUsuario;
import util.Conexao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
*
* @author LucasMarcuzo
*/
public class DAOUsuario extends Conexao {

    /**
    * grava NovoLogin
    * @param pModelNovoLogin
    * @return int
    */
    public int salvarNovoLoginDAO(ModelUsuario pModelNovoLogin){
        try {
            this.conectar();
            return this.insertSQLNovoUsuario(
                "INSERT INTO tbl_usuarios ("
                    + "pk_id_usuarios,"
                    + "login,"
                    + "senha,"
                    + "fk_matricula"
                + ") VALUES ("
                    + "'" + pModelNovoLogin.getId_novoLogin() + "',"
                    + "'" + pModelNovoLogin.getLogin() + "',"
                    + "'" + pModelNovoLogin.getSenha() + "',"
                    + "'" + pModelNovoLogin.getMatricula() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

//    /**
//    * recupera NovoLogin
//    * @param pId_novoLogin
//    * @return ModelUsuario
//    */
//    public ModelUsuario getNovoLoginDAO(int pId_novoLogin){
//        ModelUsuario modelNovoLogin = new ModelUsuario();
//        try {
//            this.conectar();
//            this.executarSQL(
//                "SELECT "
//                    + "pk_id_usuarios,"
//                    + "login,"
//                    + "senha,"
//                    + "fk_matricula"
//                 + " FROM"
//                     + " tbl_usuarios"
//                 + " WHERE"
//                     + " pk_id_novo_login = '" + pId_novoLogin + "'"
//                + ";"
//            );
//
//            while(this.getResultSet().next()){
//                modelNovoLogin.setId_novoLogin(this.getResultSet().getInt(1));
//                modelNovoLogin.setLogin(this.getResultSet().getString(2));
//                modelNovoLogin.setSenha(this.getResultSet().getString(3));
//                modelNovoLogin.setMatricula(this.getResultSet().getInt(4));
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            this.fecharConexao();
//        }
//        return modelNovoLogin;
//    }
//
//    /**
//    * recupera uma lista de NovoLogin
//        * @return ArrayList
//    */
//    public ArrayList<ModelNovoLogin> getListaNovoLoginDAO(){
//        ArrayList<ModelNovoLogin> listamodelNovoLogin = new ArrayList();
//        ModelUsuario modelNovoLogin = new ModelUsuario();
//        try {
//            this.conectar();
//            this.executarSQL(
//                "SELECT "
//                    + "pk_id_usuarios,"
//                    + "login,"
//                    + "senha,"
//                    + "fk_matricula"
//                 + " FROM"
//                     + " tbl_usuarios"
//                + ";"
//            );
//
//            while(this.getResultSet().next()){
//                modelNovoLogin = new ModelUsuario();
//                modelNovoLogin.setId_novoLogin(this.getResultSet().getInt(1));
//                modelNovoLogin.setLogin(this.getResultSet().getString(2));
//                modelNovoLogin.setSenha(this.getResultSet().getString(3));
//                modelNovoLogin.setMatricula(this.getResultSet().getInt(4));
//                listamodelNovoLogin.add(modelNovoLogin);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            this.fecharConexao();
//        }
//        return listamodelNovoLogin;
//    }
//
//    /**
//    * atualiza NovoLogin
//    * @param pModelNovoLogin
//    * @return boolean
//    */
//    public boolean atualizarNovoLoginDAO(ModelUsuario pModelNovoLogin){
//        try {
//            this.conectar();
//            return this.executarUpdateDeleteSQL(
//                "UPDATE tbl_usuarios SET "
//                    + "pk_id_usuarios = '" + pModelNovoLogin.getId_novoLogin() + "',"
//                    + "login = '" + pModelNovoLogin.getLogin() + "',"
//                    + "senha = '" + pModelNovoLogin.getSenha() + "',"
//                    + "fk_matricula = '" + pModelNovoLogin.getMatricula() + "'"
//                + " WHERE "
//                    + "pk_id_novo_login = '" + pModelNovoLogin.getId_novoLogin() + "'"
//                + ";"
//            );
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }finally{
//            this.fecharConexao();
//        }
//    }
//
//    /**
//    * exclui NovoLogin
//    * @param pId_novoLogin
//    * @return boolean
//    */
//    public boolean excluirNovoLoginDAO(int pId_novoLogin){
//        try {
//            this.conectar();
//            return this.executarUpdateDeleteSQL(
//                "DELETE FROM tbl_usuarios "
//                + " WHERE "
//                    + "pk_id_usuarios = '" + pId_novoLogin + "'"
//                + ";"
//            );
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }finally{
//            this.fecharConexao();
//        }
//    }

    /**
     * Retorna próximo ID do Novo Login.
     * @return int
     */
    public int proximoIDNovoLogin() {
         try {
            this.conectar();
            return this.lastInsertId(
                "SELECT MAX(pk_id_usuarios) FROM tbl_usuarios;"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
     * Verificando se Usuário existe no BD para fazer Login.
     * @param modelUsuario
     * @return int
     */
    public boolean validarUsuario(ModelUsuario modelUsuario) {
        try {
            this.conectar();
            return this.executarSQLLogin(
                modelUsuario,
                "SELECT pk_id_usuarios,"
                     + "login, "
                     + "senha, "
                     + "fk_matricula "
                     + "FROM tbl_usuarios "
                     + "WHERE login = ? AND "
                     + "senha = ? "
                + ";"      
            );

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }

    }
}