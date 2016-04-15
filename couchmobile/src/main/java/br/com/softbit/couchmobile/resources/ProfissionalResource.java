package br.com.softbit.couchmobile.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.softbit.couchmobile.service.ProfissionalFilterBean;
import br.com.softbit.couchmobile.service.ProfissionalService;
import br.com.softbit.couchmobile.model.Profissional;

@Path("/profissionais")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfissionalResource {
	
	ProfissionalService profissionalService = new ProfissionalService();
	
	@GET
	public List<Profissional> getProfissionais(@BeanParam ProfissionalFilterBean fb){
		if(fb.getEstado() != null || fb.getCidade() != null || fb.getBairro() != null || fb.getFormacao() != null || fb.getEspecializacao() != null || fb.getAreaDeAtuacao() != null){
			return profissionalService.getProfissionaisComFiltro(fb.getEstado(), fb.getCidade(), fb.getBairro(), fb.getFormacao(), fb.getEspecializacao(), fb.getAreaDeAtuacao());
		}else{
			return profissionalService.getProfissionais();
		}
	}
	
	@POST
	public Profissional addProfissional(Profissional profissional){
		return profissionalService.addProfissional(profissional);
	}
	
	@PUT
	@Path("/{profissionalId}")
	public Profissional updateProfissional(@PathParam("profissionalId") long id, Profissional profissional){
		profissional.setId(id);
		return profissionalService.updateProfissional(profissional);
	}
	
	@DELETE
	@Path("/{profissionalId}")
	public void deleteProfissional(@PathParam("profissionalId") long id){
		profissionalService.removeProfissional(id);
	}
	
	@GET
	@Path("/{profissionalId}")
	public Profissional test(@PathParam("profissionalId") long id){
		return profissionalService.getProfissional(id);
	}

}
