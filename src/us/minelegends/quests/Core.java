package us.minelegends.quests;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import us.minelegends.quests.commands.CmdQuest;
import us.minelegends.quests.events.EventCollectApples;
import us.minelegends.quests.events.EventDamageZombies;
import us.minelegends.quests.events.EventKillPlayer;
import us.minelegends.quests.events.EventMineDiamonds;
import us.minelegends.quests.quests.CollectApples;
import us.minelegends.quests.quests.DamageZombies;
import us.minelegends.quests.quests.KillPlayer;
import us.minelegends.quests.quests.MineDiamonds;
import us.minelegends.quests.utilities.Quest;
import us.minelegends.quests.utilities.QuestManager;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/7/15 under the package us.minelegends.quests
 ***************************************************************************************************/
public class Core extends JavaPlugin {

    private static Core core;
    public Core(){
        core = this;
    }
    public static Core getCore(){
        if (core == null){
            core = new Core();
        }
        return core;
    }

    public static final String TAG = "§6§l(!) §6";

    public Quest currentQuest;
    public int timeUntilReset;

    public void onEnable(){
        registerQuests();
        registerEvents();
        registerCommands();

        QuestManager.getQuestManager().startQuestTimer();
    }

    private void registerQuests(){
        QuestManager.getQuestManager().getQuests().add(new DamageZombies());
        QuestManager.getQuestManager().getQuests().add(new CollectApples());
        QuestManager.getQuestManager().getQuests().add(new KillPlayer());
        QuestManager.getQuestManager().getQuests().add(new MineDiamonds());
    }

    private void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new EventDamageZombies(), this);
        Bukkit.getPluginManager().registerEvents(new EventCollectApples(), this);
        Bukkit.getPluginManager().registerEvents(new EventKillPlayer(), this);
        Bukkit.getPluginManager().registerEvents(new EventMineDiamonds(), this);
    }

    private void registerCommands(){
        getCommand("quest").setExecutor(new CmdQuest());
    }

}
