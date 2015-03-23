package totem

import grails.converters.JSON

/**
 * CronConsoleController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class CronConsoleController {
    def consoleService


def index = { 
    render(view: "index",template:null)
    }


def getCode = {
        def codeInstance = Code.get(params.id)
        render codeInstance as JSON

    }

def update = {
        def codeInstance = Code.get(params.id)

        if(!codeInstance){
            render "No code found"
            return
        }
        codeInstance?.code = request?.JSON?.code
        def result = codeInstance?.save()
        if(result){
            render "Code updated"
        }else{
            render "Problem updating code"
        }
        
    }

def execute = { 
    def eval = consoleService.eval(request.JSON.code, true, [session:null])
    Map result = [
            totalTime: eval.totalTime,
            output: eval.output
        ]
        if (eval.exception) {
            result.exception = [
                output: eval.stackTraceAsString,
                lineNumber: eval.exceptionLineNumber
            ]
            result.result = eval.exception.toString()
            result.resultTree = eval.exception
        } else {
            result.result = eval.resultAsString
        }
    render result as JSON
    }
}
