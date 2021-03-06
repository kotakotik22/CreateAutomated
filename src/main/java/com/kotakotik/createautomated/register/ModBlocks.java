package com.kotakotik.createautomated.register;

import com.kotakotik.createautomated.content.blocks.NodeBlock;
import com.kotakotik.createautomated.content.blocks.oreextractor.BottomOreExtractorBlock;
import com.kotakotik.createautomated.content.blocks.oreextractor.TopOreExtractorBlock;
import com.simibubi.create.foundation.config.StressConfigDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;

public class ModBlocks {
    public static BlockEntry<TopOreExtractorBlock> ORE_EXTRACTOR_TOP;
    public static BlockEntry<BottomOreExtractorBlock> ORE_EXTRACTOR_BOTTOM;

    public static BlockEntry<NodeBlock> LAPIS_NODE;

    public static void register(CreateRegistrate registrate) {

        ORE_EXTRACTOR_TOP = registrate.block("ore_extractor_top", TopOreExtractorBlock::new)
                .initialProperties(SharedProperties::stone)
//                .blockstate(BlockStateGen.directionalBlockProvider(true))
                .blockstate(($, $$) -> {
                })
                .addLayer(() -> RenderType::getCutoutMipped)
                .transform(StressConfigDefaults.setImpact(32.0))
                .register();

        ORE_EXTRACTOR_BOTTOM = registrate.block("ore_extractor", BottomOreExtractorBlock::new)
                .initialProperties(SharedProperties::stone)
                .blockstate(($, $$) -> {
                })
                .addLayer(() -> RenderType::getCutoutMipped)
                .item().model(($, $$) -> {
                }).build()
                .transform(StressConfigDefaults.setImpact(32.0))
                .register();

//        LAPIS_NODE = registrate.block("lapis_node", p -> new NodeBlock(p, ModItems.LAPIS_ORE_PIECE, 1, OreExtractorBlock.ExtractorProgressBuilder.atSpeedOfS(128).takesSeconds(10).build())).tag(ModTags.Blocks.NODES).simpleItem().register();
    }
}
