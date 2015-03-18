package de.madcyph3r.example.example.headerTypes;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import de.madcyph3r.example.R;
import de.madcyph3r.example.example.FragmentDummy;
import de.madcyph3r.example.example.FragmentInstruction;
import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawer;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialMenu;
import de.madcyph3r.materialnavigationdrawer.menu.item.MaterialSection;

public class ImageHeaderCustomHeightActivity extends MaterialNavigationDrawer {

    MaterialNavigationDrawer drawer = null;

    @Override
    public int headerType() {
        // set type. you get the available constant from MaterialNavigationDrawer class
        return MaterialNavigationDrawer.DRAWERHEADER_IMAGE;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        bundle.putString("instruction", "This example has an image header with a custom height in the drawer. " +
                "See the method headerType in the source code. And don't forget to call " +
                "setCustomMenu(), to set your menu and setDrawerHeaderImage(), to set your image.");

        drawer = this;

        MaterialMenu menu = new MaterialMenu();

        //create instruction fragment
        Fragment fragmentInstruction = new FragmentInstruction();
        fragmentInstruction.setArguments(bundle);

        // menu items
        MaterialSection instruction = this.newSection("Instruction", fragmentInstruction , false, menu);
        instruction.setFragmentTitle("Custom Header Custom Height");
        this.newDevisor(menu);
        this.newLabel("Label", false, menu);
        this.newSection("Section", new FragmentDummy(), false, menu);

        // set start index
        menu.setStartIndex(0);

        // set this menu
        this.setCustomMenu(menu);

        // set image for recycleview_header
        this.setDrawerHeaderImage(getResources().getDrawable(R.drawable.mat6), 100);
    }
}