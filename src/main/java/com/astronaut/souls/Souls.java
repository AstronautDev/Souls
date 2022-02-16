package com.astronaut.souls;

import com.astronaut.souls.listener.PlayerKilled;
import org.bukkit.plugin.java.JavaPlugin;

public class Souls extends JavaPlugin {

    public void onEnable() {
        initListeners();
    }

    public void initListeners() {
        new PlayerKilled(this);
    }

}
