package pokecube.adventures.blocks.genetics.helper.recipe;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import pokecube.adventures.blocks.genetics.extractor.ExtractorTile;
import pokecube.adventures.blocks.genetics.helper.ClonerHelper;
import pokecube.adventures.blocks.genetics.helper.ClonerHelper.DNAPack;
import pokecube.adventures.blocks.genetics.helper.crafting.PoweredCraftingInventory;
import pokecube.adventures.blocks.genetics.helper.recipe.RecipeSelector.ItemBasedSelector;
import pokecube.adventures.blocks.genetics.helper.recipe.RecipeSelector.SelectorValue;
import pokecube.adventures.utils.RecipePokeAdv;
import pokecube.core.handlers.playerdata.PlayerPokemobCache;
import pokecube.core.items.pokecubes.PokecubeManager;
import thut.api.entity.genetics.Alleles;
import thut.api.entity.genetics.IMobGenetics;
import thut.core.common.genetics.DefaultGenetics;

public class RecipeExtract extends PoweredRecipe
{

    public static int ENERGYCOST = 10000;
    public static Function<ItemStack, Integer> ENERGYNEED = (s) -> RecipeExtract.ENERGYCOST;

    public RecipeExtract(final ResourceLocation location)
    {
        super(location);
    }

    @Override
    public boolean canCraftInDimensions(final int width, final int height)
    {
        return width * height > 2;
    }

    @Override
    public boolean complete(final IPoweredProgress tile)
    {
        final List<ItemStack> remaining = this.getRemainingItems(tile.getCraftMatrix());
        tile.setItem(tile.getOutputSlot(), this.assemble(tile.getCraftMatrix()));
        for (int i = 0; i < remaining.size(); i++)
        {
            final ItemStack old = tile.getItem(i);
            final ItemStack stack = remaining.get(i);
            if (!stack.isEmpty())
            {
                if (PokecubeManager.isFilled(old)) PlayerPokemobCache.UpdateCache(old, false, true);
                tile.setItem(i, stack);
            }
            else
            {
                if (PokecubeManager.isFilled(old)) PlayerPokemobCache.UpdateCache(old, false, true);
                tile.removeItem(i, 1);
            }
        }
        if (tile.getCraftMatrix().eventHandler != null) tile.getCraftMatrix().eventHandler.broadcastChanges();
        return true;
    }

    @Override
    public Function<ItemStack, Integer> getCostFunction()
    {
        return RecipeExtract.ENERGYNEED;
    }

    @Override
    public ItemStack assemble(final CraftingContainer inv)
    {
        if (!(inv instanceof PoweredCraftingInventory inv_p)) return ItemStack.EMPTY;
        if (!(inv_p.inventory instanceof ExtractorTile tile)) return ItemStack.EMPTY;

        IMobGenetics genes;
        final ItemStack destination = inv.getItem(0);
        ItemStack source = inv.getItem(2);
        ItemStack selector = tile.override_selector.isEmpty() ? inv.getItem(1) : tile.override_selector;
        if (ClonerHelper.getGeneSelectors(selector).isEmpty()) selector = ItemStack.EMPTY;
        boolean forcedGenes = false;
        source:
        if ((genes = ClonerHelper.getGenes(source)) == null)
        {
            final List<Ingredient> stacks = Lists.newArrayList(ClonerHelper.DNAITEMS.keySet());
            Collections.shuffle(stacks);
            if (!source.isEmpty()) for (final Ingredient stack : stacks) if (stack.test(source))
            {
                final DNAPack pack = ClonerHelper.DNAITEMS.get(stack);
                final Alleles<?, ?> alleles = pack.alleles;
                genes = new DefaultGenetics();
                genes.getAlleles().put(alleles.getExpressed().getKey(), alleles);
                forcedGenes = true;
                if (pack.chance > Math.random()) break source;
            }
            source = ItemStack.EMPTY;
        }
        final ItemStack output = destination.copy();
        output.setCount(1);
        if (source.isEmpty() || genes == null || selector.isEmpty()) return ItemStack.EMPTY;
        if (output.getTag() == null) output.setTag(new CompoundTag());
        ClonerHelper.mergeGenes(genes, output, new ItemBasedSelector(selector), forcedGenes);
        output.setCount(1);
        return output;
    }

    @Override
    public int getEnergyCost(final IPoweredProgress tile)
    {
        return RecipeExtract.ENERGYCOST;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return RecipePokeAdv.EXTRACT.get();
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(final CraftingContainer inv)
    {
        final NonNullList<ItemStack> nonnulllist = NonNullList.withSize(inv.getContainerSize(), ItemStack.EMPTY);
        if (!(inv instanceof PoweredCraftingInventory inv_p)) return nonnulllist;
        if (!(inv_p.inventory instanceof ExtractorTile tile)) return nonnulllist;
        final ItemStack selector = tile.override_selector.isEmpty() ? inv.getItem(1) : tile.override_selector;
        boolean keepDNA = false;
        boolean keepSelector = false;
        final SelectorValue value = ClonerHelper.getSelectorValue(selector);
        if (value.dnaDestructChance < Math.random()) keepDNA = true;
        if (value.selectorDestructChance < Math.random()) keepSelector = true;

        for (int i = 0; i < nonnulllist.size(); ++i)
        {
            final ItemStack item = inv.getItem(i).copy();
            if (i == 1 && keepSelector) nonnulllist.set(i, item);
            if (i == 2)
            {
                final boolean potion = item.getItem() == Items.POTION;
                final boolean multiple = item.getCount() > 1;
                if (keepDNA) nonnulllist.set(i, item);
                else if (potion) nonnulllist.set(i, new ItemStack(Items.GLASS_BOTTLE));
                else if (!multiple)
                {
                    item.setTag(null);
                    nonnulllist.set(i, item.copy());
                }
            }
            if (item.hasContainerItem()) nonnulllist.set(i, item.getContainerItem());
        }
        tile.override_selector = ItemStack.EMPTY;
        return nonnulllist;
    }
}
