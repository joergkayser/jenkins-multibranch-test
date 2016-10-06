import groovy.transform.Field

@Field defaultConf = [
    'BOOLKEY': true,
    'PR': {},]

@Field custom
def call() {
	this.custom = this.defaultConf
}