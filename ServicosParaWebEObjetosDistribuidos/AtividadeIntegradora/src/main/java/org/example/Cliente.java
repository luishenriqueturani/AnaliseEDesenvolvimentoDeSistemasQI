package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.grizzly.http.server.HttpServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("get")
public class Cliente {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("clients")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alunos> getAll() {
        return retornaListaAlunos();
    }

    @GET
    @Path("client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alunos getOne(@PathParam("id") int id) {

        for (Alunos aluno: retornaListaAlunos() ) {
            if(aluno.getId() == id){
                return aluno;
            }
        }

        return null;
    }


    public List<Alunos> retornaListaAlunos(){
        List<Alunos> listaAlunos = new ArrayList<>();

        listaAlunos.add(new Alunos(1, "Joao", "joao@joao.com",3));
        listaAlunos.add(new Alunos(2, "Maria", "maria@maria.com",1));
        listaAlunos.add(new Alunos(3, "Jose", "jose@mariajoao.com",2));
        listaAlunos.add(new Alunos(4, "Pedro", "pedro@email.com",3));


        return listaAlunos;
    }
}
