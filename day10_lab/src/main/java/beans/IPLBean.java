package beans;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.PlayerDaoImplementation;
import dao.TeamDaoImplementation;
import pojos.Player;
import pojos.Team;

public class IPLBean {
	
	private long myTeam;
	private String email;
	private String firstName;
	private String lastName;
	private String dob;
	private String batting_avg;
	private String max_age;
	private String wickets_taken;

//state : dep : dao
	private TeamDaoImplementation teamDao;
	private PlayerDaoImplementation playerDao;

	public IPLBean() {
		// dao instace
		teamDao = new TeamDaoImplementation();
		playerDao = new PlayerDaoImplementation();
		System.out.println("IPL bean created...");

	}
	

	public long getMyTeam() {
		return myTeam;
	}


	public void setMyTeam(long myTeam) {
		this.myTeam = myTeam;
	}


	public String getBatting_avg() {
		return batting_avg;
	}

	public void setBatting_avg(String batting_avg) {
		this.batting_avg = batting_avg;
	}

	public String getMax_age() {
		return max_age;
	}

	public void setMax_age(String max_age) {
		this.max_age = max_age;
	}

	public String getWickets_taken() {
		return wickets_taken;
	}

	public void setWickets_taken(String wickets_taken) {
		this.wickets_taken = wickets_taken;
	}

	// getters n setters
	public TeamDaoImplementation getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDaoImplementation teamDao) {
		this.teamDao = teamDao;
	}

	// add B.L method to ret list of all teams to the caller(JSP)
	public List<Team> fetchAllTeams() {
		// invoke dao's method
		return teamDao.getAllTeams();
	}

	public String validatePlayer() {
		
		String msg="Player Not Added";
		Team team=teamDao.getTeamDeatils(myTeam);
		Player newPlayer;
		if(team != null) {
			System.out.println("hii");
			if(team.getBattingAvg()<Double.parseDouble(batting_avg)&&team.getWicketsTaken()<Integer.parseInt(wickets_taken)&&Period.between(LocalDate.parse(dob), LocalDate.now()).getYears()<41) {
				 newPlayer=new Player(email, firstName, lastName, LocalDate.parse(dob), Double.parseDouble(batting_avg), Integer.parseInt(wickets_taken));
				 playerDao.addPlayerToTeam(newPlayer, team.getId());
				 msg="Player inserted succesfully...";
			}	
		}
		return msg;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}

}//
