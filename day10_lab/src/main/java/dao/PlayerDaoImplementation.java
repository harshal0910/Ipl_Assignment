package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImplementation implements PlayerDao {

	@Override
	public String addPlayerToTeam(Player newPlayer, Long teamId) {
		
		String msg="Adding new player failed..";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team=session.get(Team.class, teamId);
			if(team !=null) {
				team.addPlayer(newPlayer);
				session.persist(newPlayer);
				tx.commit();
			}
			msg="Added new player successfully...";
		}
		catch(RuntimeException e) {
			
		}
		return msg;
		
	}

}
