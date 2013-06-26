package com.example

import grails.validation.Validateable

/**
 * Created with IntelliJ IDEA.
 * User: dmahapatro
 * Date: 6/21/13
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Validateable
class BookCommand {
    String name
    Date pubDate
    Integer pages
}
