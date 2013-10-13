 package me.carl230690.anticuss;
 
 import java.io.PrintStream;
import java.util.List;

 import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
 
 public class AntiCussListener{
   implements Listener, Plugin;
 {
   public AntiCuss plugin;
 
   public AntiCussListener(AntiCuss instance)
   {
     this.plugin = instance;
   }
   int maxCapsPercentage;
   int minLength;
   static String upperCase;
   public void onEnable()
  {
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    saveDefaultConfig();
    this.maxCapsPercentage = getConfig().getInt("max-caps-percentage");
    this.minLength = getConfig().getInt("min-message-length");
    upperCase = getConfig().getString("uppercase-characters");
  }
   @EventHandler
   public void onPlayerChat(AsyncPlayerChatEvent e) {
/* 21 */     for (String word : e.getMessage().toLowerCase().split(" "))
/* 22 */       if ((e.getPlayer().hasPermission("anticuss.bypass")) || (e.getPlayer().isOp())) {
/* 23 */         e.setCancelled(false);
       }
/* 25 */       else if ((!e.getPlayer().hasPermission("anticuss.kick")) && (this.plugin.getConfig().getStringList("cusswords").contains(word))) {
/* 26 */         e.setCancelled(true);
/* 27 */         String warnmessage = this.plugin.getConfig().getString("warnmessage");
/* 28 */         e.getPlayer().sendMessage(ChatColor.RED + warnmessage);
/* 29 */         if (this.plugin.getConfig().getBoolean("killOnCurse")) {
/* 30 */           e.getPlayer().setHealth(0);
/* 31 */           String killMsg = this.plugin.getConfig().getString("killMessage");
/* 32 */           e.getPlayer().sendMessage(ChatColor.RED + killMsg);
         }
/* 34 */         int cost = this.plugin.getConfig().getInt("cost");
/* 35 */         if (cost > 0) {
/* 36 */           EconomyResponse cussr = AntiCuss.econ.withdrawPlayer(e.getPlayer().getName(), cost);
/* 37 */           if (cussr.transactionSuccess())
/* 38 */             e.getPlayer().sendMessage(ChatColor.RED + "You were charged $" + cost + " for cussing!");
           else
/* 40 */             e.getPlayer().sendMessage(ChatColor.RED + "An error occurred!");
         }
       }
   }
 
     @EventHandler
  public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
    if ((!event.getPlayer().hasPermission("anticuss.caps.bypass")) && 
      (event.getMessage().length() >= this.minLength) && 
      (getUppercasePercentage(event.getMessage()) > this.maxCapsPercentage))
      event.setMessage(event.getMessage().toLowerCase());
  }

  public static boolean isUppercase(String string)
  {
    return upperCase.contains(string);
  }

  public static double getUppercasePercentage(String string) {
    double upperCase = 0.0D;
    for (int i = 0; i < string.length(); i++) {
      if (isUppercase(string.substring(i, i + 1))) {
        upperCase += 1.0D;
      }
    }
    return upperCase / string.length() * 100.0D;
  }}

/* Location:           C:\Users\carl\Desktop\AntiCuss.jar
 * Qualified Name:     me.carl230690.anticuss.AntiCussListener
 * JD-Core Version:    0.6.2
 */