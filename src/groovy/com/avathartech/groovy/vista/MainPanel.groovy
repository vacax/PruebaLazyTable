package com.avathartech.groovy.vista

import com.avathartech.domains.Productos
import com.avathartech.groovy.lazy.MiProductoFactory
import com.avathartech.groovy.lazy.ProductoQuery
import com.avathartech.groovy.otrolazy.ProductoDAO
import com.avathartech.groovy.otrolazy.ProductoSearchCriteria
import com.jensjansson.pagedtable.ControlsLayout
import com.jensjansson.pagedtable.PagedTable
import com.vaadin.ui.Panel
import com.vaadin.ui.TabSheet
import com.vaadin.ui.Table
import com.vaadin.ui.VerticalLayout
import org.vaadin.addons.lazycontainer.LazyBeanContainer
import org.vaadin.addons.lazyquerycontainer.BeanQueryFactory
import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer
import org.vaadin.addons.lazyquerycontainer.LazyQueryDefinition

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 10/02/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
class MainPanel extends Panel {

    Table tablaSinPaginacion;
    Table tablaConPaginacion;
    PagedTable tablaPaginacion;
    TabSheet tabSheet;


    /**
     *
     */
    public MainPanel(){

        VerticalLayout mainLayout = new VerticalLayout()
        mainLayout.setSizeFull()
        mainLayout.setSpacing(true)
        mainLayout.setMargin(true)

        tablaSinPaginacion=new Table();
        tablaSinPaginacion.addContainerProperty("Producto", String.class, null);
        tablaSinPaginacion.addContainerProperty("Descripcion", String.class, null);
        tablaSinPaginacion.addContainerProperty("Referencia", String.class, null);
        tablaSinPaginacion.addContainerProperty("Costo", BigDecimal.class, null);
        tablaSinPaginacion.addContainerProperty("Cantidad", Integer.class, null);
        tablaSinPaginacion.setWidth("100%");
        tablaSinPaginacion.setSizeFull();

        //Llenando los valores.
        def productos=Productos.list(max: 100);
        productos.each { producto->
            tablaSinPaginacion.addItem([producto.nombre, producto.descripcion, producto.referencia, producto.costo, producto.cantidad] as Object[], producto)
        }

        tablaConPaginacion=new Table();

        //Probando el otro sin resultado optimo...
       /* BeanQueryFactory<ProductoQuery> queryFactory=new BeanQueryFactory<ProductoQuery>(ProductoQuery.class);
        //LazyQueryContainer container=new LazyQueryContainer(new MiProductoFactory(), null, 25, true);

        LazyQueryContainer container=new LazyQueryContainer(new LazyQueryDefinition(true, 25, "Index"), new MiProductoFactory());

        tablaConPaginacion.setContainerDataSource(container);

        //tablaConPaginacion.setPageLength(50);
        //tablaConPaginacion.setId("id");

        tablaConPaginacion.addContainerProperty("nombre", String.class, "nombre");
        tablaConPaginacion.addContainerProperty("descripcion", String.class, "");
        tablaConPaginacion.addContainerProperty("referencia", String.class, "");
        tablaConPaginacion.addContainerProperty("costo", BigDecimal.class, new BigDecimal("1.0"));
        tablaConPaginacion.addContainerProperty("cantidad", Integer.class, 1);
        tablaConPaginacion.setVisibleColumns(["nombre", "descripcion","referencia", "costo", "cantidad"] as Object[]);
        tablaConPaginacion.setColumnHeaders(["nombre", "descripcion","referencia", "costo", "cantidad"] as String[])*/

        //
        tablaPaginacion=new PagedTable("Ejemplo de tabla Paginacion");
        ControlsLayout control=tablaPaginacion.createControls();

        LazyBeanContainer container=new LazyBeanContainer(Productos.class, new ProductoDAO(), new ProductoSearchCriteria());
        tablaPaginacion.setContainerDataSource(container);

        VerticalLayout layoutTabla = new VerticalLayout();
        tablaPaginacion.setWidth("100%")
        control.setWidth("100%");
        layoutTabla.addComponent(tablaPaginacion);
        layoutTabla.addComponent(control);

        tabSheet=new TabSheet();
        tabSheet.setWidth("100%");
        tabSheet.setHeight("100%");

        tabSheet.addTab(tablaSinPaginacion, "Sin paginacion");
        tabSheet.addTab(tablaConPaginacion, "Con paginacion");
        tabSheet.addTab(layoutTabla, "Paginación Funcioando");

        mainLayout.addComponent(tabSheet);

        this.setSizeFull();
        this.setContent(mainLayout);

    }
}
