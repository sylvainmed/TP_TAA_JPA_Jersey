package shared;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * Class Voiture.
 *
 * @author Sylvain MEDARD
 * @author Rudi Tuvache
 */
@Entity
@Table(name = "Voiture")
public class Voiture {
	

	/** The id. */
	private int id;
	
	/** The places. */
	private int places; 
	
	/** The passagers. */
	private List<Passager> passagers;
	
	/** The event. */
	private Event event;
	

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the places.
	 *
	 * @return the places
	 */
	public int getPlaces() {
		return places;
	}

	/**
	 * Sets the places.
	 *
	 * @param places the new places
	 */
	public void setPlaces(int places) {
		this.places = places;
	}
	
	/**
	 * Gets the passagers.
	 *
	 * @return the passagers
	 */
	@OneToMany(mappedBy="voiture")
	@JsonIgnore
	public List<Passager> getPassagers() {
		return passagers;
	}

	/**
	 * Sets the passagers.
	 *
	 * @param passagers the new passagers
	 */
	public void setPassagers(List<Passager> passagers) {
		this.passagers = passagers;
	}
	
	/**
	 * Adds the passager.
	 *
	 * @param passager the passager
	 * @return the boolean
	 */
	public synchronized Boolean addPassager(Passager passager){
		if(this.getPlaces()>0){
			this.getPassagers().add(passager);
			this.setPlaces(getPlaces()-1);;
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Del passager.
	 *
	 * @param passager the passager
	 * @return the boolean
	 */
	public synchronized Boolean delPassager(Passager passager){
		if(this.getPassagers().contains(passager)){
			this.getPassagers().remove(passager);
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Gets the event.
	 *
	 * @return the event
	 */
	@ManyToOne
	@JsonIgnore
	public Event getEvent() {
		return event;
	}

	/**
	 * Sets the event.
	 *
	 * @param event the new event
	 */
	public void setEvent(Event event) {
		this.event = event;
	}
	
	/**
	 * Dec places.
	 */
	public void decPlaces(){
		this.places--;
	}
	
	/**
	 * Inc places.
	 */
	public void incPlaces(){
		this.places++;
	}

	
	
}
