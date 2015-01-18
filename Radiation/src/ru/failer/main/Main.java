package ru.failer.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.failer.radiation.Generator;
import ru.failer.radiation.Radiation;

public class Main extends JavaPlugin implements Listener {
	public void onEnable() {
		System.out.println("Radiation by Failer activated!");
		Bukkit.getPluginManager().registerEvents(this, this);
		Radiation.startRadTimer();
	}

	@EventHandler
	//отслеживание перемещения игрока
	public void move(PlayerMoveEvent event) {
		// проверка на изменение координат игрока
		if (event.getFrom().getBlockX() != event.getTo().getBlockX()) {
			//проверка зоны
			Generator.checkRadArea(event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ(), event.getPlayer());
		}
		// проверка на изменение координат игрока
		if (event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
			//проверка зоны
			Generator.checkRadArea(event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ(), event.getPlayer());
		}

	}
//заход игрока
	public void JoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
	//проверка на существование игрока в листе игроков
		if (!Radiation.checkPlayer(player)) {
			//добавление игрока в лист игроков тк его там нет
			Radiation.addPlayer(player);
		}
	}

}