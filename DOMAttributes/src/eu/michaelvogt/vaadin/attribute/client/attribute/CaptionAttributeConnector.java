package eu.michaelvogt.vaadin.attribute.client.attribute;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.aria.AriaHelper;
import com.vaadin.shared.ui.Connect;

import eu.michaelvogt.vaadin.attribute.server.CaptionAttribute;
import eu.michaelvogt.vaadin.attribute.shared.attribute.CaptionAttributeState;

@Connect(CaptionAttribute.class)
public class CaptionAttributeConnector extends AbstractExtensionConnector {
    private Widget currentWidget;

    @Override
    protected void extend(ServerConnector target) {
        currentWidget = ((ComponentConnector) target).getWidget();
    }

    @Override
    public CaptionAttributeState getState() {
        return (CaptionAttributeState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        update();
    }

    private void update() {
        AriaHelper.bindCaption(currentWidget,
                ((ComponentConnector) getState().captionConnector).getWidget()
                        .getElement());
    }

}
