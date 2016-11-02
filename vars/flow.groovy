@NonCPS
def handleConfig(override, defaults){
    println "Default config:   ${defaults.inspect()}"
    for (c in defaults.keySet()){
        if (override[c] != null) {
            defaults[c] = override[c]
        }
    }
    println "Overriden config: ${defaults.inspect()}"
    return defaults
}

def call(Closure body = {}) {

    def customconfig = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = customconfig
    body()

    def config = handleConfig(customconfig, defaultconfig())
    
    action (config)
    config.PR.call(config)

    println "After closure call config: ${config.inspect()}"
}