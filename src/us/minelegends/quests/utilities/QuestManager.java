package us.minelegends.quests.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import us.minelegends.quests.Core;
import us.minelegends.quests.events.EventDamageZombies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/7/15 under the package us.minelegends.quests.utilities
 ***************************************************************************************************/
public class QuestManager {

    private static QuestManager questManager;
    public QuestManager(){
        questManager = this;
    }
    public static QuestManager getQuestManager(){
        if (questManager == null){
            questManager = new QuestManager();
        }
        return questManager;
    }

    public List<Quest> quests = new ArrayList<>();

    public List<Quest> getQuests() {
        return quests;
    }

    public List<String> playersInQuest = new ArrayList<>();

    public List<String> getPlayersInQuest(){
        return playersInQuest;
    }

    public List<String> playersCompletedQuest = new ArrayList<>();

    public List<String> getPlayersCompletedQuest(){
        return playersCompletedQuest;
    }

    public Quest getRandomQuest(){
        Random random = new Random();
        int randomed = random.nextInt(getQuests().size());

        return quests.get(randomed);
    }

    int runNew;
    int runCount;

    public void startQuestTimer(){
        runNew = Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getCore(), new Runnable() {
            @Override
            public void run() {
                setCurrentQuest(getRandomQuest());
                getPlayersInQuest().clear();
                getPlayersCompletedQuest().clear();

                questProgress.clear();

                EventDamageZombies.cleanup();

                Core.getCore().timeUntilReset = 60 * 60 * 24;

                Bukkit.broadcastMessage(Core.TAG + "A new quest has been chosen! Use §e/quest §6to begin!");
            }
        }, 0, 20 * 60 * 60 * 24);

        runCount = Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getCore(), new Runnable() {
            @Override
            public void run() {
                Core.getCore().timeUntilReset = Core.getCore().timeUntilReset - 1;
            }
        }, 0, 20);
    }

    public void stopQuestTimer(){
        Bukkit.getScheduler().cancelTask(runNew);
        Bukkit.getScheduler().cancelTask(runCount);
    }

    public String timeConversion(int totalSeconds) {
        int hours = totalSeconds / 60 / 60;
        int minutes = (totalSeconds - (hoursToSeconds(hours)))
                / 60;
        int seconds = totalSeconds
                - ((hoursToSeconds(hours)) + (minutesToSeconds(minutes)));

        return hours + " hours " + minutes + " minutes " + seconds + " seconds";
    }

    private static int hoursToSeconds(int hours) {
        return hours * 60 * 60;
    }

    private static int minutesToSeconds(int minutes) {
        return minutes * 60;
    }

    public void setCurrentQuest(Quest quest){
        Core.getCore().currentQuest = quest;
    }

    public Quest getCurrentQuest(){
        return Core.getCore().currentQuest;
    }

    public Quest getQuest(String name){
        for (Quest all : getQuests()){
            if (all.name().equalsIgnoreCase(name)){
                return all;
            }
        }
        return null;
    }

    public HashMap<String, Integer> questProgress = new HashMap<>();

    public void setQuestProgress(String player, Integer progress, Integer total){
        QuestManager.getQuestManager().questProgress.remove(player);
        QuestManager.getQuestManager().questProgress.put(player, progress);


        Bukkit.getPlayerExact(player).sendMessage(Core.TAG + "§lQuest Progress! §6You have made progress on today's quest! (§a§l" + progress + "§6/" + total + ")!");
    }

    public void completedQuest(String player){
        questProgress.remove(player);
        Bukkit.getPlayerExact(player).sendMessage(Core.TAG + "You have §a§lsuccessfully §6completed today's quest!");
        Bukkit.getPlayerExact(player).sendMessage(Core.TAG + "Enjoy your reward and come back tomorrow for another.");

        QuestManager.getQuestManager().distributeReward(Bukkit.getPlayerExact(player));
        QuestManager.getQuestManager().getPlayersInQuest().remove(player);
        QuestManager.getQuestManager().getPlayersCompletedQuest().add(player);
    }

    public void distributeReward(Player player){
        player.getInventory().addItem(getCurrentQuest().reward());
    }

}
