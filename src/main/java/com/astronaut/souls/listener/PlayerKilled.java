package com.astronaut.souls.listener;

import com.astronaut.souls.Souls;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerKilled implements Listener {

    Souls plugin;
    public PlayerKilled(Souls plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerKilled(PlayerDeathEvent e) {
        if(!(e.getEntity().getKiller() instanceof Player)) {
            ItemStack soul = new ItemStack(Material.ENDER_EYE);
            ItemMeta soulMeta = soul.getItemMeta();
            soulMeta.setDisplayName(ChatColor.LIGHT_PURPLE + e.getEntity().getDisplayName().toUpperCase() + "'S SOUL");
            soul.setItemMeta(soulMeta);
            e.getDrops().add(soul);
            e.setDeathMessage("ZOMG! " + e.getEntity().getDisplayName() + "HAS DROPPED THEIR SOUL");
        } else {
            e.setDeathMessage("ZOMG! " + e.getEntity().getDisplayName() + "HAS NO SOUL");
        }
    }

}
