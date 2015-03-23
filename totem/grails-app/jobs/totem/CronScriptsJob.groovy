package totem

class CronScriptsJob {
    def cronService

    static triggers = {
        simple name: 'CronScriptsJob', startDelay: 5, repeatInterval: 5000l, repeatCount: -1
    }

    def execute() {
        print "<<< Start CronScript Job >>>" 
        log.info "<<< Start CronScript Job >>>" 
        cronService.executeScripts()
        log.info "<<< End CronScript Job >>>"
        print "<<< End CronScript Job >>>" 
    }
}
