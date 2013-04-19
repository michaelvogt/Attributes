Attributes
==========

Add attributes to Vaadin Components

Sometimes it is necessary to (virtually) have direct access to the browser from the Vaadin server side. Something that comes up again and again is when a Vaadin component does not allow to use a certain Browser feature that is available simply by setting an attribute to the DOM element.

Now, with this Vaadin Extension this is possible. Just instantiate an Attribute object, and extend the Component where you want to set the attribute to.

        GridLayout layout = new GridLayout(5, 5);
        
        Label label = new Label("First Name:");
        layout.addComponent(label, 2, 2);

        final Attribute labelFor = new Attribute("for", FIELD_ID);
        labelFor.extend(label);

This is only the first release, and certainly doesn't work with all Vaadin Components the way one might expect. Feel free to provide feedback when you have a certain usecase where you would like to use this add-on for, that isn't possible, yet.
