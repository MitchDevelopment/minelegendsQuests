package us.minelegends.quests.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import us.minelegends.quests.Core;
import us.minelegends.quests.utilities.QuestManager;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/9/15 under the package us.minelegends.quests.events
 ***************************************************************************************************/
public class EventCollectApples implements Listener {

    @EventHandler
    public void onEventCollectApples(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if (QuestManager.getQuestManager().getCurrentQuest() == QuestManager.getQuestManager().getQuest("2fruity4me")){
            if (event.getItem().getItemStack().getType() == Material.APPLE){
                if (QuestManager.getQuestManager().getPlayersInQuest().contains(player.getName())) {
                    if (QuestManager.getQuestManager().questProgress.get(player.getName()) == null) {
                        QuestManager.getQuestManager().setQuestProgress(player.getName(), 1, 5);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(player.getName()) != null && QuestManager.getQuestManager().questProgress.get(player.getName()) == 1) {
                        QuestManager.getQuestManager().setQuestProgress(player.getName(), 2, 5);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(player.getName()) != null && QuestManager.getQuestManager().questProgress.get(player.getName()) == 2) {
                        QuestManager.getQuestManager().setQuestProgress(player.getName(), 3, 5);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(player.getName()) != null && QuestManager.getQuestManager().questProgress.get(player.getName()) == 3) {
                        QuestManager.getQuestManager().setQuestProgress(player.getName(), 4, 5);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(player.getName()) != null && QuestManager.getQuestManager().questProgress.get(player.getName()) == 4) {
                        QuestManager.getQuestManager().completedQuest(player.getName());
                    }
                } else {
                    if (!QuestManager.getQuestManager().getPlayersCompletedQuest().contains(player.getName())) {
                        player.sendMessage(Core.TAG + "You are currently progressing on today's quest however are not entered.");
                        player.sendMessage(Core.TAG + "Run the command §7/quest join §6to enter and receive the reward!");
                    }
                }
            }
        }
    }

}
