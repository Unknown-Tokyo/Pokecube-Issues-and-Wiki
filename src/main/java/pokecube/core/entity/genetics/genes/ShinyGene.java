package pokecube.core.entity.genetics.genes;

import java.util.Random;

import net.minecraft.resources.ResourceLocation;
import pokecube.core.entity.genetics.GeneticsManager;
import thut.api.entity.genetics.Gene;
import thut.core.common.ThutCore;
import thut.core.common.genetics.genes.GeneBoolean;

public class ShinyGene extends GeneBoolean
{
    Random rand = ThutCore.newRandom();

    @Override
    public ResourceLocation getKey()
    {
        return GeneticsManager.SHINYGENE;
    }

    @Override
    public float getMutationRate()
    {
        return GeneticsManager.mutationRates.get(this.getKey());
    }

    @Override
    public Gene<Boolean> interpolate(final Gene<Boolean> other)
    {
        final ShinyGene newGene = new ShinyGene();
        final ShinyGene otherG = (ShinyGene) other;
        newGene.value = otherG.value && this.value;
        return newGene;
    }

    @Override
    public Gene<Boolean> mutate()
    {
        final ShinyGene newGene = new ShinyGene();
        newGene.value = !this.value;
        return newGene;
    }

}
