import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.casadocodigo.jsfjpa.entities.Automovel;
import br.com.casadocodigo.jsfjpa.persistence.JPAUtil;

public class RemovedorDeAutomovel {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Automovel auto = em.getReference(Automovel.class, 1L);

		tx.begin();
		em.remove(auto);
		tx.commit();
	}
}