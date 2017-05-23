package Superfrogman98.NCS.Items;

import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class ItemOre extends ItemBase implements ItemOreDict {

    private String oreName;

    public ItemOre(String name, String oreName){
        super(name);

        this.oreName = oreName;
    }

    @Override
    public void initOreDict(){
        OreDictionary.registerOre(oreName,this);
    }


}
