package ru.failer.radiation;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Radiation {
	static ArrayList<Igrok> players = new ArrayList<Igrok>();

	public static void setIgrok(Igrok igrok) {
		for (Igrok i : players) {
			if (i.player.equals(igrok.player)) {
				i = igrok;
			}
		}
	}

	public static Igrok getIgrok(Player player) {
		for (Igrok i : players) {
			if (i.player.equals(player)) {
				return i;
			}
		}
		return null;
	}

	// проверка на нахождение в зараженной местности
	public static boolean onRadArea(Player player) {
		if (getIgrok(player).onArea) {
			return true;
		}
		return false;

	}

	// проверка на существования игрока в листе игроков
	public static boolean checkPlayer(Player player) {
		if (getIgrok(player) != null) {
			return true;
		}
		return false;
	}

	// получение уровня полученной дозы игроком
	public static int getInfection(Player player) {
		return getIgrok(player).infection;
	}

	// установка полученной дозы игрока
	public static void setInfection(Player player, int dose) {
		Igrok igrok = getIgrok(player);
		igrok.infection += dose;
		setIgrok(igrok);
		System.out.println(dose);
	}

	// нахождение на рад. зоне смена
	public static void changeRadArea(Player player, boolean var, int powerArea) {
		Igrok igrok = getIgrok(player);
		igrok.onArea = var;
		igrok.powerArea = powerArea;
		setIgrok(igrok);
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
	public static void startRadTimer(Plugin plugin) {
		plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
			@Override
			public void run() {
				if (players.size() >= 1) {

					for (int i = 0; i < players.size(); i++) {
						if (players.get(i).onArea) {
							Radiation.setInfection(players.get(i).player, players.get(i).powerArea * 100);
						} else {
							Radiation.setInfection(players.get(i).player, 20);
						}
						if (players.get(i).infection > 1000) {
							int resist = ArmorDeffense.getResist(players.get(i).player);
							if (resist > 0) {
								players.get(i).player.damage((double) players.get(i).infection / (600.0 + resist * 10));
							} else {
								players.get(i).player.damage((double) players.get(i).infection / 600.0);
							}
						}
					}
				}
			}
		}, 0L, 400L);
	}
}
