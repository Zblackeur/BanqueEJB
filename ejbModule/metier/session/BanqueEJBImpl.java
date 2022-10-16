package metier.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;

@Stateless(name="BK")
public class BanqueEJBImpl implements IBanqueLocal,IBanqueRemote{
	
	@PersistenceContext
	private EntityManager em ;

	@Override
	public void addCompte(Compte c) {
		em.persist(c);
		//return c;
		
	}

	@Override
	public List<Compte> gettAllCompte() {
		Query sql =em.createQuery("select c from Compte c where c.active==true");
		return sql.getResultList();
	}

	@Override
	public Compte getCompte(Long code) {
		Compte c =(Compte)em.find(Compte.class, code);
		if(c==null) throw  new RuntimeException("Compte introuvable");
		return c;
	}

	@Override
	public void verser(double mt, Long code) {
		Compte c = getCompte(code);
		c.setSolde(mt+c.getSolde());
		em.persist(c);
		
	}

	@Override
	public void retirer(double mt, Long code) {
		Compte c = getCompte(code);
		if(c.getSolde()>=mt) c.setSolde(c.getSolde()-mt);
		em.persist(c);
		
	}

	@Override
	public void virement(double mt, Long c1, Long c2) {
		retirer(mt,c1);
		verser(mt,c2);
		
	}

	@Override
	public void updateCompte(Compte c) {
		Compte cu =(Compte)em.find(Compte.class, c.getCode());
		cu.setActive(c.getActive());
		cu.setDateCreation(c.getDateCreation());
		cu.setSolde(c.getSolde());
		//cu.setQuantite(c.getQuantite());

		cu=em.merge(cu);

		//return pu;
	}

	@Override
	public void deleteCompte(Compte c) {
		Compte cd =(Compte)em.find(Compte.class,c.getCode());
		em.remove(cd);
		
	}

}
