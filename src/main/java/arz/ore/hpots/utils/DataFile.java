package arz.ore.hpots.utils;

import arz.ore.hpots.ArzorePots;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class DataFile extends YamlConfiguration {

    private static DataFile config;
    private final Plugin plugin;
    private final File configFile;

    public static DataFile getConfig() {
        if (DataFile.config == null) {
            DataFile.config = new DataFile();
        }
        return DataFile.config;
    }

    private Plugin main() {
        return ArzorePots.getInstance();
    }

    public DataFile() {
        this.plugin = this.main();
        this.configFile = new File(this.plugin.getDataFolder(), "value.yml");
        this.saveDefault();
        this.reload();
    }

    public void reload() {
        try {
            super.load(this.configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            super.save(this.configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDefault() {
        this.plugin.saveResource("value.yml", false);
    }

    public void fullSave() {
        this.save();
        this.reload();
    }
}