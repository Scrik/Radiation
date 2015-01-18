package ru.failer.radiation;

import org.bukkit.entity.Player;

public class Igrok {
	//игрок
	Player player;
	// на зараженной зоне или нет
	boolean onArea = false;
	//полученная доза радиации
	int infection = 0;
	//сила зараженной зоны
	int powerArea;
}
