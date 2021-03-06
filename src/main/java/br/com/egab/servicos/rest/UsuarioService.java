package br.com.egab.servicos.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.egab.model.Usuario;
import br.com.egab.negocio.UsuarioNegocio;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {
	
	@EJB
	UsuarioNegocio usuarioNegocio;

	@GET
	@Path("/listar")
	public List<Usuario> listarUsuarios() {
		return usuarioNegocio.listarUsuarios();
	}
	
	@GET
	@Path("/buscarUsuario/{id}")
	public Usuario buscarUsuario(@PathParam("id") Long idUsuario) {
		return usuarioNegocio.buscarPorId(idUsuario);
	}
	
	@GET
	@Path("/excluirUsuario/{idUsuario}")
	public void excluirUsuario(@PathParam("idUsuario") Long idUsuario) {
		usuarioNegocio.excluir(idUsuario);
	}
	
	@POST
	@Path("/salvar")
	public Usuario salvar(Usuario usuario) {
		
		return usuarioNegocio.salvar(usuario);
	}
}
