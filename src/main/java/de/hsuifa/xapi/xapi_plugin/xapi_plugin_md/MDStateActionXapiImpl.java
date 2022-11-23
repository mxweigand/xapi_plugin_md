package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import com.nomagic.magicdraw.actions.MDStateAction;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MDStateActionXapiImpl extends MDStateAction {
	
    private boolean activated;
	private XapiMDImpl xapi = new XapiMDImpl();

	public MDStateActionXapiImpl(String arg0, String menuText) {
		super(arg0, menuText, null, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		// changing state
		activated = !activated;
		
		// showing changes
		if (activated) {
			JOptionPane.showMessageDialog(MDDialogParentProvider.getProvider().getDialogOwner(), "xAPI activated");
			try {
				xapi.activate();
			} catch (IOException e1) {
				xapi.deactivate();
				activated = !activated;
				e1.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(MDDialogParentProvider.getProvider().getDialogOwner(), "xAPI deactivated");
			xapi.deactivate();
		}
		
	}

	@Override
	public void updateState() {
		setState(activated);
	}

}