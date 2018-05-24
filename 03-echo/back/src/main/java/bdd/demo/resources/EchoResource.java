import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import bdd.demo.domain.Message;
import bdd.demo.services.EchoService;

@Stateless
@Path("/echo")
public class EchoResource {

    @Inject
    private EchoService delegate;
    
    @GET
    @Path("strict/{content}")
    @Produces({"application/xml","application/json"})
    public Response strict(@PathParam("content") String content) {
        return Response.ok( delegate.strict(content) ).build();
    }

    @GET
    @Path("uppercase/{content}")
    @Produces({"application/xml","application/json"})
    public Response uppercase(@PathParam("content") String content) {
        return Response.ok( delegate.uppercase(content) ).build();
    }

    @GET
    @Path("lowercase/{content}")
    @Produces({"application/xml","application/json"})
    public Response lowercase(@PathParam("content") String content) {
        return Response.ok( delegate.lowercase(content) ).build();
    }

}
