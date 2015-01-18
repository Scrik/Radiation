package ru.failer.radiation;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Radiation {
	static ArrayList<Igrok> players = new ArrayList<Igrok>();
	static Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Radiation");

	// проверка на нахождение в зараженной местности
	public static boolean onRadArea(Player player) {
		if (players.size() >= 1) {
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

	// проверка на существования игрока в листе игроков
	public static boolean checkPlayer(Player player) {
		if (players.size() >= 1) {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).player.equals(player)) {
					return true;
				}
			}
		}
		return false;
	}

	// установка полученной дозы игрока
	public static void setInfection(Player player, int dose) {
		if (players.size() >= 1) {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).player.equals(player)) {
					players.get(i).infection += dose;
				}
			}
		}
	}

	// нахождение на рад. зоне смена
	public static void changeRadArea(Player player, boolean var, int powerArea) {
		if (players.size() >= 1) {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).player.equals(player)) {
					players.get(i).onArea = var;
					players.get(i).powerArea = powerArea;
				}
			}
		}
	}

	// добавление игрока в лист игроков
	public static void addPlayer(Player player) {
		Igrok tempigrok = new Igrok();
		tempigrok.player = player;
		tempigrok.onArea = false;
		tempigrok.infection = 0;
		tempigrok.powerArea = 0;
		players.add(tempigrok);
	}

	// запуск главного таймера
	public static void startRadTimer() {
		plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				if (players.size() >= 1) {
					for (int i = 0; i < players.size(); i++) {
						if (players.get(i).onArea) {
							Radiation.setInfection(players.get(i).player, players.get(i).powerArea * 100);
						}
						if (players.get(i).infection > 1000) {
							players.get(i).player.damage((double) players.get(i).infection / 100.0);
						}
					}
				}
			}
		}, 0L, 400L);

	}

}
