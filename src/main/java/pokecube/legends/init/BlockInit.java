package pokecube.legends.init;

import java.util.Map;
import java.util.function.ToIntFunction;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.RootedDirtBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.registries.RegistryObject;
import pokecube.core.PokecubeItems;
import pokecube.core.blocks.barrels.GenericBarrel;
import pokecube.core.blocks.bookshelves.GenericBookshelf;
import pokecube.core.blocks.bookshelves.GenericBookshelfEmpty;
import pokecube.core.blocks.signs.GenericStandingSign;
import pokecube.core.blocks.signs.GenericWallSign;
import pokecube.core.entity.boats.GenericBoat.BoatRegister;
import pokecube.core.init.ItemGenerator;
import pokecube.core.init.ItemGenerator.GenericStairs;
import pokecube.legends.PokecubeLegends;
import pokecube.legends.Reference;
import pokecube.legends.blocks.BlockBase;
import pokecube.legends.blocks.FaceBlockBase;
import pokecube.legends.blocks.FallingBlockBase;
import pokecube.legends.blocks.FallingSandBlockBase;
import pokecube.legends.blocks.SaplingBase;
import pokecube.legends.blocks.StoneLogBase;
import pokecube.legends.blocks.customblocks.CramomaticBlock;
import pokecube.legends.blocks.customblocks.HeatranBlock;
import pokecube.legends.blocks.customblocks.KeldeoBlock;
import pokecube.legends.blocks.customblocks.MagearnaBlock;
import pokecube.legends.blocks.customblocks.NatureCoreBlock;
import pokecube.legends.blocks.customblocks.PortalWarp;
import pokecube.legends.blocks.customblocks.RaidSpawnBlock;
import pokecube.legends.blocks.customblocks.TaoTrioBlock;
import pokecube.legends.blocks.customblocks.TapuBuluCore;
import pokecube.legends.blocks.customblocks.TapuFiniCore;
import pokecube.legends.blocks.customblocks.TapuKokoCore;
import pokecube.legends.blocks.customblocks.TapuLeleCore;
import pokecube.legends.blocks.customblocks.TimeSpaceCoreBlock;
import pokecube.legends.blocks.customblocks.TroughBlock;
import pokecube.legends.blocks.customblocks.VictiniBlock;
import pokecube.legends.blocks.customblocks.XerneasCore;
import pokecube.legends.blocks.customblocks.YveltalEgg;
import pokecube.legends.blocks.customblocks.taputotem.BuluTotem;
import pokecube.legends.blocks.customblocks.taputotem.FiniTotem;
import pokecube.legends.blocks.customblocks.taputotem.KokoTotem;
import pokecube.legends.blocks.customblocks.taputotem.LeleTotem;
import pokecube.legends.blocks.flowing.AshBlock;
import pokecube.legends.blocks.flowing.MoltenMeteorBlock;
import pokecube.legends.blocks.normalblocks.AgedGrassBlock;
import pokecube.legends.blocks.normalblocks.AquamarineClusterBlock;
import pokecube.legends.blocks.normalblocks.AquamarineCrystalBlock;
import pokecube.legends.blocks.normalblocks.AshOre;
import pokecube.legends.blocks.normalblocks.AzureGrassBlock;
import pokecube.legends.blocks.normalblocks.BuddingAquamarineBlock;
import pokecube.legends.blocks.normalblocks.CorruptedGrassBlock;
import pokecube.legends.blocks.normalblocks.CorruptedLeavesBlock;
import pokecube.legends.blocks.normalblocks.CrackedDistorticStone;
import pokecube.legends.blocks.normalblocks.DistorticGrassBlock;
import pokecube.legends.blocks.normalblocks.DistorticStoneBlock;
import pokecube.legends.blocks.normalblocks.DynaLeavesBlock;
import pokecube.legends.blocks.normalblocks.InfectedCampfireBlock;
import pokecube.legends.blocks.normalblocks.InfectedFireBlock;
import pokecube.legends.blocks.normalblocks.InfectedTorch;
import pokecube.legends.blocks.normalblocks.InfectedTorchWall;
import pokecube.legends.blocks.normalblocks.JungleGrassBlock;
import pokecube.legends.blocks.normalblocks.MagneticBlock;
import pokecube.legends.blocks.normalblocks.MirageGlassBlock;
import pokecube.legends.blocks.normalblocks.MirageLeavesBlock;
import pokecube.legends.blocks.normalblocks.MushroomGrassBlock;
import pokecube.legends.blocks.normalblocks.OneWayGlass;
import pokecube.legends.blocks.normalblocks.OneWayLaboratoryGlass;
import pokecube.legends.blocks.normalblocks.OneWayMirageGlass;
import pokecube.legends.blocks.normalblocks.OneWaySpectrumGlass;
import pokecube.legends.blocks.normalblocks.OneWayStainedGlass;
import pokecube.legends.blocks.normalblocks.OneWayTintedGlass;
import pokecube.legends.blocks.normalblocks.SpectrumGlassBlock;
import pokecube.legends.blocks.normalblocks.UnrefinedAquamarineBlock;
import pokecube.legends.blocks.normalblocks.WallGateBlock;
import pokecube.legends.blocks.plants.BigContaminatedDripleafBlock;
import pokecube.legends.blocks.plants.BigContaminatedDripleafStemBlock;
import pokecube.legends.blocks.plants.CrystallizedBush;
import pokecube.legends.blocks.plants.CrystallizedCactus;
import pokecube.legends.blocks.plants.DistorticSapling;
import pokecube.legends.blocks.plants.DynaShrubBlock;
import pokecube.legends.blocks.plants.MirageSapling;
import pokecube.legends.blocks.plants.PollutingBlossomBlock;
import pokecube.legends.blocks.plants.SmallContaminatedDripleafBlock;
import pokecube.legends.blocks.plants.StringOfPearlsBlock;
import pokecube.legends.blocks.plants.TallCrystallizedBush;
import pokecube.legends.tileentity.RaidSpawn;
import pokecube.legends.tileentity.RingTile;
import pokecube.legends.worldgen.trees.AgedTreeGrower;
import pokecube.legends.worldgen.trees.CorruptedTreeGrower;
import pokecube.legends.worldgen.trees.DistorticTreeGrower;
import pokecube.legends.worldgen.trees.InvertedTreeGrower;
import pokecube.legends.worldgen.trees.MirageTreeGrower;
import pokecube.legends.worldgen.trees.TemporalTreeGrower;
import thut.api.block.flowing.FlowingBlock;
import thut.api.block.flowing.SolidBlock;

@SuppressWarnings("deprecation")
public class BlockInit
{
    // Decorative_Blocks
    public static final RegistryObject<Block> METEORITE_SLAB;
    public static final RegistryObject<Block> METEORITE_STAIRS;

    public static final RegistryObject<Block> OCEAN_BRICKS;
    public static final RegistryObject<Block> OCEAN_BRICK_SLAB;
    public static final RegistryObject<Block> OCEAN_BRICK_STAIRS;

    public static final RegistryObject<Block> SKY_BRICKS;
    public static final RegistryObject<Block> SKY_BRICK_SLAB;
    public static final RegistryObject<Block> SKY_BRICK_STAIRS;

    public static final RegistryObject<Block> PURPUR_BRICKS;
    public static final RegistryObject<Block> PURPUR_BRICK_SLAB;
    public static final RegistryObject<Block> PURPUR_BRICK_STAIRS;

    public static final RegistryObject<Block> MAGMA_BRICKS;
    public static final RegistryObject<Block> MAGMA_BRICK_SLAB;
    public static final RegistryObject<Block> MAGMA_BRICK_STAIRS;

    public static final RegistryObject<Block> STORMY_SKY_BRICKS;
    public static final RegistryObject<Block> STORMY_SKY_BRICK_SLAB;
    public static final RegistryObject<Block> STORMY_SKY_BRICK_STAIRS;

    // Meteor and ash blocks
    public static final RegistryObject<FlowingBlock> ASH;
    public static final RegistryObject<FlowingBlock> ASH_BLOCK;

    public static final RegistryObject<FlowingBlock> METEORITE_BLOCK;
    public static final RegistryObject<FlowingBlock> METEORITE_LAYER;

    public static final RegistryObject<FlowingBlock> METEORITE_MOLTEN_BLOCK;
    public static final RegistryObject<FlowingBlock> METEORITE_MOLTEN_LAYER;

    // Unowns
    private static final String[] unowns =
    { "unown_stone_a", "unown_stone_b", "unown_stone_c", "unown_stone_d", "unown_stone_e", "unown_stone_f",
            "unown_stone_g", "unown_stone_h", "unown_stone_i", "unown_stone_j", "unown_stone_k", "unown_stone_l",
            "unown_stone_m", "unown_stone_n", "unown_stone_o", "unown_stone_p", "unown_stone_q", "unown_stone_r",
            "unown_stone_s", "unown_stone_t", "unown_stone_u", "unown_stone_v", "unown_stone_w", "unown_stone_x",
            "unown_stone_y", "unown_stone_z", "unown_stone_ex", "unown_stone_in" };
    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] UNOWN_STONES = new RegistryObject[unowns.length];

    // Tapus Totems
    public static final RegistryObject<Block> TOTEM_BLOCK;

    private static final Map<String, MaterialColor> totemColours = Maps.newHashMap();
    private static final String[] totemKeys =
    { "_white_totem", "_orange_totem", "_magenta_totem", "_lightblue_totem", "_yellow_totem", "_lime_totem",
            "_pink_totem", "_gray_totem", "_lightgray_totem", "_cyan_totem", "_purple_totem", "_blue_totem",
            "_brown_totem", "_green_totem", "_red_totem", "_black_totem" };
    static
    {
        totemColours.put("_white_totem", MaterialColor.TERRACOTTA_WHITE);
        totemColours.put("_orange_totem", MaterialColor.TERRACOTTA_ORANGE);
        totemColours.put("_magenta_totem", MaterialColor.TERRACOTTA_MAGENTA);
        totemColours.put("_lightblue_totem", MaterialColor.TERRACOTTA_LIGHT_BLUE);
        totemColours.put("_yellow_totem", MaterialColor.TERRACOTTA_YELLOW);
        totemColours.put("_lime_totem", MaterialColor.TERRACOTTA_LIGHT_GREEN);
        totemColours.put("_pink_totem", MaterialColor.TERRACOTTA_PINK);
        totemColours.put("_gray_totem", MaterialColor.TERRACOTTA_GRAY);
        totemColours.put("_lightgray_totem", MaterialColor.TERRACOTTA_LIGHT_GRAY);
        totemColours.put("_cyan_totem", MaterialColor.TERRACOTTA_CYAN);
        totemColours.put("_purple_totem", MaterialColor.TERRACOTTA_PURPLE);
        totemColours.put("_blue_totem", MaterialColor.TERRACOTTA_BLUE);
        totemColours.put("_brown_totem", MaterialColor.TERRACOTTA_BROWN);
        totemColours.put("_green_totem", MaterialColor.TERRACOTTA_GREEN);
        totemColours.put("_red_totem", MaterialColor.TERRACOTTA_RED);
        totemColours.put("_black_totem", MaterialColor.TERRACOTTA_BLACK);
    }

    // Koko Totem
    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] KOKO = new RegistryObject[totemColours.size()];

    // Bulu Totem
    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] BULU = new RegistryObject[totemColours.size()];

    // Lele Totem
    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] LELE = new RegistryObject[totemColours.size()];

    // Fini Totem
    @SuppressWarnings("unchecked")
    public static final RegistryObject<Block>[] FINI = new RegistryObject[totemColours.size()];

    // Legendary Spawners
    public static final RegistryObject<Block> LEGENDARY_SPAWN;
    public static final RegistryObject<Block> TROUGH_BLOCK;
    public static final RegistryObject<Block> HEATRAN_BLOCK;
    public static final RegistryObject<Block> TAO_BLOCK;
    public static final RegistryObject<Block> MAGEARNA_BLOCK;

    public static final RegistryObject<Block> GOLEM_STONE;

    public static final RegistryObject<Block> REGISTEEL_CORE;
    public static final RegistryObject<Block> REGICE_CORE;
    public static final RegistryObject<Block> REGIROCK_CORE;
    public static final RegistryObject<Block> REGIELEKI_CORE;
    public static final RegistryObject<Block> REGIDRAGO_CORE;
    public static final RegistryObject<Block> REGIGIGA_CORE;

    public static final RegistryObject<Block> TIMESPACE_CORE;
    public static final RegistryObject<Block> NATURE_CORE;
    public static final RegistryObject<Block> KELDEO_CORE;
    public static final RegistryObject<Block> VICTINI_CORE;
    public static final RegistryObject<Block> YVELTAL_CORE;
    public static final RegistryObject<Block> XERNEAS_CORE;

    public static final RegistryObject<Block> TAPU_KOKO_CORE;
    public static final RegistryObject<Block> TAPU_FINI_CORE;
    public static final RegistryObject<Block> TAPU_BULU_CORE;
    public static final RegistryObject<Block> TAPU_LELE_CORE;

    // Portal
    public static final RegistryObject<Block> PORTAL;

    public static final RegistryObject<Block> RAID_SPAWNER;
    public static final RegistryObject<Block> CRAMOMATIC_BLOCK;

    // Dimensions
    // Distortic World
    public static final RegistryObject<Block> DISTORTIC_GRASS_BLOCK;
    public static final RegistryObject<Block> DISTORTIC_STONE;
    public static final RegistryObject<Block> DISTORTIC_STONE_SLAB;
    public static final RegistryObject<Block> DISTORTIC_STONE_STAIRS;
    public static final RegistryObject<Block> CRACKED_DISTORTIC_STONE;
    public static final RegistryObject<Block> DISTORTIC_GLOWSTONE;

    public static final RegistryObject<Block> DISTORTIC_MIRROR;
    public static final RegistryObject<Block> CHISELED_DISTORTIC_MIRROR;

    public static final RegistryObject<Block> FRAMED_DISTORTIC_MIRROR;
    public static final RegistryObject<Block> ONE_WAY_GLASS;
    public static final RegistryObject<Block> ONE_WAY_GLASS_WHITE;
    public static final RegistryObject<Block> ONE_WAY_GLASS_ORANGE;
    public static final RegistryObject<Block> ONE_WAY_GLASS_MAGENTA;
    public static final RegistryObject<Block> ONE_WAY_GLASS_LIGHT_BLUE;
    public static final RegistryObject<Block> ONE_WAY_GLASS_YELLOW;
    public static final RegistryObject<Block> ONE_WAY_GLASS_LIME;
    public static final RegistryObject<Block> ONE_WAY_GLASS_PINK;
    public static final RegistryObject<Block> ONE_WAY_GLASS_GRAY;
    public static final RegistryObject<Block> ONE_WAY_GLASS_LIGHT_GRAY;
    public static final RegistryObject<Block> ONE_WAY_GLASS_CYAN;
    public static final RegistryObject<Block> ONE_WAY_GLASS_PURPLE;
    public static final RegistryObject<Block> ONE_WAY_GLASS_BLUE;
    public static final RegistryObject<Block> ONE_WAY_GLASS_BROWN;
    public static final RegistryObject<Block> ONE_WAY_GLASS_GREEN;
    public static final RegistryObject<Block> ONE_WAY_GLASS_RED;
    public static final RegistryObject<Block> ONE_WAY_GLASS_BLACK;
    public static final RegistryObject<Block> ONE_WAY_GLASS_LAB;
    public static final RegistryObject<Block> ONE_WAY_GLASS_MIRAGE;
    public static final RegistryObject<Block> ONE_WAY_GLASS_SPECTRUM;
    public static final RegistryObject<Block> ONE_WAY_GLASS_TINTED;
    public static final RegistryObject<Block> ONE_WAY_FRAMED_MIRROR;

    public static final RegistryObject<Block> DISTORTIC_STONE_BRICKS;
    public static final RegistryObject<Block> DISTORTIC_STONE_BRICK_SLAB;
    public static final RegistryObject<Block> DISTORTIC_STONE_BRICK_STAIRS;
    public static final RegistryObject<Block> DISTORTIC_STONE_BARREL;

    public static final RegistryObject<Block> CHISELED_DISTORTIC_STONE;
    public static final RegistryObject<Block> CHISELED_DISTORTIC_STONE_SLAB;
    public static final RegistryObject<Block> CHISELED_DISTORTIC_STONE_STAIRS;

    public static final RegistryObject<Block> DISTORTIC_TERRACOTTA;
    public static final RegistryObject<Block> DISTORTIC_TERRACOTTA_SLAB;
    public static final RegistryObject<Block> DISTORTIC_TERRACOTTA_STAIRS;

    public static final RegistryObject<Block> DISTORTIC_OAK_PLANKS;
    public static final RegistryObject<Block> DISTORTIC_OAK_SLAB;
    public static final RegistryObject<Block> DISTORTIC_OAK_STAIRS;

    public static final RegistryObject<Block> DISTORTIC_DARK_OAK_PLANKS;
    public static final RegistryObject<Block> DISTORTIC_DARK_OAK_SLAB;
    public static final RegistryObject<Block> DISTORTIC_DARK_OAK_STAIRS;

    public static final RegistryObject<Block> DISTORTIC_SPRUCE_PLANKS;
    public static final RegistryObject<Block> DISTORTIC_SPRUCE_SLAB;
    public static final RegistryObject<Block> DISTORTIC_SPRUCE_STAIRS;

    public static final RegistryObject<Block> DISTORTIC_BIRCH_PLANKS;
    public static final RegistryObject<Block> DISTORTIC_BIRCH_SLAB;
    public static final RegistryObject<Block> DISTORTIC_BIRCH_STAIRS;

    public static final RegistryObject<Block> DISTORTIC_ACACIA_PLANKS;
    public static final RegistryObject<Block> DISTORTIC_ACACIA_SLAB;
    public static final RegistryObject<Block> DISTORTIC_ACACIA_STAIRS;

    public static final RegistryObject<Block> DISTORTIC_JUNGLE_PLANKS;
    public static final RegistryObject<Block> DISTORTIC_JUNGLE_SLAB;
    public static final RegistryObject<Block> DISTORTIC_JUNGLE_STAIRS;

    public static final RegistryObject<Block> BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> INFECTED_CAMPFIRE;
    public static final RegistryObject<Block> INFECTED_FIRE;
    public static final RegistryObject<Block> INFECTED_LANTERN;
    public static final RegistryObject<Block> INFECTED_TORCH;
    public static final RegistryObject<Block> INFECTED_TORCH_WALL;

    public static final RegistryObject<Block> AGED_COARSE_DIRT;
    public static final RegistryObject<Block> AGED_DIRT;
    public static final RegistryObject<Block> AGED_GRASS_BLOCK;
    public static final RegistryObject<Block> AGED_PODZOL;
    public static final RegistryObject<Block> AZURE_COARSE_DIRT;
    public static final RegistryObject<Block> AZURE_DIRT;
    public static final RegistryObject<Block> AZURE_GRASS_BLOCK;
    public static final RegistryObject<Block> CORRUPTED_DIRT;
    public static final RegistryObject<Block> CORRUPTED_COARSE_DIRT;
    public static final RegistryObject<Block> CORRUPTED_GRASS_BLOCK;
    public static final RegistryObject<Block> FUNGAL_NYLIUM;
    public static final RegistryObject<Block> JUNGLE_COARSE_DIRT;
    public static final RegistryObject<Block> JUNGLE_DIRT;
    public static final RegistryObject<Block> JUNGLE_GRASS_BLOCK;
    public static final RegistryObject<Block> JUNGLE_PODZOL;
    public static final RegistryObject<Block> MUSHROOM_DIRT;
    public static final RegistryObject<Block> MUSHROOM_COARSE_DIRT;
    public static final RegistryObject<Block> MUSHROOM_GRASS_BLOCK;
    public static final RegistryObject<Block> ROOTED_CORRUPTED_DIRT;
    public static final RegistryObject<Block> ROOTED_MUSHROOM_DIRT;

    public static final RegistryObject<Block> ULTRA_MAGNET;
    public static final RegistryObject<Block> SPECTRUM_GLASS;

    // Aquamarine Blocks
    public static final RegistryObject<Block> AQUAMARINE_BLOCK;
    public static final RegistryObject<Block> AQUAMARINE_BUTTON;
    public static final RegistryObject<Block> AQUAMARINE_BRICK_SLAB;
    public static final RegistryObject<Block> AQUAMARINE_BRICK_STAIRS;
    public static final RegistryObject<Block> AQUAMARINE_BRICKS;
    public static final RegistryObject<Block> AQUAMARINE_CLUSTER;
    public static final RegistryObject<Block> AQUAMARINE_CRYSTAL;
    public static final RegistryObject<Block> AQUAMARINE_PR_PLATE;
    public static final RegistryObject<Block> AQUAMARINE_SLAB;
    public static final RegistryObject<Block> AQUAMARINE_STAIRS;
    public static final RegistryObject<Block> BUDDING_AQUAMARINE;
    public static final RegistryObject<Block> LARGE_AQUAMARINE_BUD;
    public static final RegistryObject<Block> MEDIUM_AQUAMARINE_BUD;
    public static final RegistryObject<Block> SMALL_AQUAMARINE_BUD;
    public static final RegistryObject<Block> UNREFINED_AQUAMARINE;
    public static final RegistryObject<Block> UNREFINED_AQUAMARINE_SLAB;
    public static final RegistryObject<Block> UNREFINED_AQUAMARINE_STAIRS;

    // Ultra Stone
    public static final RegistryObject<Block> ULTRA_STONE;
    public static final RegistryObject<Block> ULTRA_STONE_SLAB;
    public static final RegistryObject<Block> ULTRA_STONE_STAIRS;
    public static final RegistryObject<Block> ULTRA_COBBLESTONE;
    public static final RegistryObject<Block> ULTRA_COBBLESTONE_SLAB;
    public static final RegistryObject<Block> ULTRA_COBBLESTONE_STAIRS;
    public static final RegistryObject<Block> ULTRA_STONE_BRICK_SLAB;
    public static final RegistryObject<Block> ULTRA_STONE_BRICK_STAIRS;
    public static final RegistryObject<Block> ULTRA_STONE_BRICKS;
    public static final RegistryObject<Block> ULTRA_STONE_BUTTON;
    public static final RegistryObject<Block> ULTRA_STONE_PR_PLATE;

    public static final RegistryObject<Block> ULTRA_METAL;
    public static final RegistryObject<Block> ULTRA_METAL_SLAB;
    public static final RegistryObject<Block> ULTRA_METAL_STAIRS;
    public static final RegistryObject<Block> ULTRA_METAL_BUTTON;
    public static final RegistryObject<Block> ULTRA_METAL_PR_PLATE;

    // Darkstone Blocks
    public static final RegistryObject<Block> ULTRA_DARKSTONE;
    public static final RegistryObject<Block> ULTRA_DARKSTONE_BRICKS;
    public static final RegistryObject<Block> ULTRA_DARKSTONE_BRICK_SLAB;
    public static final RegistryObject<Block> ULTRA_DARKSTONE_BRICK_STAIRS;
    public static final RegistryObject<Block> ULTRA_DARK_COBBLESTONE;
    public static final RegistryObject<Block> ULTRA_DARK_COBBLESTONE_SLAB;
    public static final RegistryObject<Block> ULTRA_DARK_COBBLESTONE_STAIRS;
    public static final RegistryObject<Block> ULTRA_DARKSTONE_SLAB;
    public static final RegistryObject<Block> ULTRA_DARKSTONE_STAIRS;
    public static final RegistryObject<Block> ULTRA_DARKSTONE_BUTTON;
    public static final RegistryObject<Block> ULTRA_DARKSTONE_PR_PLATE;

    // Dusk Dolerite Blocks
    public static final RegistryObject<Block> DUSK_DOLERITE;
    public static final RegistryObject<Block> DUSK_DOLERITE_SLAB;
    public static final RegistryObject<Block> DUSK_DOLERITE_STAIRS;
    public static final RegistryObject<Block> DUSK_DOLERITE_BUTTON;
    public static final RegistryObject<Block> DUSK_DOLERITE_PR_PLATE;
    public static final RegistryObject<Block> COBBLED_DUSK_DOLERITE;
    public static final RegistryObject<Block> COBBLED_DUSK_DOLERITE_SLAB;
    public static final RegistryObject<Block> COBBLED_DUSK_DOLERITE_STAIRS;
    public static final RegistryObject<Block> DUSK_DOLERITE_BRICKS;
    public static final RegistryObject<Block> DUSK_DOLERITE_BRICK_SLAB;
    public static final RegistryObject<Block> DUSK_DOLERITE_BRICK_STAIRS;

    public static final RegistryObject<Block> TURQUOISE_GRAVEL;

    // Azure Badlands
    public static final RegistryObject<Block> AZURE_SAND;
    public static final RegistryObject<Block> AZURE_SANDSTONE;
    public static final RegistryObject<Block> AZURE_SANDSTONE_SLAB;
    public static final RegistryObject<Block> AZURE_SANDSTONE_STAIRS;
    public static final RegistryObject<Block> AZURE_SANDSTONE_BRICKS;
    public static final RegistryObject<Block> AZURE_SANDSTONE_BRICK_SLAB;
    public static final RegistryObject<Block> AZURE_SANDSTONE_BRICK_STAIRS;
    public static final RegistryObject<Block> SMOOTH_AZURE_SANDSTONE;
    public static final RegistryObject<Block> SMOOTH_AZURE_SANDSTONE_SLAB;
    public static final RegistryObject<Block> SMOOTH_AZURE_SANDSTONE_STAIRS;
    public static final RegistryObject<Block> AZURE_SANDSTONE_BUTTON;
    public static final RegistryObject<Block> AZURE_SANDSTONE_PR_PLATE;

    // Blackened Beach
    public static final RegistryObject<Block> BLACKENED_SAND;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE_SLAB;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE_STAIRS;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE_BRICKS;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE_BRICK_SLAB;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE_BRICK_STAIRS;
    public static final RegistryObject<Block> SMOOTH_BLACKENED_SANDSTONE;
    public static final RegistryObject<Block> SMOOTH_BLACKENED_SANDSTONE_SLAB;
    public static final RegistryObject<Block> SMOOTH_BLACKENED_SANDSTONE_STAIRS;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE_BUTTON;
    public static final RegistryObject<Block> BLACKENED_SANDSTONE_PR_PLATE;

    // Mirage Desert
    public static final RegistryObject<Block> CRYSTALLIZED_SAND;
    public static final RegistryObject<Block> CRYSTALLIZED_SANDSTONE;
    public static final RegistryObject<Block> CRYS_SANDSTONE_SLAB;
    public static final RegistryObject<Block> CRYS_SANDSTONE_STAIRS;
    public static final RegistryObject<Block> CRYS_SANDSTONE_BRICKS;
    public static final RegistryObject<Block> CRYS_SANDSTONE_BRICK_SLAB;
    public static final RegistryObject<Block> CRYS_SANDSTONE_BRICK_STAIRS;
    public static final RegistryObject<Block> SMOOTH_CRYS_SANDSTONE;
    public static final RegistryObject<Block> SMOOTH_CRYS_SANDSTONE_SLAB;
    public static final RegistryObject<Block> SMOOTH_CRYS_SANDSTONE_STAIRS;
    public static final RegistryObject<Block> CRYS_SANDSTONE_BUTTON;
    public static final RegistryObject<Block> CRYS_SANDSTONE_PR_PLATE;

    // Woods
    public static final RegistryObject<Block> AGED_LOG;
    public static final RegistryObject<Block> AGED_PLANKS;
    public static final RegistryObject<Block> AGED_LEAVES;
    public static final RegistryObject<Block> AGED_WOOD;
    public static final RegistryObject<Block> STRIP_AGED_LOG;
    public static final RegistryObject<Block> STRIP_AGED_WOOD;
    public static final RegistryObject<Block> AGED_STAIRS;
    public static final RegistryObject<Block> AGED_SLAB;
    public static final RegistryObject<Block> AGED_FENCE;
    public static final RegistryObject<Block> AGED_FENCE_GATE;
    public static final RegistryObject<Block> AGED_TRAPDOOR;
    public static final RegistryObject<Block> AGED_DOOR;
    public static final RegistryObject<Block> AGED_BUTTON;
    public static final RegistryObject<Block> AGED_PR_PLATE;
    public static final RegistryObject<Block> AGED_BARREL;
    public static final RegistryObject<Block> AGED_BOOKSHELF;
    public static final RegistryObject<Block> AGED_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> CONCRETE_LOG;
    public static final RegistryObject<Block> CONCRETE_PLANKS;
    public static final RegistryObject<Block> CONCRETE_WOOD;
    public static final RegistryObject<Block> STRIP_CONCRETE_LOG;
    public static final RegistryObject<Block> STRIP_CONCRETE_WOOD;
    public static final RegistryObject<Block> CONCRETE_STAIRS;
    public static final RegistryObject<Block> CONCRETE_SLAB;
    public static final RegistryObject<Block> CONCRETE_FENCE;
    public static final RegistryObject<Block> CONCRETE_FENCE_GATE;
    public static final RegistryObject<Block> CONCRETE_TRAPDOOR;
    public static final RegistryObject<Block> CONCRETE_DOOR;
    public static final RegistryObject<Block> CONCRETE_BUTTON;
    public static final RegistryObject<Block> CONCRETE_PR_PLATE;
    public static final RegistryObject<Block> CONCRETE_BARREL;
    public static final RegistryObject<Block> CONCRETE_BOOKSHELF;
    public static final RegistryObject<Block> CONCRETE_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> CONCRETE_DENSE_PLANKS;
    public static final RegistryObject<Block> CONCRETE_DENSE_STAIRS;
    public static final RegistryObject<Block> CONCRETE_DENSE_SLAB;
    public static final RegistryObject<Block> CONCRETE_DENSE_WALL;
    public static final RegistryObject<Block> CONCRETE_DENSE_WALL_GATE;
    public static final RegistryObject<Block> CONCRETE_DENSE_BUTTON;
    public static final RegistryObject<Block> CONCRETE_DENSE_PR_PLATE;
    public static final RegistryObject<Block> CONCRETE_DENSE_BARREL;
    public static final RegistryObject<Block> CONCRETE_DENSE_BOOKSHELF;
    public static final RegistryObject<Block> CONCRETE_DENSE_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> CORRUPTED_LOG;
    public static final RegistryObject<Block> CORRUPTED_PLANKS;
    public static final RegistryObject<Block> CORRUPTED_LEAVES;
    public static final RegistryObject<Block> CORRUPTED_WOOD;
    public static final RegistryObject<Block> STRIP_CORRUPTED_LOG;
    public static final RegistryObject<Block> STRIP_CORRUPTED_WOOD;
    public static final RegistryObject<Block> CORRUPTED_STAIRS;
    public static final RegistryObject<Block> CORRUPTED_SLAB;
    public static final RegistryObject<Block> CORRUPTED_FENCE;
    public static final RegistryObject<Block> CORRUPTED_FENCE_GATE;
    public static final RegistryObject<Block> CORRUPTED_TRAPDOOR;
    public static final RegistryObject<Block> CORRUPTED_DOOR;
    public static final RegistryObject<Block> CORRUPTED_BUTTON;
    public static final RegistryObject<Block> CORRUPTED_PR_PLATE;
    public static final RegistryObject<Block> CORRUPTED_BARREL;
    public static final RegistryObject<Block> CORRUPTED_BOOKSHELF;
    public static final RegistryObject<Block> CORRUPTED_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> DISTORTIC_LOG;
    public static final RegistryObject<Block> DISTORTIC_PLANKS;
    public static final RegistryObject<Block> DISTORTIC_LEAVES;
    public static final RegistryObject<Block> DISTORTIC_WOOD;
    public static final RegistryObject<Block> STRIP_DISTORTIC_LOG;
    public static final RegistryObject<Block> STRIP_DISTORTIC_WOOD;
    public static final RegistryObject<Block> DISTORTIC_STAIRS;
    public static final RegistryObject<Block> DISTORTIC_SLAB;
    public static final RegistryObject<Block> DISTORTIC_FENCE;
    public static final RegistryObject<Block> DISTORTIC_FENCE_GATE;
    public static final RegistryObject<Block> DISTORTIC_TRAPDOOR;
    public static final RegistryObject<Block> DISTORTIC_DOOR;
    public static final RegistryObject<Block> DISTORTIC_BUTTON;
    public static final RegistryObject<Block> DISTORTIC_PR_PLATE;
    public static final RegistryObject<Block> DISTORTIC_BARREL;
    public static final RegistryObject<Block> DISTORTIC_BOOKSHELF;
    public static final RegistryObject<Block> DISTORTIC_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> INVERTED_LOG;
    public static final RegistryObject<Block> INVERTED_PLANKS;
    public static final RegistryObject<Block> INVERTED_LEAVES;
    public static final RegistryObject<Block> INVERTED_WOOD;
    public static final RegistryObject<Block> STRIP_INVERTED_LOG;
    public static final RegistryObject<Block> STRIP_INVERTED_WOOD;
    public static final RegistryObject<Block> INVERTED_STAIRS;
    public static final RegistryObject<Block> INVERTED_SLAB;
    public static final RegistryObject<Block> INVERTED_FENCE;
    public static final RegistryObject<Block> INVERTED_FENCE_GATE;
    public static final RegistryObject<Block> INVERTED_TRAPDOOR;
    public static final RegistryObject<Block> INVERTED_DOOR;
    public static final RegistryObject<Block> INVERTED_BUTTON;
    public static final RegistryObject<Block> INVERTED_PR_PLATE;
    public static final RegistryObject<Block> INVERTED_BARREL;
    public static final RegistryObject<Block> INVERTED_BOOKSHELF;
    public static final RegistryObject<Block> INVERTED_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> MIRAGE_GLASS;
    public static final RegistryObject<Block> MIRAGE_LOG;
    public static final RegistryObject<Block> MIRAGE_PLANKS;
    public static final RegistryObject<Block> MIRAGE_LEAVES;
    public static final RegistryObject<Block> MIRAGE_WOOD;
    public static final RegistryObject<Block> STRIP_MIRAGE_LOG;
    public static final RegistryObject<Block> STRIP_MIRAGE_WOOD;
    public static final RegistryObject<Block> MIRAGE_STAIRS;
    public static final RegistryObject<Block> MIRAGE_SLAB;
    public static final RegistryObject<Block> MIRAGE_FENCE;
    public static final RegistryObject<Block> MIRAGE_FENCE_GATE;
    public static final RegistryObject<Block> MIRAGE_TRAPDOOR;
    public static final RegistryObject<Block> MIRAGE_DOOR;
    public static final RegistryObject<Block> MIRAGE_BUTTON;
    public static final RegistryObject<Block> MIRAGE_PR_PLATE;
    public static final RegistryObject<Block> MIRAGE_BARREL;
    public static final RegistryObject<Block> MIRAGE_BOOKSHELF;
    public static final RegistryObject<Block> MIRAGE_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> STRING_OF_PEARLS;
    public static final RegistryObject<Block> TEMPORAL_LOG;
    public static final RegistryObject<Block> TEMPORAL_PLANKS;
    public static final RegistryObject<Block> TEMPORAL_LEAVES;
    public static final RegistryObject<Block> TEMPORAL_WOOD;
    public static final RegistryObject<Block> STRIP_TEMPORAL_LOG;
    public static final RegistryObject<Block> STRIP_TEMPORAL_WOOD;
    public static final RegistryObject<Block> TEMPORAL_STAIRS;
    public static final RegistryObject<Block> TEMPORAL_SLAB;
    public static final RegistryObject<Block> TEMPORAL_FENCE;
    public static final RegistryObject<Block> TEMPORAL_FENCE_GATE;
    public static final RegistryObject<Block> TEMPORAL_TRAPDOOR;
    public static final RegistryObject<Block> TEMPORAL_DOOR;
    public static final RegistryObject<Block> TEMPORAL_BUTTON;
    public static final RegistryObject<Block> TEMPORAL_PR_PLATE;
    public static final RegistryObject<Block> TEMPORAL_BARREL;
    public static final RegistryObject<Block> TEMPORAL_BOOKSHELF;
    public static final RegistryObject<Block> TEMPORAL_BOOKSHELF_EMPTY;

    public static final RegistryObject<Block> DYNA_LEAVES_PINK;
    public static final RegistryObject<Block> DYNA_LEAVES_RED;
    public static final RegistryObject<Block> DYNA_LEAVES_PASTEL_PINK;
    public static final RegistryObject<Block> DYNA_SHRUB;

    // Signs
    public static final RegistryObject<Block> AGED_SIGN;
    public static final RegistryObject<Block> AGED_WALL_SIGN;
    public static final RegistryObject<Block> CONCRETE_SIGN;
    public static final RegistryObject<Block> CONCRETE_WALL_SIGN;
    public static final RegistryObject<Block> CONCRETE_DENSE_SIGN;
    public static final RegistryObject<Block> CONCRETE_DENSE_WALL_SIGN;
    public static final RegistryObject<Block> CORRUPTED_SIGN;
    public static final RegistryObject<Block> CORRUPTED_WALL_SIGN;
    public static final RegistryObject<Block> DISTORTIC_SIGN;
    public static final RegistryObject<Block> DISTORTIC_WALL_SIGN;
    public static final RegistryObject<Block> INVERTED_SIGN;
    public static final RegistryObject<Block> INVERTED_WALL_SIGN;
    public static final RegistryObject<Block> MIRAGE_SIGN;
    public static final RegistryObject<Block> MIRAGE_WALL_SIGN;
    public static final RegistryObject<Block> TEMPORAL_SIGN;
    public static final RegistryObject<Block> TEMPORAL_WALL_SIGN;

    // Plants
    public static final RegistryObject<Block> INVERTED_SAPLING;
    public static final RegistryObject<Block> TEMPORAL_SAPLING;
    public static final RegistryObject<Block> AGED_SAPLING;
    public static final RegistryObject<Block> CORRUPTED_SAPLING;
    public static final RegistryObject<Block> MIRAGE_SAPLING;
    public static final RegistryObject<Block> DISTORTIC_SAPLING;
    public static final RegistryObject<Block> CRYSTALLIZED_BUSH;
    public static final RegistryObject<Block> TALL_CRYSTALLIZED_BUSH;
    public static final RegistryObject<Block> CRYSTALLIZED_CACTUS;

    // Ores
    public static final RegistryObject<Block> DUSK_COAL_ORE;
    public static final RegistryObject<Block> ULTRA_COAL_ORE;

    public static final RegistryObject<Block> DUSK_COPPER_ORE;
    public static final RegistryObject<Block> ULTRA_COPPER_ORE;

    public static final RegistryObject<Block> DUSK_GOLD_ORE;
    public static final RegistryObject<Block> ULTRA_GOLD_ORE;

    public static final RegistryObject<Block> ASH_IRON_ORE;
    public static final RegistryObject<Block> DUSK_IRON_ORE;
    public static final RegistryObject<Block> ULTRA_IRON_ORE;

    public static final RegistryObject<Block> DUSK_DIAMOND_ORE;
    public static final RegistryObject<Block> ULTRA_DIAMOND_ORE;

    public static final RegistryObject<Block> DUSK_EMERALD_ORE;
    public static final RegistryObject<Block> ULTRA_EMERALD_ORE;

    public static final RegistryObject<Block> DUSK_LAPIS_ORE;
    public static final RegistryObject<Block> ULTRA_LAPIS_ORE;

    public static final RegistryObject<Block> ULTRA_REDSTONE_ORE;
    public static final RegistryObject<Block> DUSK_REDSTONE_ORE;

    public static final RegistryObject<Block> ULTRA_FOSSIL_ORE;
    public static final RegistryObject<Block> DUSK_FOSSIL_ORE;

    public static final RegistryObject<Block> RUBY_ORE;
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE;
    public static final RegistryObject<Block> DUSK_RUBY_ORE;
    public static final RegistryObject<Block> ULTRA_RUBY_ORE;

    public static final RegistryObject<Block> SAPPHIRE_ORE;
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE;
    public static final RegistryObject<Block> DUSK_SAPPHIRE_ORE;
    public static final RegistryObject<Block> ULTRA_SAPPHIRE_ORE;

    public static final RegistryObject<Block> DUSK_COSMIC_ORE;
    public static final RegistryObject<Block> METEORITE_COSMIC_ORE;
    public static final RegistryObject<Block> ULTRA_COSMIC_ORE;

    public static final RegistryObject<Block> DUSK_SPECTRUM_ORE;
    public static final RegistryObject<Block> SPECTRUM_ORE;

    public static final RegistryObject<Block> FRACTAL_ORE;

    public static final RegistryObject<Block> FRACTAL_BLOCK;

    public static final RegistryObject<Block> RUBY_BLOCK;
    public static final RegistryObject<Block> RUBY_SLAB;
    public static final RegistryObject<Block> RUBY_STAIRS;

    public static final RegistryObject<Block> SAPPHIRE_BLOCK;
    public static final RegistryObject<Block> SAPPHIRE_SLAB;
    public static final RegistryObject<Block> SAPPHIRE_STAIRS;

    public static final RegistryObject<Block> SPECTRUM_BLOCK;
    public static final RegistryObject<Block> SPECTRUM_SLAB;
    public static final RegistryObject<Block> SPECTRUM_STAIRS;

    public static final RegistryObject<Block> COSMIC_DUST_BLOCK;

    public static final RegistryObject<Block> BIG_CONTAMINATED_DRIPLEAF;
    public static final RegistryObject<Block> BIG_CONTAMINATED_DRIPLEAF_STEM;
    public static final RegistryObject<Block> POLLUTING_BLOSSOM;
    public static final RegistryObject<Block> SMALL_CONTAMINATED_DRIPLEAF;

    public static final RegistryObject<BlockEntityType<RaidSpawn>> RAID_SPAWN_ENTITY;
    public static final RegistryObject<BlockEntityType<RingTile>> RING_ENTITY;

    static
    {
        RAID_SPAWN_ENTITY = PokecubeLegends.TILES.register("raid_spot_spawner",
                () -> BlockEntityType.Builder.of(RaidSpawn::new, BlockInit.RAID_SPAWNER.get()).build(null));
        RING_ENTITY = PokecubeLegends.TILES.register("mirage_spot_block",
                () -> BlockEntityType.Builder.of(RingTile::new, BlockInit.PORTAL.get()).build(null));

        // Dimensions Creative Tab -
        // Sorting depends on the order the blocks are listed in
        ULTRA_COAL_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_coal_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(0, 2)));
        DUSK_COAL_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_coal_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0F).requiresCorrectToolForDrops(),
                        UniformInt.of(0, 2)));

        ASH_IRON_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ash_iron_ore",
                () -> new AshOre(3816264,
                        BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BLACK).speedFactor(0.3F)
                                .sound(SoundType.SNOW).strength(0.2f).randomTicks().requiresCorrectToolForDrops()));
        ULTRA_IRON_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_iron_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                        .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops()));
        DUSK_IRON_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_iron_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));

        ULTRA_COPPER_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_copper_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                        .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops()));
        DUSK_COPPER_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_copper_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));

        ULTRA_GOLD_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_gold_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                        .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops()));
        DUSK_GOLD_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_gold_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));

        ULTRA_REDSTONE_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_redstone_ore",
                () -> new RedStoneOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                        .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops().randomTicks()
                        .lightLevel(BlockInit.litBlockEmission(9))));
        DUSK_REDSTONE_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_redstone_ore",
                () -> new RedStoneOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops().randomTicks()
                        .lightLevel(BlockInit.litBlockEmission(9))));

        ULTRA_LAPIS_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_lapis_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 5)));
        DUSK_LAPIS_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_lapis_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 5)));

        ULTRA_EMERALD_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_emerald_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(3, 7)));
        DUSK_EMERALD_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_emerald_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(3, 7)));

        ULTRA_DIAMOND_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_diamond_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(3, 7)));
        DUSK_DIAMOND_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_diamond_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(3, 7)));

        ULTRA_FOSSIL_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_fossil_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                        .strength(3.0f, 3.0f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops(),
                        UniformInt.of(0, 3)));
        DUSK_FOSSIL_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_fossil_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops(),
                        UniformInt.of(0, 3)));

        METEORITE_COSMIC_ORE = PokecubeLegends.DIMENSIONS_TAB
                .register("meteorite_cosmic_ore",
                        () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                                .sound(SoundType.DRIPSTONE_BLOCK).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                                UniformInt.of(2, 5)));
        ULTRA_COSMIC_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_cosmic_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 5)));
        DUSK_COSMIC_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_cosmic_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 5)));

        RUBY_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ruby_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)
                        .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));
        DEEPSLATE_RUBY_ORE = PokecubeLegends.DIMENSIONS_TAB.register("deepslate_ruby_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE)
                        .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));
        ULTRA_RUBY_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_ruby_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));
        DUSK_RUBY_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_ruby_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));

        SAPPHIRE_ORE = PokecubeLegends.DIMENSIONS_TAB.register("sapphire_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)
                        .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));
        DEEPSLATE_SAPPHIRE_ORE = PokecubeLegends.DIMENSIONS_TAB.register("deepslate_sapphire_ore",
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE)
                        .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));
        ULTRA_SAPPHIRE_ORE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_sapphire_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));
        DUSK_SAPPHIRE_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_sapphire_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 6)));

        SPECTRUM_ORE = PokecubeLegends.DIMENSIONS_TAB.register("spectrum_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(3, 7)));
        DUSK_SPECTRUM_ORE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_spectrum_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(3, 7)));

        // Ultra Stone Blocks
        ULTRA_STONE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_stone",
                () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_CYAN, 1.5f, 6.0f, SoundType.STONE, true));
        ULTRA_STONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("ultra_stone_stairs",
                () -> new ItemGenerator.GenericStairs(ULTRA_STONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ULTRA_STONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("ultra_stone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ULTRA_STONE_BUTTON = PokecubeLegends.DIMENSIONS_TAB
                .register("ultra_stone_button",
                        () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                                .of(Material.STONE, MaterialColor.COLOR_BLUE).sound(SoundType.BAMBOO).noCollission()
                                .strength(0.5F).requiresCorrectToolForDrops()));
        ULTRA_STONE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_stone_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).sound(SoundType.BAMBOO)
                                .noCollission().strength(0.7F).requiresCorrectToolForDrops()));

        ULTRA_COBBLESTONE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_cobblestone",
                () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_CYAN, 1.5f, 10f, SoundType.STONE, true));
        ULTRA_COBBLESTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("ultra_cobblestone_stairs",
                () -> new ItemGenerator.GenericStairs(ULTRA_COBBLESTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ULTRA_COBBLESTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("ultra_cobblestone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Darkstone Blocks
        ULTRA_DARKSTONE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_darkstone", () -> new BlockBase(Material.STONE,
                MaterialColor.COLOR_BLACK, 5f, 8f, SoundType.GILDED_BLACKSTONE, true));
        ULTRA_DARKSTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("ultra_darkstone_stairs",
                () -> new ItemGenerator.GenericStairs(ULTRA_DARKSTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(2.0F, 3.0f)
                                .sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops()));
        ULTRA_DARKSTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("ultra_darkstone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops()));
        ULTRA_DARKSTONE_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("ultra_darkstone_button",
                () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                        .of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.NETHER_BRICKS).noCollission()
                        .strength(0.5F).requiresCorrectToolForDrops()));
        ULTRA_DARKSTONE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_darkstone_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.MOBS,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                                .sound(SoundType.NETHER_BRICKS).noCollission().strength(0.7F)
                                .requiresCorrectToolForDrops()));

        ULTRA_DARK_COBBLESTONE = PokecubeLegends.DIMENSIONS_TAB.register("ultra_dark_cobblestone",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLACK, 0.8f, 10f, SoundType.STONE, true));
        ULTRA_DARK_COBBLESTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("ultra_dark_cobblestone_stairs",
                () -> new ItemGenerator.GenericStairs(ULTRA_DARK_COBBLESTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(2.0F, 3.0f)
                                .sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops()));
        ULTRA_DARK_COBBLESTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("ultra_dark_cobblestone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops()));

        // Dusk Dolerite Blocks
        DUSK_DOLERITE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
        DUSK_DOLERITE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_stairs",
                () -> new ItemGenerator.GenericStairs(DUSK_DOLERITE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE).strength(3.0F, 6.0F)
                                .sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
        DUSK_DOLERITE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
        DUSK_DOLERITE_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_button",
                () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                        .of(Material.STONE, MaterialColor.COLOR_PURPLE).sound(SoundType.DEEPSLATE).noCollission()
                        .strength(0.8F).requiresCorrectToolForDrops()));
        DUSK_DOLERITE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("dusk_dolerite_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.MOBS,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                                .sound(SoundType.DEEPSLATE).noCollission().strength(1.2F)
                                .requiresCorrectToolForDrops()));

        COBBLED_DUSK_DOLERITE = PokecubeLegends.DIMENSIONS_TAB.register("cobbled_dusk_dolerite",
                () -> new Block(BlockBehaviour.Properties.copy(DUSK_DOLERITE.get()).strength(3.5F, 6.0F)));
        COBBLED_DUSK_DOLERITE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("cobbled_dusk_dolerite_stairs",
                () -> new ItemGenerator.GenericStairs(COBBLED_DUSK_DOLERITE.get().defaultBlockState(),
                        BlockBehaviour.Properties.copy(COBBLED_DUSK_DOLERITE.get())));
        COBBLED_DUSK_DOLERITE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("cobbled_dusk_dolerite_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_DUSK_DOLERITE.get())));

        // Ash blocks
        BlockBehaviour.Properties layer_props = BlockBehaviour.Properties
                .of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK).speedFactor(0.3F).sound(SoundType.SNOW)
                .strength(0.1F).randomTicks().isViewBlocking((state, block, pos) ->
                {
                    return state.getValue(FlowingBlock.LAYERS) >= 16;
                });
        BlockBehaviour.Properties block_props = BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BLACK)
                .speedFactor(0.3F).sound(SoundType.SNOW).strength(0.2F).randomTicks();

        RegistryObject<FlowingBlock>[] regs = AshBlock.makeDust(PokecubeLegends.DIMENSIONS_TAB, Reference.ID, "ash",
                "ash_block", layer_props, block_props);

        ASH = regs[0];
        ASH_BLOCK = regs[1];

        block_props = layer_props = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                .strength(2.5f).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops();

        regs = SolidBlock.makeSolid(PokecubeLegends.DIMENSIONS_TAB, Reference.ID, "meteorite_layer", "meteorite_block",
                layer_props, block_props);

        METEORITE_LAYER = regs[0];
        METEORITE_BLOCK = regs[1];

        block_props = layer_props = BlockBehaviour.Properties.of(Material.LAVA).strength(2.0F).noOcclusion()
                .randomTicks().requiresCorrectToolForDrops().lightLevel(s -> 15);

        ResourceLocation solid_layer = new ResourceLocation(Reference.ID, "meteorite_layer");
        ResourceLocation solid_block = new ResourceLocation(Reference.ID, "meteorite_block");
        regs = MoltenMeteorBlock.makeLava(PokecubeLegends.DIMENSIONS_TAB, Reference.ID, "meteorite_molten_layer",
                "meteorite_molten_block", layer_props, block_props, solid_layer, solid_block);

        METEORITE_MOLTEN_LAYER = regs[0];
        METEORITE_MOLTEN_BLOCK = regs[1];

        // Meteor Blocks
        METEORITE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("meteorite_stairs",
                () -> new ItemGenerator.GenericStairs(METEORITE_BLOCK.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).strength(2.0F, 3.0f)
                                .sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops()));
        METEORITE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("meteorite_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                        .strength(2.0F, 3.0f).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops()));

        // Soils
        AGED_GRASS_BLOCK = PokecubeLegends.DIMENSIONS_TAB.register("aged_grass_block",
                () -> new AgedGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GOLD)
                        .sound(SoundType.GRASS).strength(0.6F).randomTicks()));
        AGED_PODZOL = PokecubeLegends.DIMENSIONS_TAB.register("aged_podzol",
                () -> new SnowyDirtBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.GOLD)
                        .sound(SoundType.GRAVEL).strength(0.6F)));
        AGED_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("aged_dirt", () -> new BlockBase(Material.DIRT,
                MaterialColor.TERRACOTTA_YELLOW, 0.5F, 0.5F, SoundType.WET_GRASS, false));
        AGED_COARSE_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("aged_coarse_dirt",
                () -> new BlockBase(Material.DIRT, MaterialColor.TERRACOTTA_YELLOW, 0.5F, 0.5F, SoundType.GRAVEL,
                        false));
        AZURE_GRASS_BLOCK = PokecubeLegends.DIMENSIONS_TAB.register("azure_grass_block",
                () -> new AzureGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_BLUE)
                        .sound(SoundType.GRASS).strength(0.6F).randomTicks()));
        AZURE_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("azure_dirt",
                () -> new BlockBase(Material.DIRT, MaterialColor.COLOR_BLUE, 0.5F, 0.5F, SoundType.GRAVEL, false));
        AZURE_COARSE_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("azure_coarse_dirt",
                () -> new BlockBase(Material.DIRT, MaterialColor.COLOR_BLUE, 0.5F, 0.5F, SoundType.GRAVEL, false));
        CORRUPTED_GRASS_BLOCK = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_grass_block",
                () -> new CorruptedGrassBlock(BlockBehaviour.Properties
                        .of(Material.GRASS, MaterialColor.TERRACOTTA_BLUE).sound(SoundType.SCAFFOLDING).strength(4F, 5F)
                        .randomTicks().requiresCorrectToolForDrops()));
        CORRUPTED_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_dirt",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE)
                        .sound(SoundType.METAL).strength(0.9F).requiresCorrectToolForDrops()));
        CORRUPTED_COARSE_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_coarse_dirt",
                () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_PURPLE, 0.9F, 0.5F, SoundType.METAL,
                        true));
        ROOTED_CORRUPTED_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("rooted_corrupted_dirt",
                () -> new RootedDirtBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE)
                        .sound(SoundType.METAL).strength(0.9F).requiresCorrectToolForDrops()));
        JUNGLE_GRASS_BLOCK = PokecubeLegends.DIMENSIONS_TAB.register("jungle_grass_block",
                () -> new JungleGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_NYLIUM)
                        .sound(SoundType.GRASS).strength(0.6F).randomTicks()));
        JUNGLE_PODZOL = PokecubeLegends.DIMENSIONS_TAB.register("jungle_podzol",
                () -> new SnowyDirtBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN)
                        .sound(SoundType.GRAVEL).strength(0.6F)));
        JUNGLE_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("jungle_dirt",
                () -> new BlockBase(Material.DIRT, MaterialColor.COLOR_BROWN, 0.5F, 0.5F, SoundType.GRAVEL, false));
        JUNGLE_COARSE_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("jungle_coarse_dirt",
                () -> new BlockBase(Material.DIRT, MaterialColor.COLOR_BROWN, 0.5F, 0.5F, SoundType.GRAVEL, false));
        MUSHROOM_GRASS_BLOCK = PokecubeLegends.DIMENSIONS_TAB.register("mushroom_grass_block",
                () -> new MushroomGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_RED)
                        .sound(SoundType.GRASS).strength(0.6F).randomTicks()));
        FUNGAL_NYLIUM = PokecubeLegends.DIMENSIONS_TAB.register("fungal_nylium",
                () -> new MushroomGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_PINK)
                        .sound(SoundType.NYLIUM).strength(0.6F).randomTicks()));
        MUSHROOM_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("mushroom_dirt",
                () -> new BlockBase(Material.DIRT, MaterialColor.COLOR_PURPLE, 0.5F, 0.5F, SoundType.GRAVEL, false));
        MUSHROOM_COARSE_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("mushroom_coarse_dirt",
                () -> new BlockBase(Material.DIRT, MaterialColor.COLOR_PURPLE, 0.5F, 0.5F, SoundType.GRAVEL, false));
        ROOTED_MUSHROOM_DIRT = PokecubeLegends.DIMENSIONS_TAB.register("rooted_mushroom_dirt",
                () -> new RootedDirtBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_PURPLE)
                        .sound(SoundType.ROOTED_DIRT).strength(0.9F)));

        TURQUOISE_GRAVEL = PokecubeLegends.DIMENSIONS_TAB.register("turquoise_gravel",
                () -> new FallingBlockBase(2243919, BlockBehaviour.Properties
                        .of(Material.SAND, MaterialColor.COLOR_CYAN).sound(SoundType.GRAVEL).strength(0.6F)));

        // Azure Badlands
        AZURE_SAND = PokecubeLegends.DIMENSIONS_TAB.register("azure_sand",
                () -> new FallingSandBlockBase(1059926, BlockBehaviour.Properties
                        .of(Material.SAND, MaterialColor.COLOR_BLUE).sound(SoundType.SAND).strength(0.6f)));
        AZURE_SANDSTONE = PokecubeLegends.DIMENSIONS_TAB.register("azure_sandstone",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLUE, 0.8f, 0.8f, SoundType.STONE, true));
        AZURE_SANDSTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("azure_sandstone_stairs",
                () -> new ItemGenerator.GenericStairs(AZURE_SANDSTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(2.0F, 3.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        AZURE_SANDSTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("azure_sandstone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        AZURE_SANDSTONE_BUTTON = PokecubeLegends.DIMENSIONS_TAB
                .register("azure_sandstone_button",
                        () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                                .of(Material.STONE, MaterialColor.COLOR_BLUE).sound(SoundType.STONE).noCollission()
                                .strength(0.5F).requiresCorrectToolForDrops()));
        AZURE_SANDSTONE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("azure_sandstone_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).sound(SoundType.STONE)
                                .noCollission().strength(0.7F).requiresCorrectToolForDrops()));

        SMOOTH_AZURE_SANDSTONE = PokecubeLegends.DIMENSIONS_TAB.register("smooth_azure_sandstone",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLUE, 2.0f, 6.0f, SoundType.STONE, true));
        SMOOTH_AZURE_SANDSTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("smooth_azure_sandstone_stairs",
                () -> new ItemGenerator.GenericStairs(SMOOTH_AZURE_SANDSTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(2.0f, 6.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        SMOOTH_AZURE_SANDSTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("smooth_azure_sandstone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE)
                        .strength(2.0f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Blackened Beach
        BLACKENED_SAND = PokecubeLegends.DIMENSIONS_TAB.register("blackened_sand",
                () -> new FallingSandBlockBase(1447446, BlockBehaviour.Properties
                        .of(Material.SAND, MaterialColor.COLOR_BLACK).sound(SoundType.SAND).strength(0.6f)));
        BLACKENED_SANDSTONE = PokecubeLegends.DIMENSIONS_TAB.register("blackened_sandstone",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLACK, 0.8f, 0.8f, SoundType.STONE, true));
        BLACKENED_SANDSTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("blackened_sandstone_stairs",
                () -> new ItemGenerator.GenericStairs(BLACKENED_SANDSTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(2.0F, 3.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        BLACKENED_SANDSTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("blackened_sandstone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        BLACKENED_SANDSTONE_BUTTON = PokecubeLegends.DIMENSIONS_TAB
                .register("blackened_sandstone_button",
                        () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                                .of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).noCollission()
                                .strength(0.5F).requiresCorrectToolForDrops()));
        BLACKENED_SANDSTONE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("blackened_sandstone_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE)
                                .noCollission().strength(0.7F).requiresCorrectToolForDrops()));

        SMOOTH_BLACKENED_SANDSTONE = PokecubeLegends.DIMENSIONS_TAB.register("smooth_blackened_sandstone",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLACK, 2.0f, 6.0f, SoundType.STONE, true));
        SMOOTH_BLACKENED_SANDSTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("smooth_blackened_sandstone_stairs",
                () -> new ItemGenerator.GenericStairs(SMOOTH_BLACKENED_SANDSTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(2.0f, 6.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        SMOOTH_BLACKENED_SANDSTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("smooth_blackened_sandstone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                        .strength(2.0f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Ultra Desert
        CRYSTALLIZED_SAND = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sand", () -> new FallingSandBlockBase(
                13753318,
                BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SNOW).sound(SoundType.SAND).strength(0.6f)));
        CRYSTALLIZED_SANDSTONE = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone",
                () -> new BlockBase(Material.STONE, MaterialColor.SNOW, 1.0f, 1.0f, SoundType.STONE, true));
        CRYS_SANDSTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone_stairs",
                () -> new ItemGenerator.GenericStairs(CRYSTALLIZED_SANDSTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(2.0F, 3.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CRYS_SANDSTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CRYS_SANDSTONE_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone_button",
                () -> new ItemGenerator.GenericWoodButton(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND).sound(SoundType.STONE)
                                .noCollission().strength(0.5F).requiresCorrectToolForDrops()));
        CRYS_SANDSTONE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE)
                                .noCollission().strength(0.7F).requiresCorrectToolForDrops()));

        SMOOTH_CRYS_SANDSTONE = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone_smooth",
                () -> new BlockBase(Material.STONE, MaterialColor.SNOW, 2.0f, 6.0f, SoundType.STONE, true));
        SMOOTH_CRYS_SANDSTONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone_smooth_stairs",
                () -> new ItemGenerator.GenericStairs(SMOOTH_CRYS_SANDSTONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(2.0f, 6.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        SMOOTH_CRYS_SANDSTONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_sandstone_smooth_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(2.0f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Aquamarine
        SMALL_AQUAMARINE_BUD = PokecubeLegends.DIMENSIONS_TAB.register("small_aquamarine_bud",
                () -> new AquamarineClusterBlock(7, 4,
                        BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F)
                                .sound(SoundType.AMETHYST).noOcclusion().randomTicks().requiresCorrectToolForDrops()
                                .lightLevel(i -> 1)));
        MEDIUM_AQUAMARINE_BUD = PokecubeLegends.DIMENSIONS_TAB.register("medium_aquamarine_bud",
                () -> new AquamarineClusterBlock(11, 4,
                        BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F)
                                .sound(SoundType.AMETHYST).noOcclusion().randomTicks().requiresCorrectToolForDrops()
                                .lightLevel(i -> 2)));
        LARGE_AQUAMARINE_BUD = PokecubeLegends.DIMENSIONS_TAB.register("large_aquamarine_bud",
                () -> new AquamarineClusterBlock(12, 2,
                        BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F)
                                .sound(SoundType.AMETHYST).noOcclusion().randomTicks().requiresCorrectToolForDrops()
                                .lightLevel(i -> 4)));
        AQUAMARINE_CLUSTER = PokecubeLegends.DIMENSIONS_TAB.register("aquamarine_cluster",
                () -> new AquamarineClusterBlock(14, 1,
                        BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F)
                                .sound(SoundType.AMETHYST).noOcclusion().randomTicks().requiresCorrectToolForDrops()
                                .lightLevel(i -> 5)));
        AQUAMARINE_CRYSTAL = PokecubeLegends.DIMENSIONS_TAB.register("aquamarine_crystal",
                () -> new AquamarineCrystalBlock(BlockBehaviour.Properties
                        .of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F).sound(SoundType.AMETHYST)
                        .randomTicks().requiresCorrectToolForDrops().dynamicShape().lightLevel(i -> 6)));
        UNREFINED_AQUAMARINE = PokecubeLegends.DIMENSIONS_TAB
                .register("unrefined_aquamarine",
                        () -> new UnrefinedAquamarineBlock(BlockBehaviour.Properties
                                .of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F)
                                .sound(SoundType.AMETHYST).requiresCorrectToolForDrops().lightLevel(i -> 6)));
        BUDDING_AQUAMARINE = PokecubeLegends.DIMENSIONS_TAB.register("budding_aquamarine",
                () -> new BuddingAquamarineBlock(BlockBehaviour.Properties
                        .of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F).sound(SoundType.AMETHYST)
                        .randomTicks().requiresCorrectToolForDrops().lightLevel(i -> 6)));
        UNREFINED_AQUAMARINE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("unrefined_aquamarine_stairs",
                () -> new ItemGenerator.GenericStairs(UNREFINED_AQUAMARINE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F)
                                .sound(SoundType.AMETHYST).requiresCorrectToolForDrops().lightLevel(i -> 6)));
        UNREFINED_AQUAMARINE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("unrefined_aquamarine_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE)
                        .strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().lightLevel(i -> 6)));
        AQUAMARINE_BLOCK = PokecubeLegends.DIMENSIONS_TAB.register("aquamarine_block",
                () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE)
                        .strength(5.0F, 6.0F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
                        .lightLevel(i -> 12)));
        AQUAMARINE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("aquamarine_stairs",
                () -> new ItemGenerator.GenericStairs(AQUAMARINE_BLOCK.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).strength(1.5F)
                                .sound(SoundType.AMETHYST).requiresCorrectToolForDrops().lightLevel(i -> 12)));
        AQUAMARINE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("aquamarine_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE)
                        .strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().lightLevel(i -> 12)));
        AQUAMARINE_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("aquamarine_button",
                () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                        .of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.AMETHYST).noCollission()
                        .strength(0.5F).requiresCorrectToolForDrops().lightLevel(i -> 6)));
        AQUAMARINE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("aquamarine_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_LIGHT_BLUE)
                                .sound(SoundType.AMETHYST).noCollission().strength(0.5F).requiresCorrectToolForDrops()
                                .lightLevel(i -> 6)));

        // Distortic World
        DISTORTIC_GRASS_BLOCK = PokecubeLegends.DIMENSIONS_TAB
                .register("distortic_grass_block",
                        () -> new DistorticGrassBlock(BlockBehaviour.Properties
                                .of(Material.GRASS, MaterialColor.TERRACOTTA_PINK).sound(SoundType.NYLIUM)
                                .strength(1, 2).requiresCorrectToolForDrops().randomTicks()));
        CRACKED_DISTORTIC_STONE = PokecubeLegends.DIMENSIONS_TAB.register("cracked_distortic_stone",
                () -> new CrackedDistorticStone(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                                .sound(SoundType.STONE).strength(1, 2).requiresCorrectToolForDrops()));

        FRACTAL_ORE = PokecubeLegends.DIMENSIONS_TAB.register("fractal_ore",
                () -> new OreBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                                .sound(SoundType.STONE).strength(3.0F, 3.0f).requiresCorrectToolForDrops(),
                        UniformInt.of(2, 7)));
        DISTORTIC_STONE = PokecubeLegends.DIMENSIONS_TAB.register("distortic_stone",
                () -> new DistorticStoneBlock(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                                .sound(SoundType.STONE).strength(1.5f).requiresCorrectToolForDrops()));
        DISTORTIC_STONE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("distortic_stone_stairs",
                () -> new ItemGenerator.GenericStairs(DISTORTIC_STONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        DISTORTIC_STONE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("distortic_stone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        DISTORTIC_MIRROR = PokecubeLegends.DIMENSIONS_TAB.register("distortic_mirror",
                () -> new BlockBase(Material.GLASS, MaterialColor.SNOW, 0.3f, 0.3f, SoundType.GLASS, true));

        DISTORTIC_GLOWSTONE = PokecubeLegends.DIMENSIONS_TAB.register("distortic_glowstone",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)
                        .strength(1.5f, 1.5f).sound(SoundType.GLASS)
                        .lightLevel(i -> 10)));

        // Woods
        // Aged Blocks
        AGED_SAPLING = PokecubeLegends.DIMENSIONS_TAB.register("aged_sapling",
                () -> new SaplingBase(AgedTreeGrower::new,
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GOLD).strength(0f, 1f)
                                .sound(SoundType.GRASS).noCollission().noOcclusion()));

        AGED_LEAVES = PokecubeLegends.DIMENSIONS_TAB.register("aged_leaves",
                () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.GOLD).strength(0.2f)
                        .sound(SoundType.GRASS).noOcclusion().isSuffocating((s, r, p) -> false)
                        .isValidSpawn(ItemGenerator::ocelotOrParrot).isViewBlocking((s, r, p) -> false)));

        AGED_LOG = PokecubeLegends.DIMENSIONS_TAB.register("aged_log",
                () -> Blocks.log(MaterialColor.TERRACOTTA_GREEN, MaterialColor.COLOR_BROWN));
        AGED_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("aged_wood",
                () -> Blocks.log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));
        STRIP_AGED_LOG = PokecubeLegends.DIMENSIONS_TAB.register("stripped_aged_log",
                () -> Blocks.log(MaterialColor.TERRACOTTA_GREEN, MaterialColor.TERRACOTTA_GREEN));
        STRIP_AGED_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("stripped_aged_wood",
                () -> Blocks.log(MaterialColor.TERRACOTTA_GREEN, MaterialColor.TERRACOTTA_GREEN));

        AGED_BARREL = PokecubeLegends.DIMENSIONS_TAB.register("aged_barrel",
                () -> new GenericBarrel(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                        .strength(2.5F).sound(SoundType.WOOD)));
        AGED_BOOKSHELF = PokecubeLegends.DIMENSIONS_TAB.register("aged_bookshelf",
                () -> new GenericBookshelf(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                        .strength(2f, 4f).sound(SoundType.WOOD)));
        AGED_BOOKSHELF_EMPTY = PokecubeLegends.DIMENSIONS_TAB.register("aged_bookshelf_empty",
                () -> new GenericBookshelfEmpty(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).strength(2f, 4f)
                                .sound(SoundType.WOOD).dynamicShape()));

        AGED_PLANKS = PokecubeLegends.DIMENSIONS_TAB.register("aged_planks", () -> new Block(BlockBehaviour.Properties
                .of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).strength(2.0f).sound(SoundType.WOOD)));
        AGED_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("aged_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).strength(2.0f).sound(SoundType.WOOD)));
        AGED_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("aged_slab", () -> new SlabBlock(BlockBehaviour.Properties
                .of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).strength(2.0f).sound(SoundType.WOOD)));
        AGED_FENCE = PokecubeLegends.DIMENSIONS_TAB.register("aged_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                        .strength(2.0f).sound(SoundType.WOOD)));
        AGED_FENCE_GATE = PokecubeLegends.DIMENSIONS_TAB.register("aged_fence_gate",
                () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                        .strength(2.0f).sound(SoundType.WOOD)));
        AGED_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("aged_button",
                () -> new ItemGenerator.GenericWoodButton(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                                .sound(SoundType.WOOD).noCollission().strength(0.5f)));
        AGED_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("aged_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                                .sound(SoundType.WOOD).noCollission().strength(0.5f)));

        AGED_TRAPDOOR = PokecubeLegends.DIMENSIONS_TAB.register("aged_trapdoor",
                () -> new ItemGenerator.GenericTrapDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                                .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));
        AGED_DOOR = PokecubeLegends.DIMENSIONS_TAB.register("aged_door",
                () -> new ItemGenerator.GenericDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                                .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));

        // Corrupted Blocks
        POLLUTING_BLOSSOM = PokecubeLegends.DIMENSIONS_TAB.register("polluting_blossom",
                () -> new PollutingBlossomBlock(
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_PURPLE).noCollission()
                                .instabreak().sound(SoundType.SMALL_DRIPLEAF)));
        SMALL_CONTAMINATED_DRIPLEAF = PokecubeLegends.DIMENSIONS_TAB.register("small_contaminated_dripleaf",
                () -> new SmallContaminatedDripleafBlock(
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_RED).noCollission()
                                .instabreak().sound(SoundType.SMALL_DRIPLEAF)));
        BIG_CONTAMINATED_DRIPLEAF = PokecubeLegends.DIMENSIONS_TAB.register("big_contaminated_dripleaf",
                () -> new BigContaminatedDripleafBlock(
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_RED).strength(0.1F)
                                .sound(SoundType.BIG_DRIPLEAF)));
        BIG_CONTAMINATED_DRIPLEAF_STEM = PokecubeLegends.DIMENSIONS_TAB.register("big_contaminated_dripleaf_stem",
                () -> new BigContaminatedDripleafStemBlock(
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_RED).noCollission()
                                .strength(0.1F).sound(SoundType.BIG_DRIPLEAF)));

        CORRUPTED_SAPLING = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_sapling",
                () -> new SaplingBase(CorruptedTreeGrower::new,
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLACK).strength(0f, 1f)
                                .sound(SoundType.GRASS).noCollission().noOcclusion()));

        CORRUPTED_LEAVES = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_leaves",
                () -> new CorruptedLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_GRAY)
                        .sound(SoundType.SOUL_SAND).strength(0.5f).noOcclusion().isSuffocating((s, r, p) -> false)
                        .isValidSpawn(ItemGenerator::ocelotOrParrot).isViewBlocking((s, r, p) -> false)));

        CORRUPTED_LOG = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_log",
                () -> Blocks.log(MaterialColor.WOOD, MaterialColor.COLOR_GRAY));
        CORRUPTED_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_wood",
                () -> Blocks.log(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY));
        STRIP_CORRUPTED_LOG = PokecubeLegends.DIMENSIONS_TAB.register("stripped_corrupted_log",
                () -> Blocks.log(MaterialColor.WOOD, MaterialColor.WOOD));
        STRIP_CORRUPTED_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("stripped_corrupted_wood",
                () -> Blocks.log(MaterialColor.WOOD, MaterialColor.WOOD));

        CORRUPTED_BARREL = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_barrel", () -> new GenericBarrel(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
        CORRUPTED_BOOKSHELF = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_bookshelf",
                () -> new GenericBookshelf(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                        .strength(2f, 4f).sound(SoundType.WOOD)));
        CORRUPTED_BOOKSHELF_EMPTY = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_bookshelf_empty",
                () -> new GenericBookshelfEmpty(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                        .strength(2f, 4f).sound(SoundType.WOOD).dynamicShape()));

        CORRUPTED_PLANKS = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_planks", () -> new Block(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        CORRUPTED_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        CORRUPTED_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_slab", () -> new SlabBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));
        CORRUPTED_FENCE = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_fence", () -> new FenceBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        CORRUPTED_FENCE_GATE = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_fence_gate", () -> new FenceGateBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        CORRUPTED_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_button",
                () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).noCollission().strength(0.5f)));
        CORRUPTED_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.MOBS,
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD)
                                .noCollission().strength(0.5f)));

        CORRUPTED_TRAPDOOR = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_trapdoor",
                () -> new ItemGenerator.GenericTrapDoor(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                        .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));
        CORRUPTED_DOOR = PokecubeLegends.DIMENSIONS_TAB.register("corrupted_door",
                () -> new ItemGenerator.GenericDoor(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                        .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));

        // Distorted Blocks
        DISTORTIC_SAPLING = PokecubeLegends.DIMENSIONS_TAB.register("distortic_sapling",
                () -> new DistorticSapling(new DistorticTreeGrower(),
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).strength(0f, 1f)
                                .sound(SoundType.GRASS).noCollission().noOcclusion()));

        DISTORTIC_LEAVES = PokecubeLegends.DIMENSIONS_TAB.register("distortic_leaves",
                () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_PURPLE)
                        .strength(0.2f).sound(SoundType.GRASS).noOcclusion().isSuffocating((s, r, p) -> false)
                        .isValidSpawn(ItemGenerator::ocelotOrParrot).isViewBlocking((s, r, p) -> false)));

        DISTORTIC_LOG = PokecubeLegends.DIMENSIONS_TAB.register("distortic_log",
                () -> Blocks.log(MaterialColor.COLOR_BLUE, MaterialColor.COLOR_BLUE));
        DISTORTIC_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("distortic_wood",
                () -> Blocks.log(MaterialColor.COLOR_BLUE, MaterialColor.COLOR_BLUE));
        STRIP_DISTORTIC_LOG = PokecubeLegends.DIMENSIONS_TAB.register("stripped_distortic_log",
                () -> Blocks.log(MaterialColor.COLOR_BLUE, MaterialColor.COLOR_BLUE));
        STRIP_DISTORTIC_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("stripped_distortic_wood",
                () -> Blocks.log(MaterialColor.COLOR_BLUE, MaterialColor.COLOR_BLUE));

        DISTORTIC_BARREL = PokecubeLegends.DIMENSIONS_TAB.register("distortic_barrel",
                () -> new GenericBarrel(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE)
                        .strength(2.5F).sound(SoundType.WOOD)));
        DISTORTIC_BOOKSHELF = PokecubeLegends.DIMENSIONS_TAB.register("distortic_bookshelf",
                () -> new GenericBookshelf(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE)
                        .strength(2f, 4f).sound(SoundType.WOOD)));
        DISTORTIC_BOOKSHELF_EMPTY = PokecubeLegends.DIMENSIONS_TAB.register("distortic_bookshelf_empty",
                () -> new GenericBookshelfEmpty(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE)
                        .strength(2f, 4f).sound(SoundType.WOOD).dynamicShape()));

        DISTORTIC_PLANKS = PokecubeLegends.DIMENSIONS_TAB.register("distortic_planks",
                () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0f)
                        .sound(SoundType.WOOD)));
        DISTORTIC_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("distortic_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("distortic_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0f)
                        .sound(SoundType.WOOD)));
        DISTORTIC_FENCE = PokecubeLegends.DIMENSIONS_TAB.register("distortic_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE)
                        .strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_FENCE_GATE = PokecubeLegends.DIMENSIONS_TAB.register("distortic_fence_gate",
                () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE)
                        .strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("distortic_button",
                () -> new ItemGenerator.GenericWoodButton(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).sound(SoundType.WOOD)
                                .noCollission().strength(0.5f)));
        DISTORTIC_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("distortic_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).sound(SoundType.WOOD)
                                .noCollission().strength(0.5f)));

        DISTORTIC_TRAPDOOR = PokecubeLegends.DIMENSIONS_TAB.register("distortic_trapdoor",
                () -> new ItemGenerator.GenericTrapDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).sound(SoundType.WOOD)
                                .strength(2.0f, 3.0f).noOcclusion()));
        DISTORTIC_DOOR = PokecubeLegends.DIMENSIONS_TAB.register("distortic_door",
                () -> new ItemGenerator.GenericDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).sound(SoundType.WOOD)
                                .strength(2.0f, 3.0f).noOcclusion()));

        // Inverted Blocks
        INVERTED_SAPLING = PokecubeLegends.DIMENSIONS_TAB.register("inverted_sapling",
                () -> new SaplingBase(InvertedTreeGrower::new,
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE).strength(0f, 1f)
                                .sound(SoundType.GRASS).noCollission().noOcclusion()));

        INVERTED_LEAVES = PokecubeLegends.DIMENSIONS_TAB.register("inverted_leaves",
                () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_LIGHT_BLUE)
                        .strength(0.2f).sound(SoundType.GRASS).noOcclusion().isSuffocating((s, r, p) -> false)
                        .isValidSpawn(ItemGenerator::ocelotOrParrot).isViewBlocking((s, r, p) -> false)));

        INVERTED_LOG = PokecubeLegends.DIMENSIONS_TAB.register("inverted_log",
                () -> Blocks.log(MaterialColor.TERRACOTTA_LIGHT_BLUE, MaterialColor.TERRACOTTA_LIGHT_BLUE));
        INVERTED_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("inverted_wood",
                () -> Blocks.log(MaterialColor.TERRACOTTA_LIGHT_BLUE, MaterialColor.TERRACOTTA_LIGHT_BLUE));
        STRIP_INVERTED_LOG = PokecubeLegends.DIMENSIONS_TAB.register("stripped_inverted_log",
                () -> Blocks.log(MaterialColor.TERRACOTTA_LIGHT_BLUE, MaterialColor.TERRACOTTA_LIGHT_BLUE));
        STRIP_INVERTED_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("stripped_inverted_wood",
                () -> Blocks.log(MaterialColor.TERRACOTTA_LIGHT_BLUE, MaterialColor.TERRACOTTA_LIGHT_BLUE));

        INVERTED_BARREL = PokecubeLegends.DIMENSIONS_TAB.register("inverted_barrel",
                () -> new GenericBarrel(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                        .strength(2.5F).sound(SoundType.WOOD)));
        INVERTED_BOOKSHELF = PokecubeLegends.DIMENSIONS_TAB.register("inverted_bookshelf",
                () -> new GenericBookshelf(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .strength(2f, 4f).sound(SoundType.WOOD)));
        INVERTED_BOOKSHELF_EMPTY = PokecubeLegends.DIMENSIONS_TAB.register("inverted_bookshelf_empty",
                () -> new GenericBookshelfEmpty(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .strength(2f, 4f).sound(SoundType.WOOD).dynamicShape()));

        INVERTED_PLANKS = PokecubeLegends.DIMENSIONS_TAB.register("inverted_planks",
                () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                        .strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        INVERTED_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("inverted_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        INVERTED_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("inverted_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                        .strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        INVERTED_FENCE = PokecubeLegends.DIMENSIONS_TAB.register("inverted_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                        .strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        INVERTED_FENCE_GATE = PokecubeLegends.DIMENSIONS_TAB.register("inverted_fence_gate",
                () -> new FenceGateBlock(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .strength(2.0f, 3.0f).sound(SoundType.WOOD)));
        INVERTED_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("inverted_button",
                () -> new ItemGenerator.GenericWoodButton(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .sound(SoundType.WOOD).noCollission().strength(0.5f)));
        INVERTED_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("inverted_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .sound(SoundType.WOOD).noCollission().strength(0.5f)));

        INVERTED_TRAPDOOR = PokecubeLegends.DIMENSIONS_TAB.register("inverted_trapdoor",
                () -> new ItemGenerator.GenericTrapDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));
        INVERTED_DOOR = PokecubeLegends.DIMENSIONS_TAB.register("inverted_door",
                () -> new ItemGenerator.GenericDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));

        // MIRAGE Blocks
        MIRAGE_SAPLING = PokecubeLegends.DIMENSIONS_TAB.register("mirage_sapling",
                () -> new MirageSapling(new MirageTreeGrower(),
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_LIGHT_BLUE).strength(0f, 1f)
                                .sound(SoundType.GRASS).noCollission().noOcclusion()));

        MIRAGE_LEAVES = PokecubeLegends.DIMENSIONS_TAB.register("mirage_leaves",
                () -> new MirageLeavesBlock(9032191,
                        BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_LIGHT_BLUE)
                                .sound(SoundType.NYLIUM).strength(0.2f).noOcclusion().isSuffocating((s, r, p) -> false)
                                .isValidSpawn(ItemGenerator::ocelotOrParrot).isViewBlocking((s, r, p) -> false)));

        MIRAGE_LOG = PokecubeLegends.DIMENSIONS_TAB.register("mirage_log",
                () -> Blocks.log(MaterialColor.SAND, MaterialColor.COLOR_LIGHT_BLUE));
        MIRAGE_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("mirage_wood",
                () -> Blocks.log(MaterialColor.COLOR_LIGHT_BLUE, MaterialColor.COLOR_LIGHT_BLUE));
        STRIP_MIRAGE_LOG = PokecubeLegends.DIMENSIONS_TAB.register("stripped_mirage_log",
                () -> Blocks.log(MaterialColor.SAND, MaterialColor.SNOW));
        STRIP_MIRAGE_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("stripped_mirage_wood",
                () -> Blocks.log(MaterialColor.SNOW, MaterialColor.SNOW));

        MIRAGE_BARREL = PokecubeLegends.DIMENSIONS_TAB.register("mirage_barrel", () -> new GenericBarrel(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.5F).sound(SoundType.WOOD)));
        MIRAGE_BOOKSHELF = PokecubeLegends.DIMENSIONS_TAB.register("mirage_bookshelf",
                () -> new GenericBookshelf(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND)
                        .strength(2f, 4f).sound(SoundType.WOOD)));
        MIRAGE_BOOKSHELF_EMPTY = PokecubeLegends.DIMENSIONS_TAB.register("mirage_bookshelf_empty",
                () -> new GenericBookshelfEmpty(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND)
                        .strength(2f, 4f).sound(SoundType.WOOD).dynamicShape()));

        MIRAGE_PLANKS = PokecubeLegends.DIMENSIONS_TAB.register("mirage_planks", () -> new Block(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0f).sound(SoundType.WOOD)));
        MIRAGE_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("mirage_stairs", () -> new ItemGenerator.GenericStairs(
                Blocks.OAK_STAIRS.defaultBlockState(),
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0f).sound(SoundType.WOOD)));
        MIRAGE_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("mirage_slab", () -> new SlabBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0f).sound(SoundType.WOOD)));
        MIRAGE_FENCE = PokecubeLegends.DIMENSIONS_TAB.register("mirage_fence", () -> new FenceBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0f).sound(SoundType.WOOD)));
        MIRAGE_FENCE_GATE = PokecubeLegends.DIMENSIONS_TAB.register("mirage_fence_gate", () -> new FenceGateBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0f).sound(SoundType.WOOD)));
        MIRAGE_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("mirage_button",
                () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).noCollission().strength(0.5f)));
        MIRAGE_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("mirage_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.MOBS,
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD)
                                .noCollission().strength(0.5f)));

        MIRAGE_TRAPDOOR = PokecubeLegends.DIMENSIONS_TAB.register("mirage_trapdoor",
                () -> new ItemGenerator.GenericTrapDoor(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND)
                        .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));
        MIRAGE_DOOR = PokecubeLegends.DIMENSIONS_TAB.register("mirage_door",
                () -> new ItemGenerator.GenericDoor(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND)
                        .sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));

        // Temporal Blocks
        STRING_OF_PEARLS = PokecubeLegends.DIMENSIONS_TAB.register("string_of_pearls",
                () -> new StringOfPearlsBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission()
                        .randomTicks().strength(0.2F).sound(SoundType.VINE)));

        TEMPORAL_SAPLING = PokecubeLegends.DIMENSIONS_TAB.register("temporal_sapling",
                () -> new SaplingBase(TemporalTreeGrower::new,
                        BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).strength(0f, 1f)
                                .sound(SoundType.GRASS).noCollission().noOcclusion()));

        TEMPORAL_LEAVES = PokecubeLegends.DIMENSIONS_TAB.register("temporal_leaves",
                () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.WARPED_NYLIUM)
                        .strength(0.2f).sound(SoundType.GRASS).noOcclusion().isSuffocating((s, r, p) -> false)
                        .isValidSpawn(ItemGenerator::ocelotOrParrot).isViewBlocking((s, r, p) -> false)));

        TEMPORAL_LOG = PokecubeLegends.DIMENSIONS_TAB.register("temporal_log",
                () -> Blocks.log(MaterialColor.WARPED_NYLIUM, MaterialColor.COLOR_BROWN));
        TEMPORAL_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("temporal_wood",
                () -> Blocks.log(MaterialColor.WARPED_NYLIUM, MaterialColor.COLOR_BROWN));
        STRIP_TEMPORAL_LOG = PokecubeLegends.DIMENSIONS_TAB.register("stripped_temporal_log",
                () -> Blocks.log(MaterialColor.WARPED_NYLIUM, MaterialColor.WARPED_NYLIUM));
        STRIP_TEMPORAL_WOOD = PokecubeLegends.DIMENSIONS_TAB.register("stripped_temporal_wood",
                () -> Blocks.log(MaterialColor.WARPED_NYLIUM, MaterialColor.WARPED_NYLIUM));

        TEMPORAL_BARREL = PokecubeLegends.DIMENSIONS_TAB.register("temporal_barrel",
                () -> new GenericBarrel(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM)
                        .strength(2.5F).sound(SoundType.WOOD)));
        TEMPORAL_BOOKSHELF = PokecubeLegends.DIMENSIONS_TAB.register("temporal_bookshelf",
                () -> new GenericBookshelf(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM)
                        .strength(2f, 4f).sound(SoundType.WOOD)));
        TEMPORAL_BOOKSHELF_EMPTY = PokecubeLegends.DIMENSIONS_TAB.register("temporal_bookshelf_empty",
                () -> new GenericBookshelfEmpty(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM)
                        .strength(2f, 4f).sound(SoundType.WOOD).dynamicShape()));

        TEMPORAL_PLANKS = PokecubeLegends.DIMENSIONS_TAB.register("temporal_planks",
                () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM).strength(2.0f)
                        .sound(SoundType.WOOD)));
        TEMPORAL_STAIRS = PokecubeLegends.DIMENSIONS_TAB.register("temporal_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WARPED_NYLIUM).strength(2.0f).sound(SoundType.WOOD)));
        TEMPORAL_SLAB = PokecubeLegends.DIMENSIONS_TAB.register("temporal_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM)
                        .strength(2.0f).sound(SoundType.WOOD)));
        TEMPORAL_FENCE = PokecubeLegends.DIMENSIONS_TAB.register("temporal_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM)
                        .strength(2.0f).sound(SoundType.WOOD)));
        TEMPORAL_FENCE_GATE = PokecubeLegends.DIMENSIONS_TAB.register("temporal_fence_gate",
                () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM)
                        .strength(2.0f).sound(SoundType.WOOD)));
        TEMPORAL_BUTTON = PokecubeLegends.DIMENSIONS_TAB.register("temporal_button",
                () -> new ItemGenerator.GenericWoodButton(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM).sound(SoundType.WOOD)
                                .noCollission().strength(0.5f)));
        TEMPORAL_PR_PLATE = PokecubeLegends.DIMENSIONS_TAB.register("temporal_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM).sound(SoundType.WOOD)
                                .noCollission().strength(0.5f)));

        TEMPORAL_TRAPDOOR = PokecubeLegends.DIMENSIONS_TAB.register("temporal_trapdoor",
                () -> new ItemGenerator.GenericTrapDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM).sound(SoundType.WOOD)
                                .strength(2.0f, 3.0f).noOcclusion()));
        TEMPORAL_DOOR = PokecubeLegends.DIMENSIONS_TAB.register("temporal_door",
                () -> new ItemGenerator.GenericDoor(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM).sound(SoundType.WOOD)
                                .strength(2.0f, 3.0f).noOcclusion()));

        // Dyna Leaves
        DYNA_LEAVES_RED = PokecubeLegends.DIMENSIONS_TAB.register("dyna_leaves_red",
                () -> new DynaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_PINK)
                        .strength(0.2f).sound(SoundType.AZALEA_LEAVES).noDrops().noOcclusion()
                        .isSuffocating((s, r, p) -> false).isValidSpawn(ItemGenerator::ocelotOrParrot)
                        .isViewBlocking((s, r, p) -> false)));
        DYNA_LEAVES_PINK = PokecubeLegends.DIMENSIONS_TAB.register("dyna_leaves_pink",
                () -> new DynaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_PINK)
                        .strength(0.2f).sound(SoundType.AZALEA_LEAVES).noDrops().noOcclusion()
                        .isSuffocating((s, r, p) -> false).isValidSpawn(ItemGenerator::ocelotOrParrot)
                        .isViewBlocking((s, r, p) -> false)));
        DYNA_LEAVES_PASTEL_PINK = PokecubeLegends.DIMENSIONS_TAB.register("dyna_leaves_pastel_pink",
                () -> new DynaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_PINK)
                        .strength(0.2f).sound(SoundType.AZALEA_LEAVES).noDrops().noOcclusion()
                        .isSuffocating((s, r, p) -> false).isValidSpawn(ItemGenerator::ocelotOrParrot)
                        .isViewBlocking((s, r, p) -> false)));

        DYNA_SHRUB = PokecubeLegends.DIMENSIONS_TAB.register("dyna_shrub", () -> new DynaShrubBlock(
                BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.AZALEA).noOcclusion()));

        CRYSTALLIZED_CACTUS = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_cactus",
                () -> new CrystallizedCactus(BlockBehaviour.Properties
                        .of(Material.CACTUS, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.AMETHYST).strength(0.4f)));
        TALL_CRYSTALLIZED_BUSH = PokecubeLegends.DIMENSIONS_TAB.register("tall_crystallized_bush",
                () -> new TallCrystallizedBush(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.SNOW)
                        .sound(SoundType.AMETHYST_CLUSTER).noCollission().instabreak()));
        CRYSTALLIZED_BUSH = PokecubeLegends.DIMENSIONS_TAB.register("crystallized_bush",
                () -> new CrystallizedBush(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.SNOW)
                        .sound(SoundType.AMETHYST_CLUSTER).noCollission().instabreak()));

        // Decorations Creative Tab -
        // Sorting depends on the order the blocks are listed in
        INFECTED_TORCH = PokecubeLegends.DECORATION_TAB.register("infected_torch", () -> new InfectedTorch(
                BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((i) ->
                {
                    return 10;
                }).sound(SoundType.WOOD), ParticleTypes.DRAGON_BREATH));
        INFECTED_TORCH_WALL = PokecubeLegends.DECORATION_TAB.register("infected_torch_wall",
                () -> new InfectedTorchWall(
                        BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((i) ->
                        {
                            return 10;
                        }).sound(SoundType.WOOD).dropsLike(INFECTED_TORCH.get()), ParticleTypes.DRAGON_BREATH));

        INFECTED_FIRE = PokecubeLegends.NO_TAB.register("infected_fire",
                () -> new InfectedFireBlock(BlockBehaviour.Properties.of(Material.FIRE, MaterialColor.COLOR_PURPLE)
                        .noCollission().instabreak().lightLevel((i) ->
                        {
                            return 10;
                        }).sound(SoundType.WOOL), 2.0f));

        COSMIC_DUST_BLOCK = PokecubeLegends.DECORATION_TAB.register("cosmic_dust_block",
                () -> new SandBlock(2730984, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_LIGHT_BLUE)
                        .sound(SoundType.SAND).strength(0.5f)));

        FRACTAL_BLOCK = PokecubeLegends.DECORATION_TAB.register("fractal_block",
                () -> new BlockBase(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE, 3f, 12, SoundType.METAL, true));

        RUBY_BLOCK = PokecubeLegends.DECORATION_TAB.register("ruby_block",
                () -> new BlockBase(Material.METAL, MaterialColor.COLOR_RED, 1.5f, 10, SoundType.METAL, true));
        RUBY_STAIRS = PokecubeLegends.DECORATION_TAB.register("ruby_stairs",
                () -> new ItemGenerator.GenericStairs(RUBY_BLOCK.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(2.0F, 3.0f)
                                .sound(SoundType.METAL).requiresCorrectToolForDrops()));
        RUBY_SLAB = PokecubeLegends.DECORATION_TAB.register("ruby_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED)
                        .strength(2.0F, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

        SAPPHIRE_BLOCK = PokecubeLegends.DECORATION_TAB.register("sapphire_block",
                () -> new BlockBase(Material.METAL, MaterialColor.COLOR_BLUE, 1.5f, 10, SoundType.METAL, true));
        SAPPHIRE_STAIRS = PokecubeLegends.DECORATION_TAB.register("sapphire_stairs",
                () -> new ItemGenerator.GenericStairs(SAPPHIRE_BLOCK.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).strength(2.0F, 3.0f)
                                .sound(SoundType.METAL).requiresCorrectToolForDrops()));
        SAPPHIRE_SLAB = PokecubeLegends.DECORATION_TAB.register("sapphire_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                        .strength(2.0F, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

        SPECTRUM_BLOCK = PokecubeLegends.DECORATION_TAB.register("spectrum_block",
                () -> new BlockBase(Material.METAL, MaterialColor.COLOR_ORANGE, 5.0f, 7, SoundType.METAL, true));
        SPECTRUM_SLAB = PokecubeLegends.DECORATION_TAB.register("spectrum_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
                        .strength(2.0F, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));
        SPECTRUM_STAIRS = PokecubeLegends.DECORATION_TAB.register("spectrum_stairs",
                () -> new ItemGenerator.GenericStairs(SPECTRUM_BLOCK.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0f)
                                .sound(SoundType.METAL).requiresCorrectToolForDrops()));

        DISTORTIC_TERRACOTTA = PokecubeLegends.DECORATION_TAB.register("distortic_terracotta",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_ORANGE, 2.0f, 3.0f, SoundType.STONE, true));
        DISTORTIC_TERRACOTTA_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_terracotta_stairs",
                () -> new ItemGenerator.GenericStairs(DISTORTIC_TERRACOTTA.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        DISTORTIC_TERRACOTTA_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_terracotta_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        BOOKSHELF_EMPTY = PokecubeLegends.DECORATION_TAB.register("bookshelf_empty",
                () -> new GenericBookshelfEmpty(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                        .strength(2f, 4f).sound(SoundType.WOOD).dynamicShape()));

        DISTORTIC_OAK_PLANKS = PokecubeLegends.DECORATION_TAB.register("distortic_oak_planks", () -> new Block(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_OAK_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_oak_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_OAK_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_oak_slab", () -> new SlabBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));

        DISTORTIC_DARK_OAK_PLANKS = PokecubeLegends.DECORATION_TAB.register("distortic_dark_oak_planks",
                () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f)
                        .sound(SoundType.WOOD)));
        DISTORTIC_DARK_OAK_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_dark_oak_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_DARK_OAK_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_dark_oak_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f)
                        .sound(SoundType.WOOD)));

        DISTORTIC_SPRUCE_PLANKS = PokecubeLegends.DECORATION_TAB.register("distortic_spruce_planks", () -> new Block(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_SPRUCE_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_spruce_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_SPRUCE_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_spruce_slab", () -> new SlabBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));

        DISTORTIC_BIRCH_PLANKS = PokecubeLegends.DECORATION_TAB.register("distortic_birch_planks", () -> new Block(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_BIRCH_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_birch_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_BIRCH_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_birch_slab", () -> new SlabBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));

        DISTORTIC_ACACIA_PLANKS = PokecubeLegends.DECORATION_TAB.register("distortic_acacia_planks", () -> new Block(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_ACACIA_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_acacia_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_ACACIA_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_acacia_slab", () -> new SlabBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));

        DISTORTIC_JUNGLE_PLANKS = PokecubeLegends.DECORATION_TAB.register("distortic_jungle_planks", () -> new Block(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_JUNGLE_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_jungle_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties
                        .of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));
        DISTORTIC_JUNGLE_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_jungle_slab", () -> new SlabBlock(
                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0f).sound(SoundType.WOOD)));

        CHISELED_DISTORTIC_MIRROR = PokecubeLegends.DECORATION_TAB.register("chiseled_distortic_mirror",
                () -> new BlockBase(Material.GLASS, MaterialColor.SNOW, 1.5f, 1.5f, SoundType.GLASS, true));

        // Concrete Blocks
        CONCRETE_LOG = PokecubeLegends.DECORATION_TAB.register("concrete_log",
                () -> StoneLogBase.concreteLog(MaterialColor.SNOW, MaterialColor.COLOR_GRAY, Material.STONE, 10.0f,
                        500.0f, SoundType.STONE));
        CONCRETE_WOOD = PokecubeLegends.DECORATION_TAB.register("concrete_wood",
                () -> StoneLogBase.concreteLog(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_GRAY, Material.STONE,
                        10.0f, 500.0f, SoundType.STONE));
        STRIP_CONCRETE_LOG = PokecubeLegends.DECORATION_TAB.register("stripped_concrete_log", () -> StoneLogBase
                .concreteLog(MaterialColor.SNOW, MaterialColor.SNOW, Material.STONE, 10.0f, 500.0f, SoundType.STONE));
        STRIP_CONCRETE_WOOD = PokecubeLegends.DECORATION_TAB.register("stripped_concrete_wood", () -> StoneLogBase
                .concreteLog(MaterialColor.SNOW, MaterialColor.SNOW, Material.STONE, 10.0f, 500.0f, SoundType.STONE));

        CONCRETE_BARREL = PokecubeLegends.DECORATION_TAB.register("concrete_barrel",
                () -> new GenericBarrel(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(4.5F)
                        .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_BOOKSHELF = PokecubeLegends.DECORATION_TAB.register("concrete_bookshelf",
                () -> new GenericBookshelf(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(10.0f, 500.0f).sound(SoundType.WOOD).requiresCorrectToolForDrops()));
        CONCRETE_BOOKSHELF_EMPTY = PokecubeLegends.DECORATION_TAB.register("concrete_bookshelf_empty",
                () -> new GenericBookshelfEmpty(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(10.0f, 500.0f).sound(SoundType.WOOD).requiresCorrectToolForDrops().dynamicShape()));

        CONCRETE_PLANKS = PokecubeLegends.DECORATION_TAB.register("concrete_planks",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(10.0f, 500.0f)
                        .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_STAIRS = PokecubeLegends.DECORATION_TAB.register("concrete_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(10.0f, 500.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_SLAB = PokecubeLegends.DECORATION_TAB.register("concrete_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(10.0f, 500.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_FENCE = PokecubeLegends.DECORATION_TAB.register("concrete_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(10.0f, 500.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_FENCE_GATE = PokecubeLegends.DECORATION_TAB.register("concrete_fence_gate",
                () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(10.0f, 500.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_BUTTON = PokecubeLegends.DECORATION_TAB.register("concrete_button",
                () -> new ItemGenerator.GenericWoodButton(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE)
                                .noCollission().strength(1.5f, 500.0f).requiresCorrectToolForDrops()));
        CONCRETE_PR_PLATE = PokecubeLegends.DECORATION_TAB.register("concrete_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE)
                                .noCollission().strength(1.5f, 500.0f).requiresCorrectToolForDrops()));

        CONCRETE_TRAPDOOR = PokecubeLegends.DECORATION_TAB.register("concrete_trapdoor",
                () -> new ItemGenerator.GenericTrapDoor(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .sound(SoundType.STONE).strength(10.0f, 500.0f).noOcclusion().requiresCorrectToolForDrops()));
        CONCRETE_DOOR = PokecubeLegends.DECORATION_TAB.register("concrete_door",
                () -> new ItemGenerator.GenericDoor(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .sound(SoundType.STONE).strength(10.0f, 500.0f).noOcclusion().requiresCorrectToolForDrops()));

        CONCRETE_DENSE_BARREL = PokecubeLegends.DECORATION_TAB.register("concrete_dense_barrel",
                () -> new GenericBarrel(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0F, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_BOOKSHELF = PokecubeLegends.DECORATION_TAB.register("concrete_dense_bookshelf",
                () -> new GenericBookshelf(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_BOOKSHELF_EMPTY = PokecubeLegends.DECORATION_TAB.register("concrete_dense_bookshelf_empty",
                () -> new GenericBookshelfEmpty(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().dynamicShape()));

        CONCRETE_DENSE_PLANKS = PokecubeLegends.DECORATION_TAB.register("concrete_dense_planks",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_STAIRS = PokecubeLegends.DECORATION_TAB.register("concrete_dense_stairs",
                () -> new ItemGenerator.GenericStairs(Blocks.OAK_STAIRS.defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(25.0f, 1200.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_SLAB = PokecubeLegends.DECORATION_TAB.register("concrete_dense_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_WALL = PokecubeLegends.DECORATION_TAB.register("concrete_dense_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_WALL_GATE = PokecubeLegends.DECORATION_TAB.register("concrete_dense_wall_gate",
                () -> new WallGateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_BUTTON = PokecubeLegends.DECORATION_TAB.register("concrete_dense_button",
                () -> new ItemGenerator.GenericStoneButton(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE)
                                .noCollission().strength(2.8f, 1200.0f).requiresCorrectToolForDrops()));
        CONCRETE_DENSE_PR_PLATE = PokecubeLegends.DECORATION_TAB.register("concrete_dense_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.MOBS,
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE)
                                .noCollission().strength(2.8f, 1200.0f).requiresCorrectToolForDrops()));

        // Ultra Metal
        ULTRA_METAL = PokecubeLegends.DECORATION_TAB.register("ultra_metal",
                () -> new BlockBase(Material.METAL, MaterialColor.COLOR_LIGHT_GREEN, 5.0f, 10f, SoundType.STONE, true));
        ULTRA_METAL_STAIRS = PokecubeLegends.DECORATION_TAB.register("ultra_metal_stairs",
                () -> new ItemGenerator.GenericStairs(ULTRA_METAL.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GREEN)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ULTRA_METAL_SLAB = PokecubeLegends.DECORATION_TAB.register("ultra_metal_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ULTRA_METAL_BUTTON = PokecubeLegends.DECORATION_TAB
                .register("ultra_metal_button",
                        () -> new ItemGenerator.GenericWoodButton(BlockBehaviour.Properties
                                .of(Material.METAL, MaterialColor.COLOR_LIGHT_GREEN).sound(SoundType.METAL)
                                .noCollission().strength(0.5F).requiresCorrectToolForDrops()));
        ULTRA_METAL_PR_PLATE = PokecubeLegends.DECORATION_TAB.register("ultra_metal_pressure_plate",
                () -> new ItemGenerator.GenericPressurePlate(PressurePlateBlock.Sensitivity.MOBS,
                        BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GREEN)
                                .sound(SoundType.METAL).noCollission().strength(0.7F).requiresCorrectToolForDrops()));

        ULTRA_MAGNET = PokecubeLegends.DECORATION_TAB.register("magnetic_stone",
                () -> new MagneticBlock(Material.STONE, MaterialColor.COLOR_BLUE, 4f, 3f, SoundType.METAL, true));

        // Bricks
        ULTRA_STONE_BRICKS = PokecubeLegends.DECORATION_TAB.register("ultra_stone_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_CYAN, 1.5f, 10f, SoundType.STONE, true));
        ULTRA_STONE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("ultra_stone_brick_stairs",
                () -> new ItemGenerator.GenericStairs(ULTRA_STONE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ULTRA_STONE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("ultra_stone_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        ULTRA_DARKSTONE_BRICKS = PokecubeLegends.DECORATION_TAB.register("ultra_darkstone_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLACK, 5f, 8f, SoundType.GILDED_BLACKSTONE,
                        true));
        ULTRA_DARKSTONE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("ultra_darkstone_brick_stairs",
                () -> new ItemGenerator.GenericStairs(ULTRA_DARKSTONE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(2.0F, 3.0f)
                                .sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops()));
        ULTRA_DARKSTONE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("ultra_darkstone_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops()));

        DUSK_DOLERITE_BRICKS = PokecubeLegends.DECORATION_TAB.register("dusk_dolerite_bricks",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                        .strength(3.5F, 6.0F).sound(SoundType.DEEPSLATE_BRICKS).requiresCorrectToolForDrops()));
        DUSK_DOLERITE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("dusk_dolerite_brick_stairs",
                () -> new ItemGenerator.GenericStairs(DUSK_DOLERITE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.copy(DUSK_DOLERITE_BRICKS.get())));
        DUSK_DOLERITE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("dusk_dolerite_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(DUSK_DOLERITE_BRICKS.get())));

        AZURE_SANDSTONE_BRICKS = PokecubeLegends.DECORATION_TAB.register("azure_sandstone_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLUE, 2.0f, 6.0f, SoundType.STONE, true));
        AZURE_SANDSTONE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("azure_sandstone_brick_stairs",
                () -> new ItemGenerator.GenericStairs(AZURE_SANDSTONE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(2.0f, 6.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        AZURE_SANDSTONE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("azure_sandstone_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE)
                        .strength(2.0f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        BLACKENED_SANDSTONE_BRICKS = PokecubeLegends.DECORATION_TAB.register("blackened_sandstone_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLACK, 2.0f, 6.0f, SoundType.STONE, true));
        BLACKENED_SANDSTONE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("blackened_sandstone_brick_stairs",
                () -> new ItemGenerator.GenericStairs(BLACKENED_SANDSTONE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(2.0f, 6.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        BLACKENED_SANDSTONE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("blackened_sandstone_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                        .strength(2.0f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        CRYS_SANDSTONE_BRICKS = PokecubeLegends.DECORATION_TAB.register("crystallized_sandstone_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.SNOW, 2.0f, 6.0f, SoundType.STONE, true));
        CRYS_SANDSTONE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("crystallized_sandstone_brick_stairs",
                () -> new ItemGenerator.GenericStairs(CRYS_SANDSTONE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(2.0f, 6.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CRYS_SANDSTONE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("crystallized_sandstone_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(2.0f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        AQUAMARINE_BRICKS = PokecubeLegends.DECORATION_TAB.register("aquamarine_bricks",
                () -> new BlockBase(Material.ICE_SOLID, MaterialColor.COLOR_LIGHT_BLUE, 0.5F, 10, SoundType.AMETHYST,
                        true));
        AQUAMARINE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("aquamarine_brick_stairs",
                () -> new ItemGenerator.GenericStairs(AQUAMARINE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_LIGHT_BLUE)
                                .strength(2.0F, 3.0f).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
        AQUAMARINE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("aquamarine_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_LIGHT_BLUE)
                        .strength(2.0F, 3.0f).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

        // Ocean Bricks
        OCEAN_BRICKS = PokecubeLegends.DECORATION_TAB.register("ocean_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_CYAN, 1.5f, 10f, SoundType.STONE, true));
        OCEAN_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("ocean_brick_stairs",
                () -> new GenericStairs(OCEAN_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).strength(2.0F, 10f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        OCEAN_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("ocean_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN)
                        .strength(2.0F, 10f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Sky Bricks
        SKY_BRICKS = PokecubeLegends.DECORATION_TAB.register("sky_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_BLUE, 1.5f, 10f, SoundType.STONE, true));
        SKY_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("sky_brick_stairs",
                () -> new ItemGenerator.GenericStairs(SKY_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(2.0F, 10f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        SKY_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("sky_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE)
                        .strength(2.0F, 10f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Purpur Bricks
        PURPUR_BRICKS = PokecubeLegends.DECORATION_TAB.register("purpur_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_MAGENTA, 1.5f, 10f, SoundType.STONE, true));
        PURPUR_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("purpur_brick_stairs",
                () -> new ItemGenerator.GenericStairs(PURPUR_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength(2.0F, 3.0f)
                                .sound(SoundType.STONE).requiresCorrectToolForDrops()));
        PURPUR_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("purpur_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Magma Bricks
        MAGMA_BRICKS = PokecubeLegends.DECORATION_TAB.register("magma_bricks",
                () -> new MagmaBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER)
                        .strength(1.5f, 10).sound(SoundType.NETHERRACK).lightLevel(b -> 3)
                        .emissiveRendering((s, r, p) -> true).requiresCorrectToolForDrops()));
        MAGMA_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("magma_brick_stairs",
                () -> new ItemGenerator.GenericStairs(MAGMA_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER).strength(2.0F, 3.0f)
                                .sound(SoundType.NETHERRACK).lightLevel(b -> 3).emissiveRendering((s, r, p) -> true)
                                .requiresCorrectToolForDrops()));
        MAGMA_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("magma_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER)
                        .strength(2.0F, 3.0f).sound(SoundType.NETHERRACK).lightLevel(b -> 3)
                        .emissiveRendering((s, r, p) -> true).requiresCorrectToolForDrops()));

        // Stormy Sky Bricks
        STORMY_SKY_BRICKS = PokecubeLegends.DECORATION_TAB.register("stormy_sky_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY, 1.5f, 10f, SoundType.STONE, true));
        STORMY_SKY_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("stormy_sky_brick_stairs",
                () -> new ItemGenerator.GenericStairs(STORMY_SKY_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        STORMY_SKY_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("stormy_sky_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Distortic Stone Bricks
        DISTORTIC_STONE_BRICKS = PokecubeLegends.DECORATION_TAB.register("distortic_stone_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_BLACK, 2.5f, 10f, SoundType.STONE, true));
        DISTORTIC_STONE_BRICK_STAIRS = PokecubeLegends.DECORATION_TAB.register("distortic_stone_brick_stairs",
                () -> new ItemGenerator.GenericStairs(DISTORTIC_STONE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        DISTORTIC_STONE_BRICK_SLAB = PokecubeLegends.DECORATION_TAB.register("distortic_stone_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        CHISELED_DISTORTIC_STONE = PokecubeLegends.DECORATION_TAB.register("chiseled_distortic_stone_bricks",
                () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_BLACK, 2.5f, 10f, SoundType.STONE, true));
        CHISELED_DISTORTIC_STONE_STAIRS = PokecubeLegends.DECORATION_TAB.register(
                "chiseled_distortic_stone_brick_stairs",
                () -> new ItemGenerator.GenericStairs(CHISELED_DISTORTIC_STONE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                                .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        CHISELED_DISTORTIC_STONE_SLAB = PokecubeLegends.DECORATION_TAB.register("chiseled_distortic_stone_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                        .strength(2.0F, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        DISTORTIC_STONE_BARREL = PokecubeLegends.DECORATION_TAB.register("distortic_stone_barrel",
                () -> new GenericBarrel(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                        .strength(4.5F).sound(SoundType.STONE).requiresCorrectToolForDrops()));

        // Unown Stones
        for (int i = 0; i < unowns.length; i++)
        {
            UNOWN_STONES[i] = PokecubeLegends.DECORATION_TAB.register(unowns[i],
                    () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_BLACK, 2f, 3f, SoundType.STONE, true));
        }

        // Glass
        MIRAGE_GLASS = PokecubeLegends.DECORATION_TAB.register("mirage_glass",
                () -> new MirageGlassBlock(DyeColor.LIGHT_BLUE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_LIGHT_BLUE).strength(0.3F)
                                .sound(SoundType.GLASS).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never)));
        SPECTRUM_GLASS = PokecubeLegends.DECORATION_TAB.register("spectrum_glass",
                () -> new SpectrumGlassBlock(DyeColor.ORANGE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_ORANGE).strength(0.3F)
                                .sound(SoundType.GLASS).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never)));
        FRAMED_DISTORTIC_MIRROR = PokecubeLegends.DECORATION_TAB.register("framed_distortic_mirror",
                () -> new OneWayStainedGlass(DyeColor.WHITE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));

        ONE_WAY_GLASS = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_glass",
                () -> new OneWayGlass(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                        .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                        .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                        .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_WHITE = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_white_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.WHITE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_ORANGE = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_orange_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.ORANGE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_MAGENTA = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_magenta_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.MAGENTA,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_LIGHT_BLUE = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_light_blue_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.LIGHT_BLUE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_YELLOW = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_yellow_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.YELLOW,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_LIME = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_lime_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.LIME,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_PINK = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_pink_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.PINK,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_GRAY = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_gray_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.GRAY,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_LIGHT_GRAY = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_light_gray_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.LIGHT_GRAY,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_CYAN = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_cyan_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.CYAN,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_PURPLE = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_purple_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.PURPLE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_BLUE = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_blue_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.BLUE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_BROWN = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_brown_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.BROWN,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_GREEN = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_green_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.GREEN,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_RED = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_red_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.RED,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_BLACK = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_black_stained_glass",
                () -> new OneWayStainedGlass(DyeColor.BLACK,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_TINTED = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_tinted_glass",
                () -> new OneWayTintedGlass(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW)
                        .noOcclusion().sound(SoundType.GLASS).strength(0.3f).noOcclusion()
                        .isValidSpawn(BlockInit::never).isRedstoneConductor(BlockInit::never)
                        .isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never)));
        ONE_WAY_GLASS_LAB = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_laboratory_glass",
                () -> new OneWayLaboratoryGlass(DyeColor.LIGHT_BLUE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_MIRAGE = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_mirage_glass",
                () -> new OneWayMirageGlass(DyeColor.LIGHT_BLUE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_GLASS_SPECTRUM = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_spectrum_glass",
                () -> new OneWaySpectrumGlass(DyeColor.ORANGE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));
        ONE_WAY_FRAMED_MIRROR = PokecubeLegends.DECORATION_TAB.register("distortic_one_way_framed_mirror",
                () -> new OneWayStainedGlass(DyeColor.WHITE,
                        BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SNOW).noOcclusion()
                                .sound(SoundType.GLASS).strength(0.3f).noOcclusion().isValidSpawn(BlockInit::never)
                                .isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never)
                                .isViewBlocking(BlockInit::never).requiresCorrectToolForDrops()));

        // Tapus Totems
        TOTEM_BLOCK = PokecubeLegends.DECORATION_TAB.register("totem_block",
                () -> new BlockBase(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY, 3f, 10f, SoundType.STONE, true));

        for (int i = 0; i < totemKeys.length; i++)
        {
            String key = totemKeys[i];
            MaterialColor colour = totemColours.get(key);
            KOKO[i] = PokecubeLegends.DECORATION_TAB.register("koko" + key,
                    () -> new KokoTotem(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(5, 15)
                            .sound(SoundType.WOOD).dynamicShape()));
            BULU[i] = PokecubeLegends.DECORATION_TAB.register("bulu" + key,
                    () -> new BuluTotem(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(5, 15)
                            .sound(SoundType.WOOD).dynamicShape()));
            LELE[i] = PokecubeLegends.DECORATION_TAB.register("lele" + key,
                    () -> new LeleTotem(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(5, 15)
                            .sound(SoundType.WOOD).dynamicShape()));
            FINI[i] = PokecubeLegends.DECORATION_TAB.register("fini" + key,
                    () -> new FiniTotem(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(5, 15)
                            .sound(SoundType.WOOD).dynamicShape()));
        }

        // Pokecube Blocks Creative Tab - Sorting depends on the order the
        // blocks are listed in
        // Block Raid
        RAID_SPAWNER = PokecubeLegends.POKECUBE_BLOCKS_TAB
                .register("raid_spot_spawner",
                        () -> new RaidSpawnBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED)
                                .randomTicks().strength(2000, 2000).sound(SoundType.METAL))
                                        .setInfoBlockName("raid_spawner"));
        CRAMOMATIC_BLOCK = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("cramomatic_block",
                () -> new CramomaticBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_RED)
                        .strength(6, 15).sound(SoundType.ANVIL).dynamicShape().requiresCorrectToolForDrops())
                                .setToolTip("cramobot"));

        // Mirage Spot (Hoopa Ring)
        PORTAL = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("mirage_spot_block",
                () -> new PortalWarp("mirage_spot_block",
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.GOLD).sound(SoundType.METAL)
                                .strength(2000, 2000)).setShape(Shapes.box(0.05, 0, 0.05, 1, 3, 1))
                                        .setToolTip("portalwarp"));

        // Legendary Spawners
        // Regi Cores
        GOLEM_STONE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("golem_stone",
                () -> new BlockBase(Material.STONE, MaterialColor.TERRACOTTA_WHITE, 3f, 10f, SoundType.STONE, true));
        REGISTEEL_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("registeel_spawn",
                () -> new FaceBlockBase(Material.METAL, MaterialColor.TERRACOTTA_WHITE, 5f, 10f, SoundType.METAL,
                        true));
        REGICE_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("regice_spawn",
                () -> new FaceBlockBase(Material.ICE_SOLID, MaterialColor.TERRACOTTA_WHITE, 5f, 10f, SoundType.GLASS,
                        true));
        REGIROCK_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("regirock_spawn",
                () -> new FaceBlockBase(Material.STONE, MaterialColor.TERRACOTTA_WHITE, 5f, 10f, SoundType.STONE,
                        true));
        REGIELEKI_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("regieleki_spawn",
                () -> new FaceBlockBase(Material.STONE, MaterialColor.TERRACOTTA_WHITE, 5f, 10f, SoundType.STONE,
                        true));
        REGIDRAGO_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("regidrago_spawn",
                () -> new FaceBlockBase(Material.CLAY, MaterialColor.TERRACOTTA_WHITE, 5f, 10f, SoundType.STONE, true));
        REGIGIGA_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("regigiga_spawn",
                () -> new FaceBlockBase(Material.HEAVY_METAL, MaterialColor.TERRACOTTA_WHITE, 5f, 10f, SoundType.METAL,
                        true));

        LEGENDARY_SPAWN = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("legendary_spawn",
                () -> new BlockBase(Material.METAL, MaterialColor.GOLD, 5f, 15f, SoundType.METAL, true));

        HEATRAN_BLOCK = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("heatran_spawn",
                () -> new HeatranBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER)
                        .strength(5, 15).sound(SoundType.NETHER_BRICKS).lightLevel(b -> 4).dynamicShape()
                        .emissiveRendering((s, r, p) -> true).requiresCorrectToolForDrops()));

        MAGEARNA_BLOCK = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("magearna_spawn",
                () -> new MagearnaBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                        .strength(5, 15).sound(SoundType.STONE).requiresCorrectToolForDrops().dynamicShape()));

        // Tapus
        TAPU_KOKO_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("koko_core",
                () -> new TapuKokoCore(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW)
                        .strength(5, 15).sound(SoundType.BASALT).dynamicShape().requiresCorrectToolForDrops()));
        TAPU_BULU_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("bulu_core",
                () -> new TapuBuluCore(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED)
                        .strength(5, 15).sound(SoundType.BASALT).dynamicShape().requiresCorrectToolForDrops()));
        TAPU_LELE_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("lele_core",
                () -> new TapuLeleCore(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE)
                        .strength(5, 15).sound(SoundType.BASALT).dynamicShape().requiresCorrectToolForDrops()));
        TAPU_FINI_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("fini_core",
                () -> new TapuFiniCore(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK)
                        .strength(5, 15).sound(SoundType.BASALT).dynamicShape().requiresCorrectToolForDrops()));

        YVELTAL_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("yveltal_spawn",
                () -> new YveltalEgg(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
                        .strength(2000, 2000).sound(SoundType.WOOD).dynamicShape())
                                .setShape(Shapes.box(0.05, 0, 0.05, 1, 2, 1)));

        KELDEO_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("keldeo_spawn",
                () -> new KeldeoBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE)
                        .strength(2000, 2000).sound(SoundType.STONE).dynamicShape())
                                .setShape(Shapes.box(0.05, 0, 0.05, 1, 1, 1)));

        TIMESPACE_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("timerspace_spawn",
                () -> new TimeSpaceCoreBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.STONE)
                        .strength(2000, 2000).sound(SoundType.STONE).dynamicShape())
                                .setShape(Shapes.box(0.05, 0, 0.05, 1, 2, 1)));

        NATURE_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("nature_spawn",
                () -> new NatureCoreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)
                        .strength(2000, 2000).sound(SoundType.STONE).dynamicShape())
                                .setShape(Shapes.box(0.05, 0, 0.05, 1, 2, 1)));

        XERNEAS_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("xerneas_spawn",
                () -> new XerneasCore(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.SNOW)
                        .strength(2000, 2000).sound(SoundType.WOOD).dynamicShape())
                                .setShape(Shapes.box(0.05, 0, 0.05, 1, 2, 1)));

        TAO_BLOCK = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("blackwhite_spawn",
                () -> new TaoTrioBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.SNOW)
                        .strength(5, 15).sound(SoundType.FUNGUS).dynamicShape())
                                .setShape(Shapes.box(0.05, 0, 0.05, 1, 1, 1)));

        TROUGH_BLOCK = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("trough_spawn",
                () -> new TroughBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN)
                        .strength(5, 15).sound(SoundType.ANVIL).lightLevel(b -> 4).dynamicShape()
                        .requiresCorrectToolForDrops()));

        VICTINI_CORE = PokecubeLegends.POKECUBE_BLOCKS_TAB.register("victini_spawn",
                () -> new VictiniBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).strength(5, 15)
                        .sound(SoundType.ANVIL).dynamicShape().requiresCorrectToolForDrops())
                                .setShape(Shapes.box(0.05, 0, 0.05, 1, 1, 1)));

        INFECTED_CAMPFIRE = PokecubeLegends.DECORATION_TAB.register("infected_campfire",
                () -> new InfectedCampfireBlock(true, 2,
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0F)
                                .sound(SoundType.WOOD).lightLevel(litBlockEmission(10)).noOcclusion()));

        INFECTED_LANTERN = PokecubeLegends.DECORATION_TAB.register("infected_lantern",
                () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_PURPLE)
                        .requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((i) ->
                        {
                            return 10;
                        }).noOcclusion()));

        // No Creative Tab
        // Signs
        AGED_SIGN = PokecubeLegends.NO_TAB.register("aged_sign",
                () -> new GenericStandingSign(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).strength(1.0F)
                                .noCollission().sound(SoundType.WOOD),
                        LegendsWoodType.AGED));
        AGED_WALL_SIGN = PokecubeLegends.NO_TAB.register("aged_wall_sign",
                () -> new GenericWallSign(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN)
                        .strength(1.0F).noCollission().sound(SoundType.WOOD).lootFrom(AGED_SIGN),
                        LegendsWoodType.AGED));
        CONCRETE_SIGN = PokecubeLegends.NO_TAB
                .register("concrete_sign",
                        () -> new GenericStandingSign(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                                .strength(10.0F, 500.0F).noCollission().sound(SoundType.STONE),
                                LegendsWoodType.CONCRETE));
        CONCRETE_WALL_SIGN = PokecubeLegends.NO_TAB.register("concrete_wall_sign",
                () -> new GenericWallSign(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(10.0F, 500.0F)
                                .noCollission().sound(SoundType.STONE).lootFrom(CONCRETE_SIGN),
                        LegendsWoodType.CONCRETE));
        CONCRETE_DENSE_SIGN = PokecubeLegends.NO_TAB.register("concrete_dense_sign",
                () -> new GenericStandingSign(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW)
                        .strength(20.0F, 1200.0F).noCollission().sound(SoundType.STONE),
                        LegendsWoodType.CONCRETE_DENSE));
        CONCRETE_DENSE_WALL_SIGN = PokecubeLegends.NO_TAB.register("concrete_dense_wall_sign",
                () -> new GenericWallSign(
                        BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(20.0F, 1200.0F)
                                .noCollission().sound(SoundType.STONE).lootFrom(CONCRETE_DENSE_SIGN),
                        LegendsWoodType.CONCRETE_DENSE));
        CORRUPTED_SIGN = PokecubeLegends.NO_TAB.register("corrupted_sign",
                () -> new GenericStandingSign(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                        .strength(1.0F).noCollission().sound(SoundType.WOOD), LegendsWoodType.CORRUPTED));
        CORRUPTED_WALL_SIGN = PokecubeLegends.NO_TAB
                .register("corrupted_wall_sign",
                        () -> new GenericWallSign(
                                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(1.0F)
                                        .noCollission().sound(SoundType.WOOD).lootFrom(CORRUPTED_SIGN),
                                LegendsWoodType.CORRUPTED));
        DISTORTIC_SIGN = PokecubeLegends.NO_TAB.register("distortic_sign",
                () -> new GenericStandingSign(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE)
                        .strength(1.0F).noCollission().sound(SoundType.WOOD), LegendsWoodType.DISTORTIC));
        DISTORTIC_WALL_SIGN = PokecubeLegends.NO_TAB.register("distortic_wall_sign",
                () -> new GenericWallSign(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(1.0F)
                                .noCollission().sound(SoundType.WOOD).lootFrom(DISTORTIC_SIGN),
                        LegendsWoodType.DISTORTIC));
        INVERTED_SIGN = PokecubeLegends.NO_TAB
                .register("inverted_sign",
                        () -> new GenericStandingSign(
                                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                        .strength(1.0F, 1.5F).noCollission().sound(SoundType.WOOD),
                                LegendsWoodType.INVERTED));
        INVERTED_WALL_SIGN = PokecubeLegends.NO_TAB.register("inverted_wall_sign",
                () -> new GenericWallSign(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_LIGHT_BLUE)
                                .strength(1.0F, 1.5F).noCollission().sound(SoundType.WOOD).lootFrom(INVERTED_SIGN),
                        LegendsWoodType.INVERTED));
        MIRAGE_SIGN = PokecubeLegends.NO_TAB.register("mirage_sign",
                () -> new GenericStandingSign(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND)
                        .strength(1.0F).noCollission().sound(SoundType.WOOD), LegendsWoodType.MIRAGE));
        MIRAGE_WALL_SIGN = PokecubeLegends.NO_TAB
                .register("mirage_wall_sign",
                        () -> new GenericWallSign(
                                BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).strength(1.0F)
                                        .noCollission().sound(SoundType.WOOD).lootFrom(MIRAGE_SIGN),
                                LegendsWoodType.MIRAGE));
        TEMPORAL_SIGN = PokecubeLegends.NO_TAB.register("temporal_sign",
                () -> new GenericStandingSign(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM)
                        .strength(1.0F).noCollission().sound(SoundType.WOOD), LegendsWoodType.TEMPORAL));
        TEMPORAL_WALL_SIGN = PokecubeLegends.NO_TAB.register("temporal_wall_sign",
                () -> new GenericWallSign(
                        BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WARPED_NYLIUM).strength(1.0F)
                                .noCollission().sound(SoundType.WOOD).lootFrom(TEMPORAL_SIGN),
                        LegendsWoodType.TEMPORAL));

        ItemGenerator.SIGN_BLOCKS.addAll(Lists.newArrayList(BlockInit.AGED_SIGN, BlockInit.AGED_WALL_SIGN,
                BlockInit.CONCRETE_SIGN, BlockInit.CONCRETE_WALL_SIGN, BlockInit.CONCRETE_DENSE_SIGN,
                BlockInit.CONCRETE_DENSE_WALL_SIGN, BlockInit.CORRUPTED_SIGN, BlockInit.CORRUPTED_WALL_SIGN,
                BlockInit.DISTORTIC_SIGN, BlockInit.DISTORTIC_WALL_SIGN, BlockInit.INVERTED_SIGN,
                BlockInit.INVERTED_WALL_SIGN, BlockInit.MIRAGE_SIGN, BlockInit.MIRAGE_WALL_SIGN,
                BlockInit.TEMPORAL_SIGN, BlockInit.TEMPORAL_WALL_SIGN));

        ItemGenerator.BOATS.add(new BoatRegister(BlockInit.AGED_PLANKS, "aged", PokecubeLegends.TAB_DIMENSIONS, PokecubeLegends.ITEMS));
        ItemGenerator.BOATS.add(new BoatRegister(BlockInit.CONCRETE_PLANKS, "concrete", PokecubeLegends.TAB_DIMENSIONS, PokecubeLegends.ITEMS));
        ItemGenerator.BOATS.add(new BoatRegister(BlockInit.CORRUPTED_PLANKS, "corrupted", PokecubeLegends.TAB_DIMENSIONS, PokecubeLegends.ITEMS));
        ItemGenerator.BOATS.add(new BoatRegister(BlockInit.DISTORTIC_PLANKS, "distortic", PokecubeLegends.TAB_DIMENSIONS, PokecubeLegends.ITEMS));
        ItemGenerator.BOATS.add(new BoatRegister(BlockInit.INVERTED_PLANKS, "inverted", PokecubeLegends.TAB_DIMENSIONS, PokecubeLegends.ITEMS));
        ItemGenerator.BOATS.add(new BoatRegister(BlockInit.MIRAGE_PLANKS, "mirage", PokecubeLegends.TAB_DIMENSIONS, PokecubeLegends.ITEMS));
        ItemGenerator.BOATS.add(new BoatRegister(BlockInit.TEMPORAL_PLANKS, "temporal", PokecubeLegends.TAB_DIMENSIONS, PokecubeLegends.ITEMS));
    }

    private static ToIntFunction<BlockState> litBlockEmission(final int i)
    {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? i : 0;
        };
    }

    private static Boolean never(BlockState state, BlockGetter block, BlockPos pos, EntityType<?> type)
    {
        return (boolean) false;
    }

    private static boolean never(BlockState state, BlockGetter block, BlockPos pos)
    {
        return false;
    }

    public static void init()
    {
        PlantsInit.registry();
        PottedPlantsInit.registry();

        for (final RegistryObject<Block> reg : PokecubeLegends.POKECUBE_BLOCKS_TAB.getEntries())
            PokecubeLegends.ITEMS.register(reg.getId().getPath(),
                    () -> new BlockItem(reg.get(), new Item.Properties().tab(PokecubeItems.TAB_BLOCKS)));

        for (final RegistryObject<Block> reg : PokecubeLegends.DIMENSIONS_TAB.getEntries())
        {
            // These are registered separately, so skip them.
            if (reg == BlockInit.BIG_CONTAMINATED_DRIPLEAF_STEM || reg == PlantsInit.DISTORTIC_VINES_PLANT
                    || reg == PlantsInit.DISTORTIC_VINES || reg == PlantsInit.GOLDEN_SHROOM_PLANT
                    || reg == PlantsInit.HANGING_TENDRILS_PLANT || reg == PlantsInit.PURPLE_WISTERIA_VINES_PLANT
                    || reg == PlantsInit.TEMPORAL_BAMBOO || reg == PlantsInit.TEMPORAL_BAMBOO_SHOOT
                    || reg == PlantsInit.PINK_TAINTED_LILY_PAD || reg == PlantsInit.TAINTED_LILY_PAD)
                continue;
            PokecubeLegends.ITEMS.register(reg.getId().getPath(),
                    () -> new BlockItem(reg.get(), new Item.Properties().tab(PokecubeLegends.TAB_DIMENSIONS)));
        }

        for (final RegistryObject<Block> reg : PokecubeLegends.DECORATION_TAB.getEntries())
        {
            if (reg == BlockInit.INFECTED_TORCH || reg == BlockInit.INFECTED_TORCH_WALL) continue;
            PokecubeLegends.ITEMS.register(reg.getId().getPath(),
                    () -> new BlockItem(reg.get(), new Item.Properties().tab(PokecubeLegends.TAB_DECORATIONS)));
        }
    }
}
