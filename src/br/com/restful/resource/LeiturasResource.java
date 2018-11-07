package br.com.restful.resource;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.restful.controller.LeituraController;
import br.com.restful.model.Leituras;

/**
 * Classe responsavel por conter os metodos REST de acesso ao webservice
 */
@Path("/")
public class LeiturasResource {
	

	@GET
	@Path("teste")
	@Produces(MediaType.APPLICATION_JSON)
	public Response teste() {
		return Response.ok("teste").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Leituras> listarTodos() {
		System.out.println("Leituras encontradas no banco");
		return new LeituraController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		Leituras leitura = new LeituraController().buscarPorId(id);
		if (leitura != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON).entity(leitura).build();
		} else {
			return Response.status(404).entity("Leitura nao encontrado").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
        @Path("/salvarLeituraJson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarLeituraJson(Leituras leitura) {
		boolean isLeituraGravado = new LeituraController().gravarLeitura(leitura);
		if (isLeituraGravado == true) {
			return Response.ok().entity(leitura).build();
		} else {
			return Response.status(500).entity("Erro no servidor  ao gravar leitura").build();
		}

	}

	@PUT
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response altualizarLeitura(Leituras leitura) {
		boolean isLeituraAtualizado = new LeituraController().atualizarLeitura(leitura);

		if (isLeituraAtualizado == true) {
			return Response.ok().entity(leitura).build();
		} else {
			return Response.status(500).entity("Erro no servidor  ao atualizar leitura").build();
		}

	}

	@DELETE
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarLeitura(Leituras leitura) {

		boolean isLeituraDeletado = new LeituraController().deletarLeitura(leitura);
		if (isLeituraDeletado == true) {
			System.out.println("Leitura " + leitura.getNome() + " deletado");
			return Response.ok().entity(leitura).build();
		} else {
			System.out.println("Erro no servidor  ao deletar leitura: " + leitura.getNome());
			return Response.status(500).entity("Erro no servidor  ao deletar leitura: " + leitura.getNome()).build();
		}
	}

}