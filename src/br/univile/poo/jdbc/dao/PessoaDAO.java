package br.univile.poo.jdbc.dao;

import br.univile.poo.jdbc.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends BaseDAO {

    public void insert(Pessoa pessoa){
        String insert = "INSERT INTO pessoas(nome, sobrenome, ativo) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conn().prepareStatement(insert)){
                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.setString(2, pessoa.getSobrenome());
                preparedStatement.setBoolean(3, pessoa.isAtivo());
                preparedStatement.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public void update(Pessoa pessoa){
        String update = "UPDATE pessoas SET nome = ?, sobrenome = ?, ativo = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn().prepareStatement(update)){
                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.setString(2, pessoa.getSobrenome());
                preparedStatement.setBoolean(3, pessoa.isAtivo());
                preparedStatement.setInt(4, pessoa.getId());

                preparedStatement.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public void delete(Pessoa pessoa){
        String delete = "DELETE FROM pessoas WHERE id = ?";
            try (PreparedStatement preparedStatement = conn().prepareStatement(delete)){
                preparedStatement.setInt(1, pessoa.getId());

                preparedStatement.execute();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public List<Pessoa> selectAllPessoas() {
        String sql = "SELECT nome, sobrenome, ativo FROM pessoas";

        List<Pessoa> allPessoas = new ArrayList<>();

        try (PreparedStatement preparedStatement = conn().prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(resultSet.getString(1));
                pessoa.setSobrenome(resultSet.getString(2));
                pessoa.setAtivo(resultSet.getBoolean(3));

                allPessoas.add(pessoa);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allPessoas;
    }

    public Pessoa getPessoa(int id){
        String sql = "SELECT id, nome, sobrenome, ativo FROM pessoas WHERE id = ?";

        Pessoa pessoa = null;

        try (PreparedStatement preparedStatement = conn().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                pessoa = new Pessoa();
                pessoa.setId(resultSet.getInt(1));
                pessoa.setNome(resultSet.getString(2));
                pessoa.setSobrenome(resultSet.getString(3));
                pessoa.setAtivo(resultSet.getBoolean(4));

            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return pessoa;
    }


}
