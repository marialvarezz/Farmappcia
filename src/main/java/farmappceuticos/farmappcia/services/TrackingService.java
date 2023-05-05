package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.model.Tracking;
import farmappceuticos.farmappcia.repositories.ResultsRepository;
import farmappceuticos.farmappcia.repositories.TrackingRepository;
import org.springframework.stereotype.Service;

@Service
public class TrackingService extends AbstractBusinessServiceSoloEnt <Tracking,Integer, TrackingRepository>{

    protected TrackingService(TrackingRepository trackingRepository) {
        super(trackingRepository);
    }
}
