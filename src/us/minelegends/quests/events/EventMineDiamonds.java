package us.minelegends.quests.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import us.minelegends.quests.Core;
import us.minelegends.quests.utilities.QuestManager;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/12/15 under the package us.minelegends.quests.events
 ***************************************************************************************************/
public class EventMineDiamonds implements Listener {

    @EventHandler
    public void onEventMineDiamonds(BlockBreakEvent event){
        Player whoBroke = event.getPlayer();

        if (QuestManager.getQuestManager().getCurrentQuest() == QuestManager.getQuestManager().getQuest("Hey look! Diamonds!")){

            if (event.getBlock().getType() == Material.DIAMOND_ORE){
                if (QuestManager.getQuestManager().getPlayersInQuest().contains(whoBroke.getName())) {
                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == null) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 1, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 1) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 2, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 2) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 3, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 3) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 4, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 4) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 5, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 5) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 6, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 6) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 7, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 7) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 8, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 8) {
                        QuestManager.getQuestManager().setQuestProgress(whoBroke.getName(), 9, 10);
                        return;
                    }

                    if (QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) != null && QuestManager.getQuestManager().questProgress.get(whoBroke.getName()) == 9) {
                        QuestManager.getQuestManager().completedQuest(whoBroke.getName());
                    }
                } else {
                    if (!QuestManager.getQuestManager().getPlayersCompletedQuest().contains(whoBroke.getName())) {
                        whoBroke.sendMessage(Core.TAG + "You are currently progressing on today's quest however are not entered.");
                        whoBroke.sendMessage(Core.TAG + "Run the command §7/quest join §6to enter and receive the reward!");
                    }
                }
            }
        }
    }

}
