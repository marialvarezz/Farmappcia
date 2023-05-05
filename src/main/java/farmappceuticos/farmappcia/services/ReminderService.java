package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Reminder;
import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.repositories.ReminderRepository;
import farmappceuticos.farmappcia.repositories.ResultsRepository;
import org.springframework.stereotype.Service;

@Service
public class ReminderService extends AbstractBusinessServiceSoloEnt <Reminder,Integer, ReminderRepository>{

    protected ReminderService(ReminderRepository reminderRepository) {
        super(reminderRepository);
    }
}
