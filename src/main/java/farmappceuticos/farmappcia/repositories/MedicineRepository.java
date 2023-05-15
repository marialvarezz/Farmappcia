package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Answers;
import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine,Integer>{

    Page<Medicine> findByName(String name, Pageable pageable);

    Page<Medicine> findByNameAndDescription(String name,String description, Pageable pageable);
}
