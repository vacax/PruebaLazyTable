package com.avathartech.groovy.otrolazy

import com.avathartech.domains.Productos
import org.vaadin.addons.lazycontainer.DAO
import org.vaadin.addons.lazycontainer.OrderByColumn
import org.vaadin.addons.lazycontainer.SearchCriteria

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 10/02/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
class ProductoDAO implements DAO<Productos> {


    @Override
    int count(SearchCriteria searchCriteria) {

        return Productos.count;
    }

    @Override
    List<Productos> find(SearchCriteria searchCriteria, int startIndex, int numberOfId, List<OrderByColumn> orderByColumns) {
        println("La cantidad Inicio: $startIndex, Cantidad maximo: $numberOfId")
        return Productos.list(max: numberOfId, offset: startIndex);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
