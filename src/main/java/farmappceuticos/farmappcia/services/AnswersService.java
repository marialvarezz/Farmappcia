package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Answers;
import farmappceuticos.farmappcia.model.IncMedicine;
import farmappceuticos.farmappcia.repositories.AnswersRepository;
import farmappceuticos.farmappcia.repositories.IncMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswersService extends AbstractBusinessServiceSoloEnt <Answers,Integer, AnswersRepository> {
    @Autowired
    private AnswersRepository answersRepository;

    protected AnswersService(AnswersRepository answersRepository) {
        super(answersRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}

