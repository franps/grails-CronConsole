package totem

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

/**
 * CodeController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class CodeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }


    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [codeInstanceList: Code.list(params), codeInstanceTotal: Code.count()]
    }

    def create() {
        [codeInstance: new Code(params)]
    }

    def save() {
        def codeInstance = new Code(params)
        if (!codeInstance.save(flush: true)) {
            render(view: "create", model: [codeInstance: codeInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'code.label', default: 'Code'), codeInstance.id])
        redirect(action: "show", id: codeInstance.id)
    }

    def show() {
        def codeInstance = Code.get(params.id)
        if (!codeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'code.label', default: 'Code'), params.id])
            redirect(action: "list")
            return
        }

        [codeInstance: codeInstance]
    }

    def edit() {
        def codeInstance = Code.get(params.id)
        if (!codeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'code.label', default: 'Code'), params.id])
            redirect(action: "list")
            return
        }

        [codeInstance: codeInstance]
    }

    def update() {
        def codeInstance = Code.get(params.id)
        if (!codeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'code.label', default: 'Code'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (codeInstance.version > version) {
                codeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'code.label', default: 'Code')] as Object[],
                          "Another user has updated this Code while you were editing")
                render(view: "edit", model: [codeInstance: codeInstance])
                return
            }
        }

        codeInstance.properties = params

        if (!codeInstance.save(flush: true)) {
            render(view: "edit", model: [codeInstance: codeInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'code.label', default: 'Code'), codeInstance.id])
        redirect(action: "show", id: codeInstance.id)
    }

    def delete() {
        def codeInstance = Code.get(params.id)
        if (!codeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'code.label', default: 'Code'), params.id])
            redirect(action: "list")
            return
        }

        try {
            codeInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'code.label', default: 'Code'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'code.label', default: 'Code'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
