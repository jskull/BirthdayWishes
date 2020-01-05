package com.rokita.birthdaywishes.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.awt.*;
import java.util.Locale;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.setJoinMessage(ChatColor.GREEN + "[+] " + player.getDisplayName());

        player.sendTitle(ChatColor.AQUA + "Happy Birthday {NAME}!", null, 10, 20, 10);

        // Welcome Firework

        Firework fw = player.getWorld().spawn(player.getLocation(), Firework.class);
        FireworkMeta fwm = fw.getFireworkMeta();
        FireworkEffect.Builder builder = FireworkEffect.builder();

        fwm.addEffect(builder.flicker(true).withColor(Color.PURPLE).build());
        fwm.addEffect(builder.trail(true).build());
        fwm.addEffect(builder.withFade(Color.BLUE).build());
        fwm.setPower(1);

        fw.setFireworkMeta(fwm);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.DARK_GRAY + "[-] " + player.getDisplayName());
    }
}
