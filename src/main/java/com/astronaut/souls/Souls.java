package com.astronaut.souls;

import com.astronaut.souls.listener.EatHeart;
import com.astronaut.souls.listener.PlayerKilled;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Souls extends JavaPlugin {

    public void onEnable() {
        initListeners();

        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20D);
        }
    }

    public void initListeners() {
        new PlayerKilled(this);
        new EatHeart(this);
    }

}
