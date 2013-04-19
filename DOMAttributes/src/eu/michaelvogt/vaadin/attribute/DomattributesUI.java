package eu.michaelvogt.vaadin.attribute;

import java.util.UUID;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class DomattributesUI extends UI {
    private static final String LABEL_ID = UUID.randomUUID().toString();
    private static final String FIELD_ID = UUID.randomUUID().toString();

    @Override
    protected void init(VaadinRequest request) {
        final GridLayout layout = new GridLayout(5, 5);
        layout.setMargin(true);
        setContent(layout);

        Label label = new Label("First Name:");
        label.setId(LABEL_ID);
        layout.addComponent(label, 2, 2);

        final TextField textField = new TextField();
        textField.setId(FIELD_ID);
        layout.addComponent(textField, 0, 2);

        Attribute fieldLabeled = new Attribute("aria-labelledby", LABEL_ID);
        fieldLabeled.extend(textField);

        final Attribute labelFor = new Attribute("for", FIELD_ID);
        labelFor.extend(label);

        Button button = new Button("Change Field ID");
        button.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                textField.setId("myownid");
                labelFor.setAttribute("for", "myownid");
            }
        });
        layout.addComponent(button, 4, 3);
    }
}