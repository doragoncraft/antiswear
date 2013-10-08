/*    */ package me.carl230690.anticuss;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import net.milkbowl.vault.economy.EconomyResponse;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ 
/*    */ public class AntiCussListener
/*    */   implements Listener
/*    */ {
/*    */   public AntiCuss plugin;
/*    */ 
/*    */   public AntiCussListener(AntiCuss instance)
/*    */   {
/* 16 */     this.plugin = instance;
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onPlayerChat(AsyncPlayerChatEvent e) {
/* 21 */     for (String word : e.getMessage().toLowerCase().split(" "))
/* 22 */       if ((e.getPlayer().hasPermission("anticuss.bypass")) || (e.getPlayer().isOp())) {
/* 23 */         e.setCancelled(false);
/*    */       }
/* 25 */       else if ((!e.getPlayer().hasPermission("anticuss.kick")) && (this.plugin.getConfig().getStringList("cusswords").contains(word))) {
/* 26 */         e.setCancelled(true);
/* 27 */         String warnmessage = this.plugin.getConfig().getString("warnmessage");
/* 28 */         e.getPlayer().sendMessage(ChatColor.RED + warnmessage);
/* 29 */         if (this.plugin.getConfig().getBoolean("killOnCurse")) {
/* 30 */           e.getPlayer().setHealth(0);
/* 31 */           String killMsg = this.plugin.getConfig().getString("killMessage");
/* 32 */           e.getPlayer().sendMessage(ChatColor.RED + killMsg);
/*    */         }
/* 34 */         int cost = this.plugin.getConfig().getInt("cost");
/* 35 */         if (cost > 0) {
/* 36 */           EconomyResponse cussr = AntiCuss.econ.withdrawPlayer(e.getPlayer().getName(), cost);
/* 37 */           if (cussr.transactionSuccess())
/* 38 */             e.getPlayer().sendMessage(ChatColor.RED + "You were charged $" + cost + " for cussing!");
/*    */           else
/* 40 */             e.getPlayer().sendMessage(ChatColor.RED + "An error occurred!");
/*    */         }
/*    */       }
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onAsyncPlayerChat(AsyncPlayerChatEvent e)
/*    */   {
/* 53 */     Player player = e.getPlayer();
/* 54 */     String message = e.getMessage();
/* 55 */     if (!player.hasPermission("anticuss.bypass")) {
/* 56 */       int caps = 0;
/* 57 */       for (int i = 0; i < message.length(); i++) {
/* 58 */         if (Character.isUpperCase(message.charAt(i)))
/* 59 */           caps++;
/*    */       }
/*    */       try
/*    */       {
/* 63 */         int iPercent = this.plugin.getConfig().getInt("capsPercentage");
/*    */ 
/* 65 */         if (1.0D * caps / message.length() * 100.0D > iPercent) {
/* 66 */           e.setCancelled(true);
/* 67 */           player.sendMessage(ChatColor.RED + "You used too many caps in that chat message.");
/*    */         }
/*    */       } catch (ArithmeticException ae) {
/* 70 */         System.out.println("Message had a length of 0 :(");
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\carl\Desktop\AntiCuss.jar
 * Qualified Name:     me.carl230690.anticuss.AntiCussListener
 * JD-Core Version:    0.6.2
 */