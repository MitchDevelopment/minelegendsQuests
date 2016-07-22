package us.minelegends.quests.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import us.minelegends.quests.Core;
import us.minelegends.quests.utilities.QuestManager;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/12/15 under the package us.minelegends.quests.events
 ***************************************************************************************************/
public class EventKillPlayer implements Listener {

    @EventHandler
    public void onEventKillPlayer(PlayerDeathEvent event){
        Player killer = event.getEntity().getKiller();

        if (QuestManager.getQuestManager().getCurrentQuest() == QuestManager.getQuestManager().getQuest("A not so friendly hello...")){
            if (killer != null){
                if (QuestManager.getQuestManager().playersInQuest.contains(killer.getName())){
                    if (QuestManager.getQuestManager().questProgress.get(killer.getName()) == null){
                        QuestManager.getQuestManager().completedQuest(killer.getName());
                    }
                } else {
                    if (!QuestManager.getQuestManager().getPlayersCompletedQuest().contains(killer.getName())) {
                        killer.sendMessage(Core.TAG + "You are currently progressing on today's quest however are not entered.");
                        killer.sendMessage(Core.TAG + "Run the command §7/quest join §6to enter and receive the reward!");
                    }
                }
            }
        }
    }

}
