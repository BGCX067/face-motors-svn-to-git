import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.casadocodigo.jsfjpa.entities.Automovel;
import br.com.casadocodigo.jsfjpa.persistence.JPAUtil;

public class PersistidorDeAutomovel {
	
	public static void main(String[] args) {
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

		//EntityManager em = emf.createEntityManager();
		
		EntityManager em = JPAUtil.getEntityManager();

		Automovel auto = new Automovel();
		auto.setAnoFabricacao(2010);
		auto.setModelo("Ferrari");
		auto.setObservacoes("Nunca foi batido");

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(auto);
		tx.commit();

		em.close();
		//emf.close();
	}
}