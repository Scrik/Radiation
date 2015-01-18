package ru.failer.main;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.failer.radiation.Generator;


public class Main extends JavaPlugin implements Listener {
	public void onEnable() {
		System.out.println("Radiation by Failer activated!");
		Bukkit.getPluginManager().registerEvents(this, this);

	}

	@EventHandler
	public void move(PlayerMoveEvent event) {
		
	    if(event.getFrom().getBlockX() != event.getTo().getBlockX()){
	    	Generator.checkRadArea(event.getPlayer().getLocation().getBlockX(),event.getPlayer().getLocation().getBlockZ());
	    }
	    if(event.getFrom().getBlockZ() != event.getTo().getBlockZ()){
	    	Generator.checkRadArea(event.getPlayer().getLocation().getBlockX(),event.getPlayer().getLocation().getBlockZ());
	    }
	    
	}

}