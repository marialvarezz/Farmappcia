package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Event;
import farmappceuticos.farmappcia.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService extends AbstractBusinessServiceSoloEnt <Event,Integer,EventRepository>{
    @Autowired
    private EventRepository eventRepository;

    protected EventService(EventRepository eventRepository) {super(eventRepository);}


}
