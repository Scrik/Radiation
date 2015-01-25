package ru.failer.radiation;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FoodRadiation {
	public static void setRadiationFood(Player player,ItemStack food){
		if(food.getType() == Material.APPLE) {
			Radiation.setInfection(player, 20);
			return;
		}
		if(food.getType() == Material.BEACON) {
			Radiation.setInfection(player, 50);
			return;
		}
		if(food.getType() == Material.BAKED_POTATO) {
			Radiation.setInfection(player, 150);
			return;
		}
		if(food.getType() == Material.BREAD) {
			Radiation.setInfection(player, 40);
			return;
		}
		if(food.getType() == Material.CAKE) {
			Radiation.setInfection(player, 70);
			return;
		}
		if(food.getType() == Material.ROTTEN_FLESH) {
			Radiation.setInfection(player, 250);
			return;
		}
		if(food.getType() == Material.COOKED_BEEF) {
			Radiation.setInfection(player, 50);
			return;
		}
		if(food.getType() == Material.COOKED_CHICKEN) {
			Radiation.setInfection(player, 50);
			return;
		}
		if(food.getType() == Material.COOKED_FISH) {
			Radiation.setInfection(player, 50);
			return;
		}
	}
}
