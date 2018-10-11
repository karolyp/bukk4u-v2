package hu.rendszerfejlesztes.konyvtar.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import hu.rendszerfejlesztes.konyvtar.model.Customer;
import hu.rendszerfejlesztes.konyvtar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {
    private static final long serialVersionUID = 6951155106810692771L;

    //backend services
    private CustomerService customerService;

    //layouts
    private HorizontalLayout actions;

    //elements
    private Grid<Customer> grid;
    private TextField filter;
    private Button addNewBtn;

    public MainView(CustomerService customerService) {
        this.customerService = customerService;
        initializeComponents();
        manageLayout();
    }

    private void manageLayout() {
        grid.setColumnReorderingAllowed(true);
        grid.setItems(customerService.findAll());

        filter.setPlaceholder("Filter by last name");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> grid.setItems(customerService.findByLastName(e.getValue())));

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
