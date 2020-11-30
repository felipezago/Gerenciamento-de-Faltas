/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciamentoFaltas.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class CreateDB {
    public static void createDB() throws SQLException{
          
        Connection c = Conexao.getConexao();
        Statement stmt = c.createStatement();

          String sql = "CREATE TABLE IF NOT EXISTS materias("
                  + "   id_materias INTEGER PRIMARY KEY autoincrement,"
                  + "   nome_materia     char(40)   not null,"
                  + "   qtd_max_faltas   integer    not null,"
                  + "   qtd_atual_faltas integer    not null"
                  + ");";

                     
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        System.out.println("Tabela criada com sucesso");
    }
    
    public static void main(String[] args) {
        try {
            createDB();
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
