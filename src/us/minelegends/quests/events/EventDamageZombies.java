package us.minelegends.quests.events;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import us.minelegends.quests.Core;
import us.minelegends.quests.utilities.QuestManager;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/7/15 under the package us.minelegends.quests.events
 ***************************************************************************************************/
public class EventDamageZombies implements Listener {

    public static List<Zombie> zombies = new ArrayList<>();

    public static void cleanup(){
        EventDamageZombies.zombies.clear();
    }

    @EventHandler
    public void onEventDamageZombies(EntityDamageByEntityEvent event){
        if (QuestManager.getQuestManager().getCurrentQuest() == QuestManager.getQuestManager().getQuest("A rotten mission")){
            if (event.getDamager() instanceof Player && event.getEntity() instanceof Zombie){
                Player damager = (Player) event.getDamager();

                if (QuestManager.getQuestManager().getPlayersInQuest().contains(damager.getName())){
                    if (QuestManager.getQuestManager().questProgress.get(damager.getName()) == null){
                        if (!zombies.contains(event.getEntity())){
                            QuestManager.getQuestManager().setQuestProgress(damager.getName(), 1, 5);
                            zombies.add((Zombie) event.getEntity());
                            return;
                        } else {
                            damager.sendMessage(Core.TAG + "This zombie has already been damaged by a player!");
                        }
                    }

                    if (QuestManager.getQuestManager().questProgress.get(damager.getName()) != null && QuestManager.getQuestManager().questProgress.get(damager.getName()) == 1){
                        if (!zombies.contains(event.getEntity())){
                            QuestManager.getQuestManager().setQuestProgress(damager.getName(), 2, 5);
                            zombies.add((Zombie) event.getEntity());
                            return;
                        } else {
                            damager.sendMessage(Core.TAG + "This zombie has already been damaged by a player!");
                        }
                    }

                    if (QuestManager.getQuestManager().questProgress.get(damager.getName()) != null && QuestManager.getQuestManager().questProgress.get(damager.getName()) == 2){
                        if (!zombies.contains(event.getEntity())){
                            QuestManager.getQuestManager().setQuestProgress(damager.getName(), 3, 5);
                            zombies.add((Zombie) event.getEntity());
                            return;
                        } else {
                            damager.sendMessage(Core.TAG + "This zombie has already been damaged by a player!");
                        }
                    }

                    if (QuestManager.getQuestManager().questProgress.get(damager.getName()) != null && QuestManager.getQuestManager().questProgress.get(damager.getName()) == 3){
                        if (!zombies.contains(event.getEntity())){
                            QuestManager.getQuestManager().setQuestProgress(damager.getName(), 4, 5);
                            zombies.add((Zombie) event.getEntity());
                            return;
                        } else {
                            damager.sendMessage(Core.TAG + "This zombie has already been damaged by a player!");
                        }
                    }

                    if (QuestManager.getQuestManager().questProgress.get(damager.getName()) != null && QuestManager.getQuestManager().questProgress.get(damager.getName()) == 4){
                        if (!zombies.contains(event.getEntity())){
                            QuestManager.getQuestManager().completedQuest(damager.getName());
                        } else {
                            damager.sendMessage(Core.TAG + "This zombie has already been damaged by a player!");
                        }
                    }
                } else {
                    if (!QuestManager.getQuestManager().getPlayersCompletedQuest().contains(damager.getName())){
                        damager.sendMessage(Core.TAG + "You are currently progressing on today's quest however are not entered.");
                        damager.sendMessage(Core.TAG + "Run the command §7/quest join §6to enter and receive the reward!");
                    }
                }
            }
        }
    }

}
