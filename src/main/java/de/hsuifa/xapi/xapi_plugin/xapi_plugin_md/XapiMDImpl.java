package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import com.nomagic.magicdraw.core.Application;

import de.hsuifa.xapi.xapi_plugin.xapi_plugin_base.xapi.Xapi;

public class XapiMDImpl extends Xapi {

    public XapiMDImpl() {
        super(new TripleServiceMDImpl());
    }

    @Override
    protected Boolean tboxServiceAvailable() {
        // tbox service is already available once plugin is loaded
        return true;
    }

    @Override
    protected Boolean tripleServiceAvailable() {
        // triple service is available once a project is active, so check for number of active projects
        int numberActiveProjects = Application.getInstance().getProjectsManager().getProjects().size();
        return (numberActiveProjects>0); 
    }

}
