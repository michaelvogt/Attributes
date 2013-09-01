package eu.michaelvogt.vaadin.attribute.client.attribute;

import com.google.gwt.user.client.Element;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

import eu.michaelvogt.vaadin.attribute.server.Attribute;
import eu.michaelvogt.vaadin.attribute.shared.attribute.AttributeState;

@Connect(Attribute.class)
public class AttributeConnector extends AbstractExtensionConnector {
    private Element currentElement;
    private String currentAttribute;
    private String currentValue;

    @Override
    protected void extend(ServerConnector target) {
        currentElement = ((ComponentConnector) target).getWidget().getElement();
        update();
    }

    @Override
    public AttributeState getState() {
        return (AttributeState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        if (stateChangeEvent.hasPropertyChanged("attribute")) {
            currentElement.removeAttribute(currentAttribute);
        }

        update();
    }

    private void update() {
        currentAttribute = getState().attribute;
        currentValue = getState().value;

        currentElement.setAttribute(currentAttribute, currentValue);
    }
}