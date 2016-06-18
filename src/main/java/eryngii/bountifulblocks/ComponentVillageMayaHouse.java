package eryngii.bountifulblocks;


import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentVillageMayaHouse extends StructureVillagePieces.Road{
		 
	

    private StructureVillagePieces.Start startPiece;
    
			protected ComponentVillageMayaHouse(StructureVillagePieces.Start par1ComponentVillageStartPiece, int par2, 
					Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5) {
				super(par1ComponentVillageStartPiece, par2);
				this.startPiece = par1ComponentVillageStartPiece;
                this.coordBaseMode = par5;
                this.boundingBox = par4StructureBoundingBox;
			}
		    public static StructureBoundingBox getStructureBoundingBox(int par3, int par4, int par5, int par6)
		    {
		        //return StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, -4, 0, 9, 6, 7, par6);
		    	return StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 9, 9, 6, par6);
		    }
		    
			@Override
			public boolean addComponentParts(World world, Random random,
					StructureBoundingBox structureboundingbox) {
				if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(world, structureboundingbox);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
                }

                this.fillWithBlocks(world, structureboundingbox, 1, 1, 1, 7, 5, 4, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(world, structureboundingbox, 0, 0, 0, 8, 0, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 0, 5, 0, 8, 5, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 0, 6, 1, 8, 6, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 0, 7, 2, 8, 7, 3, Blocks.cobblestone, Blocks.cobblestone, false);
                int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
                int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
                int k;
                int l;

                for (k = -1; k <= 2; ++k)
                {
                    for (l = 0; l <= 8; ++l)
                    {
                        this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, i, l, 6 + k, k, structureboundingbox);
                        this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, j, l, 6 + k, 5 - k, structureboundingbox);
                    }
                }

                this.fillWithBlocks(world, structureboundingbox, 0, 1, 0, 0, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 1, 1, 5, 8, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 8, 1, 0, 8, 1, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 2, 1, 0, 7, 1, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 0, 2, 0, 0, 4, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 0, 2, 5, 0, 4, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 8, 2, 5, 8, 4, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 8, 2, 0, 8, 4, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(world, structureboundingbox, 0, 2, 1, 0, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(world, structureboundingbox, 1, 2, 5, 7, 4, 5, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(world, structureboundingbox, 8, 2, 1, 8, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(world, structureboundingbox, 1, 2, 0, 7, 4, 0, Blocks.planks, Blocks.planks, false);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 2, 0, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 5, 2, 0, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 2, 0, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 3, 0, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 5, 3, 0, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 3, 0, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 2, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 3, 2, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 3, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 2, 2, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 2, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 3, 2, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 3, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 2, 5, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 3, 2, 5, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 5, 2, 5, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 2, 5, structureboundingbox);
                this.fillWithBlocks(world, structureboundingbox, 1, 4, 1, 7, 4, 1, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(world, structureboundingbox, 1, 4, 4, 7, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(world, structureboundingbox, 1, 3, 4, 7, 3, 4, Blocks.bookshelf, Blocks.bookshelf, false);
                this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 7, 1, 4, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 0), 7, 1, 3, structureboundingbox);
                k = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, k, 6, 1, 4, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, k, 5, 1, 4, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, k, 4, 1, 4, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, k, 3, 1, 4, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 1, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.wooden_pressure_plate, 0, 6, 2, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 1, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.wooden_pressure_plate, 0, 4, 2, 3, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, BountifulBlocksCore.blockCannabisContainer, 0, 7, 1, 1, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 1, 0, structureboundingbox);
                this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 0, structureboundingbox);
                this.placeDoorAtCurrentPosition(world, structureboundingbox, random, 1, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));

                if (this.getBlockAtCurrentPosition(world, 1, 0, -1, structureboundingbox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 1, -1, -1, structureboundingbox).getMaterial() != Material.air)
                {
                    this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 1, 0, -1, structureboundingbox);
                }

                for (l = 0; l < 6; ++l)
                {
                    for (int i1 = 0; i1 < 9; ++i1)
                    {
                        this.clearCurrentPositionBlocksUpwards(world, i1, 9, l, structureboundingbox);
                        this.func_151554_b(world, Blocks.cobblestone, 0, i1, -1, l, structureboundingbox);
                    }
                }

                this.spawnVillagers(world, structureboundingbox, 2, 1, 2, 1);
                return true;
            }
		 
			 
		 
			@Override
			protected int getVillagerType(int par1) {
				/*
				 * 今回追加した村人用の家であることを示します
				 * このメソッドの戻り値に基いた職業の村人がスポーンします
				 */
				return BountifulBlocksCore.mayaVillagerProfession;
			}
		 
		}

