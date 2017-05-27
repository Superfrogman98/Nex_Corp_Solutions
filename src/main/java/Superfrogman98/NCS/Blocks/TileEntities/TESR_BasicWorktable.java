package Superfrogman98.NCS.Blocks.TileEntities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;
import scala.collection.parallel.ParIterableLike;

/**
 * Created by Superfrogman98 on 5/26/2017.
 * renders the item on top of the basic worktable
 */
public class TESR_BasicWorktable extends TileEntitySpecialRenderer<TileEntityBasicWorktable> {
    @Override                                                                    //partialTicks, destroy stage
    public void renderTileEntityAt(TileEntityBasicWorktable te, double x, double y, double z, float p_180535_8_, int p_180535_9_) {
        ItemStack stack = te.itemStackHandler.getStackInSlot(0);
        if (stack != null ) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
            GlStateManager.enableBlend();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
            GlStateManager.pushMatrix();

            // checks if itemstack is block or item, used for determining offset, will have issuse with things like torches and ladders which                                                         are considered blocks but render like items in the inventory)
            if(stack.getItem() instanceof ItemBlock && Minecraft.getMinecraft().getRenderItem().shouldRenderItemIn3D(stack)){ // is block with 3d render
                GlStateManager.translate(x + 0.5, y + .935, z + 0.5);
                //GlStateManager.scale(1.3f,1.3,1f.3f);
            }else { // is item
                GlStateManager.translate(x + 0.5, y + 1.015, z + 0.45);
                GlStateManager.rotate(180,0,1,1);// makes the item flat, need to set this up so that it faces the front of the workbench
            }
            IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, te.getWorld(), null);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);

            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }

}
