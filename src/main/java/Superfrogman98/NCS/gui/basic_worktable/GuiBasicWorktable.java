package Superfrogman98.NCS.gui.basic_worktable;

import Superfrogman98.NCS.blocks.ModBlocks;
import Superfrogman98.NCS.tile_entities.TileEntityBasicWorktable;
import Superfrogman98.NCS.NexCorpSolutions;
import Superfrogman98.NCS.containers.ContainerBasicWorktable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Superfrogman98 on 5/26/2017.
 */
public class GuiBasicWorktable extends GuiContainer {
    public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    private static final ResourceLocation background = new ResourceLocation(NexCorpSolutions.modId, "textures/gui/basic_worktable_gui.png");

    public GuiBasicWorktable(TileEntityBasicWorktable tileEntity, ContainerBasicWorktable container) {
        super(container);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    public void onGuiClosed(){
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j){
        String name = I18n.format(ModBlocks.basicWorktable.getUnlocalizedName() + ".name");
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}
