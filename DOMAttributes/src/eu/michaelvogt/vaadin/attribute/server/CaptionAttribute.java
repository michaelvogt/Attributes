package eu.michaelvogt.vaadin.attribute.server;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;

import eu.michaelvogt.vaadin.attribute.shared.attribute.CaptionAttributeState;

public class CaptionAttribute extends AbstractExtension {
    public CaptionAttribute(AbstractClientConnector captionConnector) {
        getState().captionConnector = captionConnector;
    }

    @Override
    protected CaptionAttributeState getState() {
        return (CaptionAttributeState) super.getState();
    }

    @Override
    public void extend(AbstractClientConnector target) {
        super.extend(target);
    }
}
