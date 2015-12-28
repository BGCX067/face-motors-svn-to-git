package br.com.casadocodigo.jsfjpa.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.casadocodigo.jsfjpa.entities.Automovel;
import br.com.casadocodigo.jsfjpa.persistence.JPAUtil;

@ManagedBean
public class AutomovelBean {

	private Automovel automovel;

	private List<Automovel> automoveis;

	public void salva(Automovel automovel) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		em.persist(automovel);

		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Automovel> getAutomoveis() {
		if (this.automoveis == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select a from Automovel a",
					Automovel.class);

			this.automoveis = q.getResultList();

			em.close();
		}
		return automoveis;
	}

	public Automovel getAutomovel() {
		if (automovel == null)
			automovel = new Automovel();
		return automovel;
	}
}