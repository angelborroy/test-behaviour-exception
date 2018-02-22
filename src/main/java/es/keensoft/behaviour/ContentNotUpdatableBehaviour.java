package es.keensoft.behaviour;

import org.alfresco.error.AlfrescoRuntimeException;
import org.alfresco.model.ContentModel;
import org.alfresco.repo.content.ContentServicePolicies;
import org.alfresco.repo.policy.Behaviour;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.service.cmr.repository.ContentData;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;

public class ContentNotUpdatableBehaviour implements ContentServicePolicies.OnContentPropertyUpdatePolicy {
	
	private PolicyComponent policyComponent;
	
    public void init() {
        policyComponent.bindClassBehaviour(ContentServicePolicies.OnContentPropertyUpdatePolicy.QNAME, 
        		ContentModel.TYPE_CONTENT, 
        		new JavaBehaviour(this, "onContentPropertyUpdate", Behaviour.NotificationFrequency.FIRST_EVENT));
    }
    
	@Override
	public void onContentPropertyUpdate(NodeRef nodeRef, QName propertyQName, ContentData beforeValue,
			ContentData afterValue) {
		throw new AlfrescoRuntimeException("My custom message from repo!"); 
	}
	
	public void setPolicyComponent(PolicyComponent policyComponent) {
		this.policyComponent = policyComponent;
	}
	
}
