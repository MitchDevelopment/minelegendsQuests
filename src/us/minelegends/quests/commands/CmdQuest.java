package us.minelegends.quests.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import us.minelegends.quests.Core;
import us.minelegends.quests.utilities.QuestManager;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/7/15 under the package us.minelegends.quests.commands
 ***************************************************************************************************/
public class CmdQuest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("quest")){
            if (strings.length < 1){
                if (commandSender.hasPermission("minelegends.quests.admin")){
                    commandSender.sendMessage(Core.TAG + "Incorrect usage! Use §7/quest <join|leave|info|§creset§7>");
                    return false;
                }

                commandSender.sendMessage(Core.TAG + "Incorrect usage! Use §7/quest <join|leave|info>");
            } else {
                if (strings[0].equalsIgnoreCase("join")){
                    if (QuestManager.getQuestManager().getPlayersInQuest().contains(commandSender.getName())){
                        commandSender.sendMessage(Core.TAG + "You're already participating in this quest!");
                        return false;
                    }

                    if (QuestManager.getQuestManager().getPlayersCompletedQuest().contains(commandSender.getName())){
                        commandSender.sendMessage(Core.TAG + "You've already completed this quest!");
                        return false;
                    }

                    commandSender.sendMessage(Core.TAG + "You are §a§lnow §6participating in this quest!");
                    QuestManager.getQuestManager().getPlayersInQuest().add(commandSender.getName());
                } else if (strings[0].equalsIgnoreCase("leave")){
                    if (!QuestManager.getQuestManager().getPlayersInQuest().contains(commandSender.getName())){
                        commandSender.sendMessage(Core.TAG + "You are not already participating in this quest!");
                        return false;
                    }

                    commandSender.sendMessage(Core.TAG + "You are §c§lno longer §6participating in this quest!");
                    QuestManager.getQuestManager().getPlayersInQuest().remove(commandSender.getName());
                } else if (strings[0].equalsIgnoreCase("info")){
                    commandSender.sendMessage(Core.TAG + "Showing info for today's quest...");
                    commandSender.sendMessage(Core.TAG + "Task Name: §e" + Core.getCore().currentQuest.name());
                    commandSender.sendMessage(Core.TAG + "Task Description: §e" + Core.getCore().currentQuest.description());
                    commandSender.sendMessage(Core.TAG + "Time until reset: §c§l" + QuestManager.getQuestManager().timeConversion(Core.getCore().timeUntilReset));
                } else if (strings[0].equalsIgnoreCase("reset") && commandSender.hasPermission("minelegends.quests.admin")){
                    QuestManager.getQuestManager().stopQuestTimer();
                    QuestManager.getQuestManager().startQuestTimer();
                    Bukkit.broadcastMessage(Core.TAG + "§lQuest Reset! §6The current quest has been reset by §c" + commandSender.getName());
                }
            }
        }
        return false;
    }
}
