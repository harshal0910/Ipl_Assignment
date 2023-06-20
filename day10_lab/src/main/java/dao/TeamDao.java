package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
	
	//add method to lift team id and abbrevation from all the teams
	List<Team> getAllTeams();
	
	//add method to add team
	String addNewTeam(Team team);
	
	//add method to get team getDetails
	Team getTeamDeatils(long teamId);
}
