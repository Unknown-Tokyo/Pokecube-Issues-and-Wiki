package pokecube.adventures.utils.trade_presets;

import java.util.Locale;
import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import pokecube.adventures.capabilities.utils.TypeTrainer.TrainerTrade;
import pokecube.adventures.capabilities.utils.TypeTrainer.TrainerTrades;
import pokecube.adventures.utils.TradeEntryLoader;
import pokecube.adventures.utils.TradeEntryLoader.Trade;
import pokecube.adventures.utils.TradeEntryLoader.TradePreset;
import pokecube.api.PokecubeAPI;
import pokecube.api.utils.Tools;
import thut.api.util.JsonUtil;
import thut.lib.TComponent;

@TradePresetAn(key = "sellExplorationMap")
public class SellStructureMap implements TradePreset
{
    public static final String ID = new String("id");
    public static final String NEW_ONLY = new String("new_only");

    @Override
    public void apply(final Trade trade, final TrainerTrades trades)
    {
        Map<String, String> values;
        TrainerTrade recipe;
        final ItemStack sell = new ItemStack(Items.MAP);
        ItemStack buy1 = ItemStack.EMPTY;
        ItemStack buy2 = ItemStack.EMPTY;
        values = trade.buys.get(0).getValues();
        buy1 = Tools.getStack(values);
        if (trade.buys.size() > 1)
        {
            values = trade.buys.get(1).getValues();
            buy2 = Tools.getStack(values);
        }
        recipe = new TrainerTrade(buy1, buy2, sell, trade);
        values = trade.values;
        if (values.containsKey(TradeEntryLoader.CHANCE))
            recipe.chance = Float.parseFloat(values.get(TradeEntryLoader.CHANCE));
        if (values.containsKey(TradeEntryLoader.MIN)) recipe.min = Integer.parseInt(values.get(TradeEntryLoader.MIN));
        if (values.containsKey(TradeEntryLoader.MAX)) recipe.max = Integer.parseInt(values.get(TradeEntryLoader.MAX));

        ResourceLocation loc = new ResourceLocation(trade.values.get(ID));

        TagKey<ConfiguredStructureFeature<?, ?>> key = TagKey.create(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY,
                loc);

        boolean newOnly = Boolean.parseBoolean(trade.values.getOrDefault(NEW_ONLY, "false"));

        recipe.outputModifier = (entity, random) -> {
            if (!(entity.level instanceof ServerLevel serverlevel)) return ItemStack.EMPTY;
            ItemStack output = ItemStack.EMPTY;
            try
            {
                // Vanilla one uses 100 and true.
                BlockPos blockpos = serverlevel.findNearestMapFeature(key, entity.blockPosition(), 100, newOnly);
                if (blockpos != null)
                {
                    ItemStack itemstack = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte) 2, true,
                            true);
                    MapItem.renderBiomePreviewMap(serverlevel, itemstack);
                    MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", MapDecoration.Type.RED_X);
                    itemstack.setHoverName(
                            TComponent.translatable("filled_map." + loc.getPath().toLowerCase(Locale.ROOT)));
                    return itemstack;
                }
            }
            catch (Exception e)
            {
                PokecubeAPI.LOGGER.error("Error making a map trade for {}", loc);
                PokecubeAPI.LOGGER.error(e);
                return ItemStack.EMPTY;
            }

            return output;
        };

        recipe.debug_string = JsonUtil.gson.toJson(trade);

        trades.tradesList.add(recipe);
    }
}
