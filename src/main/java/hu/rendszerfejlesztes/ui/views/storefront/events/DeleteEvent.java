package hu.rendszerfejlesztes.ui.views.storefront.events;

import com.vaadin.flow.component.ComponentEvent;
import hu.rendszerfejlesztes.ui.views.orderedit.OrderItemEditor;

public class DeleteEvent extends ComponentEvent<OrderItemEditor> {
	public DeleteEvent(OrderItemEditor component) {
		super(component, false);
	}
}