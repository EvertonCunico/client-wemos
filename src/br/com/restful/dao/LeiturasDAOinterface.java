package br.com.restful.dao;

import java.util.List;

import br.com.restful.model.Leituras;

public interface LeiturasDAOinterface {

	public Leituras save(Leituras leitura);

	public boolean delete(Leituras leitura);

	public boolean update(Leituras leitura);

	public Leituras findById(Leituras leitura);

	public List<Leituras> findByName(Leituras leitura);

	public List<Leituras> findAll();
}
