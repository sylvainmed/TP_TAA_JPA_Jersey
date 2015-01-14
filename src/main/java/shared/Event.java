package shared;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;


// TODO: Auto-generated Javadoc
/**
 * Class Event.
 *
 * @author Sylvain MEDARD
 * @author Rudi Tuvache
 */

@Entity
@Table(name = "Event")
public class Event {

	/** The id. */
	private int id;
	
	/** The place. */
	private String place;
	
	/** The date. */
	private String date;
	
	/** The heure. */
	private String heure;
	
	/** The passagers. */
	private List<Passager> passagers = new ArrayList();
	
	/** The voitures. */
	private List<Voiture> voitures;
	
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
	 * Gets the passagers.
	 *
	 * @return the passagers
	 */
	@OneToMany(mappedBy="event")
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
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	
	/**
	 * Sets the place.
	 *
	 * @param place the new place
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Gets the heure.
	 *
	 * @return the heure
	 */
	public String getHeure() {
		return heure;
	}
	
	/**
	 * Sets the heure.
	 *
	 * @param heure the new heure
	 */
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	/**
	 * Gets the voitures.
	 *
	 * @return the voitures
	 */
	@OneToMany(mappedBy="event")
	@JsonIgnore
	public List<Voiture> getVoitures() {
		return voitures;
	}
	
	/**
	 * Sets the voitures.
	 *
	 * @param voitures the new voitures
	 */
	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	
	/**
	 * Adds the voiture.
	 *
	 * @param voiture the voiture
	 * @return the voiture
	 */
	public Voiture addVoiture(Voiture voiture){
		this.voitures.add(voiture);
		return voiture;
	}
	
	
	
}
