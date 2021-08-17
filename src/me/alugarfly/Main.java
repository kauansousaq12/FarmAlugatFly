package me.alugarfly;

import me.alugarfly.command.CommandFly;
import me.alugarfly.command.CommandGiveFly;
import org.bukkit.Bukkit;
import org.bukkit.block.Skull;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Ref;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§a[FarmAlugarFly] Ativado com sucesso!");
        getCommand("alugarfly").setExecutor(new CommandFly());
        getCommand("givealugarfly").setExecutor(new CommandGiveFly());
        Reflections.loadUtils();
        SkullAPI.load();
        super.onEnable();
    }
}
