package com.netjets.commandObjects
import org.codehaus.groovy.grails.validation.Validateable
/**
 * Created with IntelliJ IDEA.
 * User: asoleimani
 * Date: 6/18/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */

@Validateable
class SampleCommand {
    String name
    Date departure
    Long number

    static constraints = {
        //name blank:false
        //number nullable:true
    }

}
