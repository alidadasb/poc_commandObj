package com.example

import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry
import org.springframework.beans.propertyeditors.CustomDateEditor

import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: dmahapatro
 * Date: 6/21/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
class CustomDateEditorRegistrar implements PropertyEditorRegistrar {
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        String dateFormat = 'yyyy/MM/dd'
        registry.registerCustomEditor(Date, new CustomDateEditor(new SimpleDateFormat(dateFormat), true))
    }
}
