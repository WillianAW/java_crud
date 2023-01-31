package br.com.cadastro.aplicacao;

import br.com.cadastro.model.Usuario;
import java.util.Date;
import br.com.cadastro.dao.*;

public class Main {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setNome("Willian Eduardo");
		usuario.setId(23);
		usuario.setDataCadastro(new Date());

		CadastroDAO cadastroDAO = new CadastroDAO();
	}

}
