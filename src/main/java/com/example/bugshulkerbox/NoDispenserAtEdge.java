package com.example.bugshulkerbox;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 防止在世界顶部/底部放置发射器
 * 作者: shaojie98
 */
public class NoDispenserAtEdge extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoDispenserAtEdge插件已启用");
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.DISPENSER) {
            int y = event.getBlock().getLocation().getBlockY();
            if (y == 0 || y == 255) {
                event.setCancelled(true);
                event.getPlayer().kickPlayer("§c检测到利用bug行为！");
            }
        }
    }
}