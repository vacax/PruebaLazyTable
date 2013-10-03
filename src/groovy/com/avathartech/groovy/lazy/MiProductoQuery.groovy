package com.avathartech.groovy.lazy

import com.avathartech.domains.Productos
import com.vaadin.data.Item
import com.vaadin.data.util.BeanItem
import org.vaadin.addons.lazyquerycontainer.Query

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 10/02/13
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
class MiProductoQuery implements Query {

    @Override
    int size() {
        return Productos.count;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    List<Item> loadItems(int inicio, int contador) {
        def lista=Productos.list(max: contador, offset: inicio);
        def listaItem=new ArrayList<Item>();
        lista.each {
            listaItem << new BeanItem<Productos>(it);
        }
        return listaItem  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    void saveItems(List<Item> items, List<Item> items1, List<Item> items2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    boolean deleteAllItems() {
        return false  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    Item constructItem() {
        return new BeanItem<Productos>(Productos)  //To change body of implemented methods use File | Settings | File Templates.
    }
}
