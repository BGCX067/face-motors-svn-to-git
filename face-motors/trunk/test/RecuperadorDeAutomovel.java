import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.casadocodigo.jsfjpa.entities.Automovel;
import br.com.casadocodigo.jsfjpa.persistence.JPAUtil;

public class RecuperadorDeAutomovel {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		Query q = em.createQuery("select a from Automovel a", Automovel.class);
		
		@SuppressWarnings("unchecked")
		List<Automovel> autos = q.getResultList();

		for (Automovel a : autos) {
			System.out.println(a.getModelo());
		}
	}
}