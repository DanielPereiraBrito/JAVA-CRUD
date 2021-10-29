package br.univile.poo.jdbc.dao;

import java.sql.Connection;

abstract class BaseDAO {

    protected Connection conn(){
        return FabricaDeConexoes.getInstance().getConnection();
    }
}
