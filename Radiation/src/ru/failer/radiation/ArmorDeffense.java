package ru.failer.radiation;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmorDeffense {

	public static int getResist(Player player) {
		int res = 0;
		res += getResFromBoots(player.getInventory().getBoots());
		res += getResFromChestPlate(player.getInventory().getChestplate());
		res += getResFromHelmet(player.getInventory().getHelmet());
		res += getResFromLeggins(player.getInventory().getLeggings());
		return res;
	}

	private static int getResFromHelmet(ItemStack item) {
		if (item.getType() == Material.LEATHER_HELMET) {
			return 1;
		}
		if (item.getType() == Material.IRON_HELMET) {
			return 2;
		}
		if (item.getType() == Material.GOLD_HELMET) {
			return 3;
		}
		if (item.getType() == Material.DIAMOND_HELMET) {
			return 4;
		}
		return 0;
	}

	private static int getResFromChestPlate(ItemStack item) {
		if (item.getType() == Material.LEATHER_CHESTPLATE) {
			return 2;
		}
		if (item.getType() == Material.IRON_CHESTPLATE) {
			return 3;
		}
		if (item.getType() == Material.GOLD_CHESTPLATE) {
			return 4;
		}
		if (item.getType() == Material.DIAMOND_CHESTPLATE) {
			return 5;
		}
		return 0;
	}

	private static int getResFromBoots(ItemStack item) {
		if (item.getType() == Material.LEATHER_BOOTS) {
			return 1;
		}
		if (item.getType() == Material.IRON_BOOTS) {
			return 2;
		}
		if (item.getType() == Material.GOLD_BOOTS) {
			return 3;
		}
		if (item.getType() == Material.DIAMOND_BOOTS) {
			return 4;
		}
		return 0;
	}

	private static int getResFromLeggins(ItemStack item) {
		if (item.getType() == Material.LEATHER_LEGGINGS) {
			return 2;
		}
		if (item.getType() == Material.IRON_LEGGINGS) {
			return 3;
		}
		if (item.getType() == Material.GOLD_LEGGINGS) {
			return 4;
		}
		if (item.getType() == Material.DIAMOND_LEGGINGS) {
			return 5;
		}
		return 0;
	}

}
