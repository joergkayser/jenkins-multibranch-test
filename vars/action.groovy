def call(conf) {

	println "${this}: action invocation with param ${conf.inspect()}"
	conf.STRKEY = 'OVERWRITTEN'
}

