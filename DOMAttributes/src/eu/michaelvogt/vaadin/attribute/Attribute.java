package eu.michaelvogt.vaadin.attribute;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;

import eu.michaelvogt.vaadin.attribute.shared.attribute.AttributeState;

public class Attribute extends AbstractExtension {
    public Attribute(String attribute, String value) {
        getState().attribute = attribute;
        getState().value = value;
    }

    @Override
    protected AttributeState getState() {
        return (AttributeState) super.getState();
    }

    public String getAttribute() {
        return getState().attribute;
    }

    public void setAttribute(String attribute, String value) {
        if (attribute == null || value == null) {
            throw new IllegalArgumentException(
                    "Attribute and value can't be null");
        }

        getState().attribute = attribute;
        getState().value = value;
    }

    @Override
    public void extend(AbstractClientConnector target) {
        super.extend(target);
    }
}
