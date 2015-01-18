package ru.failer.radiation;

import org.bukkit.entity.Player;

public class Generator {
	//карта чанка
	public static	int mapList[] = {
		0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,
		0,0,1,3,2,0,0,0,0,0,0,0,0,0,0,0,
		0,0,0,1,2,5,0,0,0,0,0,1,2,0,0,0,
		0,0,0,0,3,4,0,0,0,0,1,5,4,1,0,0,
		0,0,0,0,0,0,0,0,0,0,0,1,2,1,0,0,
		0,0,0,5,0,0,0,0,1,0,0,0,1,0,0,0,
		0,0,5,5,0,0,1,4,1,0,0,0,0,0,0,0,
		0,5,0,0,0,0,0,0,1,0,0,0,1,0,0,0,
		0,0,0,0,0,0,0,0,0,0,0,1,5,1,0,0,
		0,0,0,0,0,1,1,0,0,0,0,0,9,1,0,0,
		0,0,0,0,1,2,3,1,0,0,0,0,0,0,0,0,
		0,0,0,1,2,3,4,1,0,0,0,0,0,0,0,0,
		0,0,0,0,1,3,5,3,1,0,0,0,0,0,0,0,
		0,0,0,0,0,0,2,1,1,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
		};

	// проверка зараженности места
	public static void checkRadArea(int j, int h, Player player) {
		// если переменные отрицательные
		if (j < 0) {
			j = -j;
		}
		if (h < 0) {
			h = -h;
		}
		// получение номера чанка
		double x = (double) j / 16;
		int xc = (int) x; 
		double x2 = x - xc;
		x2 = x2 * 10;
		int x3 = (int) Math.ceil(x2); 
		double z = (double) h / 16;
		int zc = (int) z; 
		double z2 = z - zc;
		z2 = z2 * 10;
		int z3 = (int) Math.ceil(z2);
		
		if (mapList[x3 * z3] == 0) {
			Radiation.changeRadArea(player, false, mapList[x3 * z3]);
		} else {
			Radiation.changeRadArea(player, true, mapList[x3 * z3]);
			Radiation.setInfection(player, mapList[x3 * z3] * 100);
		}

	}
}
