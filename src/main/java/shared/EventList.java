package shared;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// TODO: Auto-generated Javadoc
/**
 * The Class EventList.
 */
public class EventList {
	
	/** The instance. */
	private static EventList INSTANCE = new EventList();
	
	/**
	 * Gets the single instance of EventList.
	 *
	 * @return single instance of EventList
	 */
	public static EventList getInstance(){
		return INSTANCE;	
	}
	
	/** The manager. */
	EntityManager manager;
	
	/** The tx. */
	EntityTransaction tx;
	
	/**
	 * Instantiates a new event list.
	 */
	public EventList(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		this.manager = factory.createEntityManager();
		this.tx = manager.getTransaction();
	}
	
	/**
	 * Instantiates a new event list.
	 *
	 * @param manager the manager
	 * @param tx the tx
	 */
	public EventList(EntityManager manager, EntityTransaction tx){
		this.manager = manager;
		this.tx = tx;
		}
	
	/**
	 * Adds the voiture.
	 *
	 * @param places the places
	 * @param event the event
	 */
	public void addVoiture(int places, Event event){
		tx.begin();
		Voiture car = new Voiture();
		car.setPlaces(places);
		car.setEvent(event);
		manager.persist(car);
		tx.commit();
	}
	
	/**
	 * Inscription.
	 *
	 * @param passager the passager
	 */
	public void inscription(Passager passager){
		tx.begin();
		manager.persist(passager);
		tx.commit();
	}
	
	/**
	 * Gets the event.
	 *
	 * @param id the id
	 * @return the event
	 */
	public Event getEvent(int id){
		Event event = (Event) manager.find(Event.class, 1);
		return(event);
	}
	
	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public List<Event> getEvents(){
		return manager.createQuery("select e FROM Event as e", Event.class).getResultList();
	}
	
	/**
	 * Gets the passagers.
	 *
	 * @return the passagers
	 */
	public List<Passager> getPassagers(){
		return manager.createQuery("select p FROM Passager as p", Passager.class).getResultList();
	}
	
	/**
	 * Participer.
	 *
	 * @param nom the nom
	 * @param idevent the idevent
	 */
	public void participer (String nom, int idevent){
		tx.begin();
		Event event = (Event) manager.createQuery("FROM Event WHERE id="+idevent).getSingleResult();
		Passager p = new Passager();
		p.setNom(nom);
		p.setEvent(event);
		event.getPassagers().add(p);
		tx.commit();
	}
	
	/**
	 * Ajoute dans voiture.
	 *
	 * @param passager the passager
	 * @param idvoiture the idvoiture
	 */
	public void ajouteDansVoiture(Passager passager, int idvoiture){
		tx.begin();
		Voiture voiture = (Voiture) manager.createQuery("FROM Car WHERE id="+idvoiture).getSingleResult();
		passager.setVoiture(voiture);
		voiture.getPassagers().add(passager);
		voiture.decPlaces();
		tx.commit();
	}
	
	/**
	 * Adds the passager.
	 *
	 * @param event the event
	 * @param passager the passager
	 */
	public void addPassager(Event event, Passager passager){
		tx.begin();
		passager.setEvent(event);
		manager.persist(passager);
		tx.commit();
		}
	
	/**
 * Adds the event.
 *
 * @param event the event
 */
public void addEvent(Event event){
		tx.begin();
		manager.persist(event);
		tx.commit();
	}

}
