package hu.rendszerfejlesztes.ui.views.admin.products;

import static hu.rendszerfejlesztes.ui.utils.BakeryConst.PAGE_PRODUCTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import hu.rendszerfejlesztes.backend.data.Role;
import hu.rendszerfejlesztes.backend.data.entity.Product;
import hu.rendszerfejlesztes.backend.data.entity.util.EntityUtil;
import hu.rendszerfejlesztes.ui.MainView;
import hu.rendszerfejlesztes.ui.components.SearchBar;
import hu.rendszerfejlesztes.ui.crud.CrudEntityPresenter;
import hu.rendszerfejlesztes.ui.crud.CrudView;
import hu.rendszerfejlesztes.ui.utils.BakeryConst;
import hu.rendszerfejlesztes.ui.utils.converters.CurrencyFormatter;

@Tag("products-view")
@HtmlImport("src/views/admin/products/products-view.html")
@Route(value = PAGE_PRODUCTS, layout = MainView.class)
@PageTitle(BakeryConst.TITLE_PRODUCTS)
@Secured(Role.ADMIN)
public class ProductsView extends CrudView<Product, TemplateModel>  {

	@Id("search")
	private SearchBar search;

	@Id("grid")
	private Grid<Product> grid;

	private CrudEntityPresenter<Product> presenter;

	private final BeanValidationBinder<Product> binder = new BeanValidationBinder<>(Product.class);

	private CurrencyFormatter currencyFormatter = new CurrencyFormatter();

	@Autowired
	public ProductsView(CrudEntityPresenter<Product> presenter, ProductForm form) {
		super(EntityUtil.getName(Product.class), form);
		this.presenter = presenter;
		form.setBinder(binder);

		setupEventListeners();
		setupGrid();
		presenter.setView(this);
	}

	private void setupGrid() {
		grid.addColumn(Product::getName).setHeader("Product Name").setFlexGrow(10);
		grid.addColumn(p -> currencyFormatter.encode(p.getPrice())).setHeader("Unit Price");
	}

	@Override
	public Grid<Product> getGrid() {
		return grid;
	}

	@Override
	protected CrudEntityPresenter<Product> getPresenter() {
		return presenter;
	}

	@Override
	protected String getBasePage() {
		return PAGE_PRODUCTS;
	}

	@Override
	protected BeanValidationBinder<Product> getBinder() {
		return binder;
	}

	@Override
	protected SearchBar getSearchBar() {
		return search;
	}
}
