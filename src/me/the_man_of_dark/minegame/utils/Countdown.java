package me.the_man_of_dark.minegame.utils;

import me.the_man_of_dark.minegame.minegame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Countdown {

	static public void countdown(final int t, minegame plugin) {
		Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                int count = t;
                while (true) {
                   for (String player : Players.pls.get(1)) {
                	   Player p = Bukkit.getPlayer(player);
                	   p.sendMessage("ß7ßl>ßb Inß6 " + count + "ßb Sekunden");
                   }
                    count--;
                    if (count == 0) {
                        for (String player : Players.pls.get(1)) {
                     	   Player p = Bukkit.getPlayer(player);
                     	   p.sendMessage("ß7ßl>ßb Das Spiel beginnt, Viel Spaﬂ!");
                     	   Game.start();
                        }
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
	}

}
