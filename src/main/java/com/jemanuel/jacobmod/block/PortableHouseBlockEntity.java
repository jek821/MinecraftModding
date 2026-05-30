package com.jemanuel.jacobmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.NotNull;

public class PortableHouseBlockEntity extends BlockEntity{

    // Constructor
    public PortableHouseBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state){
        super(type, pos, state);
    }

    @Override
    protected void saveAdditional(@NotNull ValueOutput output){
        System.out.println("Saved Portable House Block Entity");
    }

    @Override
    protected void loadAdditional(@NotNull ValueInput input) {
        System.out.println("Loaded Portable House Block Entity");
    }
}
