package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.MDActionsCategory;

public class AMConfiguratorXapiImpl implements AMConfigurator {
  
    private NMAction action;

	public AMConfiguratorXapiImpl(NMAction action) {
		this.action = action;
	}

	@Override
	public void configure(ActionsManager manager) {
		
		// searching for tools action category
		MDActionsCategory category = (MDActionsCategory) manager.getActionFor("TOOLS");

		// add plugin to tools category
		category.addAction(action);
	
	}
	
	@Override
	public int getPriority() 
	{
		return AMConfigurator.MEDIUM_PRIORITY;
	}

}
