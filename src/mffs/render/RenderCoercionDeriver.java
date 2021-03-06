package mffs.render;

import mffs.ModularForceFieldSystem;
import mffs.base.TileEntityMFFS;
import mffs.render.model.ModelCoercionDeriver;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCoercionDeriver extends TileEntitySpecialRenderer
{
	public static final ResourceLocation TEXTURE_ON = new ResourceLocation(ModularForceFieldSystem.DOMAIN, ModularForceFieldSystem.MODEL_DIRECTORY + "coercionDeriver_on.png");
	public static final ResourceLocation TEXTURE_OFF = new ResourceLocation(ModularForceFieldSystem.DOMAIN, ModularForceFieldSystem.MODEL_DIRECTORY + "coercionDeriver_off.png");

	public static final ModelCoercionDeriver MODEL = new ModelCoercionDeriver();

	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		TileEntityMFFS tileEntity = (TileEntityMFFS) t;

		/**
		 * Render Model
		 */
		if (tileEntity.isActive())
		{
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_ON);
		}
		else
		{
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE_OFF);
		}

		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 1.95, z + 0.5);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(1.3f, 1.3f, 1.3f);

		MODEL.render(tileEntity.animation, 0.0625F);

		GL11.glPopMatrix();
	}
}