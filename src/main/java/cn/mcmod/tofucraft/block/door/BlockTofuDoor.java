package cn.mcmod.tofucraft.block.door;

import cn.mcmod.tofucraft.CommonProxy;
import cn.mcmod.tofucraft.block.BlockLoader;
import cn.mcmod.tofucraft.item.ItemLoader;
import cn.mcmod.tofucraft.material.TofuType;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockTofuDoor extends BlockDoor {

    private TofuType tofuType;

    public BlockTofuDoor(Material material,TofuType tofuType)
    {
        super(material);
        this.tofuType = tofuType;
        this.setCreativeTab(CommonProxy.tab);
        if(material== Material.WOOD) {
            this.setSoundType(SoundType.CLOTH);
            if(tofuType == TofuType.kinu){
                this.setHardness(0.6F);
                this.setResistance(2.0F);
            }else {
                this.setHardness(0.4F);
                this.setResistance(1.0F);
            }
        }else {
            if(material== Material.IRON){
                this.setSoundType(SoundType.METAL);
                this.setHardness(5.0F);
                this.setResistance(11.0F);
            }else {
                this.setSoundType(SoundType.STONE);
                this.setHardness(1.8F);
                this.setResistance(9.0F);
            }
        }
    }

    @Override
    public void onFallenUpon(World par1World, BlockPos pos, Entity par5Entity, float par6)
    {
        if (this.tofuType == TofuType.kinu)
        {
           /* TofuBlockUtils.onFallenUponFragileTofu(par1World, par5Entity, this, par6, tofuWeightingHandler);*/
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null :  this.getItem();
    }


    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {

        return new ItemStack(this.getItem());

    }

    private Item getItem()
    {
        if (this == BlockLoader.TOFUKINU_DOOR)
        {
            return ItemLoader.TOFUKINU_DOOR;
        }
        else if (this == BlockLoader.TOFUMOMEN_DOOR)
        {
            return ItemLoader.TOFUMOMEN_DOOR;
        }
        else if (this == BlockLoader.TOFUISHI_DOOR)
        {
            return ItemLoader.TOFUISHI_DOOR;
        }
        else if (this == BlockLoader.TOFUMETAL_DOOR)
        {
            return ItemLoader.TOFUMETAL_DOOR;
        }
        else
        {
            return ItemLoader.TOFUKINU_DOOR;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public TofuType getTofuType()
    {
        return this.tofuType;
    }

}
