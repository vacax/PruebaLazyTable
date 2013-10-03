package com.avathartech.groovy.lazy

import org.vaadin.addons.lazyquerycontainer.Query
import org.vaadin.addons.lazyquerycontainer.QueryDefinition
import org.vaadin.addons.lazyquerycontainer.QueryFactory

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 10/02/13
 * Time: 11:08 PM
 * To change this template use File | Settings | File Templates.
 */
class MiProductoFactory implements QueryFactory {

    private QueryDefinition definition;

    @Override
    Query constructQuery(QueryDefinition queryDefinition) {
        this.definition=definition;

        return new MiProductoQuery()  //To change body of implemented methods use File | Settings | File Templates.
    }


}
