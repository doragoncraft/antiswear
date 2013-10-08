/*    */ package me.carl230690.anticuss;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ 
/*    */ public class MuteListener
/*    */   implements Listener
/*    */ {
/*    */   public AntiCuss plugin;
/*    */ 
/*    */   public MuteListener(AntiCuss instance)
/*    */   {
/* 13 */     this.plugin = instance;
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onAsynPlayerChat(AsyncPlayerChatEvent event) {
/* 18 */     Player player = event.getPlayer();
/* 19 */     if ((this.plugin.chatMuted) && (!player.hasPermission("anticuss.bypass"))) {
/* 20 */       event.setCancelled(true);
/* 21 */       player.sendMessage(ChatColor.RED + this.plugin.getConfig().getString("cancelChatMessage"));
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\carl\Desktop\AntiCuss.jar
 * Qualified Name:     me.carl230690.anticuss.MuteListener
 * JD-Core Version:    0.6.2
 */