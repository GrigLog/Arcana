package net.arcanamod.blocks.saplings;

import net.arcanamod.worldgen.trees.TaintedAcaciaGenerator;
import net.arcanamod.blocks.bases.SaplingBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

/**
 * @author Mozaran
 * <p>
 * Used to grow all variations of the tainted acacia tree
 */
public class TaintedAcaciaSapling extends SaplingBase{
	boolean untainted;
	
	public TaintedAcaciaSapling(String name, boolean untainted){
		super(name);
		this.untainted = untainted;
	}
	
	@Override
	public void generateTree(World worldIn, BlockPos pos, BlockState state, Random rand){
		if(!TerrainGen.saplingGrowTree(worldIn, rand, pos))
			return;
		
		Feature worldgenerator = untainted ? new TaintedAcaciaGenerator(true, true, true) : new TaintedAcaciaGenerator(true, true, false);
		
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
		
		if(!worldgenerator.generate(worldIn, rand, pos)){
			worldIn.setBlockState(pos, state, 4);
		}
	}
}
