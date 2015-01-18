package ru.failer.radiation;

import org.bukkit.plugin.Plugin;

public class Generator {
	Plugin plugin;
	public static	int mapList[] = {
		0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,
		0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,
		0,0,0,1,1,1,0,0,0,0,0,1,1,0,0,0,
		0,0,0,0,1,1,0,0,0,0,1,1,1,1,0,0,
		0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,
		0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,
		0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,
		0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,
		0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,
		0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,
		0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,
		0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,
		0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,
		0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,
		0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
		};
	public Generator(Plugin plugin) {
		this.plugin = plugin;
	}
	public static void checkRadArea(int j,int h){
		if(j < 0){
			j = -j;
		}
		if(h < 0)
		{
			h = -h;
		}
		double x = (double)j/16;
		int xc = (int)x; //целая часть номер чанка
		double x2 = x - xc; //дробная часть блок чанка
		x2 = x2*10;
		int x3 = (int) Math.ceil(x2); // блок чанка
		double z = (double)h/16;
		int zc = (int)z; //целая часть
		double z2 = z - zc; //дробная часть
		z2 = z2*10;
		int z3 = (int) Math.ceil(z2);
		if(mapList[x3*z3]==0){
			System.out.println("ne rad");
		
		
			
		} else {
			System.out.println("rad");
			
			
	
		}

		
	}
}
