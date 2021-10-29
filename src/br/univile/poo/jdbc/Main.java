package br.univile.poo.jdbc;

import br.univile.poo.jdbc.dao.PessoaDAO;
import br.univile.poo.jdbc.model.Pessoa;

public class Main {

    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDAO();

        for (Pessoa p : dao.selectAllPessoas()){
            System.out.println(p);
        }

        Pessoa novaPessoa = new Pessoa(0, "Nova", "Pessoa", true);
        dao.insert(novaPessoa);

    }
}
