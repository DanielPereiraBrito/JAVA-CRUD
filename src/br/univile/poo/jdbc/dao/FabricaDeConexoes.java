package br.univile.poo.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

class FabricaDeConexoes {

    private static FabricaDeConexoes instance;

    private FabricaDeConexoes(){}

    public static FabricaDeConexoes getInstance(){
        if (instance == null){
            instance = new FabricaDeConexoes();
        }
        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:meu_banco.sql");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }
}
