package net.arcanamod.blocks;

import net.arcanamod.blocks.bases.*;
import net.arcanamod.blocks.bases.tainted.*;
import net.arcanamod.blocks.bases.untainted.UntaintedBlockBase;
import net.arcanamod.blocks.saplings.*;
import net.arcanamod.Arcana;
import net.arcanamod.blocks.bases.*;
import net.arcanamod.blocks.bases.tainted.*;
import net.arcanamod.blocks.saplings.*;
import net.arcanamod.entities.ArcanaEntities;
import net.arcanamod.items.ArcanaItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Initialize Blocks here
 *
 * @author Atlas, Mozaran, Tea
 * @see ArcanaProperties
 * @see ArcanaEntities
 * @see ArcanaItems
 */
public class ArcanaBlocks{
	public static final List<Block> BLOCKS = new ArrayList<>();
	
	// General
	public static final Block ARCANE_STONE = new BlockBase("arcane_stone", Material.ROCK).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block ARCANE_STONE_SLAB_DOUBLE = new DoubleSlabBase("arcane_stone_slab_double", Material.ROCK);
	public static final Block ARCANE_STONE_SLAB_HALF = new HalfSlabBase("arcane_stone_slab", Material.ROCK, ArcanaBlocks.ARCANE_STONE_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block ARCANE_STONE_STAIRS = new StairsBase("arcane_stone_stairs", ARCANE_STONE.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block ARCANE_STONE_BRICKS = new BlockBase("arcane_stone_bricks", Material.ROCK).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block ARCANE_STONE_BRICKS_SLAB_DOUBLE = new DoubleSlabBase("arcane_stone_bricks_slab_double", Material.ROCK);
	public static final Block ARCANE_STONE_BRICKS_SLAB_HALF = new HalfSlabBase("arcane_stone_bricks_slab", Material.ROCK, ArcanaBlocks.ARCANE_STONE_BRICKS_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block ARCANE_STONE_BRICKS_STAIRS = new StairsBase("arcane_stone_bricks_stairs", ARCANE_STONE_BRICKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block AMBER_ORE = new BlockAmberOre().setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block INFUSION_ARCANE_STONE = new BlockBase("infusion_arcane_stone", Material.ROCK).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block MAGICAL_GRASS = new BlockBase("magical_grass", Material.GRASS).setCreativeTab(Arcana.TAB_ARCANA);
	// public static final Block TABLE = new BlockBase("table", Material.WOOD).setCreativeTab(Main.TAB_ARCANA);
	
	//Blocks with function
	public static final Block RESEARCH_TABLE = new BlockResearchTable();
	public static final Block NORMAL_NODE = new BlockNormalNode().setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block CRUCIBLE = new BlockCrucible("crucible").setCreativeTab(Arcana.TAB_ARCANA);
	
	// Logs
	public static final Block DAIR_LEAVES = new LeavesBase("dair_leaves").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DAIR_LOG = new LogBase("dair_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DAIR_PLANKS = new PlanksBase("dair_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DAIR_SAPLING = new DairSapling("dair_sapling", false, false).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DAIR_SLAB_DOUBLE = new DoubleSlabBase("dair_slab_double", Material.WOOD);
	public static final Block DAIR_STONE_SLAB_HALF = new HalfSlabBase("dair_slab", Material.WOOD, ArcanaBlocks.DAIR_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DAIR_STAIRS = new StairsBase("dair_stairs", DAIR_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DEAD_LOG = new LogBase("dead_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DEAD_PLANKS = new PlanksBase("dead_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DEAD_SLAB_DOUBLE = new DoubleSlabBase("dead_slab_double", Material.WOOD);
	public static final Block DEAD_STONE_SLAB_HALF = new HalfSlabBase("dead_slab", Material.WOOD, ArcanaBlocks.DEAD_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block DEAD_STAIRS = new StairsBase("dead_stairs", DEAD_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block EUCALYPTUS_LEAVES = new LeavesBase("eucalyptus_leaves").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block EUCALYPTUS_LOG = new LogBase("eucalyptus_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block EUCALYPTUS_PLANKS = new PlanksBase("eucalyptus_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block EUCALYPTUS_SAPLING = new EucalyptusSapling("eucalyptus_sapling", false, false).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block EUCALYPTUS_SLAB_DOUBLE = new DoubleSlabBase("eucalyptus_slab_double", Material.WOOD);
	public static final Block EUCALYPTUS_STONE_SLAB_HALF = new HalfSlabBase("eucalyptus_slab", Material.WOOD, ArcanaBlocks.GREATWOOD_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block EUCALYPTUS_STAIRS = new StairsBase("eucalyptus_stairs", EUCALYPTUS_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block GREATWOOD_LEAVES = new LeavesBase("greatwood_leaves").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block GREATWOOD_LOG = new LogBase("greatwood_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block GREATWOOD_PLANKS = new PlanksBase("greatwood_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block GREATWOOD_SAPLING = new GreatwoodSapling("greatwood_sapling", false, false).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block GREATWOOD_SLAB_DOUBLE = new DoubleSlabBase("greatwood_slab_double", Material.WOOD);
	public static final Block GREATWOOD_STONE_SLAB_HALF = new HalfSlabBase("greatwood_slab", Material.WOOD, ArcanaBlocks.GREATWOOD_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block GREATWOOD_STAIRS = new StairsBase("greatwood_stairs", GREATWOOD_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block HAWTHORN_LEAVES = new LeavesBase("hawthorn_leaves").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block HAWTHORN_LOG = new LogBase("hawthorn_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block HAWTHORN_PLANKS = new PlanksBase("hawthorn_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block HAWTHORN_SAPLING = new HawthornSapling("hawthorn_sapling", false, false).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block HAWTHORN_SLAB_DOUBLE = new DoubleSlabBase("hawthorn_slab_double", Material.WOOD);
	public static final Block HAWTHORN_STONE_SLAB_HALF = new HalfSlabBase("hawthorn_slab", Material.WOOD, ArcanaBlocks.HAWTHORN_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block HAWTHORN_STAIRS = new StairsBase("hawthorn_stairs", HAWTHORN_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block SILVERWOOD_LEAVES = new LeavesBase("silverwood_leaves").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block SILVERWOOD_LOG = new LogBase("silverwood_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block SILVERWOOD_PLANKS = new PlanksBase("silverwood_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block SILVERWOOD_SAPLING = new SilverwoodSapling("silverwood_sapling").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block SILVERWOOD_SLAB_DOUBLE = new DoubleSlabBase("silverwood_slab_double", Material.WOOD);
	public static final Block SILVERWOOD_STONE_SLAB_HALF = new HalfSlabBase("silverwood_slab", Material.WOOD, ArcanaBlocks.HAWTHORN_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block SILVERWOOD_STAIRS = new StairsBase("silverwood_stairs", HAWTHORN_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block TRYPOPHOBIUS_LOG = new LogBase("trypophobius_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block TRYPOPHOBIUS_PLANKS = new PlanksBase("trypophobius_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block TRYPOPHOBIUS_SLAB_DOUBLE = new DoubleSlabBase("trypophobius_slab_double", Material.WOOD);
	public static final Block TRYPOPHOBIUS_STONE_SLAB_HALF = new HalfSlabBase("trypophobius_slab", Material.WOOD, ArcanaBlocks.TRYPOPHOBIUS_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block TRYPOPHOBIUS_STAIRS = new StairsBase("trypophobius_stairs", TRYPOPHOBIUS_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block WILLOW_LEAVES = new LeavesBase("willow_leaves").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block WILLOW_LOG = new LogBase("willow_log").setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block WILLOW_PLANKS = new PlanksBase("willow_planks", Material.WOOD).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block WILLOW_SAPLING = new WillowSapling("willow_sapling", false, false).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block WILLOW_SLAB_DOUBLE = new DoubleSlabBase("willow_slab_double", Material.WOOD);
	public static final Block WILLOW_STONE_SLAB_HALF = new HalfSlabBase("willow_slab", Material.WOOD, ArcanaBlocks.WILLOW_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block WILLOW_STAIRS = new StairsBase("willow_stairs", WILLOW_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_ARCANA);
	
	// Compressed Resources
	public static final Block ARCANIUM_BLOCK = new BlockBase("arcanium_block", Material.IRON).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block THAUMIUM_BLOCK = new BlockBase("thaumium_block", Material.IRON).setCreativeTab(Arcana.TAB_ARCANA);
	public static final Block TAINTED_ARCANIUM_BLOCK = new TaintedBlockBase("tainted_arcanium_block", Material.IRON);
	public static final Block TAINTED_COAL_BLOCK = new TaintedBlockBase("tainted_coal_block", Material.IRON);
	public static final Block TAINTED_DIAMOND_BLOCK = new TaintedBlockBase("tainted_diamond_block", Material.IRON);
	public static final Block TAINTED_EMERALD_BLOCK = new TaintedBlockBase("tainted_emerald_block", Material.IRON);
	public static final Block TAINTED_GOLD_BLOCK = new TaintedBlockBase("tainted_gold_block", Material.IRON);
	public static final Block TAINTED_IRON_BLOCK = new TaintedBlockBase("tainted_iron_block", Material.IRON);
	public static final Block TAINTED_LAPIS_BLOCK = new TaintedBlockBase("tainted_lapis_block", Material.IRON);
	public static final Block TAINTED_REDSTONE_BLOCK = new TaintedBlockBase("tainted_redstone_block", Material.IRON);
	public static final Block TAINTED_THAUMIUM_BLOCK = new TaintedBlockBase("tainted_thaumium_block", Material.IRON);
	public static final Block UNTAINTED_ARCANIUM_BLOCK = new UntaintedBlockBase("untainted_arcanium_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_COAL_BLOCK = new UntaintedBlockBase("untainted_coal_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DIAMOND_BLOCK = new UntaintedBlockBase("untainted_diamond_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EMERALD_BLOCK = new UntaintedBlockBase("untainted_emerald_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GOLD_BLOCK = new UntaintedBlockBase("untainted_gold_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_IRON_BLOCK = new UntaintedBlockBase("untainted_iron_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_LAPIS_BLOCK = new UntaintedBlockBase("untainted_lapis_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_REDSTONE_BLOCK = new UntaintedBlockBase("untainted_redstone_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_THAUMIUM_BLOCK = new UntaintedBlockBase("untainted_thaumium_block", Material.IRON).setCreativeTab(Arcana.TAB_TAINTARCANA);
	
	// Tainted General
	public static final Block TAINTED_CRUST = new TaintedBlockBase("tainted_crust", Material.ROCK);
	public static final Block TAINTED_CRUST_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_crust_slab_double", Material.WOOD);
	public static final Block TAINTED_CRUST_SLAB_HALF = new TaintedHalfSlabBase("tainted_crust_slab", Material.WOOD, ArcanaBlocks.TAINTED_CRUST_SLAB_DOUBLE);
	public static final Block TAINTED_GRASS = new TaintedGrassBase("tainted_grass_block", Material.GRASS);
	public static final Block TAINTED_GRAVEL = new TaintedBlockBase("tainted_gravel", Material.GROUND);
	public static final Block TAINTED_ROCK = new TaintedBlockBase("tainted_rock", Material.ROCK);
	public static final Block TAINTED_ROCK_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_rock_slab_double", Material.WOOD);
	public static final Block TAINTED_ROCK_SLAB_HALF = new TaintedHalfSlabBase("tainted_rock_slab", Material.WOOD, ArcanaBlocks.TAINTED_ROCK_SLAB_DOUBLE);
	public static final Block TAINTED_SAND = new TaintedBlockBase("tainted_sand", Material.SAND);
	public static final Block TAINTED_SOIL = new TaintedBlockBase("tainted_soil", Material.GROUND);
	
	// Tainted Ore
	public static final Block TAINTED_AMBER_ORE = new TaintedBlockBase("tainted_amber_ore", Material.ROCK);
	public static final Block TAINTED_ARCANIUM_ORE = new TaintedBlockBase("tainted_arcanium_ore", Material.ROCK);
	public static final Block TAINTED_CINNABAR_ORE = new TaintedBlockBase("tainted_cinnabar_ore", Material.ROCK);
	public static final Block TAINTED_COAL_ORE = new TaintedBlockBase("tainted_coal_ore", Material.ROCK);
	public static final Block TAINTED_DESTROYED_ORE = new TaintedBlockBase("tainted_destroyed_ore", Material.ROCK);
	public static final Block TAINTED_DIAMOND_ORE = new TaintedBlockBase("tainted_diamond_ore", Material.ROCK);
	public static final Block TAINTED_EMERALD_ORE = new TaintedBlockBase("tainted_emerald_ore", Material.ROCK);
	public static final Block TAINTED_GOLD_ORE = new TaintedBlockBase("tainted_gold_ore", Material.ROCK);
	public static final Block TAINTED_IRON_ORE = new TaintedBlockBase("tainted_iron_ore", Material.ROCK);
	public static final Block TAINTED_LAPIS_ORE = new TaintedBlockBase("tainted_lapis_ore", Material.ROCK);
	public static final Block TAINTED_REDSTONE_ORE = new TaintedBlockBase("tainted_redstone_ore", Material.ROCK);
	public static final Block TAINTED_RUBY_ORE = new TaintedBlockBase("tainted_ruby_ore", Material.ROCK);
	public static final Block TAINTED_SILVER_ORE = new TaintedBlockBase("tainted_silver_ore", Material.ROCK);
	
	// Tainted Wood
	public static final Block TAINTED_ACACIA_LEAVES = new TaintedLeavesBase("tainted_acacia_leaves");
	public static final Block TAINTED_ACACIA_LOG = new TaintedLogBase("tainted_acacia_log");
	public static final Block TAINTED_ACACIA_PLANKS = new TaintedBlockBase("tainted_acacia_planks", Material.WOOD);
	public static final Block TAINTED_ACACIA_SAPLING = new TaintedAcaciaSapling("tainted_acacia_sapling", false);
	public static final Block TAINTED_ACACIA_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_acacia_slab_double", Material.WOOD);
	public static final Block TAINTED_ACACIA_SLAB_HALF = new TaintedHalfSlabBase("tainted_acacia_slab", Material.WOOD, ArcanaBlocks.TAINTED_ACACIA_SLAB_DOUBLE);
	public static final Block TAINTED_ACACIA_STAIRS = new TaintedStairsBase("tainted_acacia_stairs", TAINTED_ACACIA_PLANKS.getDefaultState());
	public static final Block TAINTED_BIRCH_LEAVES = new TaintedLeavesBase("tainted_birch_leaves");
	public static final Block TAINTED_BIRCH_LOG = new TaintedLogBase("tainted_birch_log");
	public static final Block TAINTED_BIRCH_PLANKS = new TaintedBlockBase("tainted_birch_planks", Material.WOOD);
	public static final Block TAINTED_BIRCH_SAPLING = new TaintedBirchSapling("tainted_birch_sapling", false, false);
	public static final Block TAINTED_BIRCH_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_birch_slab_double", Material.WOOD);
	public static final Block TAINTED_BIRCH_SLAB_HALF = new TaintedHalfSlabBase("tainted_birch_slab", Material.WOOD, ArcanaBlocks.TAINTED_BIRCH_SLAB_DOUBLE);
	public static final Block TAINTED_BIRCH_STAIRS = new TaintedStairsBase("tainted_birch_stairs", TAINTED_BIRCH_PLANKS.getDefaultState());
	public static final Block TAINTED_DAIR_LEAVES = new TaintedLeavesBase("tainted_dair_leaves");
	public static final Block TAINTED_DAIR_LOG = new TaintedLogBase("tainted_dair_log");
	public static final Block TAINTED_DAIR_PLANKS = new TaintedBlockBase("tainted_dair_planks", Material.WOOD);
	public static final Block TAINTED_DAIR_SAPLING = new DairSapling("tainted_dair_sapling", true, false);
	public static final Block TAINTED_DAIR_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_dair_slab_double", Material.WOOD);
	public static final Block TAINTED_DAIR_SLAB_HALF = new TaintedHalfSlabBase("tainted_dair_slab", Material.WOOD, ArcanaBlocks.TAINTED_DAIR_SLAB_DOUBLE);
	public static final Block TAINTED_DAIR_STAIRS = new TaintedStairsBase("tainted_dair_stairs", TAINTED_DAIR_PLANKS.getDefaultState());
	public static final Block TAINTED_DARKOAK_LEAVES = new TaintedLeavesBase("tainted_darkoak_leaves");
	public static final Block TAINTED_DARKOAK_LOG = new TaintedLogBase("tainted_darkoak_log");
	public static final Block TAINTED_DARKOAK_PLANKS = new TaintedBlockBase("tainted_darkoak_planks", Material.WOOD);
	public static final Block TAINTED_DARKOAK_SAPLING = new TaintedDarkOakSapling("tainted_darkoak_sapling", false);
	public static final Block TAINTED_DARKOAK_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_darkoak_slab_double", Material.WOOD);
	public static final Block TAINTED_DARKOAK_SLAB_HALF = new TaintedHalfSlabBase("tainted_darkoak_slab", Material.WOOD, ArcanaBlocks.TAINTED_DARKOAK_SLAB_DOUBLE);
	public static final Block TAINTED_DARKOAK_STAIRS = new TaintedStairsBase("tainted_darkoak_stairs", TAINTED_DARKOAK_PLANKS.getDefaultState());
	public static final Block TAINTED_EUCALYPTUS_LEAVES = new TaintedLeavesBase("tainted_eucalyptus_leaves");
	public static final Block TAINTED_EUCALYPTUS_LOG = new TaintedLogBase("tainted_eucalyptus_log");
	public static final Block TAINTED_EUCALYPTUS_PLANKS = new TaintedBlockBase("tainted_eucalyptus_planks", Material.WOOD);
	public static final Block TAINTED_EUCALYPTUS_SAPLING = new EucalyptusSapling("tainted_eucalyptus_sapling", true, false);
	public static final Block TAINTED_EUCALYPTUS_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_eucalyptus_slab_double", Material.WOOD);
	public static final Block TAINTED_EUCALYPTUS_SLAB_HALF = new TaintedHalfSlabBase("tainted_eucalyptus_slab", Material.WOOD, ArcanaBlocks.TAINTED_DAIR_SLAB_DOUBLE);
	public static final Block TAINTED_EUCALYPTUS_STAIRS = new TaintedStairsBase("tainted_eucalyptus_stairs", TAINTED_DAIR_PLANKS.getDefaultState());
	public static final Block TAINTED_GREATWOOD_LEAVES = new TaintedLeavesBase("tainted_greatwood_leaves");
	public static final Block TAINTED_GREATWOOD_LOG = new TaintedLogBase("tainted_greatwood_log");
	public static final Block TAINTED_GREATWOOD_PLANKS = new TaintedBlockBase("tainted_greatwood_planks", Material.WOOD);
	public static final Block TAINTED_GREATWOOD_SAPLING = new GreatwoodSapling("tainted_greatwood_sapling", true, false);
	public static final Block TAINTED_GREATWOOD_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_greatwood_slab_double", Material.WOOD);
	public static final Block TAINTED_GREATWOOD_SLAB_HALF = new TaintedHalfSlabBase("tainted_greatwood_slab", Material.WOOD, ArcanaBlocks.TAINTED_GREATWOOD_SLAB_DOUBLE);
	public static final Block TAINTED_GREATWOOD_STAIRS = new TaintedStairsBase("tainted_greatwood_stairs", TAINTED_GREATWOOD_PLANKS.getDefaultState());
	public static final Block TAINTED_HAWTHORN_LEAVES = new TaintedLeavesBase("tainted_hawthorn_leaves");
	public static final Block TAINTED_HAWTHORN_LOG = new TaintedLogBase("tainted_hawthorn_log");
	public static final Block TAINTED_HAWTHORN_PLANKS = new TaintedBlockBase("tainted_hawthorn_planks", Material.WOOD);
	public static final Block TAINTED_HAWTHORN_SAPLING = new HawthornSapling("tainted_hawthorn_sapling", true, false);
	public static final Block TAINTED_HAWTHORN_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_hawthorn_slab_double", Material.WOOD);
	public static final Block TAINTED_HAWTHORN_SLAB_HALF = new TaintedHalfSlabBase("tainted_hawthorn_slab", Material.WOOD, ArcanaBlocks.TAINTED_HAWTHORN_SLAB_DOUBLE);
	public static final Block TAINTED_HAWTHORN_STAIRS = new TaintedStairsBase("tainted_hawthorn_stairs", TAINTED_HAWTHORN_PLANKS.getDefaultState());
	public static final Block TAINTED_JUNGLE_LEAVES = new TaintedLeavesBase("tainted_jungle_leaves");
	public static final Block TAINTED_JUNGLE_LOG = new TaintedLogBase("tainted_jungle_log");
	public static final Block TAINTED_JUNGLE_PLANKS = new TaintedBlockBase("tainted_jungle_planks", Material.WOOD);
	public static final Block TAINTED_JUNGLE_SAPLING = new TaintedJungleSapling("tainted_jungle_sapling", false);
	public static final Block TAINTED_JUNGLE_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_jungle_slab_double", Material.WOOD);
	public static final Block TAINTED_JUNGLE_SLAB_HALF = new TaintedHalfSlabBase("tainted_jungle_slab", Material.WOOD, ArcanaBlocks.TAINTED_JUNGLE_SLAB_DOUBLE);
	public static final Block TAINTED_JUNGLE_STAIRS = new TaintedStairsBase("tainted_jungle_stairs", TAINTED_JUNGLE_PLANKS.getDefaultState());
	public static final Block TAINTED_OAK_LEAVES = new TaintedLeavesBase("tainted_oak_leaves");
	public static final Block TAINTED_OAK_LOG = new TaintedLogBase("tainted_oak_log");
	public static final Block TAINTED_OAK_PLANKS = new TaintedBlockBase("tainted_oak_planks", Material.WOOD);
	public static final Block TAINTED_OAK_SAPLING = new TaintedOakSapling("tainted_oak_sapling", false);
	public static final Block TAINTED_OAK_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_oak_slab_double", Material.WOOD);
	public static final Block TAINTED_OAK_SLAB_HALF = new TaintedHalfSlabBase("tainted_oak_slab", Material.WOOD, ArcanaBlocks.TAINTED_OAK_SLAB_DOUBLE);
	public static final Block TAINTED_OAK_STAIRS = new TaintedStairsBase("tainted_oak_stairs", TAINTED_OAK_LOG.getDefaultState());
	public static final Block TAINTED_SPRUCE_LEAVES = new TaintedLeavesBase("tainted_spruce_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block TAINTED_SPRUCE_LOG = new TaintedLogBase("tainted_spruce_log");
	public static final Block TAINTED_SPRUCE_PLANKS = new TaintedBlockBase("tainted_spruce_planks", Material.WOOD);
	public static final Block TAINTED_SPRUCE_SAPLING = new TaintedSpruceSapling("tainted_spruce_sapling", false);
	public static final Block TAINTED_SPRUCE_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_spruce_slab_double", Material.WOOD);
	public static final Block TAINTED_SPRUCE_SLAB_HALF = new TaintedHalfSlabBase("tainted_spruce_slab", Material.WOOD, ArcanaBlocks.TAINTED_SPRUCE_SLAB_DOUBLE);
	public static final Block TAINTED_SPRUCE_STAIRS = new TaintedStairsBase("tainted_spruce_stairs", TAINTED_SPRUCE_PLANKS.getDefaultState());
	public static final Block TAINTED_WILLOW_LEAVES = new TaintedLeavesBase("tainted_willow_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block TAINTED_WILLOW_LOG = new TaintedLogBase("tainted_willow_log");
	public static final Block TAINTED_WILLOW_PLANKS = new TaintedBlockBase("tainted_willow_planks", Material.WOOD);
	public static final Block TAINTED_WILLOW_SAPLING = new WillowSapling("tainted_willow_sapling", true, false);
	public static final Block TAINTED_WILLOW_SLAB_DOUBLE = new TaintedDoubleSlabBase("tainted_willow_slab_double", Material.WOOD);
	public static final Block TAINTED_WILLOW_SLAB_HALF = new TaintedHalfSlabBase("tainted_willow_slab", Material.WOOD, ArcanaBlocks.TAINTED_WILLOW_SLAB_DOUBLE);
	public static final Block TAINTED_WILLOW_STAIRS = new TaintedStairsBase("tainted_willow_stairs", TAINTED_WILLOW_PLANKS.getDefaultState());
	
	// Untainted General
	public static final Block UNTAINTED_CRUST = new TaintedBlockBase("untainted_crust", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_CRUST_SLAB_DOUBLE = new DoubleSlabBase("untainted_crust_slab_double", Material.WOOD);
	public static final Block UNTAINTED_CRUST_SLAB_HALF = new HalfSlabBase("untainted_crust_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_CRUST_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GRASS = new TaintedGrassBase("untainted_grass_block", Material.GRASS).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GRAVEL = new TaintedBlockBase("untainted_gravel", Material.GROUND).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ROCK = new TaintedBlockBase("untainted_rock", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ROCK_SLAB_DOUBLE = new DoubleSlabBase("untainted_rock_slab_double", Material.WOOD);
	public static final Block UNTAINTED_ROCK_SLAB_HALF = new HalfSlabBase("untainted_rock_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_ROCK_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SAND = new TaintedBlockBase("untainted_sand", Material.SAND).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SOIL = new TaintedBlockBase("untainted_soil", Material.GROUND).setCreativeTab(Arcana.TAB_TAINTARCANA);
	
	// Untainted Ore
	public static final Block UNTAINTED_AMBER_ORE = new TaintedBlockBase("untainted_amber_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ARCANIUM_ORE = new TaintedBlockBase("untainted_arcanium_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_CINNABAR_ORE = new TaintedBlockBase("untainted_cinnabar_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_COAL_ORE = new TaintedBlockBase("untainted_coal_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DESTROYED_ORE = new TaintedBlockBase("untainted_destroyed_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DIAMOND_ORE = new TaintedBlockBase("untainted_diamond_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EMERALD_ORE = new TaintedBlockBase("untainted_emerald_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GOLD_ORE = new TaintedBlockBase("untainted_gold_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_IRON_ORE = new TaintedBlockBase("untainted_iron_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_LAPIS_ORE = new TaintedBlockBase("untainted_lapis_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_REDSTONE_ORE = new TaintedBlockBase("untainted_redstone_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_RUBY_ORE = new TaintedBlockBase("untainted_ruby_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SILVER_ORE = new TaintedBlockBase("untainted_silver_ore", Material.ROCK).setCreativeTab(Arcana.TAB_TAINTARCANA);
	
	// Untainted Wood
	public static final Block UNTAINTED_ACACIA_LEAVES = new LeavesBase("untainted_acacia_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ACACIA_LOG = new TaintedLogBase("untainted_acacia_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ACACIA_PLANKS = new TaintedBlockBase("untainted_acacia_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ACACIA_SAPLING = new TaintedAcaciaSapling("untainted_acacia_sapling", true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ACACIA_SLAB_DOUBLE = new DoubleSlabBase("untainted_acacia_slab_double", Material.WOOD);
	public static final Block UNTAINTED_ACACIA_SLAB_HALF = new HalfSlabBase("untainted_acacia_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_ACACIA_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_ACACIA_STAIRS = new TaintedStairsBase("untainted_acacia_stairs", UNTAINTED_ACACIA_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_BIRCH_LEAVES = new LeavesBase("untainted_birch_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_BIRCH_LOG = new TaintedLogBase("untainted_birch_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_BIRCH_PLANKS = new TaintedBlockBase("untainted_birch_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_BIRCH_SAPLING = new TaintedBirchSapling("untainted_birch_sapling", false, true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_BIRCH_SLAB_DOUBLE = new DoubleSlabBase("untainted_birch_slab_double", Material.WOOD);
	public static final Block UNTAINTED_BIRCH_SLAB_HALF = new HalfSlabBase("untainted_birch_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_BIRCH_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_BIRCH_STAIRS = new TaintedStairsBase("untainted_birch_stairs", UNTAINTED_BIRCH_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DAIR_LEAVES = new LeavesBase("untainted_dair_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DAIR_LOG = new TaintedLogBase("untainted_dair_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DAIR_PLANKS = new TaintedBlockBase("untainted_dair_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DAIR_SAPLING = new DairSapling("untainted_dair_sapling", true, true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DAIR_SLAB_DOUBLE = new DoubleSlabBase("untainted_dair_slab_double", Material.WOOD);
	public static final Block UNTAINTED_DAIR_SLAB_HALF = new HalfSlabBase("untainted_dair_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_DAIR_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DAIR_STAIRS = new TaintedStairsBase("untainted_dair_stairs", UNTAINTED_DAIR_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DARKOAK_LEAVES = new LeavesBase("untainted_darkoak_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DARKOAK_LOG = new TaintedLogBase("untainted_darkoak_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DARKOAK_PLANKS = new TaintedBlockBase("untainted_darkoak_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DARKOAK_SAPLING = new TaintedDarkOakSapling("untainted_darkoak_sapling", true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DARKOAK_SLAB_DOUBLE = new DoubleSlabBase("untainted_darkoak_slab_double", Material.WOOD);
	public static final Block UNTAINTED_DARKOAK_SLAB_HALF = new HalfSlabBase("untainted_darkoak_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_DARKOAK_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_DARKOAK_STAIRS = new TaintedStairsBase("untainted_darkoak_stairs", UNTAINTED_DARKOAK_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EUCALYPTUS_LEAVES = new TaintedLeavesBase("untainted_eucalyptus_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EUCALYPTUS_LOG = new TaintedLogBase("untainted_eucalyptus_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EUCALYPTUS_PLANKS = new TaintedBlockBase("untainted_eucalyptus_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EUCALYPTUS_SAPLING = new EucalyptusSapling("untainted_eucalyptus_sapling", true, true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EUCALYPTUS_SLAB_DOUBLE = new TaintedDoubleSlabBase("untainted_eucalyptus_slab_double", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EUCALYPTUS_SLAB_HALF = new TaintedHalfSlabBase("untainted_eucalyptus_slab", Material.WOOD, ArcanaBlocks.TAINTED_DAIR_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_EUCALYPTUS_STAIRS = new TaintedStairsBase("untainted_eucalyptus_stairs", TAINTED_DAIR_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GREATWOOD_LEAVES = new LeavesBase("untainted_greatwood_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GREATWOOD_LOG = new TaintedLogBase("untainted_greatwood_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GREATWOOD_PLANKS = new TaintedBlockBase("untainted_greatwood_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GREATWOOD_SAPLING = new GreatwoodSapling("untainted_greatwood_sapling", true, true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GREATWOOD_SLAB_DOUBLE = new DoubleSlabBase("untainted_greatwood_slab_double", Material.WOOD);
	public static final Block UNTAINTED_GREATWOOD_SLAB_HALF = new HalfSlabBase("untainted_greatwood_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_GREATWOOD_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_GREATWOOD_STAIRS = new TaintedStairsBase("untainted_greatwood_stairs", UNTAINTED_GREATWOOD_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_HAWTHORN_LEAVES = new LeavesBase("untainted_hawthorn_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_HAWTHORN_LOG = new TaintedLogBase("untainted_hawthorn_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_HAWTHORN_PLANKS = new TaintedBlockBase("untainted_hawthorn_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_HAWTHORN_SAPLING = new HawthornSapling("untainted_hawthorn_sapling", true, true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_HAWTHORN_SLAB_DOUBLE = new DoubleSlabBase("untainted_hawthorn_slab_double", Material.WOOD);
	public static final Block UNTAINTED_HAWTHORN_SLAB_HALF = new HalfSlabBase("untainted_hawthorn_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_HAWTHORN_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_HAWTHORN_STAIRS = new TaintedStairsBase("untainted_hawthorn_stairs", UNTAINTED_HAWTHORN_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_JUNGLE_LEAVES = new LeavesBase("untainted_jungle_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_JUNGLE_LOG = new TaintedLogBase("untainted_jungle_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_JUNGLE_PLANKS = new TaintedBlockBase("untainted_jungle_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_JUNGLE_SAPLING = new TaintedJungleSapling("untainted_jungle_sapling", true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_JUNGLE_SLAB_DOUBLE = new DoubleSlabBase("untainted_jungle_slab_double", Material.WOOD);
	public static final Block UNTAINTED_JUNGLE_SLAB_HALF = new HalfSlabBase("untainted_jungle_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_JUNGLE_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_JUNGLE_STAIRS = new TaintedStairsBase("untainted_jungle_stairs", UNTAINTED_JUNGLE_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_OAK_LEAVES = new LeavesBase("untainted_oak_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_OAK_LOG = new TaintedLogBase("untainted_oak_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_OAK_PLANKS = new TaintedBlockBase("untainted_oak_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_OAK_SAPLING = new TaintedOakSapling("untainted_oak_sapling", true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_OAK_SLAB_DOUBLE = new DoubleSlabBase("untainted_oak_slab_double", Material.WOOD);
	public static final Block UNTAINTED_OAK_SLAB_HALF = new HalfSlabBase("untainted_oak_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_OAK_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_OAK_STAIRS = new TaintedStairsBase("untainted_oak_stairs", UNTAINTED_OAK_LOG.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SPRUCE_LEAVES = new LeavesBase("untainted_spruce_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SPRUCE_LOG = new TaintedLogBase("untainted_spruce_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SPRUCE_PLANKS = new TaintedBlockBase("untainted_spruce_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SPRUCE_SAPLING = new TaintedSpruceSapling("untainted_spruce_sapling", true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SPRUCE_SLAB_DOUBLE = new DoubleSlabBase("untainted_spruce_slab_double", Material.WOOD);
	public static final Block UNTAINTED_SPRUCE_SLAB_HALF = new HalfSlabBase("untainted_spruce_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_SPRUCE_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_SPRUCE_STAIRS = new TaintedStairsBase("untainted_spruce_stairs", UNTAINTED_SPRUCE_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_WILLOW_LEAVES = new LeavesBase("untainted_willow_leaves").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_WILLOW_LOG = new TaintedLogBase("untainted_willow_log").setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_WILLOW_PLANKS = new TaintedBlockBase("untainted_willow_planks", Material.WOOD).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_WILLOW_SAPLING = new WillowSapling("untainted_willow_sapling", true, true).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_WILLOW_SLAB_DOUBLE = new DoubleSlabBase("untainted_willow_slab_double", Material.WOOD);
	public static final Block UNTAINTED_WILLOW_SLAB_HALF = new HalfSlabBase("untainted_willow_slab", Material.WOOD, ArcanaBlocks.UNTAINTED_WILLOW_SLAB_DOUBLE).setCreativeTab(Arcana.TAB_TAINTARCANA);
	public static final Block UNTAINTED_WILLOW_STAIRS = new TaintedStairsBase("untainted_willow_stairs", UNTAINTED_WILLOW_PLANKS.getDefaultState()).setCreativeTab(Arcana.TAB_TAINTARCANA);
}