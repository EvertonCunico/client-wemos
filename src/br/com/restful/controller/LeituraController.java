package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.LeiturasDAO;
import br.com.restful.model.Leituras;

/**
 * 
 * Classe responsavel por ser o controlador entre o resource e a camada DAO
 *
 * @author Manoel Silva Motoso <manoelmotoso@hotmail.com>
 * @since 10/05/2016 10:04:21
 * @version 1.0
 */
public class LeituraController {
	/**
	 * 
	 * Chama o metodo listarTodos da classe LeiturasDAO
     * @return 
	 */
    
	public ArrayList<Leituras> listarTodos() {
		System.out.println("Controller: listarTodos ");
		return LeiturasDAO.getInstance().listarTodos();

	}

	
	 // Chama o metodo getById da classe LeiturasDAO
	 
	public Leituras buscarPorId(long id) {
		System.out.println("Controller: buscarPorId - "+id);
		LeiturasDAO dao = new LeiturasDAO();
		Leituras leitura = dao.getById(id);
		return leitura;
	}

        
	/**
	 * Chama o metodo inset da classe LeiturasDAO
	 */
	public boolean gravarLeitura(Leituras leitura) {
		System.out.println("Controller: gravarLeitura "+leitura.getNome());
		return new LeiturasDAO().insert(leitura);

	}

	//Chama o metodo update na classe LeiturasDAO
	 
	public boolean atualizarLeitura(Leituras leitura) {
		System.out.println("Controller: atualizarCliente "+leitura.getNome());
		return LeiturasDAO.getInstance().update(leitura);
	}
       
        //Chama o metodo delete na classe LeiturasDAO
	 
	public boolean deletarLeitura(Leituras leitura) {
		System.out.println("Controller: deletarCliente "+leitura.getNome());
		return LeiturasDAO.getInstance().delete(leitura);
	}
}
