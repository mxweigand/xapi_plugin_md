package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;

import de.hsuifa.xapi.xapi_plugin.xapi_plugin_base.triple_service.TripleHelper;

public class TripleHelperMDImpl extends TripleHelper {

	/**
	 * constructor
	 */
    public TripleHelperMDImpl() {
		super(new TypeListMDImpl());    
    }

    /**
     * 
     * @param uri
     * @return
     */
    @Override
    public Object getEntityByUri(String uri) {
			
		// get current project
		Project project = Application.getInstance().getProjectsManager().getActiveProject();
		
		// abort if incorrect uri was given
		if (!(getBaseUri().equals(uri.substring(0, getBaseUri().length())))) { return null; }
		
		// extract elementID, which is everything following the #
		String elementID = uri.substring(uri.indexOf("#")+1);
		
		// find element
		// getElementByID returns null if not found
		Object returnEntity = project.getElementByID(elementID);
		
		// return 
		return returnEntity;

	}

}
