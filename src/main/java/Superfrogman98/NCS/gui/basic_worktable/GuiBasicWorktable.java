package Superfrogman98.NCS.gui.basic_worktable;

import Superfrogman98.NCS.blocks.tile_entities.TileEntityBasicWorktable;
import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Superfrogman98 on 5/26/2017.
 */
public class GuiBasicWorktable extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;
    private static final ResourceLocation background = new ResourceLocation(NexCorpSolutions.modId, "textures/gui/testcontainer.png");

    public GuiBasicWorktable(TileEntityBasicWorktable tileEntity, ContainerBasicWorktable container) {
        super(container);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}
