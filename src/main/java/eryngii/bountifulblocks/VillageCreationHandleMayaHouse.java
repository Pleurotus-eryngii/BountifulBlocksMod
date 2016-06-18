package eryngii.bountifulblocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class VillageCreationHandleMayaHouse  implements IVillageCreationHandler {
	 
		@Override
		public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) {
			/*
			 * 詳細不明ですが構造物生成の重み付けをしているようです
			 */
			return new StructureVillagePieces.PieceWeight(getComponentClass(), 20, MathHelper.getRandomIntegerInRange(random, i, i+1));
		}
	 
		@Override
		public Class<?> getComponentClass() {
			/*
			 * 実際に構造物を生成するクラスを返却します
			 * ここでは今回新しく追加するサンプル村人用の家生成クラスを返却しています
			 */
			return ComponentVillageMayaHouse.class;
		}
	 
		@Override
	    public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
	    {
			StructureBoundingBox structureboundingbox = ComponentVillageMayaHouse.getStructureBoundingBox(par3, par4, par5, par6);
	        return StructureComponent.findIntersecting(par1List, structureboundingbox) == null ? new ComponentVillageMayaHouse(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6) : null;
		}

	}