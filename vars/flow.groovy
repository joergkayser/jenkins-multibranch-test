@NonCPS
def handleConfig(cfg){
    for (c in config.custom.keySet()){            
        if (cfg[c] == null) {
            println "   Kept ${c} to its default value: ${config.custom[c].inspect()}"
        } else {
            println "   Overwriting ${c} to ${cfg[c].inspect()}"
            config.custom[c] = cfg[c]
        }
    }
}

def call(Closure body = {}) {    
    def cfg = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = cfg
    body()

    config()
    handleConfig(cfg)
    
    lib = action (config.custom)
    config.custom.PR.call()
    action.otherAction()    
}