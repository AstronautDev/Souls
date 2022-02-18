package com.astronaut.souls.listener;

import com.astronaut.souls.Souls;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class EatHeart implements Listener {

    Souls plugin;
    public EatHeart(Souls plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void EatHeart(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getInventory().getItemInMainHand();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(i.getType().equals(Material.ENDER_EYE)) {
                p.sendMessage("ender eye clicked");
                    if(ChatColor.stripColor(i.getItemMeta().getDisplayName()).contains("SOUL")) {
                        if(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() != 40D) {
                            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 2D);
                            p.setHealth(p.getHealth() + 2D);
                        } else if(p.getHealth() != 40D){
                            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40D);
                            p.setHealth(p.getHealth() + 2D);
                        } else {
                            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40D);
                            p.setHealth(40D);
                        }
                        p.sendMessage("HEALED NIGGA");
                    }
                }
            }
    }

    @EventHandler
    public void PlayerDie(PlayerDeathEvent e) {
        e.getEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20D);
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20D);
    }

}
