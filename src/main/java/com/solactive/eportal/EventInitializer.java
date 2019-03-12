package com.solactive.eportal;

import com.solactive.eportal.dao.EventRepository;
import com.solactive.eportal.model.Event;
import com.solactive.eportal.model.EventType;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventInitializer implements InitializingBean
{
   @Autowired
   private EventRepository eventRepository;

   @Override public void afterPropertiesSet() throws Exception
   {

      Event event1 = new Event();
      event1.setEventType(EventType.SELL);
      event1.setTitle("TV-Bank");
      event1.setDescription("Hey Leute ,\n"
            + "\n"
            + "zum Verkauf steht meine schöne TV-Bank.\n"
            + "\n"
            + "+sehr guter Zustand\n"
            + "+viel Stauraum \n"
            + "+ (B*H*T) (135*43*36)cm\n"
            + "\n"
            + "Bei Interesse einfach melden !\n"
            + "\n");

      eventRepository.save(event1);

      Event event2 = new Event();
      event2.setEventType(EventType.SELL);
      event2.setTitle("Moving out sale !");
      event2.setDescription("Hi ! \n"
            + "Selling all items in pictures for 10€ each. \n"
            + "The black Kallax is stored in Keller, could not make real photo..sorry.\n"
            + "20€ for taking all at once.\n"
            + "Intersted please text in English.\n"
            + "Thanks");

      eventRepository.save(event2);

      Event event3 = new Event();
      event3.setEventType(EventType.SELL);
      event3.setTitle("Thomson 40 Zoll LED Smart TV");
      event3.setDescription("Der Smart TV ist im Neuzustand war als Schlafzimmer gerät im Einsatz für Netflix gucken \n"
            + "Technische Details :\n"
            + "https://www.testberichte.de/p/tho…/40fb5406-testbericht.html\n"
            + "\n"
            + "Mit Fernbedienung\n"
            + "\n"
            + "Lieferung möglich\n"
            + "\n"
            + "Keine Garantie oder Rücknahme");

      eventRepository.save(event3);

      Event event4 = new Event();
      event4.setEventType(EventType.QUERY);
      event4.setTitle("My husband was robbed in the night");
      event4.setDescription(
            "Hello! My husband was robbed in the night from Friday to Saturday in U6. He was very tired after work and he fell asleep (yes, he knows he shouldn't have done it), thieves took his wallet, mobile phone and headset, they left only house keys (do you think they could have copied them somehow?). We have no hope to get the cash and phone back, but perhaps the thieves threw out my husband's wallet and documents: passport, residence card, driving license, ATM cards, insurance card... Last time my husband's mobile phone logged into the Weding district. If any of you found a brown wallet with documents issued under the name of Sukhraj Singh, please let me know. Thank you!");

      eventRepository.save(event4);

      Event event5 = new Event();
      event5.setEventType(EventType.QUERY);
      event5.setTitle("My husband was robbed in the night");
      event5.setDescription(
            "Hello! My husband was robbed in the night from Friday to Saturday in U6. He was very tired after work and he fell asleep (yes, he knows he shouldn't have done it), thieves took his wallet, mobile phone and headset, they left only house keys (do you think they could have copied them somehow?). We have no hope to get the cash and phone back, but perhaps the thieves threw out my husband's wallet and documents: passport, residence card, driving license, ATM cards, insurance card... Last time my husband's mobile phone logged into the Weding district. If any of you found a brown wallet with documents issued under the name of Sukhraj Singh, please let me know. Thank you!");

      eventRepository.save(event5);

      //eventRepository.saveAll(null);

   }
}
