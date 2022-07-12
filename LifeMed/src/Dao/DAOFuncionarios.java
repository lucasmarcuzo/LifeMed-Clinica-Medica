package DAO;

import model.ModelFuncionarios;
import util.Conexao;
import java.util.ArrayList;
import java.util.List;
/**
*
* @author LucasMarcuzo
*/
public class DAOFuncionarios extends Conexao {

    
    /**
    * grava Funcionarios
    * @param pModelFuncionarios
    * @return boolean
    */
    public boolean salvarFuncionariosDAO(ModelFuncionarios pModelFuncionarios){
        try {
            this.conectar();
            this.insertSQL(
                "INSERT INTO tbl_funcionarios ("
                    + "pk_id_funcionarios,"
                    + "nome,"
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
                    + "tipo_logradouro,"
                    + "logradouro,"
                    + "numero_casa,"
                    + "complemento,"
                    + "setor,"
                    + "funcao,"
                    + "pk_matricula,"
                    + "data_adm,"
                    + "data_dem,"
                    + "ctps,"
                    + "serie_uf,"
                    + "pis,"
                    + "dt_funcionario_desde"
                + ") VALUES ("
                    + "'" + pModelFuncionarios.getId_funcionarios() + "',"
                    + "'" + pModelFuncionarios.getNome() + "',"
                    + "'" + pModelFuncionarios.getSexo() + "',"
                    + "'" + pModelFuncionarios.getDt_nascimento() + "',"
                    + "'" + pModelFuncionarios.getEstado_civil() + "',"
                    + "'" + pModelFuncionarios.getCpf() + "',"
                    + "'" + pModelFuncionarios.getRg() + "',"
                    + "'" + pModelFuncionarios.getOrgao_exp() + "',"
                    + "'" + pModelFuncionarios.getNacionalidade() + "',"
                    + "'" + pModelFuncionarios.getNaturalidade() + "',"
                    + "'" + pModelFuncionarios.getTel_fixo() + "',"
                    + "'" + pModelFuncionarios.getTel_celular() + "',"
                    + "'" + pModelFuncionarios.getTel_contato() + "',"
                    + "'" + pModelFuncionarios.getEmail() + "',"
                    + "'" + pModelFuncionarios.getCep() + "',"
                    + "'" + pModelFuncionarios.getUf() + "',"
                    + "'" + pModelFuncionarios.getCidade() + "',"
                    + "'" + pModelFuncionarios.getBairro() + "',"
                    + "'" + pModelFuncionarios.getTipoLogradouro() + "',"
                    + "'" + pModelFuncionarios.getLogradouro() + "',"
                    + "'" + pModelFuncionarios.getNumeroCasa() + "',"
                    + "'" + pModelFuncionarios.getComplemento() + "',"
                    + "'" + pModelFuncionarios.getSetor() + "',"
                    + "'" + pModelFuncionarios.getFuncao() + "',"
                    + "'" + pModelFuncionarios.getMatricula() + "',"
                    + "'" + pModelFuncionarios.getData_adm() + "',"
                    + "'" + pModelFuncionarios.getData_dem() + "',"
                    + "'" + pModelFuncionarios.getCtps() + "',"
                    + "'" + pModelFuncionarios.getSerie_uf() + "',"
                    + "'" + pModelFuncionarios.getPis() + "',"
                    + "'" + pModelFuncionarios.getDt_funcionario_desde() + "'"
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
    * recupera Funcionarios
    * @param pId_funcionarios
    * @return ModelFuncionarios
    */
    public ModelFuncionarios getFuncionariosDAO(int pId_funcionarios){
        ModelFuncionarios modelFuncionarios = new ModelFuncionarios();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_funcionarios,"
                    + "nome,"
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
                    + "tipo_logradouro,"
                    + "logradouro,"
                    + "numero_casa,"
                    + "complemento,"
                    + "setor,"
                    + "funcao,"
                    + "pk_matricula,"
                    + "data_adm,"
                    + "data_dem,"
                    + "ctps,"
                    + "serie_uf,"
                    + "pis,"
                    + "dt_funcionario_desde"
                 + " FROM"
                     + " tbl_funcionarios"
                 + " WHERE"
                     + " pk_id_funcionarios = '" + pId_funcionarios + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFuncionarios.setId_funcionarios(this.getResultSet().getInt(1));
                modelFuncionarios.setNome(this.getResultSet().getString(2));
                modelFuncionarios.setSexo(this.getResultSet().getString(3));
                modelFuncionarios.setDt_nascimento(this.getResultSet().getString(4));
                modelFuncionarios.setEstado_civil(this.getResultSet().getString(5));
                modelFuncionarios.setCpf(this.getResultSet().getString(6));
                modelFuncionarios.setRg(this.getResultSet().getString(7));
                modelFuncionarios.setOrgao_exp(this.getResultSet().getString(8));
                modelFuncionarios.setNacionalidade(this.getResultSet().getString(9));
                modelFuncionarios.setNaturalidade(this.getResultSet().getString(10));
                modelFuncionarios.setTel_fixo(this.getResultSet().getString(11));
                modelFuncionarios.setTel_celular(this.getResultSet().getString(12));
                modelFuncionarios.setTel_contato(this.getResultSet().getString(13));
                modelFuncionarios.setEmail(this.getResultSet().getString(14));
                modelFuncionarios.setCep(this.getResultSet().getString(15));
                modelFuncionarios.setUf(this.getResultSet().getString(16));
                modelFuncionarios.setCidade(this.getResultSet().getString(17));
                modelFuncionarios.setBairro(this.getResultSet().getString(18));
                modelFuncionarios.setTipoLogradouro(this.getResultSet().getString(19));
                modelFuncionarios.setLogradouro(this.getResultSet().getString(20));
                modelFuncionarios.setNumeroCasa(this.getResultSet().getInt(21));
                modelFuncionarios.setComplemento(this.getResultSet().getString(22));
                modelFuncionarios.setSetor(this.getResultSet().getString(23));
                modelFuncionarios.setFuncao(this.getResultSet().getString(24));
                modelFuncionarios.setMatricula(this.getResultSet().getInt(25));
                modelFuncionarios.setData_adm(this.getResultSet().getString(26));
                modelFuncionarios.setData_dem(this.getResultSet().getString(27));
                modelFuncionarios.setCtps(this.getResultSet().getInt(28));
                modelFuncionarios.setSerie_uf(this.getResultSet().getString(29));
                modelFuncionarios.setPis(this.getResultSet().getInt(30));
                modelFuncionarios.setDt_funcionario_desde(this.getResultSet().getString(31));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFuncionarios;
    }

    /**
    * recupera uma lista de Funcionarios
        * @return ArrayList
    */
    public ArrayList<ModelFuncionarios> getListaFuncionariosDAO(){
        ArrayList<ModelFuncionarios> listamodelFuncionarios = new ArrayList();
        ModelFuncionarios modelFuncionarios = new ModelFuncionarios();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_funcionarios,"
                    + "nome,"
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
                    + "tipo_logradouro,"
                    + "logradouro,"
                    + "numero_casa,"
                    + "complemento,"
                    + "setor,"
                    + "funcao,"
                    + "pk_matricula,"
                    + "data_adm,"
                    + "data_dem,"
                    + "ctps,"
                    + "serie_uf,"
                    + "pis,"
                    + "dt_funcionario_desde"
                 + " FROM"
                     + " tbl_funcionarios"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFuncionarios = new ModelFuncionarios();
                modelFuncionarios.setId_funcionarios(this.getResultSet().getInt(1));
                modelFuncionarios.setNome(this.getResultSet().getString(2));
                modelFuncionarios.setSexo(this.getResultSet().getString(3));
                modelFuncionarios.setDt_nascimento(this.getResultSet().getString(4));
                modelFuncionarios.setEstado_civil(this.getResultSet().getString(5));
                modelFuncionarios.setCpf(this.getResultSet().getString(6));
                modelFuncionarios.setRg(this.getResultSet().getString(7));
                modelFuncionarios.setOrgao_exp(this.getResultSet().getString(8));
                modelFuncionarios.setNacionalidade(this.getResultSet().getString(9));
                modelFuncionarios.setNaturalidade(this.getResultSet().getString(10));
                modelFuncionarios.setTel_fixo(this.getResultSet().getString(11));
                modelFuncionarios.setTel_celular(this.getResultSet().getString(12));
                modelFuncionarios.setTel_contato(this.getResultSet().getString(13));
                modelFuncionarios.setEmail(this.getResultSet().getString(14));
                modelFuncionarios.setCep(this.getResultSet().getString(15));
                modelFuncionarios.setUf(this.getResultSet().getString(16));
                modelFuncionarios.setCidade(this.getResultSet().getString(17));
                modelFuncionarios.setBairro(this.getResultSet().getString(18));
                modelFuncionarios.setTipoLogradouro(this.getResultSet().getString(19));
                modelFuncionarios.setLogradouro(this.getResultSet().getString(20));
                modelFuncionarios.setNumeroCasa(this.getResultSet().getInt(21));
                modelFuncionarios.setComplemento(this.getResultSet().getString(22));
                modelFuncionarios.setSetor(this.getResultSet().getString(23));
                modelFuncionarios.setFuncao(this.getResultSet().getString(24));
                modelFuncionarios.setMatricula(this.getResultSet().getInt(25));
                modelFuncionarios.setData_adm(this.getResultSet().getString(26));
                modelFuncionarios.setData_dem(this.getResultSet().getString(27));
                modelFuncionarios.setCtps(this.getResultSet().getInt(28));
                modelFuncionarios.setSerie_uf(this.getResultSet().getString(29));
                modelFuncionarios.setPis(this.getResultSet().getInt(30));
                modelFuncionarios.setDt_funcionario_desde(this.getResultSet().getString(31));
                listamodelFuncionarios.add(modelFuncionarios);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFuncionarios;
    }

    /**
    * atualiza Funcionarios
    * @param pModelFuncionarios
    * @return boolean
    */
    public boolean atualizarFuncionariosDAO(ModelFuncionarios pModelFuncionarios){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_funcionarios SET "
                    + "pk_id_funcionarios = '" + pModelFuncionarios.getId_funcionarios() + "',"
                    + "nome = '" + pModelFuncionarios.getNome() + "',"
                    + "sexo = '" + pModelFuncionarios.getSexo() + "',"
                    + "dt_nascimento = '" + pModelFuncionarios.getDt_nascimento() + "',"
                    + "estado_civil = '" + pModelFuncionarios.getEstado_civil() + "',"
                    + "cpf = '" + pModelFuncionarios.getCpf() + "',"
                    + "rg = '" + pModelFuncionarios.getRg() + "',"
                    + "orgao_exp = '" + pModelFuncionarios.getOrgao_exp() + "',"
                    + "nacionalidade = '" + pModelFuncionarios.getNacionalidade() + "',"
                    + "naturalidade = '" + pModelFuncionarios.getNaturalidade() + "',"
                    + "tel_fixo = '" + pModelFuncionarios.getTel_fixo() + "',"
                    + "tel_celular = '" + pModelFuncionarios.getTel_celular() + "',"
                    + "tel_contato = '" + pModelFuncionarios.getTel_contato() + "',"
                    + "email = '" + pModelFuncionarios.getEmail() + "',"
                    + "cep = '" + pModelFuncionarios.getCep() + "',"
                    + "uf = '" + pModelFuncionarios.getUf() + "',"
                    + "cidade = '" + pModelFuncionarios.getCidade() + "',"
                    + "bairro = '" + pModelFuncionarios.getBairro() + "',"
                    + "tipo_logradouro = '" + pModelFuncionarios.getTipoLogradouro() + "',"
                    + "logradouro = '" + pModelFuncionarios.getLogradouro() + "',"
                    + "numero_casa = '" + pModelFuncionarios.getNumeroCasa() + "',"
                    + "complemento = '" + pModelFuncionarios.getComplemento() + "',"
                    + "setor = '" + pModelFuncionarios.getSetor() + "',"
                    + "funcao = '" + pModelFuncionarios.getFuncao() + "',"
                    + "pk_matricula = '" + pModelFuncionarios.getMatricula() + "',"
                    + "data_adm = '" + pModelFuncionarios.getData_adm() + "',"
                    + "data_dem = '" + pModelFuncionarios.getData_dem() + "',"
                    + "ctps = '" + pModelFuncionarios.getCtps() + "',"
                    + "serie_uf = '" + pModelFuncionarios.getSerie_uf() + "',"
                    + "pis = '" + pModelFuncionarios.getPis() + "',"
                    + "dt_funcionario_desde = '" + pModelFuncionarios.getDt_funcionario_desde() + "'"
                + " WHERE "
                    + "pk_id_funcionarios = '" + pModelFuncionarios.getId_funcionarios() + "'"
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
    * exclui Funcionarios
    * @param pId_funcionarios
    * @return boolean
    */
    public boolean excluirFuncionariosDAO(int pId_funcionarios){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_funcionarios "
                + " WHERE "
                    + "pk_id_funcionarios = '" + pId_funcionarios + "'"
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
                "SELECT MAX(pk_id_funcionarios) FROM tbl_funcionarios;"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
     * Retorna o próximo número de Matrícula.
     * @return int
     */
    public int proximoMatricula() {
        try {
            this.conectar();
            return this.lastInsertId(
                "SELECT MAX(pk_matricula) FROM tbl_funcionarios;"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }
    
    /**
    * Realiza uma pesquisa de Funcionários.
    * @param pesquisa
    * @param localPesquisa
    * @return ArrayList
    */
    public List<ModelFuncionarios> getListaFuncionariosDAO(String pesquisa, String localPesquisa) {
        ArrayList<ModelFuncionarios> listaModelFuncionarios = new ArrayList<>();
        ModelFuncionarios modelFuncionarios = null;

        try {
            this.conectar();
            switch(localPesquisa){
            case "ID":
                localPesquisa = "pk_id_funcionarios";
                break;
            case "NOME":
                localPesquisa = "nome";
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
            
        if(localPesquisa.equals("nome")){
             this.executarSQL(
                 "SELECT * FROM tbl_funcionarios WHERE "+ localPesquisa +" LIKE '%"+ pesquisa +"%'"
             );
        }
        else{
             this.executarSQL(
                 "SELECT * FROM tbl_funcionarios WHERE "+ localPesquisa +" LIKE '"+ pesquisa +"'"
             );
        }

        while (this.getResultSet().next()) {
            modelFuncionarios = new ModelFuncionarios();
            modelFuncionarios.setId_funcionarios(this.getResultSet().getInt(1));
            modelFuncionarios.setNome(this.getResultSet().getString(2));
            modelFuncionarios.setSexo(this.getResultSet().getString(3));
            modelFuncionarios.setDt_nascimento(this.getResultSet().getString(4));
            modelFuncionarios.setEstado_civil(this.getResultSet().getString(5));
            modelFuncionarios.setCpf(this.getResultSet().getString(6));
            modelFuncionarios.setRg(this.getResultSet().getString(7));
            modelFuncionarios.setOrgao_exp(this.getResultSet().getString(8));
            modelFuncionarios.setNacionalidade(this.getResultSet().getString(9));
            modelFuncionarios.setNaturalidade(this.getResultSet().getString(10));
            modelFuncionarios.setTel_fixo(this.getResultSet().getString(11));
            modelFuncionarios.setTel_celular(this.getResultSet().getString(12));
            modelFuncionarios.setTel_contato(this.getResultSet().getString(13));
            modelFuncionarios.setEmail(this.getResultSet().getString(14));
            modelFuncionarios.setCep(this.getResultSet().getString(15));
            modelFuncionarios.setUf(this.getResultSet().getString(16));
            modelFuncionarios.setCidade(this.getResultSet().getString(17));
            modelFuncionarios.setBairro(this.getResultSet().getString(18));
            modelFuncionarios.setTipoLogradouro(this.getResultSet().getString(19));
            modelFuncionarios.setLogradouro(this.getResultSet().getString(20));
            modelFuncionarios.setNumeroCasa(this.getResultSet().getInt(21));
            modelFuncionarios.setComplemento(this.getResultSet().getString(22));
            modelFuncionarios.setSetor(this.getResultSet().getString(23));
            modelFuncionarios.setFuncao(this.getResultSet().getString(24));
            modelFuncionarios.setMatricula(this.getResultSet().getInt(25));
            modelFuncionarios.setData_adm(this.getResultSet().getString(26));
            modelFuncionarios.setData_dem(this.getResultSet().getString(27));
            modelFuncionarios.setCtps(this.getResultSet().getInt(28));
            modelFuncionarios.setSerie_uf(this.getResultSet().getString(29));
            modelFuncionarios.setPis(this.getResultSet().getInt(30));
            modelFuncionarios.setDt_funcionario_desde(this.getResultSet().getString(31));
            listaModelFuncionarios.add(modelFuncionarios);
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelFuncionarios;
    }
}