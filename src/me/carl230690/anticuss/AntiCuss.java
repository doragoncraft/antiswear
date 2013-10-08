/*    */ package me.carl230690.anticuss;
/*    */ 
/*    */ import java.util.logging.Logger;

/*    */ import me.carl230690.anticuss.commands.AntiCussCommand;
/*    */ import me.carl230690.anticuss.commands.Chat;
/*    */ import me.carl230690.anticuss.commands.Clear;
/*    */ import me.carl230690.anticuss.commands.Reload;
/*    */ import net.milkbowl.vault.economy.Economy;

/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*    */ import org.bukkit.plugin.PluginDescriptionFile;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.RegisteredServiceProvider;
/*    */ import org.bukkit.plugin.ServicesManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class AntiCuss extends JavaPlugin
/*    */ {
/*    */   public AntiCuss plugin;
/*    */   public boolean chatMuted;
/* 18 */   public static Economy econ = null;
/*    */ 
/*    */   private boolean setupEconomy() {
/* 21 */     if (getServer().getPluginManager().getPlugin("Vault") == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     RegisteredServiceProvider rsp = getServer().getServicesManager().getRegistration(Economy.class);
/* 25 */     if (rsp == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     econ = (Economy)rsp.getProvider();
/* 29 */     return econ != null;
/*    */   }
/*    */ 
/*    */   public void onEnable()
/*    */   {
/* 34 */     getLogger().info("AntiCuss enabled!");
/* 35 */     getConfig().options().copyDefaults(true);
/* 36 */     saveConfig();
/* 37 */     getServer().getPluginManager().registerEvents(new AntiCussListener(this), this);
/* 38 */     getServer().getPluginManager().registerEvents(new MuteListener(this), this);
/* 39 */     getCommand("anticuss").setExecutor(new AntiCussCommand(this));
/* 40 */     getCommand("acreload").setExecutor(new Reload(this));
/* 41 */     getCommand("clearchat").setExecutor(new Clear(this));
/* 42 */     getCommand("chat").setExecutor(new Chat(this));
             PluginDescriptionFile pdfFile = this.getDescription();
/*    */ 
/* 44 */     if (!setupEconomy()) {
/* 45 */       getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", new Object[] { getDescription().getName() }));
/* 46 */       getServer().getPluginManager().disablePlugin(this);
/* 47 */       return;
/*    */     }
/*    */   }
/*    */ 
/*    */   public void onDisable() {
/* 52 */     getLogger().info("AntiCuss has been disabled!");
/*    */   }
/*    */ }

/* Location:           C:\Users\carl\Desktop\AntiCuss.jar
 * Qualified Name:     me.carl230690.anticuss.AntiCuss
 * JD-Core Version:    0.6.2
 */