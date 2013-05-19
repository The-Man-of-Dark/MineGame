package me.the_man_of_dark.minegame.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop {

	public static void giveItem(Player p, int i) {
		if (i == 1) {
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemMeta meta = bow.getItemMeta();
			meta.setDisplayName("§a§lMineGun");
			bow.setItemMeta(meta);
			p.getInventory().addItem(bow);
		}
	}

}
