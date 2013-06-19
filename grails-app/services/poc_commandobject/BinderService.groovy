package poc_commandobject

import org.codehaus.groovy.grails.commons.metaclass.GroovyDynamicMethodsInterceptor
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod

class BinderService {

    BinderService(){
        GroovyDynamicMethodsInterceptor i = new GroovyDynamicMethodsInterceptor(this)
        i.addDynamicMethodInvocation(new BindDynamicMethod())
    }

    def bind(instanceObj,bindParams){
        bindData(instanceObj, bindParams)
//        instanceObj.clearErrors()
//        instanceObj.validate()
        log.info "Object $instanceObj binded to $bindParams"
        instanceObj
    }

}
