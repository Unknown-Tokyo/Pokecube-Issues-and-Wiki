package pokecube.core.database.worldgen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import pokecube.api.PokecubeAPI;
import pokecube.core.database.resources.PackFinder;
import pokecube.core.entity.npc.NpcType;
import thut.api.util.JsonUtil;
import thut.lib.ResourceHelper;

public class StructureSpawnPresetLoader
{
    public static Map<String, JsonObject> presetMap = Maps.newHashMap();

    public static boolean validLoad = false;

    public static class SpawnPresets
    {
        List<JsonObject> presets = Lists.newArrayList();
    }

    public static void loadDatabase()
    {
        StructureSpawnPresetLoader.validLoad = false;
        final Map<ResourceLocation, Resource> resources = PackFinder.getJsonResources(NpcType.DATALOC);
        resources.forEach((file, resource) -> {
            JsonObject loaded;
            try
            {
                final BufferedReader reader = ResourceHelper.getReader(resource);
                if (reader == null) throw new FileNotFoundException(file.toString());
                loaded = JsonUtil.gson.fromJson(reader, JsonObject.class);
                reader.close();
                if (loaded.has("presets"))
                {
                    StructureSpawnPresetLoader.validLoad = true;
                    final SpawnPresets database = JsonUtil.gson.fromJson(loaded, SpawnPresets.class);
                    for (final JsonObject preset : database.presets) if (preset.has("preset_name"))
                        StructureSpawnPresetLoader.presetMap.put(preset.get("preset_name").getAsString(), preset);
                    else PokecubeAPI.LOGGER.error("Warning, needs a \"preset_name\" field for " + preset);
                }

            }
            catch (final Exception e)
            {
                PokecubeAPI.LOGGER.error("Error loading npc presets from {}", file, e);
            }
        });
    }
}
