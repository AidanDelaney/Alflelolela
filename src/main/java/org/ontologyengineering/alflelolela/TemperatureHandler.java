package org.ontologyengineering.alflelolela;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.json.Json;
import javax.json.JsonObject;
import javax.inject.*;

@Path("/")
public class TemperatureHandler {
    @Inject
    TemperatureService temperatureService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHTML() {
        return "<html>The temperature</html>";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJSON() {
        return Json.createObjectBuilder()
                .add("temperature", "null")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXML() {
        return "<xml><temperature>null</temperature></xml>";
    }

    @POST
    @Path("/{temperature}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject postJSON(@PathParam("temperature") Float temperature) {
        return getJSON();
    }
}
