package cn.mcmod.tofucraft.block.mecha;

import cn.mcmod.tofucraft.CommonProxy;
import cn.mcmod.tofucraft.tileentity.tofuenergy.worker.TileEntityRadiator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTFRadiator extends Block {
    public BlockTFRadiator() {
        super(Material.IRON);
        setCreativeTab(CommonProxy.tab);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityRadiator();
    }
}
