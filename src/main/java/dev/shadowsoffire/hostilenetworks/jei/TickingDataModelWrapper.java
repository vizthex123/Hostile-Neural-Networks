package dev.shadowsoffire.hostilenetworks.jei;

import dev.shadowsoffire.hostilenetworks.Hostile;
import dev.shadowsoffire.hostilenetworks.data.DataModel;
import dev.shadowsoffire.hostilenetworks.data.ModelTier;
import dev.shadowsoffire.hostilenetworks.item.DataModelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class TickingDataModelWrapper {

    final DataModel src;
    final ItemStack model;
    final Ingredient input;
    final ItemStack baseDrop;
    final ItemStack prediction;

    ModelTier currentTier = ModelTier.BASIC;

    public TickingDataModelWrapper(DataModel src) {
        this.src = src;
        this.model = new ItemStack(Hostile.Items.DATA_MODEL);
        DataModelItem.setStoredModel(this.model, src);
        DataModelItem.setData(this.model, src.getTierData(ModelTier.BASIC));
        this.input = src.input();
        this.baseDrop = src.baseDrop().copy();
        this.prediction = src.getPredictionDrop();
    }

    void setTier(ModelTier tier) {
        if (this.currentTier == tier) return;
        DataModelItem.setData(this.model, src.getTierData(tier));
        this.currentTier = tier;
    }

}
