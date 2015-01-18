package ru.failer.radiation;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Radiation {
	static ArrayList<Igrok> players = new ArrayList<Igrok>();
	

	public static boolean onRadArea(Player player) {
	if(players.size() >= 1) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).player.equals(player)) {
				if (players.get(i).onArea) {
					return true;
				}
			}
		}
	}
		return false;
	}
	public static void setInfection(Player player,int dose) {
		if(players.size() >= 1) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).player.equals(player)) {
				players.get(i).infection +=dose;
			}
		}
		}
	}
	public static void changeRadArea(Player player,boolean var){
		if(players.size() >= 1) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).player.equals(player)) {
				players.get(i).onArea = var;
			}
		}
		}
	}
	public static void addPlayer(Player player){
		Igrok tempigrok = new Igrok();
		tempigrok.player = player;
		tempigrok.onArea = false;
		tempigrok.infection = 0;
		players.add(tempigrok);
	}
	
	private void startKill(){
		
	}

}
