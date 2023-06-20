package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Team;
import utils.HibernateUtils;

class TestTamDao {

	private static TeamDao dao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//build session factory n create dao instance
		HibernateUtils.getFactory();//triggers craetion of sf
		dao=new TeamDaoImplementation();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		HibernateUtils.getFactory().close();
	}
	
//	@Test
//	void test() {
//		Team newTeam=new Team("Chennai","CSK","Harshal",32,65,4);
//		//invoke dao method
//		String msg=dao.addNewTeam(newTeam);
//		System.out.println(msg);
//		assertEquals(2, newTeam.getId());
//	}
	
	@Test
	void testGetAllTeams() {
		List<Team> teams=dao.getAllTeams();
		teams.forEach(t ->System.out.println(t.getId() +" "+t.getAbbreviation()));
		assertEquals(2	, teams.size());
		
	}

}
