package net.arcanamod.worldgen.trees;

import net.arcanamod.blocks.ArcanaBlocks;
import net.arcanamod.worldgen.GenerationUtilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraftforge.common.IPlantable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static net.minecraft.block.LogBlock.LOG_AXIS;

/**
 * @author Mozaran
 * <p>
 * Used to generate greatwood trees
 */
public class GreatwoodGenerator extends AbstractTreeFeature{
	private static final BlockState DEFAULT_TRUNK = ArcanaBlocks.GREATWOOD_LOG.getDefaultState();
	private static final BlockState DEFAULT_TAINTED_TRUNK = ArcanaBlocks.TAINTED_GREATWOOD_LOG.getDefaultState();
	private static final BlockState DEFAULT_UNTAINTED_TRUNK = ArcanaBlocks.UNTAINTED_GREATWOOD_LOG.getDefaultState();
	private static final BlockState DEFAULT_LEAVES = ArcanaBlocks.GREATWOOD_LEAVES.getDefaultState().withProperty(LeavesBlock.CHECK_DECAY, Boolean.FALSE);
	private static final BlockState DEFAULT_TAINTED_LEAVES = ArcanaBlocks.TAINTED_GREATWOOD_LEAVES.getDefaultState().withProperty(LeavesBlock.CHECK_DECAY, Boolean.FALSE);
	private static final BlockState DEFAULT_UNTAINTED_LEAVES = ArcanaBlocks.UNTAINTED_GREATWOOD_LEAVES.getDefaultState().withProperty(LeavesBlock.CHECK_DECAY, Boolean.FALSE);
	
	private final BlockState metaWood;
	private final BlockState metaLeaves;
	
	private final int minTreeHeight = 23;
	
	private ArrayList<BlockPos> xTrunkBlockList = new ArrayList<>();
	private ArrayList<BlockPos> yTrunkBlockList = new ArrayList<>();
	private ArrayList<BlockPos> zTrunkBlockList = new ArrayList<>();
	private ArrayList<BlockPos> leafBlockList = new ArrayList<>();
	private Set<BlockPos> takenOriginPos = new HashSet<>();
	private Set<BlockPos> takenEndPos = new HashSet<>();
	
	public GreatwoodGenerator(boolean notify, boolean tainted){
		this(notify, tainted, false);
	}
	
	public GreatwoodGenerator(boolean notify, boolean tainted, boolean untainted){
		super(notify);
		if(tainted){
			metaWood = untainted ? DEFAULT_UNTAINTED_TRUNK : DEFAULT_TAINTED_TRUNK;
			metaLeaves = untainted ? DEFAULT_UNTAINTED_LEAVES : DEFAULT_TAINTED_LEAVES;
		}else{
			metaWood = DEFAULT_TRUNK;
			metaLeaves = DEFAULT_LEAVES;
		}
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position){
		int seed = rand.nextInt(8);
		int height = rand.nextInt(3) + minTreeHeight;
		
		// Gen Trunk
		for(int i = 0; i < height; ++i){
			yTrunkBlockList.add(position.add(0, i, 0));
			yTrunkBlockList.add(position.add(1, i, 0));
			yTrunkBlockList.add(position.add(0, i, 1));
			yTrunkBlockList.add(position.add(1, i, 1));
		}
		
		// Gen Top Branch
		int xOffset = (seed % 4 == 0 || seed % 4 == 1) ? 0 : 1;
		int zOffset = (seed % 4 == 0 || seed % 4 == 2) ? 0 : 1;
		genBranch(position.add(xOffset, height, zOffset), position.add(xOffset, height + 1, zOffset), LogBlock.EnumAxis.Y);
		
		// Gen 4-5 branches per side on lower half 5 blocks long
		int lowerY = 6;
		int upperY = height / 2;
		int numBranches = 5 + ((rand.nextInt(2) % 2 == 0) ? 0 : 2);
		int branchLength = 2 + rand.nextInt(2);
		genTreeSection(lowerY, upperY, numBranches, branchLength, position, rand);
		lowerY = upperY + 1;
		upperY = height;
		numBranches = 7 + ((rand.nextInt(2) % 2 == 0) ? 0 : 2);
		branchLength = 2 + rand.nextInt(3);
		genTreeSection(lowerY, upperY, numBranches, branchLength, position, rand);
		
		for(BlockPos pos : takenOriginPos){
			genLeafNode(pos);
		}
		
		// Check if tree fits in world
		if(position.getY() >= 1 && position.getY() + height + 1 <= worldIn.getHeight()){
			for(BlockPos pos : leafBlockList){
				if(!this.isReplaceable(worldIn, pos)){
					return false;
				}
			}
			for(BlockPos pos : xTrunkBlockList){
				if(!this.isReplaceable(worldIn, pos)){
					return false;
				}
			}
			for(BlockPos pos : yTrunkBlockList){
				if(!this.isReplaceable(worldIn, pos)){
					return false;
				}
			}
			for(BlockPos pos : zTrunkBlockList){
				if(!this.isReplaceable(worldIn, pos)){
					return false;
				}
			}
		}else{
			return false;
		}
		
		BlockState state = worldIn.getBlockState(position.down());
		
		if(state.getBlock().canSustainPlant(state, worldIn, position.down(), Direction.UP, (IPlantable)Blocks.SAPLING) && position.getY() < worldIn.getHeight() - height - 1){
			state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
			for(BlockPos pos : leafBlockList){
				setBlockAndNotifyAdequately(worldIn, pos, metaLeaves);
			}
			for(BlockPos pos : yTrunkBlockList){
				setBlockAndNotifyAdequately(worldIn, pos, metaWood);
			}
			for(BlockPos pos : xTrunkBlockList){
				setBlockAndNotifyAdequately(worldIn, pos, metaWood.withProperty(LOG_AXIS, LogBlock.EnumAxis.X));
			}
			for(BlockPos pos : zTrunkBlockList){
				setBlockAndNotifyAdequately(worldIn, pos, metaWood.withProperty(LOG_AXIS, LogBlock.EnumAxis.Z));
			}
			
			return true;
		}else{
			return false;
		}
	}
	
	private void genTreeSection(int lowerY, int upperY, int numBranches, int branchLength, BlockPos position, Random rand){
		for(int i = 0; i < numBranches; ++i){
			// Strait Branch
			if(i == 0){
				int adjBranchLength = 2;
				int sideStart = rand.nextInt(2);
				int yStart = ThreadLocalRandom.current().nextInt(lowerY, upperY);
				int yEnd = yStart + 1 + rand.nextInt(2);
				
				// Mark one branch and reflect it across axises
				BlockPos start = position.add(-1, yStart, sideStart);
				BlockPos end = position.add(-1 - adjBranchLength, yEnd, sideStart);
				takenOriginPos.add(start);
				takenEndPos.add(end);
				genBranch(start, end, LogBlock.EnumAxis.X);
				genBranch(position.add(2, yStart, sideStart), position.add(2 + adjBranchLength, yEnd, sideStart), LogBlock.EnumAxis.X);
				genBranch(position.add(sideStart, yStart, -1), position.add(sideStart, yEnd, -1 - adjBranchLength), LogBlock.EnumAxis.Z);
				genBranch(position.add(sideStart, yStart, 2), position.add(sideStart, yEnd, 2 + adjBranchLength), LogBlock.EnumAxis.Z);
			}else{
				// Diagonal branches
				boolean validStart = false;
				boolean validEnd = false;
				int yStart = -1;
				int yEnd = -1;
				int sideStart = -1;
				int sideEnd = -1;
				while(!validStart){
					sideStart = rand.nextInt(2);
					yStart = ThreadLocalRandom.current().nextInt(lowerY, upperY);
					
					BlockPos tempStart = position.add(-1, yStart, sideStart);
					if(!takenOriginPos.contains(tempStart)){
						takenOriginPos.add(tempStart);
						validStart = true;
					}
				}
				while(!validEnd){
					sideEnd = (i % 2 == 0) ? ThreadLocalRandom.current().nextInt(-branchLength, 0) : ThreadLocalRandom.current().nextInt(0, branchLength);
					yEnd = (rand.nextInt(4) % 2 == 0) ? yStart + rand.nextInt(4) : yStart - rand.nextInt(4);
					
					if(yEnd < 6)
						yEnd = 6;
					
					BlockPos tempEnd = position.add(-1 - branchLength, yEnd, sideEnd);
					if(!takenEndPos.contains(tempEnd)){
						takenEndPos.add(tempEnd);
						validEnd = true;
					}
				}
				// -x
				genBranch(position.add(-1, yStart, sideStart), position.add(-1 - branchLength, yEnd, sideEnd), LogBlock.EnumAxis.X);
				// +x
				genBranch(position.add(2, yStart, sideStart), position.add(2 + branchLength, yEnd, sideEnd), LogBlock.EnumAxis.X);
				// -z
				genBranch(position.add(sideStart, yStart, -1), position.add(sideEnd, yEnd, -1 - branchLength), LogBlock.EnumAxis.Z);
				// +z
				genBranch(position.add(sideStart, yStart, 2), position.add(sideEnd, yEnd, 2 + branchLength), LogBlock.EnumAxis.Z);
			}
		}
	}
	
	private void genBranch(BlockPos origin, BlockPos end, LogBlock.EnumAxis logAxis){
		if(logAxis == LogBlock.EnumAxis.X){
			xTrunkBlockList.addAll(GenerationUtilities.GenerateTrunk(origin, end, 1));
		}else if(logAxis == LogBlock.EnumAxis.Y){
			yTrunkBlockList.addAll(GenerationUtilities.GenerateTrunk(origin, end, 1));
		}else{
			zTrunkBlockList.addAll(GenerationUtilities.GenerateTrunk(origin, end, 1));
		}
		genLeafNode(end.add(0, -1, 0));
	}
	
	private void genLeafNode(BlockPos origin){
		leafBlockList.addAll(GenerationUtilities.GenerateCircle(origin, 1, GenerationUtilities.GenType.FULL));
		leafBlockList.addAll(GenerationUtilities.GenerateCircle(origin.add(0, 1, 0), 3, GenerationUtilities.GenType.FULL));
		leafBlockList.add(origin.add(0, 2, 0));
		leafBlockList.add(origin.add(1, 2, 0));
		leafBlockList.add(origin.add(-1, 2, 0));
		leafBlockList.add(origin.add(0, 2, 1));
		leafBlockList.add(origin.add(0, 2, -1));
		leafBlockList.add(origin.add(0, 3, 0));
	}
}
