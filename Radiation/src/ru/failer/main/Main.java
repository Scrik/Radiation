package ru.failer.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.failer.radiation.FoodRadiation;
import ru.failer.radiation.Generator;
import ru.failer.radiation.Radiation;
import ru.failer.scoreboard.ScoreBoard;

public class Main extends JavaPlugin implements Listener {
	public void onEnable() {
		new ScoreBoard();
		System.out.println("Radiation by Failer activated!");
		Bukkit.getPluginManager().registerEvents(this, this);
		Radiation.startRadTimer(this);
	}

	@EventHandler
	// отслеживание перемещения игрока
	public void move(PlayerMoveEvent event) {
		// проверка на изменение координат игрока
		if (event.getFrom().getBlockX() != event.getTo().getBlockX()) {
			// проверка зоны
			Generator.checkRadArea(event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ(), event.getPlayer());
		}
		// проверка на изменение координат игрока
		if (event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
			// проверка зоны
			Generator.checkRadArea(event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ(), event.getPlayer());
		}

	}

	// заход игрока
	@EventHandler
	public void JoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		// проверка на существование игрока в листе игроков
		if (!Radiation.checkPlayer(player)) {
			// добавление игрока в лист игроков тк его там нет
			Radiation.addPlayer(player);
		}
	}

	// смерть игрока
	@EventHandler
	public void DeathEvent(PlayerDeathEvent event) {
		Player player = event.getEntity().getPlayer();
		int d = Radiation.getInfection(player);
		d = -d;
		// обнуление счетчика заражения
		Radiation.setInfection(player, d);
	}
	//еда
	@EventHandler
	public void eatevent(PlayerItemConsumeEvent event) {
		FoodRadiation.setRadiationFood(event.getPlayer(), event.getItem());
	}

}