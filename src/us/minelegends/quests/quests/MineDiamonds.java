package us.minelegends.quests.quests;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import us.minelegends.quests.utilities.ItemStackBuilder;
import us.minelegends.quests.utilities.Quest;

/***************************************************************************************************
 * This class was created by CodenameFlip on 11/12/15 under the package us.minelegends.quests.quests
 ***************************************************************************************************/
public class MineDiamonds implements Quest {
    @Override
    public String name() {
        return "Hey look! Diamonds!";
    }

    @Override
    public String description() {
        return "Collect 10 diamonds by mining (Shop doesn't count cheater!)";
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public ItemStack reward() {
        return new ItemStackBuilder(Material.DIAMOND_BLOCK).withAmount(1).build();
    }
}
