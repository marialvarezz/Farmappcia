package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.repositories.AgendaRepository;
import farmappceuticos.farmappcia.repositories.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultsService extends AbstractBusinessServiceSoloEnt <Results,Integer, ResultsRepository>{

    protected ResultsService(ResultsRepository resultsRepository) {
        super(resultsRepository);
    }
}
