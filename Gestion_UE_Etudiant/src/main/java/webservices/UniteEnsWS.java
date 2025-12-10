/*package webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

@Path("/ue")   // endpoint racine
public class UniteEnsWS {

    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getALL() {
        return Response
                .status(Response.Status.OK)
                .entity(helper.getListeUE())
                .build();
    }

    @POST
    @Path("/addUE")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUE(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity("UE added")
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Error adding UE")
                    .build();
        }
    }
}
*/ //version de prof

package webservices;

import metiers.UniteEnseignementBusiness;
import entities.UniteEnseignement;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")   // endpoint racine
public class UniteEnsWS {

    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getALL() {
        return Response
                .status(Response.Status.OK)
                .entity(helper.getListeUE())
                .build();
    }

    @POST
    @Path("/addUE")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUE(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity("UE added")
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Error adding UE")
                    .build();
        }
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUE(@PathParam("id") int id){
        if(helper.deleteUniteEnseignement(id)==true){
            return Response.status(200).entity("object deleted").build();

        }else return Response.status(400).entity("object not deleted").build();
    }


@PUT
@Path("/update/{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public Response updateUE(UniteEnseignement ue,@PathParam("id") int code) {

    if (helper.updateUniteEnseignement(code,ue)==true) {
        return Response.status(Response.Status.OK).entity("UE updated").build();
    } else {
        return Response.status(Response.Status.BAD_REQUEST).entity("Error updating UE").build();
    }
}



}
