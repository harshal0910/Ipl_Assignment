package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

public class TeamDaoImplementation implements TeamDao{

	@Override
	public List<Team> getAllTeams() {
		List<Team>teamList=null;
		String jpql="select new pojos.Team(id,abbreviation) from Team t";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			teamList=session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
			
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return teamList;
	}

	@Override
	public String addNewTeam(Team team) {
		// TODO Auto-generated method stub
		
		String msg="Adding new team failed";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(team);
			tx.commit();
			msg="Team added successfully...!!!";
		}
		catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return msg;	
	}

	@Override
	public Team getTeamDeatils(long teamId) {
		Team team=new Team();
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			 team = session.get(Team.class, teamId);
			 tx.commit();
			 System.out.println("hello");
		}
		catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return team;
	}

}
