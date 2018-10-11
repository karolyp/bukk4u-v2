package bookstore.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import bookstore.model.Customer;
import bookstore.service.TestService;

@Route
public class MainView extends VerticalLayout {
    private static final long serialVersionUID = 6951155106810692771L;

    //backend services
    private TestService testService;

    //layouts
    private HorizontalLayout actions;

    //elements
    private Grid<Customer> grid;
    private TextField      filter;
    private Button         addNewBtn;

    public MainView(TestService testService) {
        this.testService = testService;
        initializeComponents();
        manageLayout();
    }

    private void manageLayout() {
        grid.setColumnReorderingAllowed(true);
        grid.setItems(testService.listCustomers());

        filter.setPlaceholder("Filter by last name");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> grid.setItems(testService.listCustomCustomers(e.getValue())));

        addNewBtn.addClickListener(e -> testService.addCustomer());

        add(actions, grid); //a paraméterek olyan sorrendben jelennek meg a lapon, amilyen sorrendben hozzáadtuk őket
        setSizeFull();
    }

    private void initializeComponents() {
        grid = new Grid<>(Customer.class);
        filter = new TextField();
        addNewBtn = new Button("New Customer", VaadinIcon.PLUS.create());
        actions = new HorizontalLayout(filter, addNewBtn);
    }
}
