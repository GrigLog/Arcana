package net.arcanamod.blocks.bases.untainted;

import net.arcanamod.util.IHasModel;
import net.arcanamod.Arcana;
import net.arcanamod.blocks.ArcanaProperties;
import net.arcanamod.blocks.bases.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;

/**
 * Basic Untainted Block, all untainted block should either be this, or extend it
 *
 * @author Mozaran
 * @see BlockBase
 */
public class UntaintedBlockBase extends BlockBase implements IHasModel{
	public static final PropertyBool FULLYTAINTED = ArcanaProperties.FULLYTAINTED;
	
	public UntaintedBlockBase(String name, Material material){
		super(name, material);
		this.setDefaultState(this.getDefaultState().withProperty(ArcanaProperties.FULLYTAINTED, false));
	}
	
	@Override
	public int getMetaFromState(BlockState state){
		int i = 0;
		boolean tainted = state.getValue(FULLYTAINTED);
		
		if(tainted){
			i = 1;
		}else{
			i = 0;
		}
		
		return i;
	}
	
	@Override
	public BlockState getStateFromMeta(int meta){
		boolean tainted = false;
		int i = meta;
		
		if(i == 1){
			tainted = true;
		}else if(i == 0){
			tainted = false;
		}
		
		return this.getDefaultState().withProperty(FULLYTAINTED, tainted);
	}
	
	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, FULLYTAINTED);
	}
	
	@Override
	public void registerModels(){
		Arcana.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
