package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import de.hsuifa.xapi.xapi_plugin.xapi_plugin_base.mapping.EntityType;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.PackageableElement;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.magicdraw.uml.Finder;

public class EntityTypeMDImpl extends EntityType {

    public EntityTypeMDImpl(String baseUri, String entityTypeName, Class<?> associatedClass) {
        super(baseUri, entityTypeName, associatedClass);
    }

    public EntityTypeMDImpl(String baseUri, String entityTypeName, Class<?> associatedClass, boolean isLiteral) {
        super(baseUri, entityTypeName, associatedClass, isLiteral);
    }

    @Override
    public String getSpecificUriImplSpecific(Object specificElement) {
	
		if (!(specificElement instanceof BaseElement)) { return null; }
		
		return baseUri + "#" + ((BaseElement) specificElement).sGetID();

    }

    @Override
    protected Collection<Object> getAllEntitiesOfTypeImplSpecific() {

        // get current project
		Project project = Application.getInstance().getProjectsManager().getActiveProject();
		
		// narrow scope of search: remove auxiliary resources
		Collection<PackageableElement> modelRootElements = project.getPrimaryModel().getPackagedElement();
		
		List<Element> filteredModelRootElements= new ArrayList<Element>();
		for (PackageableElement modelRootElement: modelRootElements) {
			boolean add = true;
			for (Stereotype stereotypeOfRootElement : StereotypesHelper.getStereotypes(modelRootElement)) {
				if (stereotypeOfRootElement.getName().equals("auxiliaryResource")) { add = false; break;}
			}
			if (add) { filteredModelRootElements.add(modelRootElement); }
		}
		
		// create array of single class
		Class<?>[] classArray = { getAssoiciatedClass() };

		// find all objects, suppress warning for unchecked type casting, has been checked
		@SuppressWarnings("unchecked")
		Collection<Object> allEntitiesOfType = ((Collection<Object>) ((Collection<?>) Finder.byTypeRecursively()
				.find(filteredModelRootElements, classArray, true)));

		// return null if collection is empty
		if (allEntitiesOfType.isEmpty()) { return null; }
		
		// return result
		return allEntitiesOfType;

    }
    
}
