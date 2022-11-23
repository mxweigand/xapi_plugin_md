package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import de.hsuifa.xapi.xapi_plugin.xapi_plugin_base.triple_service.TripleService;

public class TripleServiceMDImpl extends TripleService {
    
    public TripleServiceMDImpl() {
        super(new TripleHelperMDImpl());
    }

}
