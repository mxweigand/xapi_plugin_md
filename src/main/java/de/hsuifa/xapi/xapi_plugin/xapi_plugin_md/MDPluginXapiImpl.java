package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.plugins.Plugin;

public class MDPluginXapiImpl extends Plugin {
	
    @Override
    public void init() {
    	// add option in menu bar/tools to start plugin     	
        ActionsConfiguratorsManager.getInstance().addMainMenuConfigurator(new AMConfiguratorXapiImpl(new MDStateActionXapiImpl("startxapi", "Start xAPI")));
    }
    
    @Override
    public boolean close() {
        return true;   
    }
    
    @Override
    public boolean isSupported() {	
        return true; 
    }

}
