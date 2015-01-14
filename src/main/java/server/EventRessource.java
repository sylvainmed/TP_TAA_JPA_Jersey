package server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import shared.Event;
import shared.EventList;
import shared.Passager;
import shared.Voiture;

@Path("/event")
public class EventRessource {
	
	/**
	 * Instantiates a new event ressource.
	 */
	public EventRessource() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	@GET
	@Path("/getevent")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Event> getEvents(){
		return EventList.getInstance().getEvents();
	}
	
	/**
	 * Gets the passagers.
	 *
	 * @return the passagers
	 */
	@GET
	@Path("/getpassagers")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Passager> getPassagers(){
		return EventList.getInstance().getPassagers();
	}
	
	/**
	 * Participer.
	 *
	 * @param idEvent the id event
	 * @param nom the nom
	 */
	@POST
	@Path("/new")
	@Consumes({MediaType.APPLICATION_JSON})
	public void participer (int idEvent, String nom){
		EventList.getInstance().participer(nom, idEvent);
		System.out.println("Passager ajouté à un event");
	}
	
	/**
	 * Addcar.
	 *
	 * @param places the places
	 * @param event the event
	 */
	@POST
	@Path("/addcar")
	@Produces({MediaType.APPLICATION_JSON})
	public void addcar (int places, Event event){
		EventList.getInstance().addVoiture(places, event);
	}
	
}


