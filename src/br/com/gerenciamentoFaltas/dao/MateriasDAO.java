/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciamentoFaltas.dao;

import br.com.gerenciamentoFaltas.model.Materias;
import br.com.gerenciamentoFaltas.util.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class MateriasDAO {
    public static void insertDB(Materias mat) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stmt= con.createStatement();
        con.setAutoCommit(false);
        
        String sql= "insert into materias(nome_materia, qtd_max_faltas, qtd_atual_faltas) values ('"+mat.getNome_materia()+"', "
                + ""+mat.getQtd_Max_faltas()+", 0)";
        stmt.executeUpdate(sql);
        con.commit();
        stmt.close();
        con.close();
        
    }
    
    public static void deleteDB(Materias mat) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stmt= con.createStatement();
        con.setAutoCommit(false);
        
        String sql= "delete from materias where id_materias= "+mat.getId_materias()+"";
        stmt.executeUpdate(sql);
        con.commit();
        stmt.close();
        con.close();
    }
    
    public static void updateDB(Materias mat) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stmt= con.createStatement();
        con.setAutoCommit(false);
        
        String sql= "update materias set nome_materia= '"+mat.getNome_materia()+"', set qtd_faltas= "+mat.getId_materias()+""
                + " where id_materias= "+mat.getId_materias()+"";
        stmt.executeUpdate(sql);
        con.commit();
        stmt.close();
        con.close();
        
    }
    
    public static List<Materias> selectDB(Materias mat) throws SQLException{
        List<Materias> lista= new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        ResultSet rs= stmt.executeQuery("select * from materias "
                + "where nome_materia like '%"+mat.getNome_materia()+"%';");
        while(rs.next()){
            Materias mate = new Materias();
            mate.setNome_materia(rs.getString("nome_materia"));
            mate.setId_materias(rs.getInt("id_materias"));
            mate.setQtd_Max_faltas(rs.getInt("qtd_max_faltas"));
            
            lista.add(mate);
        }
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        return lista;
        
    }
    
    public static void adicionarFaltas(int faltas, int id) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        String sql= "update materias set qtd_atual_faltas = qtd_atual_faltas + "+faltas+" where id_materias = "+id+"";
        stmt.executeUpdate(sql);
        con.commit();
        stmt.close();
        con.close();
        
    }
    
    public static void removerFaltas(int faltas, int id) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        String sql= "update materias set qtd_atual_faltas = qtd_atual_faltas - "+faltas+" where id_materias = "+id+"";
        stmt.executeUpdate(sql);
        con.commit();
        stmt.close();
        con.close();
        
    }
    
    
    
    public static List<Materias> pesquisarCombo() throws SQLException{
        List<Materias> lista= new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        ResultSet rs= stmt.executeQuery("select * from materias");
        while(rs.next()){
            Materias mat = new Materias();
            mat.setNome_materia(rs.getString("nome_materia"));
            mat.setId_materias(rs.getInt("id_materias"));
            lista.add(mat);
        }
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        return lista;
    }
    
    public static List<Materias> selectDB() throws SQLException{
        List<Materias> lista= new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        ResultSet rs= stmt.executeQuery("select * from materias");
        
        while(rs.next()){
            Materias mate = new Materias();
            int max, atual;
            max = rs.getInt("qtd_max_faltas");
            atual= rs.getInt("qtd_atual_faltas");
            
            mate.setId_materias(rs.getInt("id_materias"));
            mate.setQtd_Max_faltas(rs.getInt("qtd_max_faltas"));
            mate.setQtd_atual_faltas(rs.getInt("qtd_atual_faltas"));
            if(atual > max){
                mate.setNome_materia(rs.getString("nome_materia").concat(" (Reprovado)"));
            }else{
                mate.setNome_materia(rs.getString("nome_materia"));
            }

            
            lista.add(mate);
        }
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        return lista;
        
    }
    
    public static List<Materias> pesquisa(String sql) throws SQLException{
        List<Materias> lista= new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        ResultSet rs= stmt.executeQuery("select * from materias where nome_materia= '"+sql+"'");
        while(rs.next()){
            Materias mate = new Materias();
            int max, atual;
            max = rs.getInt("qtd_max_faltas");
            atual= rs.getInt("qtd_atual_faltas");
            
            mate.setId_materias(rs.getInt("id_materias"));
            mate.setQtd_Max_faltas(rs.getInt("qtd_max_faltas"));
            mate.setQtd_atual_faltas(rs.getInt("qtd_atual_faltas"));
            if(atual > max){
                mate.setNome_materia(rs.getString("nome_materia").concat(" (Reprovado)"));
            }else{
                mate.setNome_materia(rs.getString("nome_materia"));
            }
            
            lista.add(mate);
        }
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        return lista;
        
    }
    
    
    public static List<Materias> ordenarMat() throws SQLException{
        List<Materias> lista= new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        ResultSet rs= stmt.executeQuery("select * from materias order by nome_materia asc");
        while(rs.next()){
            Materias mate = new Materias();
            int max, atual;
            max = rs.getInt("qtd_max_faltas");
            atual= rs.getInt("qtd_atual_faltas");
            
            mate.setId_materias(rs.getInt("id_materias"));
            mate.setQtd_Max_faltas(rs.getInt("qtd_max_faltas"));
            mate.setQtd_atual_faltas(rs.getInt("qtd_atual_faltas"));
            if(atual > max){
                mate.setNome_materia(rs.getString("nome_materia").concat(" (Reprovado)"));
            }else{
                mate.setNome_materia(rs.getString("nome_materia"));
            }
            
            lista.add(mate);
        }
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        return lista;
    }
    
    public static List<Materias> ordenarQtMax() throws SQLException{
        List<Materias> lista= new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        ResultSet rs= stmt.executeQuery("select * from materias order by qtd_max_faltas asc");
        while(rs.next()){
            Materias mate = new Materias();
            int max, atual;
            max = rs.getInt("qtd_max_faltas");
            atual= rs.getInt("qtd_atual_faltas");
            
            mate.setId_materias(rs.getInt("id_materias"));
            mate.setQtd_Max_faltas(rs.getInt("qtd_max_faltas"));
            mate.setQtd_atual_faltas(rs.getInt("qtd_atual_faltas"));
            if(atual > max){
                mate.setNome_materia(rs.getString("nome_materia").concat(" (Reprovado)"));
            }else{
                mate.setNome_materia(rs.getString("nome_materia"));
            }
            
            lista.add(mate);
        }
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        return lista;
    }
    
    public static List<Materias> ordenarQtAtual() throws SQLException{
        List<Materias> lista= new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        con.setAutoCommit(false);
        
        ResultSet rs= stmt.executeQuery("select * from materias order by qtd_atual_faltas asc");
        while(rs.next()){
            Materias mate = new Materias();
            int max, atual;
            max = rs.getInt("qtd_max_faltas");
            atual= rs.getInt("qtd_atual_faltas");
            
            mate.setId_materias(rs.getInt("id_materias"));
            mate.setQtd_Max_faltas(rs.getInt("qtd_max_faltas"));
            mate.setQtd_atual_faltas(rs.getInt("qtd_atual_faltas"));
            if(atual > max){
                mate.setNome_materia(rs.getString("nome_materia").concat(" (Reprovado)"));
            }else{
                mate.setNome_materia(rs.getString("nome_materia"));
            }
            
            lista.add(mate);
        }
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        return lista;
    }
    
    public static void main(String[] args) {
        Materias mat= new Materias();

    }
}
