package de.hsuifa.xapi.xapi_plugin.xapi_plugin_md;

import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.CallBehaviorAction;
import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.InputPin;
import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.OutputPin;
import com.nomagic.uml2.ext.magicdraw.actions.mdintermediateactions.ValueSpecificationAction;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityFinalNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ControlFlow;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.InitialNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ObjectFlow;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.activities.mdintermediateactivities.ForkNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdintermediateactivities.JoinNode;
import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ElementValue;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceValue;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralInteger;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralReal;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import de.hsuifa.xapi.xapi_plugin.xapi_plugin_base.mapping.EntityType;
import de.hsuifa.xapi.xapi_plugin.xapi_plugin_base.mapping.RelationType;
import de.hsuifa.xapi.xapi_plugin.xapi_plugin_base.mapping.TypeList;


public class TypeListMDImpl extends TypeList {

    public TypeListMDImpl() {
		super("http://www.hsu-ifa.de/ontologies/cameo");
	}

	@Override
    protected void addTypes() {

        // entity types (resources)
		EntityType entityTypeControlFlow = addNewEntityType("ControlFlow",ControlFlow.class); 
		EntityType entityTypeCallBehaviorAction = addNewEntityType("CallBehaviorAction",CallBehaviorAction.class); 
		EntityType entityTypeSlot = addNewEntityType("Slot",Slot.class); 
		EntityType entityTypeProperty = addNewEntityType("Property",Property.class); 
		EntityType entityTypeLiteralReal = addNewEntityType("LiteralReal",LiteralReal.class);
        EntityType entityTypeLiteralInteger = addNewEntityType("LiteralInteger",LiteralInteger.class); 
		EntityType entityTypeInstanceSpecification = addNewEntityType("InstanceSpecification",InstanceSpecification.class); 
		EntityType entityTypeInstanceValue = addNewEntityType("InstanceValue",InstanceValue.class); 
		EntityType entityTypeValueSpecificationAction = addNewEntityType("ValueSpecificationAction",ValueSpecificationAction.class); 
		EntityType entityTypeOutputPin = addNewEntityType("OutputPin",OutputPin.class); 
		EntityType entityTypeInputPin = addNewEntityType("InputPin",InputPin.class); 
		EntityType entityTypeObjectFlow = addNewEntityType("ObjectFlow",ObjectFlow.class); 
		EntityType entityTypeJoinNode = addNewEntityType("JoinNode",JoinNode.class); 
		EntityType entityTypeActivityFinalNode = addNewEntityType("ActivityFinalNode",ActivityFinalNode.class); 
		EntityType entityTypeActivity = addNewEntityType("Activity",Activity.class); 
		EntityType entityTypeInitialNode = addNewEntityType("InitialNode",InitialNode.class); 
		EntityType entityTypeForkNode = addNewEntityType("ForkNode",ForkNode.class); 
		EntityType entityTypeMDClass = addNewEntityType("MDClass",com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class); 
		EntityType entityTypeClassifier = addNewEntityType("Classifier", Classifier.class);
		EntityType entityTypeAllocation = addNewEntityType("Allocation",Abstraction.class); 
		EntityType entityTypeStereotype = addNewEntityType("Stereotype",Stereotype.class); 
		EntityType entityTypeElementValue = addNewEntityType("ElementValue",ElementValue.class); 

        // entity types (literals)		
		EntityType entityTypeDataTypeXSDDouble = addNewEntityType("DataTypeXSDDouble",Double.class,true); 
		EntityType entityTypeDataTypeXSDString = addNewEntityType("DataTypeXSDString",String.class,true);
        EntityType entityTypeDataTypeXSDInteger = addNewEntityType("DataTypeXSDInteger",Integer.class,true);

		// relation types
		relationTypeList.add(new RelationType(baseUri, "hasIncomingControlFlow",entityTypeActivityFinalNode,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ActivityFinalNode) subject).getIncoming();
			}
		});
        relationTypeList.add(new RelationType(baseUri, "hasIncomingControlFlow",entityTypeJoinNode,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((JoinNode) subject).getIncoming();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasIncomingControlFlow",entityTypeForkNode,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ForkNode) subject).getIncoming();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasIncomingControlFlow",entityTypeCallBehaviorAction,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((CallBehaviorAction) subject).getIncoming();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOutgoingControlFlow",entityTypeInitialNode,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InitialNode) subject).getOutgoing();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOutgoingControlFlow",entityTypeJoinNode,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((JoinNode) subject).getOutgoing();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOutgoingControlFlow",entityTypeForkNode,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ForkNode) subject).getOutgoing();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOutgoingControlFlow",entityTypeCallBehaviorAction,entityTypeControlFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((CallBehaviorAction) subject).getOutgoing();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasIncomingObjectFlow",entityTypeInputPin,entityTypeObjectFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InputPin) subject).getIncoming();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOutgoingObjectFlow",entityTypeOutputPin,entityTypeObjectFlow) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((OutputPin) subject).getOutgoing();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasInputPin",entityTypeCallBehaviorAction,entityTypeInputPin) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((CallBehaviorAction) subject).getInput();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOutputPin",entityTypeValueSpecificationAction,entityTypeOutputPin) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ValueSpecificationAction) subject).getOutput();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeJoinNode,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((JoinNode) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeActivityFinalNode,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ActivityFinalNode) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeInitialNode,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InitialNode) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeForkNode,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ForkNode) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeObjectFlow,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ObjectFlow) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeValueSpecificationAction,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ValueSpecificationAction) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeControlFlow,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ControlFlow) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasOwner",entityTypeCallBehaviorAction,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((CallBehaviorAction) subject).getOwner();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasBehavior",entityTypeCallBehaviorAction,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((CallBehaviorAction) subject).getBehavior();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasInstanceValue",entityTypeValueSpecificationAction,entityTypeInstanceValue) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ValueSpecificationAction) subject).getValue();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasSlot",entityTypeInstanceSpecification,entityTypeSlot) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InstanceSpecification) subject).getSlot();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasInstanceSpecification",entityTypeInstanceValue,entityTypeInstanceSpecification) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InstanceValue) subject).getInstance();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasValue",entityTypeLiteralReal,entityTypeDataTypeXSDDouble) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((LiteralReal) subject).getValue();
			}
		});
        relationTypeList.add(new RelationType(baseUri, "hasValue",entityTypeLiteralInteger,entityTypeDataTypeXSDInteger) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((LiteralInteger) subject).getValue();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasValue",entityTypeSlot,entityTypeLiteralReal) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Slot) subject).getValue();		
			}
		});
        relationTypeList.add(new RelationType(baseUri, "hasValue",entityTypeSlot,entityTypeElementValue) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Slot) subject).getValue();		
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasValue",entityTypeSlot,entityTypeInstanceValue) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Slot) subject).getValue();		
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasElement",entityTypeElementValue,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((ElementValue) subject).getElement();		
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasProperty",entityTypeSlot,entityTypeProperty) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Slot) subject).getDefiningFeature();		
			}
		}); 
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeCallBehaviorAction,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((CallBehaviorAction) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeActivity,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Activity) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeInputPin,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InputPin) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeOutputPin,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((OutputPin) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeProperty,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Property) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeMDClass,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeInstanceSpecification,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InstanceSpecification) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeStereotype,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Stereotype) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasName",entityTypeClassifier,entityTypeDataTypeXSDString) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Classifier) subject).getName();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasSupplier",entityTypeAllocation,entityTypeMDClass) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Abstraction) subject).getSupplier();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasClient",entityTypeAllocation,entityTypeActivity) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Abstraction) subject).getClient();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasClient",entityTypeAllocation,entityTypeCallBehaviorAction) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Abstraction) subject).getClient();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasAppliedStereotypeInstance",entityTypeCallBehaviorAction,entityTypeInstanceSpecification) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((CallBehaviorAction) subject).getAppliedStereotypeInstance();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasAppliedStereotypeInstance",entityTypeActivity,entityTypeInstanceSpecification) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((Activity) subject).getAppliedStereotypeInstance();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasAppliedStereotypeInstance",entityTypeMDClass,entityTypeInstanceSpecification) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) subject).getAppliedStereotypeInstance();
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasAppliedStereotype",entityTypeCallBehaviorAction,entityTypeStereotype) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return StereotypesHelper.getStereotypes((CallBehaviorAction) subject);
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasAppliedStereotype",entityTypeActivity,entityTypeStereotype) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return StereotypesHelper.getStereotypes((Activity) subject);
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasAppliedStereotype",entityTypeMDClass,entityTypeStereotype) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return StereotypesHelper.getStereotypes((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) subject);
			}
		});
		relationTypeList.add(new RelationType(baseUri, "hasClassifier",entityTypeInstanceSpecification,entityTypeClassifier) {
			public Object getObjectsForDefinedSubjectAppSpecific(Object subject) {	
				return ((InstanceSpecification) subject).getClassifier();
			}
		});

    } 

    /**
     * helper method
     * @param entityTypeName
     * @param associatedClass
     * @return
     */
    private EntityType addNewEntityType(String entityTypeName, Class<?> associatedClass) {

        EntityType newEntityType = new EntityTypeMDImpl(baseUri, entityTypeName, associatedClass);
        entityTypeList.add(newEntityType);
        return newEntityType;
        
    }

    /**
     * helper method
     * @param entityTypeName
     * @param associatedClass
     * @param isLiteral
     * @return
     */
    private EntityType addNewEntityType(String entityTypeName, Class<?> associatedClass, boolean isLiteral) {

        EntityType newEntityType = new EntityTypeMDImpl(baseUri, entityTypeName, associatedClass, isLiteral);
        entityTypeList.add(newEntityType);
        return newEntityType;
        
    }

}
