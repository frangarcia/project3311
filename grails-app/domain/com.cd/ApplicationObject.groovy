package com.cd

/**
 * Base Implementation for Domain Class to keep common attributes for tracking create and update date and user
 */
abstract class ApplicationObject implements Serializable{

    transient def springSecurityService

    static transients = ['springSecurityService']

    Date dateCreated
    Date lastUpdated
    String createdBy
    String modifiedBy


    transient beforeInsertExecuted = false

    /**
     * Logic to perform before insertion
     */
    transient static beforeInsert = {
        if (!beforeInsertExecuted) {
            beforeInsertExecuted = true
            doBeforeInsert(delegate)
        }
    }
    /*
    Logic to perform before update
     */
    transient static beforeUpdate = {
        doBeforeUpdate(delegate)
    }

    transient def doBeforeInsert(obj) {
        obj.lastUpdated = new Date()
        def principal = "frangarcia"
        obj.modifiedBy = principal
        obj.createdBy = principal
    }

    transient def doBeforeUpdate(obj) {
        def principal = "frangarcia"
        obj.modifiedBy = principal
    }


    public getDates() {
        Map dates = [dateCreated: dateCreated, createdBy: createdBy, lastUpdated: lastUpdated, modifiedBy: modifiedBy]
        return dates
    }
}
