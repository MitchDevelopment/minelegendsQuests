package us.minelegends.quests.quests;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import us.minelegends.quests.utilities.ItemStackBuilder;
import us.minelegends.quests.utilities.Quest;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/7/15 under the package us.minelegends.quests.quests
 ***************************************************************************************************/
public class DamageZombies implements Quest {
    @Override
    public String name() {
        return "A rotten mission";
    }

    @Override
    public String description() {
        return "Damage 5 zombies with any item.";
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public ItemStack reward(){
        return new ItemStackBuilder(Material.DIAMOND).withName("§d§lThe Prettiest Pinkest Diamond").withEnchantment(Enchantment.ARROW_INFINITE).withLore("§7Forged from the depths of heaven.. sooo shiiny!").build();
    }
}
