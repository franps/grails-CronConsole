package totem

/**
 * CronService
 * A service class encapsulates the core business logic of a Grails application
 */
class CronService {

    static transactional = true
    def consoleService

    def executeScripts(){
        def actualHour = new Date().hours as Integer
        def eval
        def dateWitouthMinutes = Date.parse("yyy-MM-dd HH", new Date().format("yyy-MM-dd HH"))
        def scriptsToExute = Code.findAllByHourAndIsActiveAndLastRunLessThan(actualHour, true, dateWitouthMinutes)
        if(!scriptsToExute){
            print "No hay scripts para ejecutar"
            log.info "No hay scripts para ejecutar"
            return
        }else{
            print "Hay $scriptsToExute.size() para ejecutar"
            log.info "Hay $scriptsToExute.size() para ejecutar"
        }

        scriptsToExute.each{ it ->
             eval = consoleService.eval(it.code, true, [session:null])
             it.lastRun = new Date()
             it.save(failOnError:true)
        }

        Map result = [
            totalTime: eval.totalTime,
            output: eval.output
        ]
        if (eval.exception) {
            result.exception = [
                stackTrace: eval.stackTraceAsString,
                lineNumber: eval.exceptionLineNumber
            ]
            result.result = eval.exception.toString()
            result.resultTree = eval.exception
        } else {
            result.result = eval.resultAsString
        }

        print result
        log.info result
    }
}
