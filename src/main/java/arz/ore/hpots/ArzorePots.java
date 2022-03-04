package arz.ore.hpots;

import lombok.Getter;
import arz.ore.hpots.commands.PotCommands;
import arz.ore.hpots.listener.VelocityListener;
import me.vaperion.blade.Blade;
import me.vaperion.blade.command.bindings.impl.BukkitBindings;
import me.vaperion.blade.command.container.impl.BukkitCommandContainer;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class ArzorePots extends JavaPlugin {

    @Getter
    private static ArzorePots instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        Blade.of()
                .fallbackPrefix("hPots")
                .containerCreator(BukkitCommandContainer.CREATOR)
                .binding(new BukkitBindings())
                .build()
                .register(PotCommands.class);

        getServer().getPluginManager().registerEvents(new VelocityListener(), this);
        System.out.println("hPots " + getDescription().getVersion() + " enabled Arzore#2317");
    }

    @Override
    public void onDisable() {
        instance = null;

        System.out.println("hPots " + getDescription().getVersion() + " disabled Arzore#2317");
    }
}
