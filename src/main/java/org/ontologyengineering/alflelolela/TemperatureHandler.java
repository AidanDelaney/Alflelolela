package org.ontologyengineering.alflelolela;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import javax.ejb.EJB;

import java.util.Optional;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

@Path("/")
public class TemperatureHandler {
    @EJB
    TemperatureService temperatureService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHTML() {
        Optional<Temperature> temp = temperatureService.getTemperature();

         if(temp.isPresent()) {
             return "<html>The temperature is  " + temp.get().getTemperature() + "</html>";
         }  else {
             return "<html>Unknown temperature</html>";
         }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Temperature getJSON() {
        Optional<Temperature> temp = temperatureService.getTemperature();

        if(temp.isPresent()) {
            return temp.get();
        } else {
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXML() {
        return "<xml><temperature>null</temperature></xml>";
    }

    @POST
    @Path("/{temperature}")
    @Produces(MediaType.APPLICATION_JSON)
    public Temperature postJSON(@PathParam("temperature") Float temperature) {
        temperatureService.setTemperature(temperature);
        System.out.println(temperature);
        return getJSON();
    }
}
