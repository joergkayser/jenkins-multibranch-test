import groovy.transform.Field

@Field conf = [:]

def call(script) {
    this.conf = script
	println "${this}: action invocation with param ${this.conf.inspect()}"
	return this
}

def call() {
	println "${this}: action invocation without param ${this.conf.inspect()}"
}

def otherAction() {		
	println "${this}: config from within otherAction invocation: ${config.custom.inspect()}"
}