package metier.session;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Compte;

@Local
public interface IBanqueLocal {
	public  void addCompte(Compte c);
	public List<Compte> gettAllCompte();
	public  Compte getCompte(Long  code);
	public void  verser (double mt, Long code);
	public void  retirer (double mt, Long code);
	public void  virement (double mt, Long c1, Long c2);
	public  void updateCompte(Compte c);
	public void deleteCompte(Compte c);

}
