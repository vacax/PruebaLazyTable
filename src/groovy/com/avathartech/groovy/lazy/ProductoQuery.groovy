package com.avathartech.groovy.lazy

import com.avathartech.domains.Productos
import org.vaadin.addons.lazyquerycontainer.AbstractBeanQuery
import org.vaadin.addons.lazyquerycontainer.QueryDefinition

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 10/02/13
 * Time: 03:48 PM
 * To change this template use File | Settings | File Templates.
 */
class ProductoQuery extends AbstractBeanQuery<Productos> {

    public ProductoQuery(QueryDefinition definition,
                         Map<String, Object> queryConfiguration, Object[] sortPropertyIds,
                         boolean[] sortStates) {
        super(definition, queryConfiguration, sortPropertyIds, sortStates);
    }

    /**
     *
     * @return
     */
    @Override
    protected Productos constructBean() {
        return new Productos();  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @return
     */
    @Override
    int size() {
        int cantidad=Productos.count;
        println("Las cantidad total es: $cantidad")
        return cantidad;  //Representa la cantidad de los productos.
    }

    /**
     *
     * @param i
     * @param i1
     * @return
     */
    @Override
    protected List<Productos> loadBeans(int startIndex, int count) {
        println("Recibiendo inicio: $startIndex, total: $count");
        def lista= Productos.list(offset: startIndex, max: count);
        println("La cantidad es: "+lista?.size());
        //println("Los valores: "+lista);
        return lista;
    }

    /**
     *
     * @param ts
     * @param ts1
     * @param ts2
     */
    @Override
    protected void saveBeans(List<Productos> ts, List<Productos> ts1, List<Productos> ts2) {
        //To change body of implemented methods use File | Settings | File Templates.
        println("Sin implementar...")
    }
}
