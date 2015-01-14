package shared;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;

// TODO: Auto-generated Javadoc
/**
 * Class Passager.
 *
 * @author Sylvain MEDARD
 * @author Rudi Tuvache
 */

@Entity
@Table(name = "Passager")
public class Passager {

	/** The id. */
	private int id;
	
	/** The nom. */
	private String nom;
	
	/** The voiture. */
	private Voiture voiture;
	
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
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Gets the voiture.
	 *
	 * @return the voiture
	 */
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JsonIgnore
	public Voiture getVoiture() {
		return voiture;
	}
	
	/**
	 * Sets the voiture.
	 *
	 * @param voiture the new voiture
	 */
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	/**
	 * Gets the event.
	 *
	 * @return the event
	 */
	@ManyToOne(cascade=CascadeType.PERSIST)
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
		event.getPassagers().add(this);
	}
		
	
	
}
