package burn447.dartcraftReloaded.Items.Tools;

import burn447.dartcraftReloaded.dartcraftReloaded;
import burn447.dartcraftReloaded.util.References;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static burn447.dartcraftReloaded.dartcraftReloaded.forceToolMaterial;
import static burn447.dartcraftReloaded.util.References.MODIFIERS.*;

/**
 * Created by BURN447 on 5/13/2018.
 */
public class ItemForcePickaxe extends ItemToolBase {

    private static String name;

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE);

    public List<References.MODIFIERS> applicableModifers = new ArrayList<>();

    public ItemForcePickaxe(String name) {
        super(name, 1, -2.8F, forceToolMaterial, EFFECTIVE_ON);
        setApplicableModifers();
        this.attackDamage = 2.0F;
        this.name = name;
    }

    @Override
    public void registerItemModel() {
        dartcraftReloaded.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        {
            Block block = blockIn.getBlock();

            if (block == Blocks.OBSIDIAN) {
                return this.toolMaterial.getHarvestLevel() == 3;
            } else if (block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE) {
                if (block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK) {
                    if (block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE) {
                        if (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE) {
                            if (block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE) {
                                if (block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE) {
                                    Material material = blockIn.getMaterial();

                                    if (material == Material.ROCK) {
                                        return true;
                                    } else if (material == Material.IRON) {
                                        return true;
                                    } else {
                                        return material == Material.ANVIL;
                                    }
                                } else {
                                    return this.toolMaterial.getHarvestLevel() >= 2;
                                }
                            } else {
                                return this.toolMaterial.getHarvestLevel() >= 1;
                            }
                        } else {
                            return this.toolMaterial.getHarvestLevel() >= 1;
                        }
                    } else {
                        return this.toolMaterial.getHarvestLevel() >= 2;
                    }
                } else {
                    return this.toolMaterial.getHarvestLevel() >= 2;
                }
            } else {
                return this.toolMaterial.getHarvestLevel() >= 2;
            }
        }
    }

    public void setApplicableModifers() {
        applicableModifers.add(MOD_CHARGE);
        applicableModifers.add(MOD_CHARGEII);
        applicableModifers.add(MOD_HEAT);
        applicableModifers.add(MOD_LUCK);
        applicableModifers.add(MOD_GRINDING);
        applicableModifers.add(MOD_TOUCH);
        applicableModifers.add(MOD_STURDY);
        applicableModifers.add(MOD_REPAIR);
        applicableModifers.add(MOD_SPEED);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {

        return super.initCapabilities(stack, nbt);
    }
}
