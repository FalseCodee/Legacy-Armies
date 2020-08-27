package me.falsecode.biomeset;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkLoadEvent;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void ChunkLoad(ChunkLoadEvent e) {
        Chunk c = e.getChunk();
        World w = c.getWorld();

        int cX = c.getX() * 16;
        int cZ = c.getZ() * 16;
        if (c.isLoaded()) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    if (w.getBiome(cX + x, cZ + z) == Biome.OCEAN) {
                        w.setBiome(cX + x, cZ + z, Biome.PLAINS);
                    }
                }
            }
        } else {
            return;
        }
    }
}
