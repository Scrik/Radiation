package ru.failer.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class ScoreBoard {
	private Scoreboard board;
	private Objective obj;
	private Team team;
	
	public ScoreBoard(){
		board = Bukkit.getScoreboardManager().getNewScoreboard();
	}

}
