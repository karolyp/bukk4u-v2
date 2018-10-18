package hu.rendszerfejlesztes.ui.views.storefront.events;

import com.vaadin.flow.component.ComponentEvent;
import hu.rendszerfejlesztes.ui.views.orderedit.OrderItemsEditor;

public class NewEditorEvent extends ComponentEvent<OrderItemsEditor> {

	public NewEditorEvent(OrderItemsEditor component) {
		super(component, false);
	}
}