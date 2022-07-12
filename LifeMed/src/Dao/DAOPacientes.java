package Dao;

import model.ModelPacientes;
import util.Conexao;
import java.util.ArrayList;
/**
*
* @author LucasMarcuzo
*/
public class DAOPacientes extends Conexao {

    /**
    * grava Pacientes
    * @param pModelPacientes
    * @return boolean
    */
    public boolean salvarPacientesDAO(ModelPacientes pModelPacientes){
        try {
            this.conectar();
            this.insertSQL(
                "INSERT INTO tbl_pacientes ("
                    + "pk_id_paciente,"
                    + "pk_nome,"
                    + "sexo,"
                    + "dt_nascimento,"
                    + "estado_civil,"
                    + "cpf,"
                    + "rg,"
                    + "orgao_exp,"
                    + "nacionalidade,"
                    + "naturalidade,"
                    + "tel_fixo,"
                    + "tel_celular,"
                    + "tel_contato,"
                    + "email,"
                    + "cep,"
                    + "uf,"
                    + "cidade,"
                    + "bairro,"
                    + "tipo,"
                    + "logradouro,"
                    + "numero,"
                    + "complemento,"
                    + "dt_cliente_desde"
                + ") VALUES ("
                    + "'" + pModelPacientes.getId_paciente() + "',"
                    + "'" + pModelPacientes.getNome() + "',"
                    + "'" + pModelPacientes.getSexo() + "',"
                    + "'" + pModelPacientes.getDt_nascimento() + "',"
                    + "'" + pModelPacientes.getEstado_civil() + "',"
                    + "'" + pModelPacientes.getCpf() + "',"
                    + "'" + pModelPacientes.getRg() + "',"
                    + "'" + pModelPacientes.getOrgao_exp() + "',"
                    + "'" + pModelPacientes.getNacionalidade() + "',"
                    + "'" + pModelPacientes.getNaturalidade() + "',"
                    + "'" + pModelPacientes.getTel_fixo() + "',"
                    + "'" + pModelPacientes.getTel_celular() + "',"
                    + "'" + pModelPacientes.getTel_contato() + "',"
                    + "'" + pModelPacientes.getEmail() + "',"
                    + "'" + pModelPacientes.getCep() + "',"
                    + "'" + pModelPacientes.getUf() + "',"
                    + "'" + pModelPacientes.getCidade() + "',"
                    + "'" + pModelPacientes.getBairro() + "',"
                    + "'" + pModelPacientes.getTipoLogradouro()+ "',"
                    + "'" + pModelPacientes.getLogradouro() + "',"
                    + "'" + pModelPacientes.getNumeroCasa() + "',"
                    + "'" + pModelPacientes.getComplemento() + "',"
                    + "'" + pModelPacientes.getDt_cliente_desde() + "'"
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
    * recupera Pacientes
    * @param pId_paciente
    * @return ModelPacientes
    */
    public ModelPacientes getPacientesDAO(int pId_paciente){
        ModelPacientes modelPacientes = new ModelPacientes();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_paciente,"
                    + "pk_nome,"
                    + "sexo,"
                    + "dt_nascimento,"
                    + "estado_civil,"
                    + "cpf,"
                    + "rg,"
                    + "orgao_exp,"
                    + "nacionalidade,"
                    + "naturalidade,"
                    + "tel_fixo,"
                    + "tel_celular,"
                    + "tel_contato,"
                    + "email,"
                    + "cep,"
                    + "uf,"
                    + "cidade,"
                    + "bairro,"
                    + "tipo,"
                    + "logradouro,"
                    + "numero,"
                    + "complemento,"
                    + "dt_cliente_desde"
                 + " FROM"
                     + " tbl_pacientes"
                 + " WHERE"
                     + " pk_id_paciente = '" + pId_paciente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPacientes.setId_paciente(this.getResultSet().getInt(1));
                modelPacientes.setNome(this.getResultSet().getString(2));
                modelPacientes.setSexo(this.getResultSet().getString(3));
                modelPacientes.setDt_nascimento(this.getResultSet().getString(4));
                modelPacientes.setEstado_civil(this.getResultSet().getString(5));
                modelPacientes.setCpf(this.getResultSet().getString(6));
                modelPacientes.setRg(this.getResultSet().getString(7));
                modelPacientes.setOrgao_exp(this.getResultSet().getString(8));
                modelPacientes.setNacionalidade(this.getResultSet().getString(9));
                modelPacientes.setNaturalidade(this.getResultSet().getString(10));
                modelPacientes.setTel_fixo(this.getResultSet().getString(11));
                modelPacientes.setTel_celular(this.getResultSet().getString(12));
                modelPacientes.setTel_contato(this.getResultSet().getString(13));
                modelPacientes.setEmail(this.getResultSet().getString(14));
                modelPacientes.setCep(this.getResultSet().getString(15));
                modelPacientes.setUf(this.getResultSet().getString(16));
                modelPacientes.setCidade(this.getResultSet().getString(17));
                modelPacientes.setBairro(this.getResultSet().getString(18));
                modelPacientes.setTipoLogradouro(this.getResultSet().getString(19));
                modelPacientes.setLogradouro(this.getResultSet().getString(20));
                modelPacientes.setNumeroCasa(this.getResultSet().getInt(21));
                modelPacientes.setComplemento(this.getResultSet().getString(22));
                modelPacientes.setDt_cliente_desde(this.getResultSet().getString(23));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelPacientes;
    }

    /**
    * recupera uma lista de Pacientes
        * @return ArrayList
    */
    public ArrayList<ModelPacientes> getListaPacientesDAO(){
        ArrayList<ModelPacientes> listamodelPacientes = new ArrayList();
        ModelPacientes modelPacientes = new ModelPacientes();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_paciente,"
                    + "pk_nome,"
                    + "sexo,"
                    + "dt_nascimento,"
                    + "estado_civil,"
                    + "cpf,"
                    + "rg,"
                    + "orgao_exp,"
                    + "nacionalidade,"
                    + "naturalidade,"
                    + "tel_fixo,"
                    + "tel_celular,"
                    + "tel_contato,"
                    + "email,"
                    + "cep,"
                    + "uf,"
                    + "cidade,"
                    + "bairro,"
                    + "tipo,"
                    + "logradouro,"
                    + "numero,"
                    + "complemento,"
                    + "dt_cliente_desde"
                 + " FROM"
                     + " tbl_pacientes"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPacientes = new ModelPacientes();
                modelPacientes.setId_paciente(this.getResultSet().getInt(1));
                modelPacientes.setNome(this.getResultSet().getString(2));
                modelPacientes.setSexo(this.getResultSet().getString(3));
                modelPacientes.setDt_nascimento(this.getResultSet().getString(4));
                modelPacientes.setEstado_civil(this.getResultSet().getString(5));
                modelPacientes.setCpf(this.getResultSet().getString(6));
                modelPacientes.setRg(this.getResultSet().getString(7));
                modelPacientes.setOrgao_exp(this.getResultSet().getString(8));
                modelPacientes.setNacionalidade(this.getResultSet().getString(9));
                modelPacientes.setNaturalidade(this.getResultSet().getString(10));
                modelPacientes.setTel_fixo(this.getResultSet().getString(11));
                modelPacientes.setTel_celular(this.getResultSet().getString(12));
                modelPacientes.setTel_contato(this.getResultSet().getString(13));
                modelPacientes.setEmail(this.getResultSet().getString(14));
                modelPacientes.setCep(this.getResultSet().getString(15));
                modelPacientes.setUf(this.getResultSet().getString(16));
                modelPacientes.setCidade(this.getResultSet().getString(17));
                modelPacientes.setBairro(this.getResultSet().getString(18));
                modelPacientes.setTipoLogradouro(this.getResultSet().getString(19));
                modelPacientes.setLogradouro(this.getResultSet().getString(20));
                modelPacientes.setNumeroCasa(this.getResultSet().getInt(21));
                modelPacientes.setComplemento(this.getResultSet().getString(22));
                modelPacientes.setDt_cliente_desde(this.getResultSet().getString(23));
                listamodelPacientes.add(modelPacientes);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelPacientes;
    }

    /**
    * atualiza Pacientes
    * @param pModelPacientes
    * @return boolean
    */
    public boolean atualizarPacientesDAO(ModelPacientes pModelPacientes){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_pacientes SET "
                    + "pk_id_paciente = '" + pModelPacientes.getId_paciente() + "',"
                    + "pk_nome = '" + pModelPacientes.getNome() + "',"
                    + "sexo = '" + pModelPacientes.getSexo() + "',"
                    + "dt_nascimento = '" + pModelPacientes.getDt_nascimento() + "',"
                    + "estado_civil = '" + pModelPacientes.getEstado_civil() + "',"
                    + "cpf = '" + pModelPacientes.getCpf() + "',"
                    + "rg = '" + pModelPacientes.getRg() + "',"
                    + "orgao_exp = '" + pModelPacientes.getOrgao_exp() + "',"
                    + "nacionalidade = '" + pModelPacientes.getNacionalidade() + "',"
                    + "naturalidade = '" + pModelPacientes.getNaturalidade() + "',"
                    + "tel_fixo = '" + pModelPacientes.getTel_fixo() + "',"
                    + "tel_celular = '" + pModelPacientes.getTel_celular() + "',"
                    + "tel_contato = '" + pModelPacientes.getTel_contato() + "',"
                    + "email = '" + pModelPacientes.getEmail() + "',"
                    + "cep = '" + pModelPacientes.getCep() + "',"
                    + "uf = '" + pModelPacientes.getUf() + "',"
                    + "cidade = '" + pModelPacientes.getCidade() + "',"
                    + "bairro = '" + pModelPacientes.getBairro() + "',"
                    + "tipo = '" + pModelPacientes.getTipoLogradouro()+ "',"
                    + "logradouro = '" + pModelPacientes.getLogradouro() + "',"
                    + "numero = '" + pModelPacientes.getNumeroCasa() + "',"
                    + "complemento = '" + pModelPacientes.getComplemento() + "',"
                    + "dt_cliente_desde = '" + pModelPacientes.getDt_cliente_desde() + "'"
                + " WHERE "
                    + "pk_id_paciente = '" + pModelPacientes.getId_paciente() + "'"
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
    * exclui Pacientes
    * @param pId_paciente
    * @return boolean
    */
    public boolean excluirPacientesDAO(int pId_paciente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_pacientes "
                + " WHERE "
                    + "pk_id_paciente = '" + pId_paciente + "'"
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
     * Retorna o próximo ID
     * @return int
     */
    public int proximoID(){
        try {
            this.conectar();
            return this.lastInsertId(
                "SELECT MAX(pk_id_paciente) FROM tbl_pacientes;"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }
    
     /**
    * Realiza uma pesquisa de Pacientes.
    * @param pesquisa
    * @param localPesquisa
    * @return ArrayList
    */
    public ArrayList<ModelPacientes> getListaPacientesDAO(String pesquisa, String localPesquisa){
        ArrayList<ModelPacientes> listaModelPacientes;
        listaModelPacientes = new ArrayList<>();
        ModelPacientes modelPacientes = null;
        
        try {
            this.conectar();
            switch(localPesquisa){
                case "ID":
                    localPesquisa = "pk_id_paciente";
                    break;
                case "NOME":
                    localPesquisa = "pk_nome";
                    break;
                case "CPF":
                    localPesquisa = "cpf";
                    break;
                case "RG":
                    localPesquisa = "rg";
                    break;
                default:
                    return null;
            }
            
            if(localPesquisa.equals("pk_nome")){
                this.executarSQL(
                    "SELECT * FROM tbl_pacientes WHERE "+ localPesquisa +" LIKE '%"+ pesquisa +"%'"
                );
            }
            else{
                this.executarSQL(
                    "SELECT * FROM tbl_pacientes WHERE "+ localPesquisa +" LIKE '"+ pesquisa +"'"
                );
            }

            while (this.getResultSet().next()) {
                modelPacientes = new ModelPacientes();
                modelPacientes.setId_paciente(this.getResultSet().getInt(1));
                modelPacientes.setNome(this.getResultSet().getString(2));
                modelPacientes.setSexo(this.getResultSet().getString(3));
                modelPacientes.setDt_nascimento(this.getResultSet().getString(4));
                modelPacientes.setEstado_civil(this.getResultSet().getString(5));
                modelPacientes.setCpf(this.getResultSet().getString(6));
                modelPacientes.setRg(this.getResultSet().getString(7));
                modelPacientes.setOrgao_exp(this.getResultSet().getString(8));
                modelPacientes.setNacionalidade(this.getResultSet().getString(9));
                modelPacientes.setNaturalidade(this.getResultSet().getString(10));
                modelPacientes.setTel_fixo(this.getResultSet().getString(11));
                modelPacientes.setTel_celular(this.getResultSet().getString(12));
                modelPacientes.setTel_contato(this.getResultSet().getString(13));
                modelPacientes.setEmail(this.getResultSet().getString(14));
                modelPacientes.setCep(this.getResultSet().getString(15));
                modelPacientes.setUf(this.getResultSet().getString(16));
                modelPacientes.setCidade(this.getResultSet().getString(17));
                modelPacientes.setBairro(this.getResultSet().getString(18));
                modelPacientes.setTipoLogradouro(this.getResultSet().getString(19));
                modelPacientes.setLogradouro(this.getResultSet().getString(20));
                modelPacientes.setNumeroCasa(this.getResultSet().getInt(21));
                modelPacientes.setComplemento(this.getResultSet().getString(22));
                modelPacientes.setDt_cliente_desde(this.getResultSet().getString(23));
                listaModelPacientes.add(modelPacientes);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelPacientes;
    }
}